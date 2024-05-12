package com.sirjain.entities.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.world.World;

public class SeaPenEntity extends WaterCreatureEntity {
	public SeaPenEntity(EntityType<? extends WaterCreatureEntity> entityType, World world) {
		super(entityType, world);
	}

	public static DefaultAttributeContainer.Builder createSeaPenAttributes() {
		return LivingEntity
			.createLivingAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 2)
			.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 4)
			.add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 2);
	}

	@Override
	public boolean isPushable() {
		return false;
	}
}
