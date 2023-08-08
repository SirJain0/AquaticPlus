package com.sirjain.items.abstract_item;

import com.sirjain.entities.entity.template.AbstractAquaticStarEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class AbstractAquaticStarItem extends Item {
	public AbstractAquaticStarItem(Settings settings) {
		super(settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		final ItemStack itemStack = user.getStackInHand(hand);

		if (!world.isClient) {
			AbstractAquaticStarEntity entity = getEntity(world, user);
//			if (entity == null) return TypedActionResult.pass(itemStack);

			entity.setItem(itemStack);
			entity.setVelocity(user, user.getPitch(), user.getYaw(), 0, 1.2F, 0);
			world.spawnEntity(entity);

			user.incrementStat(Stats.USED.getOrCreateStat(this));

			// TODO: Change to custom sound
			world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_ENDER_PEARL_THROW, SoundCategory.NEUTRAL, 0.5F, 1F);

			if (!user.getAbilities().creativeMode) {
				(itemStack).decrement(1);
				user.getItemCooldownManager().set(this, 5);
			}

			return TypedActionResult.success(itemStack);
		} else {
			return TypedActionResult.pass(itemStack);
		}
	}

	public AbstractAquaticStarEntity getEntity(World world, PlayerEntity user) {
		return null;
	}
}