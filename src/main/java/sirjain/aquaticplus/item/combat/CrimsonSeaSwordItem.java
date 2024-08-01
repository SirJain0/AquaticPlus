package sirjain.aquaticplus.item.combat;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import sirjain.aquaticplus.entity.entities.projectile.SeahorseSpikeEntity;
import sirjain.aquaticplus.item.AquaticPlusItems;
import sirjain.aquaticplus.item.abstract_item.SeaSwordItem;

public class CrimsonSeaSwordItem extends SeaSwordItem {
	@Override
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20*5, 0));

		if (target.getRandom().nextInt(3) == 0) {
			target.setOnFireFor(3);
		}

		return super.postHit(stack, target, attacker);
	}

	@Override
	public ParticleEffect getParticle() {
		return ParticleTypes.FLAME;
	}

	@Override
	public ProjectileEntity getEntity(World world, LivingEntity user) {
		return new SeahorseSpikeEntity(world, user);
	}

	@Override
	public boolean hasAmmoItem() {
		return true;
	}

	@Override
	public @Nullable ItemStack getAmmoItem() {
		return AquaticPlusItems.CRIMSON_SEAHORSE_SPIKE.getDefaultStack();
	}

	@Override
	public float getProjectileVelocity() {
		return 1;
	}

	@Override
	public int getNumProjectiles() {
		return 1;
	}

	@Override
	public int getDivergence() {
		return 0;
	}

	@Override
	public boolean hasDurability() {
		return true;
	}

	@Override
	public int durabilityDecrement() {
		return 5;
	}
}
