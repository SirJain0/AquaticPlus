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
import net.minecraft.world.World;

public abstract class AbstractAquaticStarEntity extends ThrownItemEntity {
	public AbstractAquaticStarEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
		super(entityType, world);
	}

	public AbstractAquaticStarEntity(EntityType<? extends ThrownItemEntity> entityType, World world, LivingEntity owner) {
		super(entityType, owner, world);
	}

	@Override
	protected void onEntityHit(EntityHitResult entityHitResult) {
		super.onEntityHit(entityHitResult);

		Entity entity = entityHitResult.getEntity();

		if (!this.getWorld().isClient) {
			if (entity instanceof LivingEntity target) {
				if (target.hasStatusEffect(StatusEffects.WATER_BREATHING))
					target.removeStatusEffect(StatusEffects.WATER_BREATHING);

				target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 20*8, 0));
				target.damage(target.getDamageSources().magic(), 4);

				if (this.getConditionalEffect() != null)
					target.addStatusEffect(new StatusEffectInstance(getConditionalEffect(), 20*6, 0));
			}
		}
	}

	@Override
	protected float getGravity() {
		return 0;
	}

	@Override
	public void tick() {
		final boolean hasStoppedMoving = this.getVelocity().x == 0 || this.getVelocity().y == 0 || this.getVelocity().z == 0;
		final boolean isIdle = hasStoppedMoving && this.age > 5;
		if (isIdle) this.kill();
		super.tick();
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

	public StatusEffect getConditionalEffect() {
		return null;
	}
}
