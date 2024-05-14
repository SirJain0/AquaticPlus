package com.sirjain.entities.entity;

import com.sirjain.entities.entity.template.NoBucketSchoolingFishEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.World;

/*
TODO:
- Try to make custom spawn egg
- Make it attack guardians via projectile, and change texture if angry
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

	@Override
	public void tick() {
		super.tick();

		if (this.getWorld().isClient) {
			World world = this.getWorld();
			double xPos = this.getX() + 0.8f;
			double xPos2 = this.getX() - 0.8f;

			summonRandomMagicParticle(world, xPos);
			summonRandomMagicParticle(world, xPos2);
		}

		if (this.age % 70 == 0 && this.getHealth() < this.getMaxHealth()) {
			this.heal(2);
		}
	}

	public void summonRandomMagicParticle(World world, double x) {
		if (this.random.nextInt(7) == 0) {
			world.addParticle(
				ParticleTypes.END_ROD,
				x, this.getRandomBodyY(), this.getZ() + 0.5f,
				-0.01f, 0.05f, 0
			);
		}
	}
}