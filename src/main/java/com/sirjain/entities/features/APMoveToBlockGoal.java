package com.sirjain.entities.features;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ai.goal.MoveToTargetPosGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;

import java.util.Arrays;
import java.util.List;

public class APMoveToBlockGoal extends MoveToTargetPosGoal {
    private final int range;
    private final int maxYDifference;

    public APMoveToBlockGoal(PathAwareEntity mob, double speed, int range, int maxYDifference) {
        super(mob, speed, range);
        this.range = range;
        this.maxYDifference = maxYDifference;
    }

    final List<BlockState> preferredBlocks = Arrays.asList(
            Blocks.STONE.getDefaultState(),
            Blocks.GRAVEL.getDefaultState(),
            Blocks.DEAD_BRAIN_CORAL.getDefaultState(),
            Blocks.DEAD_TUBE_CORAL.getDefaultState(),
            Blocks.DEAD_BUBBLE_CORAL.getDefaultState(),
            Blocks.DEAD_BRAIN_CORAL_FAN.getDefaultState(),
            Blocks.DEAD_BUBBLE_CORAL_FAN.getDefaultState()
    );

    @Override
    protected boolean isTargetPos(WorldView world, BlockPos pos) {
        return preferredBlocks.contains(world.getBlockState(pos));
    }

    protected boolean findTargetPos() {
        BlockPos blockPos = this.mob.getBlockPos();
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        for(int k = this.lowestY; k <= this.maxYDifference; k = k > 0 ? -k : 1 - k) {
            for(int l = 0; l < this.range; ++l) {
                for(int m = 0; m <= l; m = m > 0 ? -m : 1 - m) {
                    for(int n = m < l && m > -l ? l : 0; n <= l; n = n > 0 ? -n : 1 - n) {
                        mutable.set(blockPos, m, k - 1, n);
                        if (this.mob.isInWalkTargetRange(mutable) && this.isTargetPos(this.mob.getWorld(), mutable)) {
                            this.targetPos = mutable;
                            this.mob.getWorld().breakBlock(targetPos, false);
                            this.mob.heal(2);
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}