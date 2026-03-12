package sirjain.aquaticplus.item.projectile;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import sirjain.aquaticplus.entity.entities.projectile.AirleechPouchEntity;

public class AirleechPouchItem extends Item {
	public AirleechPouchItem(Settings settings) {
		super(settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack stackInHand = user.getStackInHand(hand);

		if (world.isClient) {
			return TypedActionResult.pass(stackInHand);
		}

		ThrownItemEntity airleechPouchEntity = new AirleechPouchEntity(world, user);
		airleechPouchEntity.setItem(stackInHand);
		airleechPouchEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0, 0.75F, 0);
		world.spawnEntity(airleechPouchEntity);

		if (!user.getAbilities().creativeMode) {
			stackInHand.decrement(1);
			user.getItemCooldownManager().set(this, 2);
		}

		user.incrementStat(Stats.USED.getOrCreateStat(this));

		return TypedActionResult.success(stackInHand);
	}
}
