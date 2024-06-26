package sirjain.aquaticplus.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import sirjain.aquaticplus.status_effect.AquaticPlusStatusEffects;

public class LionfishSpikeItem extends Item {
	public LionfishSpikeItem() {
		super(new Item.Settings());
	}

	@Override
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		target.addStatusEffect(new StatusEffectInstance(AquaticPlusStatusEffects.SEA_BANE, 20*3, 0));
		return super.postHit(stack, target, attacker);
	}
}