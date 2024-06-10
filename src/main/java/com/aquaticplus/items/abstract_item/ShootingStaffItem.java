package com.aquaticplus.items.abstract_item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public abstract class ShootingStaffItem extends Item {
	public ShootingStaffItem(Settings settings) {
		super(settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		if (world.isClient) return TypedActionResult.pass(user.getStackInHand(hand));

		if (!user.getAbilities().creativeMode && this.hasAmmoItem()) {
			if (this.hasAmmoItem()) {
				int slotWithProjectile = user.getInventory().getSlotWithStack(getAmmoItem());

				if (slotWithProjectile < 0)
					return TypedActionResult.pass(user.getStackInHand(hand));

				user.getInventory().getStack(slotWithProjectile).decrement(1);
			}

			if (hasDurability()) {
				user.getStackInHand(hand).damage(durabilityDecrement(), user, (p) -> p.sendToolBreakStatus(user.getActiveHand()));
			}

			user.getItemCooldownManager().set(this, 10);
		}

		int divergence;
		if (getDivergence() != 0) divergence = world.random.nextInt(getDivergence());
		else divergence = 0;

		for (int i = 0; i < getNumProjectiles(); i++) {
			ProjectileEntity projectile = getEntity(world, user);

			if (projectile instanceof ThrownItemEntity thrownItemEntity) thrownItemEntity.setItem(getAmmoItem());

			projectile.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, getProjectileVelocity(), divergence);
			world.spawnEntity(projectile);
		}

		// TODO: Add custom staff sound
		// world.playSound(null, user.getX(), user.getY(), user.getZ(), MythicManiaSoundEvents.SHOCK_BOLT_STAFF_FIRE, SoundCategory.NEUTRAL, 0.7F, 2.5F);

		return super.use(world, user, hand);
	}

	abstract public ProjectileEntity getEntity(World world, LivingEntity user);

	@Nullable abstract public ItemStack getAmmoItem();

	abstract public float getProjectileVelocity();

	abstract public int getNumProjectiles();

	abstract public int getDivergence();

	abstract public boolean hasAmmoItem();

	abstract public boolean hasDurability();

	abstract public int durabilityDecrement();
}
