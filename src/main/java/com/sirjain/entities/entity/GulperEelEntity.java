package com.sirjain.entities.entity;

import com.sirjain.entities.entity.template.AbstractEelEntity;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.world.World;

public class GulperEelEntity extends AbstractEelEntity {
	public final AnimationState swimAnimationState = new AnimationState();
	private int idleAnimationTimeout = 0;

	public GulperEelEntity(EntityType<? extends FishEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void initGoals() {
		super.initGoals();
	}

	@Override
	protected void updateLimbs(float v) {
		float f = this.getPose() == EntityPose.STANDING ? Math.min(v * 6.0F, 1.0F) : 0;
		this.limbAnimator.updateLimbs(f, 0.2F);
	}

	@Override
	public void tick() {
		super.tick();
		if (this.getWorld().isClient) this.setupAnimationStates();
	}

	private void setupAnimationStates() {
		if (this.idleAnimationTimeout <= 0) {
			this.idleAnimationTimeout = 80;
			this.swimAnimationState.start(this.age);
		} else {
			--this.idleAnimationTimeout;
		}
	}

	public static DefaultAttributeContainer.Builder createGulperEelEntity() {
		return AbstractEelEntity
			.createGenericEelAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 20);
	}
}
