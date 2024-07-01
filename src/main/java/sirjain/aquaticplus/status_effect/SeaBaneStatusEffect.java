package sirjain.aquaticplus.status_effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class SeaBaneStatusEffect extends StatusEffect {
	private int tickTimeout = 0;

	public SeaBaneStatusEffect(StatusEffectCategory statusEffectCategory, int color) {
		super(statusEffectCategory, color);
	}

	@Override
	public void applyUpdateEffect(LivingEntity entity, int amplifier) {
		int appliedAmplifier = entity.isUndead()
			? Math.min(amplifier, 6)
			: Math.min(amplifier, 29);

		int resetTime = entity.isUndead()
			? 30 - (3 * appliedAmplifier)
			: 70 - (2 * appliedAmplifier);

		handleDamage(resetTime, entity);
	}

	public void handleDamage(int resetTime, LivingEntity entity) {
		if (entity.getHealth() == 1) return;

		if (tickTimeout > resetTime) {
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

	@Override
	public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
		super.onApplied(entity, attributes, amplifier);
		tickTimeout = 0;
	}
}