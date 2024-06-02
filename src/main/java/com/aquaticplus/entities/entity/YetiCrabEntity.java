package com.aquaticplus.entities.entity;

import com.aquaticplus.entities.entity.template.AbstractCrabEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class YetiCrabEntity extends AbstractCrabEntity {
	public YetiCrabEntity(EntityType<? extends AbstractCrabEntity> entityType, World world) {
		super(entityType, world);
	}
}
