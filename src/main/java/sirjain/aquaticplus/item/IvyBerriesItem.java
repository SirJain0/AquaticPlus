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

		if (canDecrementStack(user)) {
			stack.decrement(1);
		}

		if (!world.isClient) {
			if (world.random.nextInt(12) == 0) {
				user.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 20*3, 0));
			} else if (world.random.nextInt(5) == 0) {
				user.removeStatusEffect(StatusEffects.POISON);
			}
		}

		return stack;
	}

	public boolean canDecrementStack(LivingEntity user) {
		return user instanceof PlayerEntity player && !player.getAbilities().creativeMode;
	}
}
