package com.sirjain.items;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.List;

public class DetoxifyingAcidItem extends Item {
    public DetoxifyingAcidItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        PlayerEntity user = context.getPlayer();
        List<BlockState> copperStates = Arrays.asList(
                Blocks.EXPOSED_COPPER.getDefaultState(),
                Blocks.WEATHERED_COPPER.getDefaultState(),
                Blocks.OXIDIZED_COPPER.getDefaultState()
        );

        if (copperStates.contains(world.getBlockState(pos)))
            world.setBlockState(pos, Blocks.COPPER_BLOCK.getDefaultState());

        if (user != null && user.getAbilities().creativeMode) {
            ItemStack stack = user.getStackInHand(user.getActiveHand());
            stack.decrement(1);
        }

        return super.useOnBlock(context);
    }
}