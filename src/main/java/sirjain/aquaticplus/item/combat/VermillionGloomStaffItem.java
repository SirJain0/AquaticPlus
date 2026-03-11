package sirjain.aquaticplus.item.combat;

import com.google.common.collect.Lists;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import sirjain.aquaticplus.AquaticPlusUtil;

import java.util.ArrayList;

public class VermillionGloomStaffItem extends Item {
	public VermillionGloomStaffItem() {
		super(new Item.Settings().maxCount(1).maxDamage(620));
	}

	@Override
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		if (!target.getWorld().isClient) {
			// Wither Effect
			target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 8*20, 0));

			// Damage 3hp
			target.damage(target.getDamageSources().mobAttack(attacker), 3);

			// 1/4 chance of fire
			if (target.getRandom().nextInt(3) == 0) {
				target.setOnFireFor(3);
			}

			// Removing water breathing effect
			if (target.hasStatusEffect(StatusEffects.WATER_BREATHING)) {
				target.removeStatusEffect(StatusEffects.WATER_BREATHING);
			}

			// 1/5 chance of healing
			if (attacker.getRandom().nextInt(4) == 0) {
				attacker.heal(4);
			}

			// Durability
			if (attacker instanceof PlayerEntity player && !player.getAbilities().creativeMode) {
				Hand hand = player.getActiveHand();
				player.getStackInHand(hand).damage(1, player, p -> p.sendToolBreakStatus(hand));
			}

			return true;
		}

		return super.postHit(stack, target, attacker);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		if (!world.isClient) {
			if (world.random.nextInt(6) == 0)
				user.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 20*30, 0));

			if (user.getRandom().nextInt(5) == 0 && !user.getAbilities().creativeMode)
				user.heal(3);
		}

		if (user.isSneaking()) {
			AquaticPlusUtil.performShockwaveAttack(user, null);

			if (!user.getAbilities().creativeMode) {
				user.getStackInHand(hand).damage(1, user, p -> p.sendToolBreakStatus(hand));
			}
		} else {
			if (user.getRandom().nextInt(3) == 0) {
				AquaticPlusUtil.performPlasmaBallShootAttack(user, null, 4);
			} else {
				AquaticPlusUtil.performPlasmaBeamShootAttack(user, null);
			}
		}

		return super.use(world, user, hand);
	}
}
