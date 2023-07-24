package com.sirjain.status_effects;

import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class NumbingStatusEffect extends StatusEffect {
    public NumbingStatusEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        Vec3d velocityPriorEffect = entity.getVelocity();
        World world = entity.getWorld();
        entity.setVelocity(velocityPriorEffect.x * 0.85f, velocityPriorEffect.y, velocityPriorEffect.z * 0.85f);

        if (canDropItemInHand(entity, world, amplifier)) {
            ItemStack stackInActiveHand = entity.getStackInHand(entity.getActiveHand());

            if (!stackInActiveHand.isEmpty() && !world.isClient) {
                ItemEntity itemEntity = new ItemEntity(world, entity.getX(), entity.getY(), entity.getZ(), stackInActiveHand);
                Vec3d velocity = itemEntity.getVelocity();

                itemEntity.setVelocity(
                        velocity.x + world.random.nextFloat() * 0.2f - world.random.nextFloat() * 0.4f,
                        velocity.y,
                        velocity.z + world.random.nextFloat() * 0.2f - world.random.nextFloat() * 0.4f
                );

                itemEntity.setNoGravity(false);
                itemEntity.setToDefaultPickupDelay();
                world.spawnEntity(itemEntity);

                if (entity instanceof PlayerEntity)
                    ((PlayerEntity) entity).incrementStat(Stats.USED.getOrCreateStat(stackInActiveHand.getItem()));
            }

            if (world.isClient) {
                ItemStack stack = entity.getStackInHand(entity.getActiveHand());
                stack.decrement(1);

                if (entity instanceof PlayerEntity)
                    ((PlayerEntity) entity).playerScreenHandler.sendContentUpdates();
            }
        }
    }

    public boolean canDropItemInHand(LivingEntity entity, World world, int amplifier) {
        return entity.handSwingProgress > 0.83;
//                world.random.nextInt(10 - (amplifier / 2 + 1)) == 0;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}