package sirjain.aquaticplus.entity.entities;

import sirjain.aquaticplus.entity.entities.template.NoBucketSchoolingFishEntity;
import sirjain.aquaticplus.item.AquaticPlusItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundCategory;
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

import java.util.function.IntFunction;

public class MantaRayEntity extends NoBucketSchoolingFishEntity implements Saddleable, Mount {
	private static final TrackedData<Integer> MANTA_RAY_TYPE = DataTracker.registerData(MantaRayEntity.class, TrackedDataHandlerRegistry.INTEGER);
	private static final TrackedData<Boolean> SADDLED = DataTracker.registerData(MantaRayEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
	private static final TrackedData<Integer> BOOST_TIME = DataTracker.registerData(MantaRayEntity.class, TrackedDataHandlerRegistry.INTEGER);
	private static final TrackedData<Boolean> SITTING = DataTracker.registerData(MantaRayEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

	private final SaddledComponent saddledComponent;

	public MantaRayEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
		super(entityType, world);
		this.saddledComponent = new SaddledComponent(this.dataTracker, BOOST_TIME, SADDLED);
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(0, new FollowGroupLeaderGoal(this));
		this.goalSelector.add(1, new SwimAroundGoal(this, 1.0, 10));
		this.goalSelector.add(2, new LookAroundGoal(this));
		this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.add(0, new AttackGoal(this));
		// TODO: Make the bait item shrimp when it is added
		this.goalSelector.add(2, new TemptGoal(this, this.isSaddled() ? 1 : 0.7f, Ingredient.ofItems(AquaticPlusItems.HALIBUT), this.isSaddled()));

		this.targetSelector.add(0, new ActiveTargetGoal<>(this, LanternfishEntity.class, true, true));
	}

	@Nullable
	@Override
	public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
		this.initVariant();
		return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
	}

	@Override
	protected void initDataTracker() {
		super.initDataTracker();

		this.dataTracker.startTracking(MANTA_RAY_TYPE, MantaRayType.DARK.id);
		this.dataTracker.startTracking(SADDLED, false);
		this.dataTracker.startTracking(BOOST_TIME, 0);
		this.dataTracker.startTracking(SITTING, false);
	}

	@Override
	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);

		nbt.putInt("MantaRayType", this.getVariant().id);
		this.saddledComponent.writeNbt(nbt);
		nbt.putBoolean("sitting", this.isSitting());
	}

	@Override
	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);

		this.setVariant(MantaRayType.byId(nbt.getInt("MantaRayType")));
		this.saddledComponent.readNbt(nbt);
		this.setSitting(nbt.getBoolean("sitting"));
	}

	@Override
	public void tickMovement() {
		if (!this.isSitting()) super.tickMovement();
	}

	@Override
	public void tickControlled(PlayerEntity controllingPlayer, Vec3d movementInput) {
		controllingPlayer.heal(1);
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
				this.move(MovementType.SELF, this.getRotationVector().multiply(0.15f));

			super.travel(movementInput.multiply(3f));
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

	@Override
	public double getMountedHeightOffset() {
		return 1.45;
	}

	protected void initVariant() {
		int textureID = this.random.nextInt(3);

		if (textureID == 0) this.setVariant(MantaRayType.DARK);
		else if (textureID == 1) this.setVariant(MantaRayType.DARK_SPOTTED);
		else if (textureID == 2) this.setVariant(MantaRayType.BLUE);
	}

	public void setVariant(MantaRayType mantaRayType) {
		this.dataTracker.set(MANTA_RAY_TYPE, mantaRayType.id);
	}

	public MantaRayType getVariant() {
		return MantaRayType.byId(this.dataTracker.get(MANTA_RAY_TYPE));
	}

	@Nullable
	@Override
	public LivingEntity getControllingPassenger() {
		return (LivingEntity) this.getFirstPassenger();
	}

	private void setRiding(PlayerEntity player) {
		player.setYaw(this.getYaw());
		player.setPitch(this.getPitch());
		player.startRiding(this);
	}

	@Override
	protected ActionResult interactMob(PlayerEntity player, Hand hand) {
		// TODO: change halibut to slimy shrimp when it is added
		if (hand == Hand.MAIN_HAND && this.isSaddled()) {
			if (player.getStackInHand(hand).isOf(AquaticPlusItems.HALIBUT)) this.setSitting(!this.isSitting());
			else this.setRiding(player);

			return ActionResult.SUCCESS;
		}

		return super.interactMob(player, hand);
	}

	public boolean isSitting() {
		return this.dataTracker.get(SITTING);
	}

	public void setSitting(boolean sitting) {
		this.dataTracker.set(SITTING, sitting);
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

	public static DefaultAttributeContainer.Builder createMantaRayAttributes() {
		return SchoolingFishEntity
			.createFishAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 22)
			.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 3);
	}

	public enum MantaRayType implements StringIdentifiable {
		DARK(0, "dark"),
		DARK_SPOTTED(1, "dark_spotted"),
		BLUE(2, "blue");

		private static final IntFunction<MantaRayType> BY_ID = ValueLists.createIdToValueFunction(
			MantaRayType::getId, values(), DARK
		);

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

		public static MantaRayType byId(int id) {
			return BY_ID.apply(id);
		}
	}
}