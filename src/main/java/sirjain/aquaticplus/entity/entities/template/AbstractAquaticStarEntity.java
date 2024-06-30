package sirjain.aquaticplus.entity.entities.template;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public abstract class AbstractAquaticStarEntity extends APProjectileEntity {
	public AbstractAquaticStarEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
		super(entityType, world);
	}

	public AbstractAquaticStarEntity(EntityType<? extends ThrownItemEntity> entityType, World world, LivingEntity owner) {
		super(entityType, world, owner);
	}

	@Override
	protected void onEntityHit(EntityHitResult entityHitResult) {
		super.onEntityHit(entityHitResult);

		Entity entity = entityHitResult.getEntity();

		if (!this.getWorld().isClient && entity instanceof LivingEntity target) {
			if (target.hasStatusEffect(StatusEffects.WATER_BREATHING))
				target.removeStatusEffect(StatusEffects.WATER_BREATHING);

			target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 20 * 8, 0));
			target.damage(target.getDamageSources().magic(), 4);

			if (this.getConditionalEffect() != null)
				target.addStatusEffect(new StatusEffectInstance(getConditionalEffect(), 20 * 6, 0));
		}
	}

	abstract public StatusEffect getConditionalEffect();
}
