package com.aquaticplus.entities.entity.template;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.ai.control.AquaticMoveControl;
import net.minecraft.entity.ai.control.YawAdjustingLookControl;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.SwimNavigation;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public abstract class APFishEntity extends FishEntity {
	public APFishEntity(EntityType<? extends FishEntity> entityType, World world) {
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

	// Float used for speeding up the fish in the travel() method
	public float getSpeedAmplifier() {
		return 0f;
	}

	// Used for changing the fish's speed depending on the getSpeedAmplifier()
	@Override
	public void travel(Vec3d movementInput) {
		if (this.isLogicalSideForUpdatingMovement())
			this.move(MovementType.SELF, this.getRotationVector().multiply(this.getSpeedAmplifier()));

		super.travel(movementInput);
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
