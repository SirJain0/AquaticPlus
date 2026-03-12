package sirjain.aquaticplus.item.projectile;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import sirjain.aquaticplus.status_effect.AquaticPlusStatusEffects;

import java.util.List;

public class MidnightPikeItem extends SwordItem {
	public MidnightPikeItem() {
		super(ToolMaterials.IRON, 1, 0, new Item.Settings().maxCount(1).maxDamage(220));
	}

	@Override
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		Random rand = target.getRandom();

		if (rand.nextInt(7) == 0) addEffect(target, AquaticPlusStatusEffects.SEA_BANE, 20*8, 1);
		if (rand.nextInt(7) == 0) addEffect(target, AquaticPlusStatusEffects.LAND_DROWNING, 20*7, 0);
		if (rand.nextInt(10) == 0) addEffect(target, StatusEffects.WITHER, 20*10, 0);
		if (rand.nextInt(5) == 0) addEffect(target, StatusEffects.NAUSEA, 20*8, 0);

		return super.postHit(stack, target, attacker);
	}

	private void addEffect(LivingEntity target, StatusEffect effect, int duration, int amp) {
		target.addStatusEffect(new StatusEffectInstance(effect, duration, amp));
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(Text.translatable("aquaticplus.midnight_pike.tooltip").formatted(Formatting.LIGHT_PURPLE));
		super.appendTooltip(stack, world, tooltip, context);
	}
}
