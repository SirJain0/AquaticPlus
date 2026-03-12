package sirjain.aquaticplus.item.combat;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PteroisBowItem extends BowItem {
	public PteroisBowItem(Settings settings) {
		super(settings);
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(Text.translatable("aquaticplus.pterois_bow.tooltip").formatted(Formatting.YELLOW));
		super.appendTooltip(stack, world, tooltip, context);
	}
}
