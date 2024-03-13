package com.sirjain.entities.entity.template;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.control.AquaticMoveControl;
import net.minecraft.entity.ai.control.YawAdjustingLookControl;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.SwimNavigation;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public abstract class APSchoolingFishEntity extends SchoolingFishEntity {
	public APSchoolingFishEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
		super(entityType, world);

		// Sets some movement AI for all fish
		this.moveControl = new AquaticMoveControl(this, 85, 10, 1, 0.04F, true);
		this.lookControl = new YawAdjustingLookControl(this, 10);
	}

	// Sets navigation for all fish
	@Override
	protected EntityNavigation createNavigation(World world) {
		return new SwimNavigation(this, world);
	}

	// TODO: Change to proper sound later
	// Flop sound for all fish for the mod
	@Override
	protected SoundEvent getFlopSound() {
		return SoundEvents.ENTITY_COD_FLOP;
	}

	// Overriden in later classes
	@Override
	public ItemStack getBucketItem() {
		return ItemStack.EMPTY;
	}
}
