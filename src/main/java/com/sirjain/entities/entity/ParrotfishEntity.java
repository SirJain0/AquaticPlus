package com.sirjain.entities.entity;

import com.sirjain.entities.goals.APSwimAroundGoal;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.EscapeDangerGoal;
import net.minecraft.entity.ai.goal.MoveToTargetPosGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

import java.util.Arrays;
import java.util.List;

public class ParrotfishEntity extends SchoolingFishEntity {
    ParrotfishEntity parrotFishEntity = this;

    public ParrotfishEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(2, new APSwimAroundGoal(this, 1, 1, 10, 4));
        this.goalSelector.add(0, new EscapeDangerGoal(this, 1.3));
        this.goalSelector.add(1, new MoveToTargetPosGoal(this, 1.3, 12) {
            @Override
            protected boolean isTargetPos(WorldView world, BlockPos pos) {
                List<BlockState> preferredBlocks = Arrays.asList(
                        Blocks.STONE.getDefaultState(),
                        Blocks.GRAVEL.getDefaultState(),
                        Blocks.DEAD_BRAIN_CORAL.getDefaultState(),
                        Blocks.DEAD_TUBE_CORAL.getDefaultState(),
                        Blocks.DEAD_BUBBLE_CORAL.getDefaultState(),
                        Blocks.DEAD_BRAIN_CORAL_FAN.getDefaultState(),
                        Blocks.DEAD_BUBBLE_CORAL_FAN.getDefaultState()
                );

                boolean isTargetBlock = preferredBlocks.contains(world.getBlockState(pos));
                if (isTargetBlock)
                    parrotFishEntity.getWorld().breakBlock(pos, false);

                return preferredBlocks.contains(world.getBlockState(pos));
            }
        });
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

    public static DefaultAttributeContainer.Builder createParrotfishAttributes() {
        return FishEntity
                .createFishAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 8)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 3);
    }
}
