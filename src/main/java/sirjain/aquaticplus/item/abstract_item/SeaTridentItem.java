package sirjain.aquaticplus.item.abstract_item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import sirjain.aquaticplus.entity.entities.template.SeaTridentEntity;

public abstract class SeaTridentItem extends Item {
	public SeaTridentItem() {
		super(new Item.Settings().maxCount(1));
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		final ItemStack stackInHand = user.getStackInHand(hand);

		if (world.isClient) return TypedActionResult.pass(stackInHand);

		SeaTridentEntity trident = getEntity(world, user);
		trident.setVelocity(user, user.getPitch(), user.getYaw(), 0, 1, 0);
		world.spawnEntity(trident);

		if (!user.getAbilities().creativeMode) {
			stackInHand.decrement(1);
			user.getItemCooldownManager().set(this, 5);
		}

		// TODO: Change to custom sound
		world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_ENDER_PEARL_THROW, SoundCategory.NEUTRAL, 0.5F, 1F);
		user.incrementStat(Stats.USED.getOrCreateStat(this));

		return TypedActionResult.success(stackInHand);
	}

	abstract public SeaTridentEntity getEntity(World world, PlayerEntity user);
}