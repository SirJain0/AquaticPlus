package com.sirjain.entities.entity;

import com.sirjain.entities.features.APMoveToBlockGoal;
import com.sirjain.entities.goals.APSwimAroundGoal;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.EscapeDangerGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class ParrotfishEntity extends SchoolingFishEntity {
        ParrotfishEntity parrotFishEntity = this;

        public ParrotfishEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
                super(entityType, world);
        }

        public static DefaultAttributeContainer.Builder createParrotfishAttributes() {
                return FishEntity
                        .createFishAttributes()
                        .add(EntityAttributes.GENERIC_MAX_HEALTH, 8)
                        .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 3);
        }

        @Override
        protected void initGoals() {
                this.goalSelector.add(2, new APSwimAroundGoal(this, 1, 1, 10, 4));
                this.goalSelector.add(0, new EscapeDangerGoal(this, 1.3));
                this.goalSelector.add(0, new APMoveToBlockGoal(this, 1.3f, 10, 1));
        }

        // TODO: Replace with generic flop sound
        @Override
        protected SoundEvent getFlopSound() {
                return SoundEvents.ENTITY_COD_FLOP;
        }

        // TODO: Add bucket item
        @Override
        public ItemStack getBucketItem() {
                return null;
        }
}
