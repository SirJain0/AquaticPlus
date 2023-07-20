package com.sirjain.items;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
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
        PlayerEntity user = context.getPlayer();
        if (user == null) return ActionResult.PASS;

        world.setBlockState(user.isSneaking() ? context.getBlockPos().up() : context.getBlockPos(), Blocks.STONE.getDefaultState());

        if (!user.getAbilities().creativeMode)
            user.getItemCooldownManager().set(this, 40);

        return super.useOnBlock(context);
    }
}