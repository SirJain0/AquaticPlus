package com.aquaticplus.entities.entity.projectile;

import com.aquaticplus.AquaticPlusUtil;
import com.aquaticplus.registries.AquaticPlusEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

public class PlasmaEntity extends ThrownEntity {
	public PlasmaEntity(EntityType<? extends PlasmaEntity> entityType, World world) {
		super(entityType, world);
	}

	public PlasmaEntity(World world, LivingEntity owner) {
		super(AquaticPlusEntities.PLASMA_ENTITY, world);
		this.setOwner(owner);

		BlockPos blockPos = owner.getBlockPos();
		double d = (double) blockPos.getX() + 0.5;
		double e = (double) blockPos.getY() + 0.5;
		double f = (double) blockPos.getZ() + 0.5;

		this.refreshPositionAndAngles(d, e, f, this.getYaw(), this.getPitch());
	}

	// Destroys the particle if the particle has stopped moving
	@Override
	public void tick() {
		super.tick();

		final boolean hasStoppedMoving = this.getVelocity().x == 0 || this.getVelocity().y == 0 || this.getVelocity().z == 0;
		final boolean isIdle = hasStoppedMoving && this.age > 5;

		if (isIdle)
			this.kill();

		if (this.isSubmergedInWater())
			this.setVelocity(this.getVelocity().multiply(AquaticPlusUtil.UNDERWATER_PARTICLE_MULTIPLIER));
	}

	@Override
	protected void initDataTracker() {
	}

	public void checkDespawn() {
		if (this.getWorld().getDifficulty() == Difficulty.PEACEFUL) this.discard();
	}

	@Override
	protected float getGravity() {
		return 0;
	}
}
