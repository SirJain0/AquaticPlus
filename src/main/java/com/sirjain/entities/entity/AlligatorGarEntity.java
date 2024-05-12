package com.sirjain.entities.entity;

import com.sirjain.entities.entity.template.NoBucketSchoolingFishEntity;
import com.sirjain.entities.goals.ActiveBabyTargetGoal;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.AttackGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.world.World;

/*
TODO:
- Gar flesh food item
 */
public class AlligatorGarEntity extends NoBucketSchoolingFishEntity {
	public AlligatorGarEntity(EntityType<? extends NoBucketSchoolingFishEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void initGoals() {
		super.initGoals();
		this.goalSelector.add(1, new AttackGoal(this));
		this.targetSelector.add(1, new ActiveBabyTargetGoal<>(this, TurtleEntity.class, true));

	}

	@Override
	public float getSpeedAmplifier() {
		return 0.06f;
	}

	public boolean shouldAngerAt(LivingEntity entity) {
		return this.getTarget() != null && this.getTarget() instanceof TurtleEntity;
	}

	public static DefaultAttributeContainer.Builder createAlligatorGarAttributes() {
		return FishEntity
			.createFishAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 12)
			.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 4F);
	}
}
