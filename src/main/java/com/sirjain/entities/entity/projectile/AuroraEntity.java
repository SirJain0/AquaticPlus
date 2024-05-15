package com.sirjain.entities.entity.projectile;

import com.sirjain.registries.AquaticPlusEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.GuardianEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class AuroraEntity extends ProjectileEntity {
	public AuroraEntity(EntityType<? extends ProjectileEntity> entityType, World world) {
		super(entityType, world);
	}

	public AuroraEntity(World world) {
		super(AquaticPlusEntities.AURORA_ENTITY, world);
//		this.setOwner(owner);
	}

	@Override
	protected void onEntityHit(EntityHitResult entityHitResult) {
		Entity entity = entityHitResult.getEntity();

		if (entity instanceof GuardianEntity)
			entity.damage(this.getDamageSources().magic(), 2);

		super.onEntityHit(entityHitResult);
	}

	@Override
	protected void initDataTracker() {
	}
}