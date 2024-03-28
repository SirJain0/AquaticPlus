package com.sirjain.entities.entity;

import com.sirjain.entities.entity.template.AbstractEelEntity;
import com.sirjain.entities.goals.GulperEelAttackGoal;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.world.World;

/*
To do:
- Play bite animation for when it is attacking
*/
public class GulperEelEntity extends AbstractEelEntity {
	public static TrackedData<Boolean> IS_ATTACKING = DataTracker.registerData(GulperEelEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

	public final AnimationState swimAnimationState = new AnimationState();
	public final AnimationState attackAnimationState = new AnimationState();
	public int idleAnimationTimeout = 0;
	public int attackAnimationTimeout = 0;

	public GulperEelEntity(EntityType<? extends FishEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void initGoals() {
		super.initGoals();
		this.goalSelector.add(0, new GulperEelAttackGoal(this, 1.1D, true));
		this.targetSelector.add(0, new RevengeGoal(this));
	}

	@Override
	protected void initDataTracker() {
		super.initDataTracker();
		this.dataTracker.startTracking(IS_ATTACKING, false);
	}

	public void setIsAttacking(boolean attacking) {
		this.dataTracker.set(IS_ATTACKING, attacking);
	}

	public boolean isAttacking() {
		return this.dataTracker.get(IS_ATTACKING);
	}

	@Override
	public void tick() {
		super.tick();

		if (this.getWorld().isClient) this.setupAnimationStates();
//		if (this.getTarget() == null) this.setAttacking(false);
	}

	private void setupAnimationStates() {
		if (this.idleAnimationTimeout <= 0) {
			this.idleAnimationTimeout = 80;
			this.swimAnimationState.start(this.age);
		} else {
			--this.idleAnimationTimeout;
		}

//
//		if (this.isAttacking() && attackAnimationTimeout <= 0) {
//			attackAnimationTimeout = 40;
//			attackAnimationState.start(this.age);
//		} else {
//			--this.attackAnimationTimeout;
//		}
//
//		if (!this.isAttacking()) {
//			attackAnimationState.stop();
//		}
	}

//	@Override
//	public boolean tryAttack(Entity target) {
//		if (super.tryAttack(target) && target instanceof LivingEntity) {
//			this.setIsAttacking(true);
//		}
//
//		return super.tryAttack(target);
//	}

	public static DefaultAttributeContainer.Builder createGulperEelEntity() {
		return AbstractEelEntity
			.createGenericEelAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 20)
			.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 7);
	}
}
