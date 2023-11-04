package com.sirjain.items.abstract_item;

import com.sirjain.entities.entity.template.AbstractAquaticStarEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public abstract class AbstractAquaticStarItem extends Item {
	public AbstractAquaticStarItem(Settings settings) {
		super(settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		final ItemStack stackInHand = user.getStackInHand(hand);

		if (world.isClient) return TypedActionResult.pass(stackInHand);

		AbstractAquaticStarEntity star = getEntity(world, user);
		star.setItem(stackInHand);
		star.setVelocity(user, user.getPitch(), user.getYaw(), 0, 0.75F, 0);
		world.spawnEntity(star);

		if (!user.getAbilities().creativeMode) {
			stackInHand.decrement(1);
			user.getItemCooldownManager().set(this, 5);
		}

		// TODO: Change to custom sound
		world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_ENDER_PEARL_THROW, SoundCategory.NEUTRAL, 0.5F, 1F);
		user.incrementStat(Stats.USED.getOrCreateStat(this));

		return TypedActionResult.success(stackInHand);
	}

	abstract public AbstractAquaticStarEntity getEntity(World world, PlayerEntity user);
}