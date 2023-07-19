package com.sirjain.entities.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SpiritedFishEntity extends FishEntity {
    public SpiritedFishEntity(EntityType<? extends FishEntity> entityType, World world) {
        super(entityType, world);
    }

    // TODO: Change this to a more generalized flop sound for all fish
    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.ENTITY_COD_FLOP;
    }

    // TODO: Prevent crash and figure out how to not give fish bucket item
    @Nullable
    @Override
    public ItemStack getBucketItem() {
        return null;
    }

    @Override
    public void mobTick() {
        if (isTouchingWaterOrRain()) return;

        boolean isMobExplosionType = this.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING);
        World.ExplosionSourceType destructionType = isMobExplosionType
                ? World.ExplosionSourceType.MOB
                : World.ExplosionSourceType.NONE;
        World world = this.getWorld();

        if (!world.isClient && this.isAlive()) {
            world.createExplosion(this, this.getX(), this.getY(), this.getZ(), 1, destructionType);
            this.kill();
        }
    }

    public static DefaultAttributeContainer.Builder createSpiritedFishAttributes() {
        return FishEntity
                .createFishAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 6)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.8f);
    }
}