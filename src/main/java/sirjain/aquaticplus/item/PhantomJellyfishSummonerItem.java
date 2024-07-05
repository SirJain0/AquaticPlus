package sirjain.aquaticplus.item;

import net.minecraft.block.FluidBlock;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;
import sirjain.aquaticplus.entity.AquaticPlusEntities;

import java.util.List;

public class PhantomJellyfishSummonerItem extends Item {
	public PhantomJellyfishSummonerItem() {
		super(new Item.Settings().maxCount(1).rarity(Rarity.RARE));
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(Text.literal("It burns so hot that it burns underwater...").formatted(Formatting.RED));
		super.appendTooltip(stack, world, tooltip, context);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack itemStack = user.getStackInHand(hand);
		BlockHitResult blockHitResult = raycast(world, user, RaycastContext.FluidHandling.SOURCE_ONLY);

		if (blockHitResult.getType() != HitResult.Type.BLOCK) {
			return TypedActionResult.pass(itemStack);
		} else if (!(world instanceof ServerWorld)) {
			return TypedActionResult.success(itemStack);
		} else {
			BlockPos blockPos = blockHitResult.getBlockPos();

			if (!(world.getBlockState(blockPos).getBlock() instanceof FluidBlock)) {
				return TypedActionResult.pass(itemStack);
			} else if (world.canPlayerModifyAt(user, blockPos) && user.canPlaceOn(blockPos, blockHitResult.getSide(), itemStack)) {
				EntityType<?> entityType = AquaticPlusEntities.PHANTOM_JELLYFISH_ENTITY;
				Entity entity = entityType.spawnFromItemStack((ServerWorld)world, itemStack, user, blockPos, SpawnReason.MOB_SUMMONED, false, false);

				if (entity == null) {
					return TypedActionResult.pass(itemStack);
				} else {
					if (!user.getAbilities().creativeMode) {
						itemStack.decrement(1);
					}

					user.incrementStat(Stats.USED.getOrCreateStat(this));
					world.emitGameEvent(user, GameEvent.ENTITY_PLACE, entity.getPos());

					return TypedActionResult.consume(itemStack);
				}
			} else {
				return TypedActionResult.fail(itemStack);
			}
		}
	}
}
