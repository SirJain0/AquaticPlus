package com.sirjain.status_effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class SeaBaneStatusEffect extends StatusEffect {
	private int tickTimeout = 0;

	public SeaBaneStatusEffect(StatusEffectCategory statusEffectCategory, int color) {
		super(statusEffectCategory, color);
	}

	@Override
	public void applyUpdateEffect(LivingEntity entity, int amplifier) {
		if (entity.isUndead()) handleDamage(20 - amplifier, entity);
		else handleDamage(70 - (2 * amplifier), entity);
	}

	public void handleDamage(int resetTime, LivingEntity entity) {
		if (entity.getHealth() == 1) return;

		if (tickTimeout == resetTime) {
			entity.damage(entity.getDamageSources().magic(), 1);
			tickTimeout = 0;
		} else {
			tickTimeout++;
		}
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return true;
	}
}