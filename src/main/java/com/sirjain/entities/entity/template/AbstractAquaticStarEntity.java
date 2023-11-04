package com.sirjain.entities.entity.template;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public abstract class AbstractAquaticStarEntity extends SelfKillingProjectileEntity {
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

	@Override
	protected float getGravity() {
		return 0;
	}

	@Override
	public void tick() {
		super.tick();

		if (this.isSubmergedInWater()) {
			Vec3d prevVelocity = this.getVelocity();
			this.setVelocity(prevVelocity.x * (1 / 0.8), prevVelocity.y * (1 / 0.8), prevVelocity.z * (1 / 0.8));
		}
	}

	@Override
	protected void tickInVoid() {
		this.kill();
	}

	@Override
	protected void onCollision(HitResult hitResult) {
		super.onCollision(hitResult);
		this.kill();
	}

	abstract public StatusEffect getConditionalEffect();
}
