package com.sirjain.entities.entity;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.function.ValueLists;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.function.IntFunction;

/*
TODO:
- Animations
- Crab Claw item
- Neon Leaf item + crafting recipes
 */
public class NeonCrabEntity extends WaterCreatureEntity {
	private static final TrackedData<Integer> NEON_CRAB_TYPE = DataTracker.registerData(NeonCrabEntity.class, TrackedDataHandlerRegistry.INTEGER);

	public final AnimationState walkAnimationState = new AnimationState();
	private int idleAnimationTimeout = 0;
	private int walkAnimationTimeout = 0;

	public NeonCrabEntity(EntityType<? extends WaterCreatureEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(0, new EscapeDangerGoal(this, 1.4f));
		this.goalSelector.add(1, new WanderAroundFarGoal(this, 1));
		this.goalSelector.add(3, new LookAroundGoal(this));
	}

	@Override
	protected void updateLimbs(float v) {
		float f = this.getPose() == EntityPose.STANDING ? 1 : 0;
		this.limbAnimator.updateLimbs(f, 0.2F);
	}

	@Override
	public void tick() {
		super.tick();

		if (this.getWorld().isClient) this.setupAnimationStates();
	}

	private void setupAnimationStates() {
		if (this.idleAnimationTimeout <= 0) {
			this.idleAnimationTimeout = 80;
			this.walkAnimationState.start(this.age);
		} else {
			--this.idleAnimationTimeout;
		}
	}

	public static DefaultAttributeContainer.Builder createNeonCrabAttributes() {
		return WaterCreatureEntity
			.createMobAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 7)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 3);
	}

	@Nullable
	@Override
	public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
		this.initVariant();
		return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
	}

	protected void initVariant() {
		int textureID = this.random.nextInt(3);

		if (textureID == 0) this.setVariant(NeonCrabType.CYAN);
		if (textureID == 1) this.setVariant(NeonCrabType.PINK);
		else if (textureID == 2) this.setVariant(NeonCrabType.ORANGE);
	}

	@Override
	protected void initDataTracker() {
		super.initDataTracker();
		this.dataTracker.startTracking(NEON_CRAB_TYPE, NeonCrabType.CYAN.id);
	}

	@Override
	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);
		nbt.putInt("neon_crab_type", this.getVariant().id);
	}

	@Override
	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);
		this.setVariant(NeonCrabType.byId(nbt.getInt("neon_crab_type")));
	}

	public void setVariant(NeonCrabType sardineType) {
		this.dataTracker.set(NEON_CRAB_TYPE, sardineType.id);
	}

	public NeonCrabType getVariant() {
		return NeonCrabType.byId(this.dataTracker.get(NEON_CRAB_TYPE));
	}

	public enum NeonCrabType implements StringIdentifiable {
		CYAN(0, "cyan"),
		PINK(1, "pink"),
		ORANGE(2, "orange");

		private static final IntFunction<NeonCrabType> BY_ID = ValueLists.createIdToValueFunction(
			NeonCrabType::getId, values(), CYAN
		);

		final int id;
		private final String name;

		NeonCrabType(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public String asString() {
			return this.name;
		}

		public int getId() {
			return this.id;
		}

		public static NeonCrabType byId(int id) {
			return BY_ID.apply(id);
		}
	}
}
