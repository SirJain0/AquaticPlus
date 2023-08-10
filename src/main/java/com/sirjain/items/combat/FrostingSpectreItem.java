package com.sirjain.items.combat;

import com.sirjain.entities.entity.projectile.FrostedSnowballProjectileEntity;
import com.sirjain.items.abstract_item.AbstractStaffItem;
import com.sirjain.registries.AquaticPlusItems;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FrostingSpectreItem extends AbstractStaffItem {
	public FrostingSpectreItem(Settings settings) {
		super(settings, 2, 1.1f, AquaticPlusItems.FROSTED_SNOWBALL, 4);
	}

	@Override
	public ThrownItemEntity getEntity(World world, LivingEntity user) {
		return new FrostedSnowballProjectileEntity(world, user);
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(Text.translatable("aquaticplus.frosting_staff.tooltip").formatted(Formatting.AQUA));
		super.appendTooltip(stack, world, tooltip, context);
	}
}
