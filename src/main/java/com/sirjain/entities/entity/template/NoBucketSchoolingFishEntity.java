package com.sirjain.entities.entity.template;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class NoBucketSchoolingFishEntity extends SchoolingFishEntity {
        public NoBucketSchoolingFishEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
                super(entityType, world);
        }

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
}
