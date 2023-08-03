package com.sirjain.items;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class StonifierItem extends Item {
        public StonifierItem(Settings settings) {
                super(settings);
        }

        @Override
        public ActionResult useOnBlock(ItemUsageContext context) {
                World world = context.getWorld();
                PlayerEntity user = context.getPlayer();
                BlockPos pos = context.getBlockPos();
                List<BlockState> disallowedBlocks = Arrays.asList(
                        Blocks.END_PORTAL.getDefaultState(),
                        Blocks.BEDROCK.getDefaultState(),
                        Blocks.OBSIDIAN.getDefaultState(),
                        Blocks.CHEST.getDefaultState(),
                        Blocks.SHULKER_BOX.getDefaultState(),
                        Blocks.DRAGON_EGG.getDefaultState(),
                        Blocks.BARRIER.getDefaultState(),
                        Blocks.NETHER_PORTAL.getDefaultState(),
                        Blocks.END_PORTAL.getDefaultState(),
                        Blocks.END_GATEWAY.getDefaultState()
                );

                if (user == null) return ActionResult.PASS;

                if (!disallowedBlocks.contains(world.getBlockState(pos)))
                        world.setBlockState(user.isSneaking() ? pos.up() : pos, Blocks.STONE.getDefaultState());

                if (!user.getAbilities().creativeMode) {
                        user.getStackInHand(user.getActiveHand()).damage(1, user, (p) -> p.sendToolBreakStatus(user.getActiveHand()));
                        user.getItemCooldownManager().set(this, 40);
                }

                return super.useOnBlock(context);
        }

        @Override
        public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                tooltip.add(Text.translatable("aquaticplus.stonifier.tooltip").formatted(Formatting.GRAY));
                super.appendTooltip(stack, world, tooltip, context);
        }
}