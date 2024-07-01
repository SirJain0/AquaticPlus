package sirjain.aquaticplus.item.projectile;

import sirjain.aquaticplus.entity.entities.projectile.AquaticStarEntity;
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

public class AquaticStarItem extends AbstractAquaticStarItem {
	@Override
	public AbstractAquaticStarEntity getEntity(World world, PlayerEntity user) {
		return new AquaticStarEntity(world, user);
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(Text.translatable("aquaticplus.aquatic_star.tooltip").formatted(Formatting.BLUE));
		super.appendTooltip(stack, world, tooltip, context);
	}
}