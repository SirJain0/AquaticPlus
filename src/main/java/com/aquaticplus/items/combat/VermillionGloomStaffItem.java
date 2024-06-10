package com.aquaticplus.items.combat;

import com.aquaticplus.entities.entity.projectile.PlasmaEntity;
import com.aquaticplus.items.abstract_item.ShootingStaffItem;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.*;
import net.minecraft.world.World;

import java.util.ArrayList;

public class VermillionGloomStaffItem extends ShootingStaffItem {
	public VermillionGloomStaffItem() {
		super(new Item.Settings().maxCount(1).maxDamage(1704));
	}

	@Override
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 8*20, 0));

		if (target.getRandom().nextInt(3) == 0) {
			target.setOnFireFor(3);
		}

		if (isWearingMetalArmor(attacker)) {
			target.damage(target.getDamageSources().mobAttack(attacker), 3);
		}

		return super.postHit(stack, target, attacker);
	}

	public boolean isWearingMetalArmor(LivingEntity wearer) {
		ArrayList<ItemStack> armorItems = Lists.newArrayList(wearer.getArmorItems());

		ArmorMaterial gold = ArmorMaterials.GOLD;
		ArmorMaterial iron = ArmorMaterials.IRON;
		ArmorMaterial chain = ArmorMaterials.CHAIN;
		ArmorMaterial diamond = ArmorMaterials.DIAMOND;

		return armorItems.stream().filter(stack -> stack.getItem() instanceof ArmorItem armor && (armor.getMaterial() == gold || armor.getMaterial() == iron || armor.getMaterial() == chain || armor.getMaterial() == diamond)).count() == 4;
	}

	@Override
	public ProjectileEntity getEntity(World world, LivingEntity user) {
		return new PlasmaEntity(world, user);
	}

	@Override
	public ItemStack getAmmoItem() {
		return null;
	}

	@Override
	public float getProjectileVelocity() {
		return 0.9f;
	}

	@Override
	public int getNumProjectiles() {
		return 2;
	}

	@Override
	public int getDivergence() {
		return 8;
	}

	@Override
	public boolean hasAmmoItem() {
		return false;
	}

	@Override
	public boolean hasDurability() {
		return false;
	}

	@Override
	public int durabilityDecrement() {
		return 0;
	}
}
