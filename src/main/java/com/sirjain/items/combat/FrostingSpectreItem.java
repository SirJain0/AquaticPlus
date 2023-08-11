package com.sirjain.items.combat;

import com.sirjain.entities.entity.projectile.FrostedSnowballProjectileEntity;
import com.sirjain.items.abstract_item.AbstractStaffItem;
import com.sirjain.registries.AquaticPlusItems;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FrostingSpectreItem extends AbstractStaffItem {
	public FrostingSpectreItem(Settings settings) {
		super(settings, 2, 1.1f, AquaticPlusItems.FROSTED_SNOWBALL, 4);
	}

	@Override
	public ThrownItemEntity getEntity(World world, LivingEntity user) {
		return new FrostedSnowballProjectileEntity(world, user);
	}

	@Override
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {

		// TODO: Figure out why these particles are not showing
		FrostedSnowballProjectileEntity.summonParticle(ParticleTypes.CLOUD, target.getWorld(), 8, target);
		sendInAir(2,  target);

		if (attacker instanceof PlayerEntity player && !player.getAbilities().creativeMode) {
			Hand hand = player.getActiveHand();
			player.getStackInHand(hand).damage(1, player, (p) -> p.sendToolBreakStatus(player.getActiveHand()));
		}

		return super.postHit(stack, target, attacker);
	}

	public void sendInAir(double yVel, LivingEntity entity) {
		yVel *= 1.0 - (entity.getAttributeValue(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE) / 2);
		if (yVel <= 0) return;

		Vec3d prevVelocity = entity.getVelocity();
		entity.setVelocity(prevVelocity.x, prevVelocity.y * yVel, prevVelocity.z);
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(Text.translatable("aquaticplus.frosting_spectre.tooltip").formatted(Formatting.AQUA));
		super.appendTooltip(stack, world, tooltip, context);
	}
}
