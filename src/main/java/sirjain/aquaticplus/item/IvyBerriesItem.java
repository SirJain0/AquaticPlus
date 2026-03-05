package sirjain.aquaticplus.item;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.world.World;

public class IvyBerriesItem extends Item {
	public IvyBerriesItem(Settings settings) {
		super(settings);
	}

	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		if (user instanceof ServerPlayerEntity serverPlayerEntity) {
			Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
			serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
		}

		if (!world.isClient) {
			if (world.random.nextInt(12) == 0) {
				user.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 20*3, 0));
			} else if (world.random.nextInt(5) == 0 && user.hasStatusEffect(StatusEffects.POISON)) {
				user.removeStatusEffect(StatusEffects.POISON);
			}
		}

		return super.finishUsing(stack, world, user);
	}
}
