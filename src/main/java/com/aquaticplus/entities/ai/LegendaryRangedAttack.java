package com.aquaticplus.entities.ai;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.tslat.smartbrainlib.api.core.behaviour.custom.attack.AnimatableRangedAttack;
import net.tslat.smartbrainlib.util.BrainUtils;

public class LegendaryRangedAttack<E extends LivingEntity & RangedAttackMob> extends AnimatableRangedAttack<E> {
	public LegendaryRangedAttack(int delayTicks) {
		super(delayTicks);
	}

	@Override
	protected void doDelayedAction(E entity) {
		if (this.target == null)
			return;

		if (!BrainUtils.canSee(entity, this.target) || entity.squaredDistanceTo(this.target) > this.attackRadius)
			return;

		// Attack here
		System.out.println("Legendary attack!");

		BrainUtils.setForgettableMemory(entity, MemoryModuleType.ATTACK_COOLING_DOWN, true, this.attackIntervalSupplier.apply(entity));
	}
}
