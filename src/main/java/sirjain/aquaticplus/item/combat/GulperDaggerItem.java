package sirjain.aquaticplus.item.combat;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GulperDaggerItem extends SwordItem {
	public GulperDaggerItem() {
		super(ToolMaterials.STONE, 4, 0, new Item.Settings().maxCount(1).maxDamage(230));
	}

	@Override
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		if (target.getRandom().nextInt(4) == 0) {
			World world = target.getWorld();
			List<Entity> entities = world.getOtherEntities(target, target.getBoundingBox().expand(3), EntityPredicates.VALID_LIVING_ENTITY);

			for (Entity entityAround : entities) {
				if (entityAround == attacker) continue;
				entityAround.damage(entityAround.getDamageSources().magic(), 3);
			}

			return true;
		}

		return super.postHit(stack, target, attacker);
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(Text.translatable("aquaticplus.gulper_dagger.tooltip").formatted(Formatting.GRAY));
		super.appendTooltip(stack, world, tooltip, context);
	}
}
