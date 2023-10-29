package com.sirjain.entities.entity;

import com.sirjain.entities.entity.template.NoBucketFishEntity;
import com.sirjain.entities.goals.APSwimAroundGoal;
import com.sirjain.registries.AquaticPlusStatusEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.control.AquaticMoveControl;
import net.minecraft.entity.ai.control.YawAdjustingLookControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.SwimNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class MaxillaMortisEntity extends NoBucketFishEntity {
	public static final TrackedData<Boolean> HAS_ACTIVE_TARGET = DataTracker.registerData(MaxillaMortisEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
	public static final TrackedData<Boolean> CAN_RECOLOR = DataTracker.registerData(MaxillaMortisEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

	public MaxillaMortisEntity(EntityType<? extends FishEntity> entityType, World world) {
		super(entityType, world);
		this.setTargetState(false);
		this.moveControl = new AquaticMoveControl(this, 20, 10, 1, 0.04F, true);
		this.lookControl = new YawAdjustingLookControl(this, 10);
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(1, new SwimAroundGoal(this, 1.0, 10));
		this.goalSelector.add(2, new LookAroundGoal(this));
		this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));		this.goalSelector.add(0, new AttackGoal(this));
		this.goalSelector.add(0, new MoveIntoWaterGoal(this));
		this.initTargetGoals();
	}

	protected void initTargetGoals() {
		List<Class<? extends LivingEntity>> targets = Arrays.asList(
			SalmonEntity.class,
			CodEntity.class,
			TropicalFishEntity.class,
			SchoolingFishEntity.class
		);

		for (Class<? extends LivingEntity> target : targets) {
			this.targetSelector.add(2, new ActiveTargetGoal<>(this, target, true));
		}

		this.targetSelector.add(0, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.add(1, new RevengeGoal(this));
	}

	@Override
	protected EntityNavigation createNavigation(World world) {
		return new SwimNavigation(this, world);
	}

	@Override
	protected void initDataTracker() {
		super.initDataTracker();
		this.dataTracker.startTracking(HAS_ACTIVE_TARGET, false);
		this.dataTracker.startTracking(CAN_RECOLOR, false);
	}

	@Override
	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);
		nbt.putBoolean("has_active_target", this.dataTracker.get(HAS_ACTIVE_TARGET));
		nbt.putBoolean("can_recolor", this.dataTracker.get(CAN_RECOLOR));
	}

	@Override
	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);
		setTargetState(nbt.getBoolean("has_active_target"));
		setTargetState(nbt.getBoolean("can_recolor"));
	}

	@Override
	public void setCustomName(@Nullable Text name) {
		super.setCustomName(name);

		if (name != null && name.equals(Text.literal("Fibula")))
			this.setCanBeRecolored(true);
	}

	// TODO: Change to generic fish flop sound
	@Override
	protected SoundEvent getFlopSound() {
		return SoundEvents.ENTITY_COD_FLOP;
	}

	@Override
	public boolean tryAttack(Entity entity) {
		boolean canAttack = super.tryAttack(entity) && entity instanceof LivingEntity;
		if (canAttack)
			((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(AquaticPlusStatusEffects.NUMBING, 6 * 20, 0), this);

		return canAttack;
	}

	@Override
	public void setTarget(@Nullable LivingEntity target) {
		super.setTarget(target);
                setTargetState(this.getTarget() != null);
	}

	@Override
	protected boolean isDisallowedInPeaceful() {
		return true;
	}

	public void setTargetState(boolean value) {
		this.dataTracker.set(HAS_ACTIVE_TARGET, value);
	}

	public void setCanBeRecolored(boolean value) {
		this.dataTracker.set(CAN_RECOLOR, value);
	}

	@Override
	public boolean shouldRenderName() {
		return false;
	}

	public static DefaultAttributeContainer.Builder createMaxillaMortisAttributes() {
		return FishEntity
			.createFishAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 36)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 4)
			.add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 2)
			.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 7);
	}
}