package com.sirjain.entities.goals;

import com.sirjain.entities.entity.GulperEelEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.util.Hand;

// Credit to KaupenJoe!
public class GulperEelAttackGoal extends MeleeAttackGoal {
	private final GulperEelEntity entity;
	private int attackDelay = 20;
	private int ticksUntilNextAttack = 20;
	private boolean shouldCountTillNextAttack = false;

	public GulperEelAttackGoal(GulperEelEntity mob, double speed, boolean pauseWhenMobIdle) {
		super(mob, speed, pauseWhenMobIdle);
		entity = mob;
	}

	@Override
	public void start() {
		super.start();
		attackDelay = 20;
		ticksUntilNextAttack = 20;
	}

	@Override
	protected void attack(LivingEntity pEnemy, double pDistToEnemySqr) {
		if (isEnemyWithinAttackDistance(pEnemy, pDistToEnemySqr)) {
			shouldCountTillNextAttack = true;

			if (isTimeToStartAttackAnimation()) {
				entity.setIsAttacking(true);
			}

			if (isTimeToAttack()) {
				this.mob.getLookControl().lookAt(pEnemy.getX(), pEnemy.getEyeY(), pEnemy.getZ());
				performAttack(pEnemy);
			}
		} else {
			resetAttackCooldown();
			shouldCountTillNextAttack = false;
			entity.setIsAttacking(false);
			entity.attackAnimationTimeout = 0;
		}
	}

	private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy, double pDistToEnemySqr) {
		return pDistToEnemySqr <= this.getSquaredMaxAttackDistance(pEnemy);
	}

	protected void resetAttackCooldown() {
		this.ticksUntilNextAttack = this.getTickCount(attackDelay * 2);
	}

	protected boolean isTimeToStartAttackAnimation() {
		return this.ticksUntilNextAttack <= attackDelay;
	}

	protected boolean isTimeToAttack() {
		return this.ticksUntilNextAttack <= 0;
	}

	protected void performAttack(LivingEntity pEnemy) {
		this.resetAttackCooldown();
		this.mob.swingHand(Hand.MAIN_HAND);
		this.mob.tryAttack(pEnemy);
	}

	@Override
	public void tick() {
		super.tick();
		if(shouldCountTillNextAttack) {
			this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
		}
	}

	@Override
	public void stop() {
		entity.setIsAttacking(false);
		super.stop();
	}
}