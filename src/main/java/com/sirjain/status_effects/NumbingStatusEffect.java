package com.sirjain.status_effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class NumbingStatusEffect extends StatusEffect {
	public NumbingStatusEffect(StatusEffectCategory category, int color) {
		super(category, color);
	}

	@Override
	public void applyUpdateEffect(LivingEntity entity, int amplifier) {
		World world = entity.getWorld();
		entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20, amplifier / 2, false, false, false));

		if (canDropItemInHand(entity, world, amplifier)) {
			ItemStack stackInActiveHand = entity.getStackInHand(entity.getActiveHand());

			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).dropItem(stackInActiveHand.copyWithCount(1), false, true);
			else entity.dropStack(stackInActiveHand.copyWithCount(1));

			stackInActiveHand.decrement(1);
		}
	}

	public boolean canDropItemInHand(LivingEntity entity, World world, int amplifier) {
		return entity.handSwingProgress > 0.83 &&
			!world.isClient &&
			world.random.nextInt(7 - (amplifier / 2 + 1)) == 0;
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return true;
	}
}