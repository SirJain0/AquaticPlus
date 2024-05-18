package com.sirjain.entities.entity;

import com.sirjain.entities.entity.projectile.AuroraEntity;
import com.sirjain.entities.entity.template.NoBucketSchoolingFishEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.ProjectileAttackGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.ElderGuardianEntity;
import net.minecraft.entity.mob.GuardianEntity;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class VolanAuroraEntity extends NoBucketSchoolingFishEntity implements RangedAttackMob {
	public static final TrackedData<Boolean> IS_ANGRY = DataTracker.registerData(VolanAuroraEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
	@Nullable public PlayerEntity leader;
	public boolean isAttracted;

	public VolanAuroraEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
		super(entityType, world);
		this.isAttracted = false;
	}

	@Override
	protected void initGoals() {
		super.initGoals();
		this.goalSelector.add(0, new ProjectileAttackGoal(this, 1, 40, 15));

		this.targetSelector.add(0, new ActiveTargetGoal<>(this, GuardianEntity.class, false));
		this.targetSelector.add(0, new ActiveTargetGoal<>(this, ElderGuardianEntity.class, false));
	}

	@Override
	public float getSpeedAmplifier() {
		return 0.11f;
	}

	@Override
	public void tick() {
		super.tick();

		if (this.getWorld().isClient) {
			World world = this.getWorld();
			double xPos = this.getX() + 0.8f;
			double xPos2 = this.getX() - 0.8f;

			summonRandomMagicParticle(world, xPos);
			summonRandomMagicParticle(world, xPos2);
		}

		if (this.age % 70 == 0 && this.getHealth() < this.getMaxHealth()) {
			this.heal(2);
		}

		if (this.isAttracted) {
			if (this.squaredDistanceTo(this.leader) >= 144.0) {
				this.isAttracted = false;
				this.leader = null;
			} else {
				this.navigation.startMovingTo(this.leader, this.speed);
			}
		} else {
			this.leader = null;
		}
	}

	public void summonRandomMagicParticle(World world, double x) {
		int chance;

		if (this.isAngry()) chance = 7;
		else if (this.isAttracted) chance = 14;
		else chance = 30;

		if (this.random.nextInt(chance) == 0) {
			world.addParticle(
				ParticleTypes.END_ROD,
				x, this.getRandomBodyY(), this.getZ() + 0.5f,
				-0.01f, 0.05f, 0
			);
		}
	}

	@Override
	protected void initDataTracker() {
		super.initDataTracker();
		this.dataTracker.startTracking(IS_ANGRY, false);
	}

	@Override
	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);
		nbt.putBoolean("is_angry", this.isAngry());
	}

	@Override
	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);
		this.dataTracker.set(IS_ANGRY, nbt.getBoolean("is_angry"));
	}

	public boolean isAngry() {
		return this.dataTracker.get(IS_ANGRY);
	}

	public void setAngryState(boolean value) {
		this.dataTracker.set(IS_ANGRY, value);
	}

	@Override
	public void setTarget(@Nullable LivingEntity target) {
		super.setTarget(target);
		this.setAngryState(this.getTarget() != null);
	}

	public static DefaultAttributeContainer.Builder createVolanAuroraAttributes() {
		return FishEntity
			.createFishAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 22)
			.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 4f);
	}

	@Override
	public void attack(LivingEntity target, float pullProgress) {
		ThrownItemEntity projectile = new AuroraEntity(this.getWorld(), this);

		double xCoord = target.getX() - this.getX();
		double yCoord = target.getBodyY(0.3f) - projectile.getY();
		double zCoord = target.getZ() - this.getZ();
		double velPath = Math.sqrt(xCoord * xCoord + zCoord * zCoord);

		projectile.setVelocity(xCoord, yCoord + velPath * (double) 0.2f, zCoord, 1, 0);
		this.getWorld().spawnEntity(projectile);
	}
}