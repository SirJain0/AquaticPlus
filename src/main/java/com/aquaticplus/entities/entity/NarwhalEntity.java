package com.aquaticplus.entities.entity;

import com.aquaticplus.entities.entity.template.NoBucketSchoolingFishEntity;
import com.aquaticplus.registries.AquaticPlusItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.EscapeDangerGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

// TODO: Look into making it tameable and/or breedable?
public class NarwhalEntity extends NoBucketSchoolingFishEntity implements Saddleable, Mount {
	private static final TrackedData<Boolean> SADDLED = DataTracker.registerData(NarwhalEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
	private static final TrackedData<Integer> BOOST_TIME = DataTracker.registerData(NarwhalEntity.class, TrackedDataHandlerRegistry.INTEGER);
	private static final TrackedData<Boolean> DOUBLE_TUSKED = DataTracker.registerData(NarwhalEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
	private static final TrackedData<Boolean> SITTING = DataTracker.registerData(NarwhalEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

	private final SaddledComponent saddledComponent;

	public NarwhalEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
		super(entityType, world);
		this.saddledComponent = new SaddledComponent(this.dataTracker, BOOST_TIME, SADDLED);
	}

	@Override
	protected void initGoals() {
		super.initGoals();
		this.goalSelector.add(4, new EscapeDangerGoal(this, 1.45));
	}

	@Nullable
	@Override
	public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
		if (this.getRandom().nextInt(40) == 0) {
			this.setDoubleTusked(true);
			this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(30);
			this.heal(this.getMaxHealth());
		}

		return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
	}

	@Override
	public void tickControlled(PlayerEntity controllingPlayer, Vec3d movementInput) {
		super.tickControlled(controllingPlayer, movementInput);

		if (this.age % 20*5 == 0 && controllingPlayer.getHealth() < controllingPlayer.getMaxHealth()) {
			if (!this.getWorld().isClient) this.heal(1);
			if (this.getWorld().isClient) this.spawnHealingParticle(controllingPlayer);
		}
	}

	public void spawnHealingParticle(PlayerEntity controllingPlayer) {
		this.getWorld().addParticle(
			ParticleTypes.HEART,
			controllingPlayer.getX(),
			controllingPlayer.getRandomBodyY(),
			controllingPlayer.getZ(),
			0, 0.04f, 0
		);
	}

	// Code for dealing with making it mountable and ridable
	@Override
	protected void initDataTracker() {
		super.initDataTracker();

		this.dataTracker.startTracking(SADDLED, false);
		this.dataTracker.startTracking(DOUBLE_TUSKED, false);
		this.dataTracker.startTracking(BOOST_TIME, 0);
		this.dataTracker.startTracking(SITTING, false);
	}

	@Override
	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);

