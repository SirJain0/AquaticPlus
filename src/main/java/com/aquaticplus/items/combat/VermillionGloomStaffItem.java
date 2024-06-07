package com.aquaticplus.items.combat;

import com.google.common.collect.Lists;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;

public class VermillionGloomStaffItem extends SwordItem {
	public VermillionGloomStaffItem() {
		super(ToolMaterials.DIAMOND, 6, 0, new Item.Settings().maxCount(1).maxDamage(1704));
	}

	@Override
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 8*20, 0));

		if (isWearingMetalArmor(attacker)) {
			target.damage(target.getDamageSources().mobAttack(attacker), 3);
		}

		return super.postHit(stack, target, attacker);
	}

	public boolean isWearingMetalArmor(LivingEntity wearer) {
		var list = Lists.newArrayList(wearer.getArmorItems());

		var gold = ArmorMaterials.GOLD;
		var iron = ArmorMaterials.IRON;
		var chain = ArmorMaterials.CHAIN;
		var diamond = ArmorMaterials.DIAMOND;

		return list.stream().filter(stack -> stack.getItem() instanceof ArmorItem armor && (armor.getMaterial() == gold || armor.getMaterial() == iron || armor.getMaterial() == chain || armor.getMaterial() == diamond)).count() == 4;
	}
}
