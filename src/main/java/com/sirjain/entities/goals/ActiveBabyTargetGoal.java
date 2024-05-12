package com.sirjain.entities.goals;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.mob.MobEntity;

public class ActiveBabyTargetGoal<T extends LivingEntity> extends ActiveTargetGoal<T> {
	public ActiveBabyTargetGoal(MobEntity mob, Class<T> targetClass, boolean checkVisibility) {
		super(mob, targetClass, checkVisibility);
	}

	@Override
	public boolean canStart() {
		return super.canStart() && targetEntity.isBaby();
	}
}
