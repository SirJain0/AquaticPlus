package com.sirjain.items;

import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
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
        PlayerEntity user = context.getPlayer();

        if (world.getBlockState(breakPos) == Blocks.STONE.getDefaultState())
            world.breakBlock(breakPos, false);

        if (user != null && !user.getAbilities().creativeMode) {
            user.getStackInHand(user.getActiveHand()).damage(1, user, (p) -> p.sendToolBreakStatus(user.getActiveHand()));
            user.getItemCooldownManager().set(this, 40);
        }

        return super.useOnBlock(context);
    }
}
