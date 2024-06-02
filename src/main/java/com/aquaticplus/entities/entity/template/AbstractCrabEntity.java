package com.aquaticplus.entities.entity.template;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.EscapeDangerGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.world.World;

abstract public class AbstractCrabEntity extends WaterCreatureEntity {
	protected AbstractCrabEntity(EntityType<? extends WaterCreatureEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(0, new EscapeDangerGoal(this, 1.4f));
		this.goalSelector.add(1, new WanderAroundFarGoal(this, 1));
		this.goalSelector.add(3, new LookAroundGoal(this));
	}

	public static DefaultAttributeContainer.Builder createCrabAttributes() {
		return WaterCreatureEntity
			.createMobAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 7)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 3);
	}
}
