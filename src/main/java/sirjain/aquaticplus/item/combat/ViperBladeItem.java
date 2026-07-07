package sirjain.aquaticplus.item.combat;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ViperBladeItem extends SwordItem {
	public ViperBladeItem() {
		super(ToolMaterials.STONE, 3, 0, new Item.Settings().maxCount(1).maxDamage(180));
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(Text.translatable("aquaticplus.viper_blade.tooltip").formatted(Formatting.WHITE));
		super.appendTooltip(stack, world, tooltip, context);
	}
}
