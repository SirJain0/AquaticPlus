package com.aquaticplus.items.combat;

import com.aquaticplus.entities.entity.projectile.FrostedSnowballEntity;
import com.aquaticplus.items.abstract_item.ShootingStaffItem;
import com.aquaticplus.registries.AquaticPlusItems;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FrostingSpectreItem extends ShootingStaffItem {
	public FrostingSpectreItem(Settings settings) {
		super(settings);
	}

	@Override
	public ThrownItemEntity getEntity(World world, LivingEntity user) {
		return new FrostedSnowballEntity(world, user);
	}

	@Override
	public boolean hasAmmoItem() {
		return true;
	}

	@Override
	public boolean hasDurability() {
		return true;
	}

	@Override
	public int durabilityDecrement() {
		return 1;
	}

	@Override
	public ItemStack getAmmoItem() {
		return new ItemStack(AquaticPlusItems.FROSTED_BALL);
	}

	@Override
	public float getProjectileVelocity() {
		return 1.1f;
	}

	@Override
	public int getNumProjectiles() {
		return 2;
	}

	@Override
	public int getDivergence() {
		return 4;
	}

	@Override
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		ServerWorld world = (ServerWorld) target.getWorld();

		world.spawnParticles(
			ParticleTypes.CLOUD,
			target.getX(), target.getY(), target.getZ(),
			5, 0.5, 0.2, 0.5, 0.02
		);

		sendInAir(2, target);

		if (attacker instanceof PlayerEntity player && !player.getAbilities().creativeMode) {
			Hand hand = player.getActiveHand();
			player.getStackInHand(hand).damage(1, player, (p) -> p.sendToolBreakStatus(hand));
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
		tooltip.add(Text.translatable("aquaticplus.frosting_spectre.tooltip").formatted(Formatting.BLUE));
		super.appendTooltip(stack, world, tooltip, context);
	}
}
