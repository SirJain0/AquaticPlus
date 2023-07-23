package com.sirjain.status_effects;

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

        if (entity.handSwingProgress > 0 && entity.getWorld().random.nextInt(45 - (amplifier * 2)) == 0) {
            ItemStack stackInActiveHand = entity.getStackInHand(entity.getActiveHand());
            entity.dropItem(stackInActiveHand.getItem(), 5);
            stackInActiveHand.decrement(1);
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}