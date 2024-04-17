package com.sirjain.entities.entity;

import com.sirjain.entities.entity.template.APFishEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

/*
TODO:
- Attack revenge AI
 */
public class FrostedSplasherEntity extends APFishEntity {
	public FrostedSplasherEntity(EntityType<? extends FishEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	public void travel(Vec3d movementInput) {
		super.travel(movementInput);

		if (this.isLogicalSideForUpdatingMovement())
			this.move(MovementType.SELF, this.getRotationVector().multiply(0.08f));
	}

	public static DefaultAttributeContainer.Builder createFrostedSplasherAttributes() {
		return FishEntity
			.createFishAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 16)
			.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 2);
	}

	@Override
	public void tick() {
		super.tick();

		if (this.getWorld().isClient) {
			World world = this.getWorld();
			double xPos = this.getX() + 0.8f;
			double xPos2 = this.getX() - 0.8f;

			summonRandomSnowParticle(world, xPos);
			summonRandomSnowParticle(world, xPos2);
		}
	}

	public void summonRandomSnowParticle(World world, double x) {
		if (this.random.nextInt(5) == 0) {
			world.addParticle(
				ParticleTypes.SNOWFLAKE,
				x, this.getRandomBodyY(), this.getZ() + 0.5f,
				-0.01f, 0.05f, 0
			);
		}
	}
}