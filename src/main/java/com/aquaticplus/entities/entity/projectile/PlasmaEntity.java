package com.aquaticplus.entities.entity.projectile;

import com.aquaticplus.AquaticPlusUtil;
import com.aquaticplus.entities.entity.OculiMagniEntity;
import com.aquaticplus.registries.AquaticPlusEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.thrown.ThrownEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

public class PlasmaEntity extends ThrownEntity {
	public static final TrackedData<Boolean> IS_SHOT_AS_BEAM = DataTracker.registerData(PlasmaEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

	public PlasmaEntity(EntityType<? extends PlasmaEntity> entityType, World world) {
		super(entityType, world);
	}

	public PlasmaEntity(World world, LivingEntity owner, boolean isShotAsBeam) {
		super(AquaticPlusEntities.PLASMA_ENTITY, world);

		this.setOwner(owner);

		if (isShotAsBeam) {
			this.setIsShotAsBeam(true);
		}

		BlockPos blockPos = owner.getBlockPos();
		double d = (double) blockPos.getX() + 0.5;
		double e = (double) blockPos.getY() + 0.5;
		double f = (double) blockPos.getZ() + 0.5;

		this.refreshPositionAndAngles(d, e, f, this.getYaw(), this.getPitch());
	}

	// Handles what happens when an entity is hit
	// TODO: Idea - Add rare chance of explosion when I sort out the claim mod?
	@Override
	protected void onEntityHit(EntityHitResult entityHitResult) {
		Entity entity = entityHitResult.getEntity();

		if (entity instanceof LivingEntity target && !this.getWorld().isClient) {
			int fireTicks = this.isShotAsBeam() ? 8 : 4;

			target.damage(target.getDamageSources().mobProjectile(this, (LivingEntity) this.getOwner()), 2);
			target.setOnFireFor(fireTicks);

			if (target.getRandom().nextInt(4) == 0)
				target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 4*20, 1));

			if (target.getRandom().nextInt(5) == 0 && this.isShotAsBeam())
				target.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 4*20, 1));
		}

		super.onEntityHit(entityHitResult);
	}

	// Destroys the particle if the particle has stopped moving
	@Override
	public void tick() {
		super.tick();

		final boolean hasStoppedMoving = this.getVelocity().x == 0 || this.getVelocity().y == 0 || this.getVelocity().z == 0;
		final boolean isIdle = hasStoppedMoving && this.age > 5;
		int ageTicksUntilParticleSpawns = this.isShotAsBeam() ? 1 : 3;
		int numParticlesSpawned = this.isShotAsBeam() ? 3 : 1;

		if (isIdle || this.age > 20*10) {
			this.kill();
		}

		if (this.isSubmergedInWater()) {
			this.setVelocity(this.getVelocity().multiply(AquaticPlusUtil.UNDERWATER_PARTICLE_MULTIPLIER));
		}

		if (this.getWorld().isClient() && this.age % ageTicksUntilParticleSpawns == 0) {
			for (int x = 0; x < numParticlesSpawned; x++) {
				this.getWorld().addParticle(ParticleTypes.LAVA, this.getParticleX(1), this.getRandomBodyY(), this.getParticleZ(0.2), 0, 0, 0);
			}
		}
	}

	// Sets on fire if it is visible
	@Override
	public boolean isOnFire() {
		return !isShotAsBeam();
	}

	// Set gravity to 0 so it doesn't fall
	@Override
	protected float getGravity() {
		return 0;
	}

	// == DATA TRACKER FOR TRACKING THE TYPE OF PROJECTILE ==

	@Override
	protected void initDataTracker() {
		this.dataTracker.startTracking(IS_SHOT_AS_BEAM, false);
	}

	@Override
	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);
		nbt.putBoolean("is_shot_as_beam", this.isShotAsBeam());
	}

	@Override
	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);
		this.dataTracker.set(IS_SHOT_AS_BEAM, nbt.getBoolean("is_shot_as_beam"));
	}

	public void setIsShotAsBeam(boolean val) {
		this.dataTracker.set(IS_SHOT_AS_BEAM, val);
	}

	public boolean isShotAsBeam() {
		return this.dataTracker.get(IS_SHOT_AS_BEAM);
	}
}
