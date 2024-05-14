package com.sirjain.entities.entity;

import com.sirjain.entities.entity.template.NoBucketSchoolingFishEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.AttackGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.ElderGuardianEntity;
import net.minecraft.entity.mob.GuardianEntity;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

/*
TODO:
- Try to make custom spawn egg
- Make it attack guardians via projectile
- Think of an item that baits it - maybe a spectre of some sort?
- Emissive texture for eyes - change based on variant
 */
public class VolanAuroraEntity extends NoBucketSchoolingFishEntity {
	public static final TrackedData<Boolean> IS_ANGRY = DataTracker.registerData(VolanAuroraEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

	public VolanAuroraEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void initGoals() {
		super.initGoals();
		this.goalSelector.add(0, new AttackGoal(this));
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
	}

	public void summonRandomMagicParticle(World world, double x) {
		int chance = this.isAngry() ? 7 : 15;

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
}