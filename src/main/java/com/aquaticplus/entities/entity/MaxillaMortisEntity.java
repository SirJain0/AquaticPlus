package com.aquaticplus.entities.entity;

import com.aquaticplus.entities.entity.template.NoBucketFishEntity;
import com.aquaticplus.registries.AquaticPlusStatusEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;
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
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(1, new SwimAroundGoal(this, 1.0, 10));
		this.goalSelector.add(2, new LookAroundGoal(this));
		this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.add(0, new AttackGoal(this));
		this.goalSelector.add(0, new MoveIntoWaterGoal(this));
		this.initTargetGoals();
	}

	protected void initTargetGoals() {
		List<Class<? extends LivingEntity>> targets = Arrays.asList(
			OculiMagniEntity.class,
			SchoolingFishEntity.class
		);

		for (Class<? extends LivingEntity> target : targets) {
			this.targetSelector.add(2, new ActiveTargetGoal<>(this, target, true));
		}

		this.targetSelector.add(0, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.add(1, new RevengeGoal(this));
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

		nbt.putBoolean("has_active_target", this.hasActiveTarget());
		nbt.putBoolean("can_recolor", this.canRecolor());
	}

	@Override
	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);

		this.setTargetState(nbt.getBoolean("has_active_target"));
		this.setTargetState(nbt.getBoolean("can_recolor"));
	}

	@Override
	public void travel(Vec3d movementInput) {
		super.travel(movementInput);

		if (this.hasActiveTarget() && this.isLogicalSideForUpdatingMovement())
			this.move(MovementType.SELF, this.getRotationVector().multiply(0.16f));
	}

	@Override
	public void setCustomName(@Nullable Text name) {
		super.setCustomName(name);

		if (name != null && name.equals(Text.literal("Fibula")))
			this.setCanBeRecolored(true);
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
                this.setTargetState(this.getTarget() != null);
	}

	@Override
	protected boolean isDisallowedInPeaceful() {
		return true;
	}

	public void setTargetState(boolean value) {
		this.dataTracker.set(HAS_ACTIVE_TARGET, value);
	}

	public boolean hasActiveTarget() {
		return this.dataTracker.get(HAS_ACTIVE_TARGET);
	}

	public void setCanBeRecolored(boolean value) {
		this.dataTracker.set(CAN_RECOLOR, value);
	}

	public boolean canRecolor() {
		return this.dataTracker.get(CAN_RECOLOR);
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