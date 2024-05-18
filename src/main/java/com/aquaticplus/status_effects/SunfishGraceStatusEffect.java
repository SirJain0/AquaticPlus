package com.aquaticplus.status_effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class SunfishGraceStatusEffect extends StatusEffect {
	public SunfishGraceStatusEffect(StatusEffectCategory category, int color) {
		super(category, color);
	}

	@Override
	public void applyUpdateEffect(LivingEntity entity, int amplifier) {
		if (entity.isInsideWaterOrBubbleColumn() && entity.isLogicalSideForUpdatingMovement())
			entity.move(MovementType.SELF, entity.getRotationVector().multiply(0.16f + (amplifier / 50f)));
	}

	@Override
	public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
		if (entity.getHealth() < entity.getMaxHealth())
			entity.heal(2);
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return true;
	}
}