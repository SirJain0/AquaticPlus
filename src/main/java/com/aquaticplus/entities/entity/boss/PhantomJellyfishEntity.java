package com.aquaticplus.entities.entity.boss;

import com.aquaticplus.entities.entity.template.APFishEntity;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.world.World;

public class PhantomJellyfishEntity extends APFishEntity {
	public PhantomJellyfishEntity(EntityType<? extends FishEntity> entityType, World world) {
		super(entityType, world);
	}

	public final AnimationState swimAnimationState = new AnimationState();
	public int idleAnimationTimeout = 0;

	@Override
	public void tick() {
		super.tick();
		if (this.getWorld().isClient) this.setupAnimationStates();
	}

	private void setupAnimationStates() {
		if (this.idleAnimationTimeout <= 0) {
			this.idleAnimationTimeout = 80;
			this.swimAnimationState.start(this.age);
		} else {
			--this.idleAnimationTimeout;
		}
	}

	public static DefaultAttributeContainer.Builder createPhantomJellyfishAttributes() {
		return FishEntity
			.createFishAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 110)
			.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 10);
	}
}
