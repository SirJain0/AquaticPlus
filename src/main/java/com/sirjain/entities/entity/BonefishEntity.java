package com.sirjain.entities.entity;

import com.sirjain.entities.entity.template.NoBucketSchoolingFishEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.FleeEntityGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class BonefishEntity extends NoBucketSchoolingFishEntity {
	public BonefishEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void initGoals() {
		super.initGoals();
		if (isScaredOfSpiritedFish())
			this.goalSelector.add(3, new FleeEntityGoal<>(this, SpiritedFishEntity.class, 6.0F, 1.0, 1.2));
	}

	// TODO: Replace with better flop sound
	@Override
	protected SoundEvent getFlopSound() {
		return SoundEvents.ENTITY_COD_FLOP;
	}

	@Override
	public void tick() {
		super.tick();
		if (this.age % 100 == 0) this.heal(1);
	}

	public boolean isScaredOfSpiritedFish() {
		return true;
	}

	public static DefaultAttributeContainer.Builder createBonefishAttributes() {
		return SchoolingFishEntity
			.createFishAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 8);
	}
}