		this.saddledComponent.writeNbt(nbt);
		nbt.putBoolean("double_tusked", this.isDoubleTusked());
		nbt.putBoolean("sitting", this.isSitting());
	}

	@Override
	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);

		this.saddledComponent.readNbt(nbt);
		this.setDoubleTusked(nbt.getBoolean("double_tusked"));
		this.setSitting(nbt.getBoolean("sitting"));
	}

	public boolean isDoubleTusked() {
		return this.dataTracker.get(DOUBLE_TUSKED);
	}

	public void setDoubleTusked(boolean val) {
		this.dataTracker.set(DOUBLE_TUSKED, val);
	}

	public boolean isSitting() {
		return this.dataTracker.get(SITTING);
	}

	public void setSitting(boolean sitting) {
		this.dataTracker.set(SITTING, sitting);
	}

	@Nullable
	@Override
	public LivingEntity getControllingPassenger() {
		return (LivingEntity) this.getFirstPassenger();
	}

	@Override
	public void travel(Vec3d movementInput) {
		if (this.hasPassengers() && getControllingPassenger() instanceof PlayerEntity && this.isSubmergedInWater()) {
			LivingEntity rider = this.getControllingPassenger();

			this.setYaw(rider.getYaw());
			this.prevYaw = this.getYaw();
			this.setPitch(rider.getPitch() * 0.5F);
			this.setRotation(this.getYaw(), this.getPitch());
			this.bodyYaw = this.getYaw();
			this.headYaw = this.bodyYaw;
			float sidewaysSpeed = rider.sidewaysSpeed * 0.5F;
			float forwardSpeed = rider.forwardSpeed;

			if (forwardSpeed <= 0.0F)
				forwardSpeed *= 0.25F;

			if (this.isLogicalSideForUpdatingMovement()) {
				this.setMovementSpeed((float) this.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED));
				this.move(MovementType.SELF, this.getRotationVector().multiply(
					MinecraftClient.getInstance().options.sprintKey.isPressed()
						? forwardSpeed / 1.5f
						: forwardSpeed / 2.5f
				));

				super.travel(new Vec3d(sidewaysSpeed, movementInput.y, forwardSpeed));
			}
		} else {
			if (this.isLogicalSideForUpdatingMovement())
				this.move(MovementType.SELF, this.getRotationVector().multiply(0.11f));

			super.travel(movementInput.multiply(2f));
		}

		if (!this.isSubmergedInWater() && this.isLogicalSideForUpdatingMovement()) {
			this.setVelocity(this.getVelocity().x, -0.7f, this.getVelocity().z);
		}
	}

	@Override
	public Vec3d updatePassengerForDismount(LivingEntity passenger) {
		Direction direction = this.getMovementDirection();

		if (direction.getAxis() == Direction.Axis.Y) {
			return super.updatePassengerForDismount(passenger);
		}

		int[][] is = Dismounting.getDismountOffsets(direction);
		BlockPos blockPos = this.getBlockPos();
		BlockPos.Mutable mutable = new BlockPos.Mutable();
		for (EntityPose entityPose : passenger.getPoses()) {
			Box box = passenger.getBoundingBox(entityPose);

			for (int[] js : is) {
				mutable.set(blockPos.getX() + js[0], blockPos.getY(), blockPos.getZ() + js[1]);
				double d = this.getWorld().getDismountHeight(mutable);

				if (!Dismounting.canDismountInBlock(d)) continue;
				Vec3d vec3d = Vec3d.ofCenter(mutable, d);
				if (!Dismounting.canPlaceEntityAt(this.getWorld(), passenger, box.offset(vec3d))) continue;
				passenger.setPose(entityPose);

				return vec3d;
			}
		}

		return super.updatePassengerForDismount(passenger);
	}

	private void setRiding(PlayerEntity player) {
		player.setYaw(this.getYaw());
		player.setPitch(this.getPitch());
		player.startRiding(this);
	}

	@Override
	protected ActionResult interactMob(PlayerEntity player, Hand hand) {
		if (hand == Hand.MAIN_HAND && this.isSaddled()) {
			if (player.getStackInHand(hand).isOf(AquaticPlusItems.HALIBUT)) this.setSitting(!this.isSitting());
			else this.setRiding(player);

			return ActionResult.SUCCESS;
		}

		return super.interactMob(player, hand);
	}

	@Override
	public void tickMovement() {
		if (!this.isSitting()) super.tickMovement();
	}

	@Override
	public boolean canBeSaddled() {
		return !this.isBaby() && this.isAlive();
	}

	@Override
	public void saddle(@Nullable SoundCategory sound) {
		this.saddledComponent.setSaddled(true);
	}

	@Override
	public boolean isSaddled() {
		return this.saddledComponent.isSaddled();
	}

	@Override
	protected void dropInventory() {
		super.dropInventory();
		if (this.isSaddled()) this.dropItem(Items.SADDLE);
	}

	public static DefaultAttributeContainer.Builder createNarwhalAttributes() {
		return FishEntity
			.createFishAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 18);
	}
}
