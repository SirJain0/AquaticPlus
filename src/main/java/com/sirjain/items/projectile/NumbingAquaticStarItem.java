package com.sirjain.items.projectile;

import com.sirjain.entities.entity.projectile.NumbingAquaticStarEntity;
import com.sirjain.entities.entity.template.AbstractAquaticStarEntity;
import com.sirjain.items.abstract_item.AbstractAquaticStarItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class NumbingAquaticStarItem extends AbstractAquaticStarItem {
	public NumbingAquaticStarItem(Settings settings) {
		super(settings);
	}

	@Override
	public AbstractAquaticStarEntity getEntity(World world, PlayerEntity user) {
		return new NumbingAquaticStarEntity(world, user);
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(Text.translatable("aquaticplus.numbing_aquatic_star.tooltip").formatted(Formatting.BLUE));
		super.appendTooltip(stack, world, tooltip, context);
	}
}