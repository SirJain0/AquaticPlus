package com.aquaticplus.entities.ai;

import com.aquaticplus.AquaticPlusUtil;
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
	protected void doDelayedAction(E boss) {
		if (this.target == null)
			return;

		if (!BrainUtils.canSee(boss, this.target) || boss.squaredDistanceTo(this.target) > this.attackRadius)
			return;

		// Attack
		AquaticPlusUtil.performPlasmaBallShootAttack(boss, target, 5);

		BrainUtils.setForgettableMemory(boss, MemoryModuleType.ATTACK_COOLING_DOWN, true, this.attackIntervalSupplier.apply(boss));
	}
}
