package sirjain.aquaticplus.item.combat;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import sirjain.aquaticplus.entity.entities.VolanAuroraEntity;

public class AuroraStaffItem extends Item {
	public AuroraStaffItem() {
		super(new Item.Settings().maxCount(1).maxDamage(500));
	}

	@Override
	public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
		if (entity instanceof VolanAuroraEntity volanAurora) {
			if (volanAurora.getTarget() == null) volanAurora.isAttracted = !volanAurora.isAttracted;
			if (volanAurora.leader == null) volanAurora.leader = user;

			if (!user.getAbilities().creativeMode) {
				stack.damage(1, user, p -> p.sendToolBreakStatus(hand));
			}

			user.getWorld().playSound(user, user.getBlockPos(), SoundEvents.BLOCK_END_PORTAL_FRAME_FILL, SoundCategory.NEUTRAL, 0.8F, 0.5F);

			return ActionResult.SUCCESS;
		}

		return super.useOnEntity(stack, user, entity, hand);
	}
}