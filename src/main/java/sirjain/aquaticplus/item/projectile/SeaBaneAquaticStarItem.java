package sirjain.aquaticplus.item.projectile;

import sirjain.aquaticplus.entity.entities.projectile.SeaBaneAquaticStarEntity;
import sirjain.aquaticplus.entity.entities.template.AbstractAquaticStarEntity;
import sirjain.aquaticplus.item.abstract_item.AbstractAquaticStarItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SeaBaneAquaticStarItem extends AbstractAquaticStarItem {
	@Override
	public AbstractAquaticStarEntity getEntity(World world, PlayerEntity user) {
		return new SeaBaneAquaticStarEntity(world, user);
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(Text.translatable("aquaticplus.sea_bane_aquatic_star.tooltip").formatted(Formatting.RED));
		super.appendTooltip(stack, world, tooltip, context);
	}
}