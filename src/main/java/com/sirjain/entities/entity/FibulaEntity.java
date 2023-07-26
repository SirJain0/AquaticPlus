package com.sirjain.entities.entity;

import com.sirjain.entities.goals.APSwimAroundGoal;
import com.sirjain.registries.AquaticPlusStatusEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.AttackGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class FibulaEntity extends FishEntity {
        public FibulaEntity(EntityType<? extends FishEntity> entityType, World world) {
                super(entityType, world);
        }

        public static DefaultAttributeContainer.Builder createFibulaAttributes() {
                return FishEntity
                        .createFishAttributes()
                        .add(EntityAttributes.GENERIC_MAX_HEALTH, 36)
                        .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 4)
                        .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 2)
                        .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 7);
        }

        @Override
        protected void initGoals() {
                this.goalSelector.add(1, new APSwimAroundGoal(this, 1, 1, 10, 3));
                this.goalSelector.add(0, new AttackGoal(this));
                this.initTargetGoals();
        }

        // TODO: Simplify target selectors to include some sort of iterable array to prevent repetitive code
        protected void initTargetGoals() {
                this.targetSelector.add(0, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
                this.targetSelector.add(2, new ActiveTargetGoal<>(this, SalmonEntity.class, true));
                this.targetSelector.add(2, new ActiveTargetGoal<>(this, CodEntity.class, true));
                this.targetSelector.add(2, new ActiveTargetGoal<>(this, TropicalFishEntity.class, true));
                this.targetSelector.add(2, new ActiveTargetGoal<>(this, SchoolingFishEntity.class, true));

                this.targetSelector.add(1, new RevengeGoal(this));
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

        @Override
        public boolean tryAttack(Entity target) {
                boolean canAttack = super.tryAttack(target) && target instanceof LivingEntity;
                if (canAttack)
                        ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(AquaticPlusStatusEffects.NUMBING, 6 * 20, 0), this);

                return canAttack;
        }

        @Override
        protected boolean isDisallowedInPeaceful() {
                return true;
        }
}