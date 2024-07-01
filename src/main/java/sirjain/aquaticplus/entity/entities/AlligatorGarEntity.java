package sirjain.aquaticplus.entity.entities;

import sirjain.aquaticplus.entity.entities.template.NoBucketSchoolingFishEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.AttackGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.world.World;

public class AlligatorGarEntity extends NoBucketSchoolingFishEntity {
	public AlligatorGarEntity(EntityType<? extends NoBucketSchoolingFishEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void initGoals() {
		super.initGoals();
		this.goalSelector.add(1, new AttackGoal(this));
		this.targetSelector.add(1, new ActiveTargetGoal<>(this, TurtleEntity.class, 5, false, false, entity -> entity.isBaby()));
	}

	@Override
	public float getSpeedAmplifier() {
		return 0.06f;
	}

	public static DefaultAttributeContainer.Builder createAlligatorGarAttributes() {
		return FishEntity
			.createFishAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 12)
			.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 4F);
	}
}
