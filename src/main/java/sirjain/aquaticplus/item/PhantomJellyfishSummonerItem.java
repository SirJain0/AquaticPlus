package sirjain.aquaticplus.item;

import sirjain.aquaticplus.entity.AquaticPlusEntities;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.BlockPos;
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

	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		BlockPos usePos = context.getBlockPos();
		BlockState blockStateAtUseLocation = context.getWorld().getBlockState(usePos);

		if (!blockStateAtUseLocation.isSolidBlock(context.getWorld(), usePos))
			return super.useOnBlock(context);

		return ActionResult.PASS;
	}
}
