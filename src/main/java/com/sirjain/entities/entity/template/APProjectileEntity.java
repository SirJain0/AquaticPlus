package com.sirjain.entities.entity.template;

import com.sirjain.AquaticPlusUtil;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.world.World;

public abstract class APProjectileEntity extends ThrownItemEntity {
	public APProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
		super(entityType, world);
	}

	public APProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world, LivingEntity owner) {
		super(entityType, owner, world);
	}

	// Destroys the particle if the particle has stopped moving
	@Override
	public void tick() {
		super.tick();

		final boolean hasStoppedMoving = this.getVelocity().x == 0 || this.getVelocity().y == 0 || this.getVelocity().z == 0;
		final boolean isIdle = hasStoppedMoving && this.age > 5;

		if (isIdle) this.kill();

		if (this.isSubmergedInWater())
			this.setVelocity(this.getVelocity().multiply(AquaticPlusUtil.UNDERWATER_PARTICLE_MULTIPLIER));
	}
}
