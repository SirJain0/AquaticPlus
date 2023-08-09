package com.sirjain.entities.entity.projectile;

import com.sirjain.entities.entity.template.SelfKillingProjectileEntity;
import com.sirjain.registries.AquaticPlusEntities;
import com.sirjain.registries.AquaticPlusItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class FrostedSnowballProjectileEntity extends SelfKillingProjectileEntity {
	public FrostedSnowballProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
		super(entityType, world);
	}

	public FrostedSnowballProjectileEntity(World world, LivingEntity owner) {
		super(AquaticPlusEntities.FROSTED_SNOWBALL_PROJECTILE_ENTITY, world, owner);
	}

	@Override
	protected Item getDefaultItem() {
		return AquaticPlusItems.FROSTED_SNOWBALL;
	}

	@Override
	protected void onEntityHit(EntityHitResult entityHitResult) {
		super.onEntityHit(entityHitResult);
		Entity entity = entityHitResult.getEntity();

		if (entity instanceof LivingEntity target && target.canFreeze() && !target.isDead()) {
			if (target.isFrozen() && target.age % 40 == 0) {
				target.damage(target.getDamageSources().freeze(), 2);
			} else {
				target.setFrozenTicks(Math.min(target.getMinFreezeDamageTicks(), target.getFrozenTicks() + 1));
			}
		}

		this.kill();
	}

	@Override
	protected void onCollision(HitResult hitResult) {
		super.onCollision(hitResult);
		this.kill();
	}

	@Override
	protected float getGravity() {
		return 0;
	}
}
