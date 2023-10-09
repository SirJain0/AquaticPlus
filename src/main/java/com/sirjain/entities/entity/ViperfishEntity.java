package com.sirjain.entities.entity;

import com.sirjain.entities.entity.template.NoBucketFishEntity;
import com.sirjain.registries.AquaticPlusStatusEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.EscapeDangerGoal;
import net.minecraft.entity.ai.goal.FleeEntityGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.ElderGuardianEntity;
import net.minecraft.entity.mob.GuardianEntity;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class ViperfishEntity extends NoBucketFishEntity {
	public ViperfishEntity(EntityType<? extends FishEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void initGoals() {
		super.initGoals();
		this.goalSelector.add(isLowOnHealth() ? 4 : 0, new MeleeAttackGoal(this, 1.4, true));
		this.goalSelector.add(isLowOnHealth() ? 0 : 5, new EscapeDangerGoal(this, 1.4f));
		this.targetSelector.add(0, new RevengeGoal(this, ElderGuardianEntity.class, GuardianEntity.class));
	}

	// TODO: Change to generic sound flop
	@Override
	protected SoundEvent getFlopSound() {
		return SoundEvents.ENTITY_COD_FLOP;
	}

	public boolean isLowOnHealth() {
		return this.getHealth() < this.getMaxHealth() / 2;
	}

	@Override
	public boolean tryAttack(Entity entity) {
		boolean canAttack = super.tryAttack(entity) && entity instanceof LivingEntity;
		if (canAttack)
			((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 6 * 20, 0), this);

		return canAttack;
	}

	public static DefaultAttributeContainer.Builder createViperfishAttributes() {
		return FishEntity
			.createFishAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 16)
			.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 4.2f);
	}
}