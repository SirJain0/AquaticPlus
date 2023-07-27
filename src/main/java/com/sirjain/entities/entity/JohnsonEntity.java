package com.sirjain.entities.entity;

import com.sirjain.registries.AquaticPlusItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.FleeEntityGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.MoveIntoWaterGoal;
import net.minecraft.entity.ai.goal.SwimAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class JohnsonEntity extends FishEntity {
        public JohnsonEntity(EntityType<? extends FishEntity> entityType, World world) {
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

        public static DefaultAttributeContainer.Builder createJohnsonAttributes() {
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
        public ItemStack getBucketItem() {
                return AquaticPlusItems.PARROTFISH_SPAWN_EGG.getDefaultStack();
        }

        @Override
        protected ActionResult interactMob(PlayerEntity player, Hand hand) {
                return ActionResult.PASS;
        }
}