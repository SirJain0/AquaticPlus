package com.aquaticplus.entities.ai;

import com.aquaticplus.entities.entity.projectile.PlasmaEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.projectile.thrown.ThrownEntity;
import net.tslat.smartbrainlib.api.core.behaviour.custom.attack.AnimatableRangedAttack;
import net.tslat.smartbrainlib.util.BrainUtils;

public class PlasmaBallShootAttack<E extends LivingEntity & RangedAttackMob> extends AnimatableRangedAttack<E> {
	public PlasmaBallShootAttack(int delayTicks) {
		super(delayTicks);
	}

	@Override
	protected void doDelayedAction(E entity) {
		if (this.target == null)
			return;

		if (!BrainUtils.canSee(entity, this.target) || entity.squaredDistanceTo(this.target) > this.attackRadius)
			return;

		// Attack here
		System.out.println("Plasma ball attack!");

		double xCoord = target.getX() - entity.getX();
		double zCoord = target.getZ() - entity.getZ();
		double velPath = Math.sqrt(xCoord * xCoord + zCoord * zCoord);

		for (int i = 0; i < 5; i++) {
			ThrownEntity projectile = new PlasmaEntity(entity.getWorld(), entity, false);
			double yCoord = target.getBodyY(0.3f) - projectile.getY() - 2;

			projectile.setVelocity(xCoord, yCoord + velPath * (double) 0.2f, zCoord, 1, 20);
			entity.getWorld().spawnEntity(projectile);
		}

		BrainUtils.setForgettableMemory(entity, MemoryModuleType.ATTACK_COOLING_DOWN, true, this.attackIntervalSupplier.apply(entity));
	}
}
