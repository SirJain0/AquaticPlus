package sirjain.aquaticplus.entity.entities;

import net.minecraft.entity.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.function.ValueLists;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import sirjain.aquaticplus.AquaticPlusUtil;
import sirjain.aquaticplus.entity.entities.template.APFishEntity;
import sirjain.aquaticplus.item.AquaticPlusItems;
import sirjain.aquaticplus.particle.AquaticPlusParticles;

import java.util.function.IntFunction;

public class DumboBlobEntity extends APFishEntity implements Mount {
	private static final TrackedData<Integer> DUMBO_BLOB_TYPE = DataTracker.registerData(DumboBlobEntity.class, TrackedDataHandlerRegistry.INTEGER);
	private static final TrackedData<Integer> BURST_TICKER = DataTracker.registerData(DumboBlobEntity.class, TrackedDataHandlerRegistry.INTEGER);

	public static final String BUCKET_VARIANT_TAG_KEY = "BucketVariantTag";
	public final AnimationState bobAnimationState = new AnimationState();
	private int idleAnimationTimeout = 0;

	public DumboBlobEntity(EntityType<? extends FishEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected SoundEvent getFlopSound() {
		return SoundEvents.ENTITY_GENERIC_EXPLODE;
	}

	@Override
	public ItemStack getBucketItem() {
		return AquaticPlusItems.DUMBO_BLOB_BUCKET.getDefaultStack();
	}

	@Override
	protected ActionResult interactMob(PlayerEntity player, Hand hand) {
		if (player.getStackInHand(hand).getItem() == Items.FIREWORK_STAR) {
			this.summonHeartParticles();
			this.heal(2);
			player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 10*20, 0));

			return ActionResult.SUCCESS;
		} else if (hand == Hand.MAIN_HAND && player.getStackInHand(hand).getItem() != Items.WATER_BUCKET) {
			this.setRiding(player);
			return ActionResult.SUCCESS;
		}

