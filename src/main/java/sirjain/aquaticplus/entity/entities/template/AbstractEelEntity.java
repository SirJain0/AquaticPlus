package sirjain.aquaticplus.entity.entities.template;

import sirjain.aquaticplus.entity.ai.APSwimAroundGoal;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.EscapeDangerGoal;
import net.minecraft.entity.ai.goal.FleeEntityGoal;
import net.minecraft.entity.ai.goal.MoveIntoWaterGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public abstract class AbstractEelEntity extends NoBucketFishEntity {
	public AbstractEelEntity(EntityType<? extends FishEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(0, new EscapeDangerGoal(this, 1.5f));
		this.goalSelector.add(4, new FleeEntityGoal<>(this, PlayerEntity.class, 9, 1.0, 1.5));
		this.goalSelector.add(0, new MoveIntoWaterGoal(this));
		this.goalSelector.add(5, new APSwimAroundGoal(this, 1, 1, 10, 3));
	}

	public static DefaultAttributeContainer.Builder createGenericEelAttributes() {
		return createFishAttributes()
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 3)
			.add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 2);
	}
}
