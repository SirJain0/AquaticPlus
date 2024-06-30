package sirjain.aquaticplus.entity.entities.template;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public abstract class NoBucketFishEntity extends APFishEntity {
	public NoBucketFishEntity(EntityType<? extends FishEntity> entityType, World world) {
		super(entityType, world);
	}

	// Returns a pass so that nothing happens when right clicking fish
	@Override
	protected ActionResult interactMob(PlayerEntity player, Hand hand) {
		return ActionResult.PASS;
	}

	// Returns an action result of PASS when user right clicks it
	@Override
	public ItemStack getBucketItem() {
		return ItemStack.EMPTY;
	}
}