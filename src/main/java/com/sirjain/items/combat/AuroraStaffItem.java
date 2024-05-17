package com.sirjain.items.combat;

import com.sirjain.entities.entity.VolanAuroraEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class AuroraStaffItem extends Item {
	public AuroraStaffItem() {
		super(new Item.Settings().maxCount(1).maxDamage(65));
	}

	@Override
	public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
		if (entity instanceof VolanAuroraEntity volanAurora) {
			if (volanAurora.getTarget() == null) volanAurora.isAttracted = !volanAurora.isAttracted;
			if (volanAurora.leader == null) volanAurora.leader = user;

			if (!user.getAbilities().creativeMode) {
				stack.damage(1, user, p -> p.sendToolBreakStatus(hand));
			}

			return ActionResult.SUCCESS;
		}

		return super.useOnEntity(stack, user, entity, hand);
	}
}