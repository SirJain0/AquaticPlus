package com.aquaticplus.items;

import com.aquaticplus.registries.AquaticPlusEntities;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PhantomJellyfishSummonerItem extends SpawnEggItem {
	public PhantomJellyfishSummonerItem() {
		super(AquaticPlusEntities.PHANTOM_JELLYFISH_ENTITY, -1, -1, new Item.Settings().maxCount(1).rarity(Rarity.RARE));
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(Text.literal("It burns so hot that it burns underwater...").formatted(Formatting.RED));
		super.appendTooltip(stack, world, tooltip, context);
	}
}
