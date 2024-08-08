package sirjain.aquaticplus.item.combat;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import sirjain.aquaticplus.entity.entities.projectile.CrimsonSeaTridentEntity;
import sirjain.aquaticplus.entity.entities.template.SeaTridentEntity;
import sirjain.aquaticplus.item.abstract_item.SeaTridentItem;

import java.util.List;

public class CrimsonSeaTridentItem extends SeaTridentItem {
	@Override
	public SeaTridentEntity getEntity(World world, PlayerEntity user) {
		return new CrimsonSeaTridentEntity(world, user);
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(Text.translatable("aquaticplus.crimson_sea_trident.tooltip").formatted(Formatting.RED));
		super.appendTooltip(stack, world, tooltip, context);
	}
}
