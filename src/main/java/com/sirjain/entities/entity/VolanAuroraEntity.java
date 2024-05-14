package com.sirjain.entities.entity;

import com.sirjain.entities.entity.template.NoBucketSchoolingFishEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.world.World;

/*
TODO:
- Try to make custom spawn egg
- Make it attack guardians via projectile, and change texture if angry
- Emit particles
- Spawns
- Drops
- Think of an item that baits it - maybe a spectre of some sort?
- Emissive texture for eyes - change based on variant
 */
public class VolanAuroraEntity extends NoBucketSchoolingFishEntity {
	public VolanAuroraEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
		super(entityType, world);
	}

	public static DefaultAttributeContainer.Builder createVolanAuroraAttributes() {
		return FishEntity
			.createFishAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 22)
			.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 4f);
	}

	@Override
	public float getSpeedAmplifier() {
		return 0.11f;
	}
}