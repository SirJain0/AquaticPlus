package com.aquaticplus.items.abstract_item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public abstract class ShootingStaffItem extends Item {
	public ShootingStaffItem(Settings settings) {
		super(settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		if (world.isClient) return TypedActionResult.pass(user.getStackInHand(hand));

		if (!user.getAbilities().creativeMode) {
			int slotWithShockBolt = user.getInventory().getSlotWithStack(getAmmoItem());
			if (slotWithShockBolt < 0) return TypedActionResult.pass(user.getStackInHand(hand));

			user.getInventory().getStack(slotWithShockBolt).decrement(1);
			user.getStackInHand(hand).damage(1, user, (p) -> p.sendToolBreakStatus(user.getActiveHand()));
			user.getItemCooldownManager().set(this, 10);
		}

		for (int i = 0; i < getNumProjectiles(); i++) {
			ThrownItemEntity projectile = getEntity(world, user);
			projectile.setItem(getAmmoItem());
			projectile.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, getProjectileVelocity(), world.random.nextInt(getDivergence()));

			world.spawnEntity(projectile);
		}

		// TODO: Add custom staff sound
		// world.playSound(null, user.getX(), user.getY(), user.getZ(), MythicManiaSoundEvents.SHOCK_BOLT_STAFF_FIRE, SoundCategory.NEUTRAL, 0.7F, 2.5F);

		return super.use(world, user, hand);
	}

	abstract public ThrownItemEntity getEntity(World world, LivingEntity user);

	abstract public ItemStack getAmmoItem();

	abstract public float getProjectileVelocity();

	abstract public int getNumProjectiles();

	abstract public int getDivergence();
}
