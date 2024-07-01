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
			target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 8*20, 0));

			if (target.getRandom().nextInt(3) == 0) {
				target.setOnFireFor(3);
			}

			if (isWearingMetalArmor(attacker)) {
				target.damage(target.getDamageSources().mobAttack(attacker), 3);
			}

			if (attacker.getRandom().nextInt(4) == 0) {
				attacker.heal(2);
			}

			if (attacker instanceof PlayerEntity player && !player.getAbilities().creativeMode) {
				Hand hand = player.getActiveHand();
				player.getStackInHand(hand).damage(1, player, p -> p.sendToolBreakStatus(hand));
			}

			return true;
		}

		return super.postHit(stack, target, attacker);
	}

	public boolean isWearingMetalArmor(LivingEntity wearer) {
		ArrayList<ItemStack> armorItems = Lists.newArrayList(wearer.getArmorItems());

		ArmorMaterial gold = ArmorMaterials.GOLD;
		ArmorMaterial iron = ArmorMaterials.IRON;
		ArmorMaterial chain = ArmorMaterials.CHAIN;
		ArmorMaterial diamond = ArmorMaterials.DIAMOND;

		return armorItems.stream().filter(stack -> stack.getItem() instanceof ArmorItem armor && (armor.getMaterial() == gold || armor.getMaterial() == iron || armor.getMaterial() == chain || armor.getMaterial() == diamond)).count() == 4;
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
