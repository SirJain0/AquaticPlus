package com.sirjain.items.abstract_item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public abstract class AbstractStaffItem extends Item {
	private final int numProjectiles;
	private final float projectileVelocity;
	private final Item ammo;
	private final int divergence;

	public AbstractStaffItem(Settings settings, int numProjectiles, float projectileVelocity, Item ammo, int divergence) {
		super(settings);
		this.numProjectiles = numProjectiles;
		this.projectileVelocity = projectileVelocity;
		this.ammo = ammo;
		this.divergence = divergence;
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack stack = ammo.getDefaultStack();

		if (world.isClient) return TypedActionResult.pass(user.getStackInHand(hand));

		if (!user.getAbilities().creativeMode) {
			int slotWithShockBolt = user.getInventory().getSlotWithStack(stack);
			if (slotWithShockBolt < 0) return TypedActionResult.pass(user.getStackInHand(hand));

			user.getInventory().getStack(slotWithShockBolt).decrement(1);
			user.getStackInHand(hand).damage(1, user, (p) -> p.sendToolBreakStatus(user.getActiveHand()));
			user.getItemCooldownManager().set(this, 10);
		}


		for (int i = 0; i < numProjectiles; i++) {
			ThrownItemEntity projectile = getEntity(world, user);
			projectile.setItem(stack);
			projectile.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, projectileVelocity, world.random.nextInt(divergence));

			world.spawnEntity(projectile);
		}

		// TODO: Add custom staff sound
		// world.playSound(null, user.getX(), user.getY(), user.getZ(), MythicManiaSoundEvents.SHOCK_BOLT_STAFF_FIRE, SoundCategory.NEUTRAL, 0.7F, 2.5F);

		return super.use(world, user, hand);
	}

	public ThrownItemEntity getEntity(World world, LivingEntity user) {
		return null;
	}
}
