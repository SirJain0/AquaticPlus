package com.sirjain.entities.entity;

import com.google.common.collect.UnmodifiableIterator;
import com.sirjain.entities.entity.template.NoBucketSchoolingFishEntity;
import com.sirjain.entities.goals.APSwimAroundGoal;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.EscapeDangerGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.function.ValueLists;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.injection.Coerce;

import java.util.function.IntFunction;

public class MantaRayEntity extends NoBucketSchoolingFishEntity implements Saddleable, ItemSteerable {
	private static final TrackedData<Integer> MANTA_RAY_TYPE = DataTracker.registerData(MantaRayEntity.class, TrackedDataHandlerRegistry.INTEGER);
	private static final TrackedData<Boolean> SADDLED = DataTracker.registerData(MantaRayEntity.class, TrackedDataHandlerRegistry.BOOLEAN);;
	private static final TrackedData<Integer> BOOST_TIME = DataTracker.registerData(MantaRayEntity.class, TrackedDataHandlerRegistry.INTEGER);

	private final SaddledComponent saddledComponent;

	public MantaRayEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
		super(entityType, world);
		this.saddledComponent = new SaddledComponent(this.dataTracker, BOOST_TIME, SADDLED);
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(0, new EscapeDangerGoal(this, 1.4f));
		this.goalSelector.add(1, new APSwimAroundGoal(this, 1, 1, 2, 10));
	}

	@Nullable
	@Override
	public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
		this.initVariant();
		return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
	}

	protected void initDataTracker() {
		super.initDataTracker();
		this.dataTracker.startTracking(MANTA_RAY_TYPE, MantaRayType.DARK.id);
		this.dataTracker.startTracking(SADDLED, false);
		this.dataTracker.startTracking(BOOST_TIME, 0);
	}

	protected void initVariant() {
		int textureID = this.random.nextInt(3);

		if (textureID == 0) this.setVariant(MantaRayType.DARK);
		else if (textureID == 1) this.setVariant(MantaRayType.DARK_SPOTTED);
		else if (textureID == 2) this.setVariant(MantaRayType.BLUE);
	}

	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);
		nbt.putInt("MantaRayType", this.getVariant().id);
		this.saddledComponent.writeNbt(nbt);
	}

	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);
		this.setVariant(MantaRayEntity.MantaRayType.byId(nbt.getInt("MantaRayType")));
		this.saddledComponent.readNbt(nbt);
	}

	public static DefaultAttributeContainer.Builder createMantaRayAttributes() {
		return SchoolingFishEntity
			.createFishAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 22)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 5f);
	}

	public void setVariant(MantaRayType mantaRayType) {
		this.dataTracker.set(MANTA_RAY_TYPE, mantaRayType.id);
	}

	public MantaRayEntity.MantaRayType getVariant() {
		return MantaRayEntity.MantaRayType.byId(this.dataTracker.get(MANTA_RAY_TYPE));
	}

	@Override
	public ActionResult interactMob(PlayerEntity player, Hand hand) {
		if (this.isSaddled() && !this.hasPassengers() && !player.shouldCancelInteraction()) {
			if (!this.getWorld().isClient) {
				player.startRiding(this);
			}

			return ActionResult.success(this.getWorld().isClient);
		} else {
			ActionResult actionResult = super.interactMob(player, hand);

			if (!actionResult.isAccepted()) {
				ItemStack itemStack = player.getStackInHand(hand);
				return itemStack.isOf(Items.SADDLE) ? itemStack.useOnEntity(player, this, hand) : ActionResult.PASS;
			} else {
				return actionResult;
			}
		}
	}

	@Override
	public boolean canBeSaddled() {
		return this.isAlive() && !this.isBaby();
	}

	@Override
	protected void dropInventory() {
		super.dropInventory();

		if (this.isSaddled())
			this.dropItem(Items.SADDLE);
	}

	@Override
	public void saddle(@Nullable SoundCategory sound) {
		this.saddledComponent.setSaddled(true);
		this.getWorld().playSoundFromEntity(null, this, SoundEvents.ENTITY_PIG_SADDLE, sound, 0.5F, 1.0F);
	}

	@Override
	public boolean isSaddled() {
		return this.saddledComponent.isSaddled();
	}

	@Override
	public boolean consumeOnAStickItem() {
		return this.saddledComponent.boost(this.getRandom());
	}

	@Override
	public Vec3d updatePassengerForDismount(LivingEntity passenger) {
		Direction direction = this.getMovementDirection();
		if (direction.getAxis() == Direction.Axis.Y) {
			return super.updatePassengerForDismount(passenger);
		} else {
			int[][] is = Dismounting.getDismountOffsets(direction);
			BlockPos blockPos = this.getBlockPos();
			BlockPos.Mutable mutable = new BlockPos.Mutable();

			for (EntityPose entityPose : passenger.getPoses()) {
				Box box = passenger.getBoundingBox(entityPose);

				for (int[] js : is) {
					mutable.set(blockPos.getX() + js[0], blockPos.getY(), blockPos.getZ() + js[1]);
					double d = this.getWorld().getDismountHeight(mutable);
					if (Dismounting.canDismountInBlock(d)) {
						Vec3d vec3d = Vec3d.ofCenter(mutable, d);
						if (Dismounting.canPlaceEntityAt(this.getWorld(), passenger, box.offset(vec3d))) {
							passenger.setPose(entityPose);
							return vec3d;
						}
					}
				}
			}

			return super.updatePassengerForDismount(passenger);
		}
	}

	@Override
	protected void tickControlled(PlayerEntity controllingPlayer, Vec3d movementInput) {
		super.tickControlled(controllingPlayer, movementInput);
		this.setRotation(controllingPlayer.getYaw(), controllingPlayer.getPitch() * 0.5F);
		this.prevYaw = this.bodyYaw = this.headYaw = this.getYaw();
		this.saddledComponent.tickBoost();
	}

	@Override
	protected Vec3d getControlledMovementInput(PlayerEntity controllingPlayer, Vec3d movementInput) {
		return new Vec3d(0.0, 0.0, 1.0);
	}

	@Override
	protected float getSaddledSpeed(PlayerEntity controllingPlayer) {
		return (float)(this.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED) * 0.225 * (double)this.saddledComponent.getMovementSpeedMultiplier());
	}

	@Nullable
	@Override
	public LivingEntity getControllingPassenger() {
		if (this.isSaddled()) {
			Entity passenger = this.getFirstPassenger();

			if (passenger instanceof PlayerEntity playerEntity) {
				if (playerEntity.getMainHandStack().isOf(Items.CARROT_ON_A_STICK) || playerEntity.getOffHandStack().isOf(Items.CARROT_ON_A_STICK)) {
					return playerEntity;
				}
			}
		}

		return null;
	}

	public void onTrackedDataSet(TrackedData<?> data) {
		if (BOOST_TIME.equals(data) && this.getWorld().isClient) {
			this.saddledComponent.boost();
		}

		super.onTrackedDataSet(data);
	}

	public enum MantaRayType implements StringIdentifiable {
		DARK(0, "dark"),
		DARK_SPOTTED(1, "dark_spotted"),
		BLUE(2, "blue");

		private static final IntFunction<MantaRayEntity.MantaRayType> BY_ID = ValueLists.createIdToValueFunction(MantaRayEntity.MantaRayType::getId, values(), DARK);
		final int id;
		private final String name;

		MantaRayType(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public String asString() {
			return this.name;
		}

		public int getId() {
			return this.id;
		}

		public static MantaRayEntity.MantaRayType byId(int id) {
			return BY_ID.apply(id);
		}
	}
}