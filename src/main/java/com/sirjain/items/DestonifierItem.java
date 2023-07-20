package com.sirjain.items;

import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DestonifierItem extends Item {
    public DestonifierItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos breakPos = context.getBlockPos();

        if (world.getBlockState(breakPos) == Blocks.STONE.getDefaultState())
            world.breakBlock(breakPos, false);

        return super.useOnBlock(context);
    }
}
