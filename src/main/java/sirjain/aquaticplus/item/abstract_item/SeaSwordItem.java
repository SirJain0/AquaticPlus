package sirjain.aquaticplus.item.abstract_item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public abstract class SeaSwordItem extends ShootingStaffItem {
	public SeaSwordItem() {
		super(new Item.Settings().maxCount(1).maxDamage(450));
	}

	@Override
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		World world = target.getWorld();
		target.damage(target.getDamageSources().generic(), 7);

		if (!world.isClient) {
			((ServerWorld) world).spawnParticles(getParticle(), target.getX(), target.getY(), target.getZ(), 20, 0.2f, 0.1f, 0.05f, 0.5f);
		}

		if (attacker instanceof PlayerEntity player && !player.getAbilities().creativeMode) {
			player.getStackInHand(player.getActiveHand()).damage(durabilityDecrement(), player, (p) -> p.sendToolBreakStatus(player.getActiveHand()));
		}

		return super.postHit(stack, target, attacker);
	}

	abstract public ParticleEffect getParticle();
}