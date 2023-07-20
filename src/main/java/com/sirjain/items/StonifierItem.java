package com.sirjain.items;

import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

public class StonifierItem extends Item {
    public StonifierItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        world.setBlockState(context.getBlockPos(), Blocks.STONE.getDefaultState());

        return super.useOnBlock(context);
    }
}
