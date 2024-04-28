package com.sirjain.entities.entity;

import com.sirjain.entities.entity.projectile.FrostedSnowballProjectileEntity;
import com.sirjain.entities.entity.template.APFishEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.ProjectileAttackGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class FrostedSplasherEntity extends APFishEntity implements RangedAttackMob {
	public FrostedSplasherEntity(EntityType<? extends FishEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void initGoals() {
		super.initGoals();

		this.goalSelector.add(0, new ProjectileAttackGoal(this, 1.0D, 20/*(20*60) * 2*/, 15.0F));
		this.targetSelector.add(1, new RevengeGoal(this));
	}

	@Override
	public float getSpeedAmplifier() {
		return 0.06f;
	}

	public static DefaultAttributeContainer.Builder createFrostedSplasherAttributes() {
		return FishEntity
			.createFishAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 16)
			.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 2);
	}

	@Override
	public void tick() {
		super.tick();

		if (this.getWorld().isClient) {
			World world = this.getWorld();
			double xPos = this.getX() + 0.8f;
			double xPos2 = this.getX() - 0.8f;

			summonRandomSnowParticle(world, xPos);
			summonRandomSnowParticle(world, xPos2);
		}

		if (this.age % 60 == 0 && this.getHealth() < this.getMaxHealth()) {
			this.heal(1);
		}
	}

	public void summonRandomSnowParticle(World world, double x) {
		if (this.random.nextInt(5) == 0) {
			world.addParticle(
				ParticleTypes.SNOWFLAKE,
				x, this.getRandomBodyY(), this.getZ() + 0.5f,
				-0.01f, 0.05f, 0
			);
		}
	}

	@Override
	public void attack(LivingEntity target, float pullProgress) {
		ThrownItemEntity projectile = new FrostedSnowballProjectileEntity(this.getWorld(), this);

		double xCoord = target.getX() - this.getX();
		double yCoord = target.getBodyY(0.3f) - projectile.getY();
		double zCoord = target.getZ() - this.getZ();
		double velPath = Math.sqrt(xCoord * xCoord + zCoord * zCoord);

		projectile.setVelocity(xCoord, yCoord + velPath * (double) 0.2f, zCoord, 1, 0);
		this.getWorld().spawnEntity(projectile);
	}
}