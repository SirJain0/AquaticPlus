package com.sirjain.entities.entity;

import com.sirjain.entities.entity.template.NoBucketFishEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.FleeEntityGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.MoveIntoWaterGoal;
import net.minecraft.entity.ai.goal.SwimAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class ShadowSardelEasterEggEntity extends NoBucketFishEntity {
        public ShadowSardelEasterEggEntity(EntityType<? extends FishEntity> entityType, World world) {
                super(entityType, world);
                this.experiencePoints = 20;
        }

        @Override
        protected void initGoals() {
                this.goalSelector.add(0, new MoveIntoWaterGoal(this));
                this.goalSelector.add(2, new SwimAroundGoal(this, 1.0, 10));
                this.goalSelector.add(4, new LookAroundGoal(this));
                this.goalSelector.add(1, new FleeEntityGoal<>(this, PlayerEntity.class, 6.0F, 1.0, 1.3));
        }

        public static DefaultAttributeContainer.Builder createEasterEggAttributes() {
                return FishEntity
                        .createFishAttributes()
                        .add(EntityAttributes.GENERIC_MAX_HEALTH, 100)
                        .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.8f);
        }

        // TODO: Change this to a more generalized flop sound for all fish
        @Override
        protected SoundEvent getFlopSound() {
                return SoundEvents.ENTITY_COD_FLOP;
        }

        @Override
        public void tick() {
                super.tick();
                if (this.age % 60 == 0) this.heal(1);
        }
}