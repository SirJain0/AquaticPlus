package com.sirjain.items;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DeoxidizingMaterialItem extends Item {
        public DeoxidizingMaterialItem(Settings settings) {
                super(settings);
        }

        @Override
        public ActionResult useOnBlock(ItemUsageContext context) {
                World world = context.getWorld();
                BlockPos pos = context.getBlockPos();
                PlayerEntity user = context.getPlayer();

                if (isState(world, pos, Blocks.OXIDIZED_COPPER)) world.setBlockState(pos, Blocks.WEATHERED_COPPER.getDefaultState());
                else if (isState(world, pos, Blocks.WEATHERED_COPPER)) world.setBlockState(pos, Blocks.EXPOSED_COPPER.getDefaultState());
                else if (isState(world, pos, Blocks.EXPOSED_COPPER)) world.setBlockState(pos, Blocks.COPPER_BLOCK.getDefaultState());

                if (isState(world, pos, Blocks.OXIDIZED_CUT_COPPER)) world.setBlockState(pos, Blocks.WEATHERED_CUT_COPPER.getDefaultState());
                else if (isState(world, pos, Blocks.WEATHERED_CUT_COPPER)) world.setBlockState(pos, Blocks.EXPOSED_CUT_COPPER.getDefaultState());
                else if (isState(world, pos, Blocks.EXPOSED_CUT_COPPER)) world.setBlockState(pos, Blocks.CUT_COPPER.getDefaultState());

                if (isState(world, pos, Blocks.OXIDIZED_CUT_COPPER_SLAB)) world.setBlockState(pos, Blocks.WEATHERED_CUT_COPPER_SLAB.getDefaultState());
                else if (isState(world, pos, Blocks.WEATHERED_CUT_COPPER_SLAB)) world.setBlockState(pos, Blocks.EXPOSED_CUT_COPPER_SLAB.getDefaultState());
                else if (isState(world, pos, Blocks.EXPOSED_CUT_COPPER_SLAB)) world.setBlockState(pos, Blocks.CUT_COPPER_SLAB.getDefaultState());

                if (user != null && !user.getAbilities().creativeMode) {
                        ItemStack stack = user.getStackInHand(user.getActiveHand());
                        stack.decrement(1);
                }

                return super.useOnBlock(context);
        }

        public boolean isState(World world, BlockPos pos, Block block) {
                return world.getBlockState(pos) == block.getDefaultState();
        }
}