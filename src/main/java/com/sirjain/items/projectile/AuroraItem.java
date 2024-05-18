package com.sirjain.items.projectile;

import com.sirjain.entities.entity.projectile.AuroraEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class AuroraItem extends Item {
	public AuroraItem(Settings settings) {
		super(settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		final ItemStack stackInHand = user.getStackInHand(hand);

		if (world.isClient) return TypedActionResult.pass(stackInHand);

		ThrownItemEntity aurora = new AuroraEntity(world, user);
		aurora.setItem(stackInHand);
		aurora.setVelocity(user, user.getPitch(), user.getYaw(), 0, 0.75F, 0);
		world.spawnEntity(aurora);

		if (!user.getAbilities().creativeMode) {
			stackInHand.decrement(1);
			user.getItemCooldownManager().set(this, 5);
		}

		user.incrementStat(Stats.USED.getOrCreateStat(this));

		return TypedActionResult.success(stackInHand);
	}
}
