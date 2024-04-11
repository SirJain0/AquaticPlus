package com.sirjain.status_effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class SeaBaneStatusEffect extends StatusEffect {
	private int hurtTimeout = 0;

	public SeaBaneStatusEffect(StatusEffectCategory statusEffectCategory, int color) {
		super(statusEffectCategory, color);
	}

	@Override
	public void applyUpdateEffect(LivingEntity entity, int amplifier) {
		if (!entity.isUndead()) return;

		if (hurtTimeout == 20 - amplifier) {
			entity.damage(entity.getDamageSources().magic(), 1);
			hurtTimeout = 0;
		} else {
			hurtTimeout++;
		}
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return true;
	}
}