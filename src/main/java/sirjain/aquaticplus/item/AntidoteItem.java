package sirjain.aquaticplus.item;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class AntidoteItem extends Item {
	private final StatusEffect effect;

	public AntidoteItem(StatusEffect effect) {
		super(new Item.Settings().maxCount(16));
		this.effect = effect;
	}

	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		if (user instanceof ServerPlayerEntity serverPlayerEntity) {
			Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
			serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
		}

		if (user instanceof PlayerEntity && !((PlayerEntity)user).getAbilities().creativeMode) {
			stack.decrement(1);
		}

		if (!world.isClient) {
			user.removeStatusEffect(effect);
		}

		return stack.isEmpty() ? new ItemStack(Items.GLASS_BOTTLE) : stack;
	}

	public int getMaxUseTime(ItemStack stack) {
		return 20;
	}

	public UseAction getUseAction(ItemStack stack) {
		return UseAction.DRINK;
	}

	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		return ItemUsage.consumeHeldItem(world, user, hand);
	}

//	protected abstract StatusEffect getEffect();
}
