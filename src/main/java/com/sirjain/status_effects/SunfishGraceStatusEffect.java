package com.sirjain.status_effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class SunfishGraceStatusEffect extends StatusEffect {
	public SunfishGraceStatusEffect(StatusEffectCategory category, int color) {
		super(category, color);
	}

	@Override
	public void applyUpdateEffect(LivingEntity entity, int amplifier) {
		if (entity.isInsideWaterOrBubbleColumn()) {
			float boostedVel = 1.1f + (amplifier / 20f);
			entity.setVelocity(entity.getVelocity().multiply(boostedVel, 1, boostedVel));
		}
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return true;
	}
}