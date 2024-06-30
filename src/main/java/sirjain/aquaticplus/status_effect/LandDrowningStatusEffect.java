package sirjain.aquaticplus.status_effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class LandDrowningStatusEffect extends StatusEffect {
	public LandDrowningStatusEffect(StatusEffectCategory category, int color) {
		super(category, color);
	}

	@Override
	public void applyUpdateEffect(LivingEntity entity, int amplifier) {
		if (!entity.canBreatheInWater() && entity.isAlive()) {
			entity.setAir(entity.getAir() - (5 + amplifier));

			if (entity.getAir() < -19) {
				entity.damage(entity.getDamageSources().drown(), amplifier > 0 ? 2 : 1);
				entity.setAir(0);
			}
		}
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return true;
	}
}
