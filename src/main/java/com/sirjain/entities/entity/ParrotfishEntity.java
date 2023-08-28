package com.sirjain.entities.entity;

import com.sirjain.entities.goals.MoveToAndBreakBlockGoal;
import com.sirjain.registries.AquaticPlusItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class ParrotfishEntity extends SchoolingFishEntity {
	public ParrotfishEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void initGoals() {
		super.initGoals();
		this.goalSelector.add(1, new MoveToAndBreakBlockGoal(this, 1.3f, 10, 1));
	}

	public static DefaultAttributeContainer.Builder createParrotfishAttributes() {
		return FishEntity
			.createFishAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 8)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 3);
	}

	// TODO: Replace with generic flop sound
	@Override
	protected SoundEvent getFlopSound() {
		return SoundEvents.ENTITY_COD_FLOP;
	}

	@Override
	public ItemStack getBucketItem() {
		return AquaticPlusItems.PARROTFISH_SPAWN_EGG.getDefaultStack();
	}
}
