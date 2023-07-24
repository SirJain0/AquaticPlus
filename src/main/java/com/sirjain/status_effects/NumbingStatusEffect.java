package com.sirjain.status_effects;

import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;

public class NumbingStatusEffect extends StatusEffect {
    public NumbingStatusEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        Vec3d velocityPriorEffect = entity.getVelocity();
        entity.setVelocity(velocityPriorEffect.x * 0.8f, velocityPriorEffect.y, velocityPriorEffect.z * 0.8f);

        if (canDropItemInHand(entity, amplifier)) {
            ItemStack stackInActiveHand = entity.getStackInHand(entity.getActiveHand());
//            entity.dropItem(stackInActiveHand.getItem(), 5);
//            System.out.println(entity.handSwingProgress);

            if (!stackInActiveHand.isEmpty()) {
                ItemEntity itemEntity = new ItemEntity(entity.getWorld(), entity.getX(), entity.getY(), entity.getZ(), stackInActiveHand);
//                itemEntity.setVelocity();
                itemEntity.setToDefaultPickupDelay();
                entity.getWorld().spawnEntity(itemEntity);
            }
        }
    }

    public boolean canDropItemInHand(LivingEntity entity, int amplifier) {
        return entity.handSwingProgress > 0.83 &&
                entity.getWorld().random.nextInt(10 - (amplifier / 2 + 1)) == 0;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}