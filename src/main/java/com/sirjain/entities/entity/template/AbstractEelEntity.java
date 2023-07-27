package com.sirjain.entities.entity.template;

import com.sirjain.entities.goals.APSwimAroundGoal;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.MoveIntoWaterGoal;
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

public abstract class AbstractEelEntity extends FishEntity {
        public AbstractEelEntity(EntityType<? extends FishEntity> entityType, World world) {
                super(entityType, world);
        }

        @Override
        protected void initGoals() {
                this.goalSelector.add(0, new MoveIntoWaterGoal(this));
                this.goalSelector.add(1, new APSwimAroundGoal(this, 1, 1, 10, 5));
        }

        // TODO: Change to generic fish flop sound
        @Override
        protected SoundEvent getFlopSound() {
                return SoundEvents.ENTITY_COD_FLOP;
        }

        @Override
        public ItemStack getBucketItem() {
                return ItemStack.EMPTY;
        }

        @Override
        protected ActionResult interactMob(PlayerEntity player, Hand hand) {
                return ActionResult.PASS;
        }

        public static DefaultAttributeContainer.Builder createGenericEelAttributes() {
                return FishEntity
                        .createFishAttributes()
                        .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 3)
                        .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 2);
        }
}
