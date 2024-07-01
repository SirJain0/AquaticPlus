package sirjain.aquaticplus.item.projectile;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import sirjain.aquaticplus.entity.entities.projectile.LandDrowningAquaticStarEntity;
import sirjain.aquaticplus.entity.entities.template.AbstractAquaticStarEntity;
import sirjain.aquaticplus.item.abstract_item.AbstractAquaticStarItem;

import java.util.List;

public class LandDrowningAquaticStarItem extends AbstractAquaticStarItem {
	@Override
	public AbstractAquaticStarEntity getEntity(World world, PlayerEntity user) {
		return new LandDrowningAquaticStarEntity(world, user);
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(Text.translatable("aquaticplus.land_drowning_aquatic_star.tooltip").formatted(Formatting.AQUA));
		super.appendTooltip(stack, world, tooltip, context);
	}
}