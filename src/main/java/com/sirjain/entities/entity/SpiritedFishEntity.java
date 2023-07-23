package com.sirjain.entities.entity;

import com.sirjain.entities.goals.APSwimAroundGoal;
import com.sirjain.registries.AquaticPlusItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.EscapeDangerGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

public class SpiritedFishEntity extends FishEntity {
    public SpiritedFishEntity(EntityType<? extends FishEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new APSwimAroundGoal(this, 1, 2, 12, 3));
        this.goalSelector.add(0, new EscapeDangerGoal(this, 1.3));
    }

    // TODO: Change this to a more generalized flop sound for all fish
    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.ENTITY_COD_FLOP;
    }

    @Override
    public ItemStack getBucketItem() {
        return new ItemStack(AquaticPlusItems.SPIRITED_FISH_BUCKET);
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
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 4);
    }
}