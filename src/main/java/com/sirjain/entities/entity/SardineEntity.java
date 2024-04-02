package com.sirjain.entities.entity;

import com.sirjain.entities.entity.template.APSchoolingFishEntity;
import com.sirjain.registries.AquaticPlusItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SardineEntity extends APSchoolingFishEntity {
	public SardineEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	public ItemStack getBucketItem() {
		return AquaticPlusItems.SARDINE_SPAWN_EGG.getDefaultStack();
	}

	public static DefaultAttributeContainer.Builder createSardineAttributes() {
		return FishEntity
			.createFishAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 4)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 6);
	}
}