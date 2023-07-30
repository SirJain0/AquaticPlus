package com.sirjain.entities.entity;

import com.sirjain.entities.goals.APSwimAroundGoal;
import com.sirjain.registries.AquaticPlusEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.EscapeDangerGoal;
import net.minecraft.entity.ai.goal.MoveIntoWaterGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.world.World;

public class ShadowSardelEntity extends SchoolingFishEntity {
        public ShadowSardelEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
                super(entityType, world);
        }

        @Override
        protected void initGoals() {
                this.goalSelector.add(0, new MoveIntoWaterGoal(this));
                this.goalSelector.add(2, new APSwimAroundGoal(this, 1, 2, 12, 3));
                this.goalSelector.add(1, new EscapeDangerGoal(this, 1.3));
        }

        // TODO: Add generic flop sound
        @Override
        protected SoundEvent getFlopSound() {
                return null;
        }

        // TODO: Add bucket item
        @Override
        public ItemStack getBucketItem() {
                return null;
        }

        @Override
        public void tick() {
                super.tick();

                if (this.hasCustomName()) {
                        Text name = this.getCustomName();

                        if (Text.literal("Johnson").equals(name))
                                handleVariant(AquaticPlusEntities.JOHNSON_ENTITY);
                        else if (Text.literal("Mindinator").equals(name))
                                handleVariant(AquaticPlusEntities.MINDINATOR_ENTITY);
                }
        }

        public void handleVariant(EntityType<ShadowSardelEasterEggEntity> entityType) {
                ShadowSardelEasterEggEntity entity = entityType.create(this.getWorld());
                if (entity == null) return;
                entity.refreshPositionAndAngles(this.getX(), this.getY(), this.getZ(), this.getYaw(), 0.0F);
                this.getWorld().spawnEntity(entity);
                this.kill();
        }

        public static DefaultAttributeContainer.Builder createShadowSardelAttributes() {
                return SchoolingFishEntity
                        .createFishAttributes()
                        .add(EntityAttributes.GENERIC_MAX_HEALTH, 5)
                        .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 3);
        }
}