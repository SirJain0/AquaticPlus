package com.sirjain.status_effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class SeaBaneStatusEffect extends StatusEffect {
	private int tickTimeout = 0;

	public SeaBaneStatusEffect(StatusEffectCategory statusEffectCategory, int color) {
		super(statusEffectCategory, color);
	}

	// TODO: This only sometimes happens, or happens after some time
	@Override
	public void applyUpdateEffect(LivingEntity entity, int amplifier) {
		int undeadResetTime = 20 - (3 * amplifier);
		int regularResetTime = 70 - (2 * amplifier);

		if (entity.isUndead()) handleDamage(amplifier >= 6 ? 5 : undeadResetTime, entity);
		else handleDamage(amplifier >= 30 ? 5 : regularResetTime, entity);

		System.out.println("Regular reset time:" + regularResetTime);
		System.out.println("Amplifier:" + amplifier);
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