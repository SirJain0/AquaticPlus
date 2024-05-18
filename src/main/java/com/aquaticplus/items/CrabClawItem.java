package com.aquaticplus.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

// TODO: When this mod gets updated, add extra build reach.
public class CrabClawItem extends Item {
	public CrabClawItem(Settings settings) {
		super(settings);
	}

	@Override
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		DamageSource attackDamageSource = attacker.isPlayer()
			? target.getDamageSources().playerAttack((PlayerEntity) attacker)
			: target.getDamageSources().magic();

		target.damage(attackDamageSource, 3);

		return super.postHit(stack, target, attacker);
	}
}