package com.sirjain.entities.entity;

import com.sirjain.entities.entity.template.APSchoolingFishEntity;
import com.sirjain.registries.AquaticPlusItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class HalibutEntity extends APSchoolingFishEntity {
	public HalibutEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
		super(entityType, world);
	}

	public static DefaultAttributeContainer.Builder createHalibutAttributes() {
		return SchoolingFishEntity
			.createFishAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 6);
	}

	@Override
	public ItemStack getBucketItem() {
		return AquaticPlusItems.HALIBUT_BUCKET.getDefaultStack();
	}
}
