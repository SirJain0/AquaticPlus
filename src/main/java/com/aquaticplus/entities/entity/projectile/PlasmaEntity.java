package com.aquaticplus.entities.entity.projectile;

import com.aquaticplus.AquaticPlusUtil;
import com.aquaticplus.registries.AquaticPlusEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.thrown.ThrownEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

public class PlasmaEntity extends ThrownEntity {
	public boolean isShotAsBeam;

	public PlasmaEntity(EntityType<? extends PlasmaEntity> entityType, World world) {
		super(entityType, world);
	}

	public PlasmaEntity(World world, LivingEntity owner, boolean isShotAsBeam) {
		super(AquaticPlusEntities.PLASMA_ENTITY, world);

		this.setOwner(owner);
		this.isShotAsBeam = isShotAsBeam;

		BlockPos blockPos = owner.getBlockPos();
		double d = (double) blockPos.getX() + 0.5;
		double e = (double) blockPos.getY() + 0.5;
		double f = (double) blockPos.getZ() + 0.5;

		this.refreshPositionAndAngles(d, e, f, this.getYaw(), this.getPitch());
	}

	// TODO: Idea - Add rare chance of explosion when I sort out the claim mod?
	@Override
	protected void onEntityHit(EntityHitResult entityHitResult) {
		Entity entity = entityHitResult.getEntity();

		if (entity instanceof LivingEntity target && !this.getWorld().isClient) {
			target.damage(target.getDamageSources().mobProjectile(this, (LivingEntity) this.getOwner()), 2);
			target.setOnFireFor(4);

			if (target.getRandom().nextInt(4) == 0)
				target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 4*20, 1));

			if (target.getRandom().nextInt(5) == 0)
				target.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 4*20, 1));
		}

		super.onEntityHit(entityHitResult);
	}

	// Destroys the particle if the particle has stopped moving
	@Override
	public void tick() {
		super.tick();

		if (!this.getWorld().isClient)
			System.out.println(isShotAsBeam);

		final boolean hasStoppedMoving = this.getVelocity().x == 0 || this.getVelocity().y == 0 || this.getVelocity().z == 0;
		final boolean isIdle = hasStoppedMoving && this.age > 5;

		if (isIdle || this.age > 20*10)
			this.kill();

		if (this.isSubmergedInWater())
			this.setVelocity(this.getVelocity().multiply(AquaticPlusUtil.UNDERWATER_PARTICLE_MULTIPLIER));

		if (this.getWorld().isClient() && this.age % 3 == 0) {
			this.getWorld().addParticle(ParticleTypes.LAVA, this.getParticleX(1), this.getRandomBodyY(), this.getParticleZ(0.2), 0, 0, 0);
		}
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