		return super.interactMob(player, hand);
	}

	public void copyDataToStack(ItemStack stack) {
		super.copyDataToStack(stack);

		NbtCompound nbtCompound = stack.getOrCreateNbt();
		nbtCompound.putInt(BUCKET_VARIANT_TAG_KEY, this.getVariant().id);
	}

	public void summonHeartParticles() {
		World world = this.getWorld();

		if (world.isClient) {
			world.addParticle(ParticleTypes.HEART, this.getX(), this.getRandomBodyY(), this.getZ(), 0, 0.1f, 0);
			world.addParticle(ParticleTypes.HEART, this.getX(), this.getRandomBodyY(), this.getZ(), 0, 0.1f, 0);
		}
	}

	@Override
	protected void updateLimbs(float v) {
		float f = this.getPose() == EntityPose.STANDING ? Math.min(v * 6.0F, 1.0F) : 0;
		this.limbAnimator.updateLimbs(f, 0.2F);
	}

	@Override
	public void tick() {
		super.tick();

		if (this.getWorld().isClient)
			this.setupAnimationStates();

		AquaticPlusUtil.summonAmbientParticles(this, AquaticPlusParticles.DUMBO_SPARK, 20);
	}

	private void setupAnimationStates() {
		if (this.idleAnimationTimeout <= 0) {
			this.idleAnimationTimeout = 80;
			this.bobAnimationState.start(this.age);
		} else {
			--this.idleAnimationTimeout;
		}
	}

	@Nullable
	@Override
	public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
		if (spawnReason == SpawnReason.BUCKET && entityNbt != null && entityNbt.contains(BUCKET_VARIANT_TAG_KEY, 3)) {
			this.setVariant(DumboBlobType.byId(entityNbt.getInt(BUCKET_VARIANT_TAG_KEY)));
			return entityData;
		}

		this.initVariant();
		return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
	}

	protected void initVariant() {
		int textureID = this.random.nextInt(4);

		if (textureID == 0) this.setVariant(DumboBlobType.BLUE_PURPLE);
		else if (textureID == 1) this.setVariant(DumboBlobType.PINK_ORANGE);
		else if (textureID == 2) this.setVariant(DumboBlobType.GREEN);
		else if (textureID == 3) this.setVariant(DumboBlobType.ORANGE_YELLOW);
	}

	protected void initDataTracker() {
		super.initDataTracker();

		this.dataTracker.startTracking(DUMBO_BLOB_TYPE, DumboBlobType.BLUE_PURPLE.id);
		this.dataTracker.startTracking(BURST_TICKER, 0);
	}

	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);

		nbt.putInt("dumbo_blob_type", this.getVariant().id);
		nbt.putInt("burst_ticker", this.dataTracker.get(BURST_TICKER));
	}

	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);

		this.setVariant(DumboBlobType.byId(nbt.getInt("dumbo_blob_type")));
		this.dataTracker.set(BURST_TICKER, nbt.getInt("burst_ticker"));
	}

	public void setVariant(DumboBlobType type) {
		this.dataTracker.set(DUMBO_BLOB_TYPE, type.id);
	}

	public DumboBlobType getVariant() {
		return DumboBlobType.byId(this.dataTracker.get(DUMBO_BLOB_TYPE));
	}

	public int getBurstTicks() {
		return this.dataTracker.get(BURST_TICKER);
	}

	public boolean canBurst() {
		return this.dataTracker.get(BURST_TICKER) == 20*4;
	}

	public void setBurstTicks(int value) {
		this.dataTracker.set(BURST_TICKER, value);
	}

	public void incrementBurstTicks() {
		this.setBurstTicks(this.getBurstTicks() + 1);
	}

	public void decrementBurstTicks() {
		this.setBurstTicks(this.getBurstTicks() - 1);
	}

	@Override
	protected void mobTick() {
		if (!this.isTouchingWater()) {
			if (this.canBurst()) {
				boolean isMobExplosionType = this.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING);
				World world = this.getWorld();

				World.ExplosionSourceType destructionType = isMobExplosionType
					? World.ExplosionSourceType.MOB
					: World.ExplosionSourceType.NONE;

				if (!world.isClient && this.isAlive()) {
					world.createExplosion(this, this.getX(), this.getY(), this.getZ(), 0, destructionType);
					this.kill();
				}
			} else {
				this.incrementBurstTicks();
			}
		} else if (this.getBurstTicks() != 0) {
			this.decrementBurstTicks();
		}

		super.mobTick();
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
	protected void tickControlled(PlayerEntity controllingPlayer, Vec3d movementInput) {
		BlockPos posAbove = this.getBlockPos().up();
		World world = this.getWorld();

		if (world.getBlockState(posAbove).isAir()) {
			this.discard();
			this.kill();
		} else if (this.isLogicalSideForUpdatingMovement()) {
			this.setMovementSpeed((float) this.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED));
			this.setVelocity(0, 0.1f, 0);

			super.travel(new Vec3d(0, movementInput.y, forwardSpeed));
		}
	}

	@Override
	public void kill() {
		World world = this.getWorld();

		if (!world.isClient) {
			((ServerWorld) world).spawnParticles(ParticleTypes.HEART, this.getX(), this.getRandomBodyY(), this.getZ(), 6, 0, -0.1, 0, 0.1);
		}

		super.kill();
	}

	@Override
	public double getMountedHeightOffset() {
		return -0.1D;
	}

	@Nullable
	@Override
	public LivingEntity getControllingPassenger() {
		return (LivingEntity) this.getFirstPassenger();
	}

	private void setRiding(LivingEntity passenger) {
		passenger.setYaw(this.getYaw());
		passenger.setPitch(this.getPitch());
		passenger.startRiding(this);
	}

	public static DefaultAttributeContainer.Builder createDumboBlobAttributes() {
		return FishEntity
			.createFishAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 4)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.8f);
	}

	public enum DumboBlobType implements StringIdentifiable {
		BLUE_PURPLE(0, "blue_purple"),
		PINK_ORANGE(1, "pink_orange"),
		GREEN(2, "green"),
		ORANGE_YELLOW(3, "orange_yellow");

		private static final IntFunction<DumboBlobEntity.DumboBlobType> BY_ID = ValueLists.createIdToValueFunction(
			DumboBlobEntity.DumboBlobType::getId, values(), BLUE_PURPLE
		);

		final int id;
		private final String name;

		DumboBlobType(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public String asString() {
			return this.name;
		}

		public int getId() {
			return this.id;
		}

		public static DumboBlobEntity.DumboBlobType byId(int id) {
			return BY_ID.apply(id);
		}
	}
}
