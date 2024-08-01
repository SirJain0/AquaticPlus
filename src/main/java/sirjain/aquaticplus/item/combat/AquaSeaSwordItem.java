package sirjain.aquaticplus.item.combat;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import sirjain.aquaticplus.item.abstract_item.SeaSwordItem;
import sirjain.aquaticplus.status_effect.AquaticPlusStatusEffects;

public class AquaSeaSwordItem extends SeaSwordItem {
	@Override
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20*5, 0));

		if (target.getRandom().nextInt(3) == 0) {
			target.addStatusEffect(new StatusEffectInstance(AquaticPlusStatusEffects.LAND_DROWNING));
		}

		return super.postHit(stack, target, attacker);
	}

	@Override
	public ParticleEffect getParticle() {
		return ParticleTypes.END_ROD;
	}
}
