package sirjain.aquaticplus.entity.entities;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.EscapeDangerGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.text.Text;
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

public class DeepSeaIsopodEntity extends WaterCreatureEntity implements Mount {
	private static final TrackedData<Integer> ISOPOD_TYPE = DataTracker.registerData(DeepSeaIsopodEntity.class, TrackedDataHandlerRegistry.INTEGER);
	public static final TrackedData<Boolean> IS_FROSTPOD = DataTracker.registerData(DeepSeaIsopodEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
	public static final TrackedData<Boolean> IS_BELLYRUBBED = DataTracker.registerData(DeepSeaIsopodEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

	public int bellyrubCooldown = 60;

	public DeepSeaIsopodEntity(EntityType<? extends WaterCreatureEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(0, new EscapeDangerGoal(this, 1.4f));
		this.goalSelector.add(1, new WanderAroundFarGoal(this, 1));
		this.goalSelector.add(3, new LookAroundGoal(this));
	}

	@Override
	public void setCustomName(@Nullable Text name) {
		super.setCustomName(name);
		this.setFrostpodState(name != null && name.getString().equalsIgnoreCase("frostpod"));
	}

	@Override
	protected void initDataTracker() {
		super.initDataTracker();

		this.dataTracker.startTracking(IS_FROSTPOD, false);
		this.dataTracker.startTracking(IS_BELLYRUBBED, false);
		this.dataTracker.startTracking(ISOPOD_TYPE, IsopodType.SAND.id);
	}

	@Override
	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);

		nbt.putBoolean("is_frostpod", this.isFrostpod());
		nbt.putBoolean("is_bellyrubbed", this.isBellyrubbed());
		nbt.putInt("isopod_type", this.getVariant().id);
	}

	@Override
	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);

		this.setFrostpodState(nbt.getBoolean("is_frostpod"));
		this.setIsBellyrubbed(nbt.getBoolean("is_bellyrubbed"));
		this.setVariant(IsopodType.byId(nbt.getInt("isopod_type")));
	}

	public boolean isFrostpod() {
		return this.dataTracker.get(IS_FROSTPOD);
	}

	public void setFrostpodState(boolean val) {
		this.dataTracker.set(IS_FROSTPOD, val);
	}

	public boolean isBellyrubbed() {
		return this.dataTracker.get(IS_BELLYRUBBED);
	}

	public void setIsBellyrubbed(boolean val) {
		this.dataTracker.set(IS_BELLYRUBBED, val);
	}

	@Override
	public double getMountedHeightOffset() {
		return 0.73f;
	}

	@Nullable
	@Override
	public LivingEntity getControllingPassenger() {
		return (LivingEntity) this.getFirstPassenger();
	}

	private void setRiding(PlayerEntity pPlayer) {
		pPlayer.setYaw(this.getYaw());
		pPlayer.setPitch(this.getPitch());
		pPlayer.startRiding(this);
	}

	@Override
	public ActionResult interactMob(PlayerEntity player, Hand hand) {
		if (hand == Hand.MAIN_HAND) {
			if (player.isSneaking()) {
				this.setIsBellyrubbed(true);
				return ActionResult.SUCCESS;
			}

			this.setRiding(player);
			return ActionResult.SUCCESS;
		}

		return super.interactMob(player, hand);
	}

	@Override
	public void tick() {
		if (this.isBellyrubbed()) {
			if (!this.getWorld().isClient) {
				if (this.bellyrubCooldown == 0) {
					this.setIsBellyrubbed(false);
					this.bellyrubCooldown = 60;
					this.getNavigation().recalculatePath();

					if (this.random.nextInt(3) == 0)
						this.heal(1);
				} else {
					this.setVelocity(0, 0, 0);
					bellyrubCooldown--;
				}
			}

			if (this.getWorld().isClient && this.random.nextInt(10) == 0) {
				this.getWorld().addParticle(ParticleTypes.HEART, this.getX(), this.getRandomBodyY(), this.getZ(), 0, 0.1f, 0);
			}
		}

		super.tick();
	}

	@Override
	public void travel(Vec3d movementInput) {
		if (this.hasPassengers() && getControllingPassenger() instanceof PlayerEntity) {
			LivingEntity livingentity = this.getControllingPassenger();

			this.setYaw(livingentity.getYaw());
			this.prevYaw = this.getYaw();
			this.setPitch(livingentity.getPitch() * 0.5F);
			this.setRotation(this.getYaw(), this.getPitch());
			this.bodyYaw = this.getYaw();
			this.headYaw = this.bodyYaw;

			float sideSpeed = livingentity.sidewaysSpeed * 0.5F;
			float fwdSpeed = livingentity.forwardSpeed;

			if (fwdSpeed <= 0.0F) fwdSpeed *= 0.25F;

			if (this.isLogicalSideForUpdatingMovement()) {
				float newSpeed = (float)this.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED);

				if (MinecraftClient.getInstance().options.sprintKey.isPressed()) newSpeed *= 1.5f;

				this.setMovementSpeed(newSpeed);
				super.travel(new Vec3d(sideSpeed, movementInput.y, fwdSpeed));
			}
		} else {
			super.travel(movementInput);
		}
	}

	@Override
	public Vec3d updatePassengerForDismount(LivingEntity passenger) {
		Direction direction = this.getMovementDirection();

		if (direction.getAxis() == Direction.Axis.Y)
			return super.updatePassengerForDismount(passenger);

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

	public static DefaultAttributeContainer.Builder createIsopodAttributes() {
		return FishEntity
			.createFishAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 16)
			.add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 3)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.7f);
	}

	// == VARIANTS ==
	
	@Nullable
	@Override
	public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
		this.initVariant();
		return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
	}

	protected void initVariant() {
		int textureID = this.random.nextInt(3);

		if (textureID == 0) this.setVariant(IsopodType.SAND);
		else if (textureID == 1) this.setVariant(IsopodType.COAL);
		else if (textureID == 2) this.setVariant(IsopodType.GILDED);
	}

	public void setVariant(IsopodType sardineType) {
		this.dataTracker.set(ISOPOD_TYPE, sardineType.id);
	}

	public IsopodType getVariant() {
		return IsopodType.byId(this.dataTracker.get(ISOPOD_TYPE));
	}

	public enum IsopodType implements StringIdentifiable {
		SAND(0, "sand"),
		COAL(1, "coal"),
		GILDED(2, "gilded");

		private static final IntFunction<IsopodType> BY_ID = ValueLists.createIdToValueFunction(
			DeepSeaIsopodEntity.IsopodType::getId, values(), SAND
		);

		final int id;
		private final String name;

		IsopodType(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public String asString() {
			return this.name;
		}

		public int getId() {
			return this.id;
		}

		public static IsopodType byId(int id) {
			return BY_ID.apply(id);
		}
	}
}
