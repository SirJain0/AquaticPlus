package com.sirjain.entities.entity;

import com.sirjain.entities.entity.template.APSchoolingFishEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.world.World;

public class BluefinTunaEntity extends APSchoolingFishEntity {
	public BluefinTunaEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void initGoals() {
		super.initGoals();
		this.goalSelector.add(1, new ActiveTargetGoal<>(this, ShadowSardelEntity.class, true));
	}

	public static DefaultAttributeContainer.Builder createBluefinTunaAttributes() {
		return FishEntity
			.createFishAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 12)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 4.5F);
	}
}
