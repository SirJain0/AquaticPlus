package com.sirjain.entities.entity;

import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.control.AquaticMoveControl;
import net.minecraft.entity.ai.control.YawAdjustingLookControl;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.SwimAroundGoal;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.SwimNavigation;
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
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.function.ValueLists;
import net.minecraft.world.GameRules;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.function.IntFunction;

/*
- Make them float to the surface when players ride them
- Bucketable?
- Maybe some sort of cute spin animation when fed?
- Animations - swimming, bobbing, exploding
 */
public class DumboBlobEntity extends FishEntity {
	private static final TrackedData<Integer> DUMBO_BLOB_TYPE = DataTracker.registerData(DumboBlobEntity.class, TrackedDataHandlerRegistry.INTEGER);
	private static final TrackedData<Integer> BURST_TICKER = DataTracker.registerData(DumboBlobEntity.class, TrackedDataHandlerRegistry.INTEGER);

	public DumboBlobEntity(EntityType<? extends FishEntity> entityType, World world) {
		super(entityType, world);
		this.moveControl = new AquaticMoveControl(this, 10, 30, 1, 0.04F, true);
		this.lookControl = new YawAdjustingLookControl(this, 70);
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(1, new SwimAroundGoal(this, 0.8f, 1));
		this.goalSelector.add(2, new LookAroundGoal(this));
	}

	@Override
	protected EntityNavigation createNavigation(World world) {
		return new SwimNavigation(this, world);
	}

	@Override
	protected SoundEvent getFlopSound() {
		return SoundEvents.ENTITY_GENERIC_EXPLODE;
	}

	@Override
	public ItemStack getBucketItem() {
		return ItemStack.EMPTY;
	}

	@Override
	protected ActionResult interactMob(PlayerEntity player, Hand hand) {
		// TODO: Change to proper plant item
		if (player.getStackInHand(hand).getItem() == Items.WHEAT_SEEDS) {
			this.summonHeartParticles();
			player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 10*20, 0));

			return ActionResult.SUCCESS;
		}

		return ActionResult.PASS;
	}

	public void summonHeartParticles() {
		if (getWorld().isClient) {
			getWorld().addParticle(ParticleTypes.HEART, this.getX(), this.getRandomBodyY(), this.getZ(), 0, 0.1f, 0);
			getWorld().addParticle(ParticleTypes.HEART, this.getX(), this.getRandomBodyY(), this.getZ(), 0, 0.1f, 0);
		}
	}

	@Nullable
	@Override
	public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
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

	public static DefaultAttributeContainer.Builder createDumboBlobAttributes() {
		return FishEntity
			.createFishAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 4)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.8f);
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
		if (!this.isSubmergedInWater()) {
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

		System.out.println(getBurstTicks());
		super.mobTick();
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
