package com.aquaticplus.entities.entity;

import com.aquaticplus.AquaticPlusUtil;
import com.aquaticplus.entities.entity.template.APSchoolingFishEntity;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.FleeEntityGoal;
import net.minecraft.entity.ai.goal.ProjectileAttackGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

/*
TODO:
- Fix/finish animations
- Item drop
- Render layer fix translucency bug
 */
public class VermillionJellyEntity extends APSchoolingFishEntity implements RangedAttackMob {
	public final AnimationState swimAnimationState = new AnimationState();
	public int idleAnimationTimeout = 0;

	public static final TrackedData<Boolean> IS_MUTATED = DataTracker.registerData(VermillionJellyEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

	public VermillionJellyEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void initGoals() {
		super.initGoals();
		this.goalSelector.add(2, new FleeEntityGoal<>(this, PlayerEntity.class, 10, 1.4, 2));
		this.goalSelector.add(0, new ProjectileAttackGoal(this, 1, 40, 15));

		this.targetSelector.add(0, new RevengeGoal(this));
	}

	@Override
	public ItemStack getBucketItem() {
		return null;
	}

	@Nullable
	@Override
	public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
		if (this.random.nextInt(7) == 0)
			this.setMutatedState(true);

		return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
	}

	@Override
	public void tick() {
		if (this.age % 40 == 0)
			this.heal(1);

		if (this.getWorld().isClient)
			this.setupAnimationStates();

		super.tick();
	}

	private void setupAnimationStates() {
		if (this.idleAnimationTimeout <= 0) {
			this.idleAnimationTimeout = 80;
			this.swimAnimationState.start(this.age);
		} else {
			--this.idleAnimationTimeout;
		}
	}

	@Override
	protected void initDataTracker() {
		super.initDataTracker();
		this.dataTracker.startTracking(IS_MUTATED, false);
	}

	@Override
	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);
		nbt.putBoolean("is_mutated", this.isMutated());
	}

	@Override
	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);
		this.dataTracker.set(IS_MUTATED, nbt.getBoolean("is_mutated"));
	}

	public boolean isMutated() {
		return this.dataTracker.get(IS_MUTATED);
	}

	public void setMutatedState(boolean value) {
		this.dataTracker.set(IS_MUTATED, value);
	}

	public static DefaultAttributeContainer.Builder createVermillionJellyAttributes() {
		return JellyfishEntity
			.createJellyfishAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 10);
	}

	@Override
	public void attack(LivingEntity target, float pullProgress) {
		if (this.age % 3 == 0) {
			if (this.isMutated() && this.random.nextInt(4) == 0) {
				AquaticPlusUtil.performPlasmaBallShootAttack(this, this.getTarget(), 2);
			} else {
				AquaticPlusUtil.performPlasmaBeamShootAttack(this, this.getTarget());
			}
		}
	}
}
