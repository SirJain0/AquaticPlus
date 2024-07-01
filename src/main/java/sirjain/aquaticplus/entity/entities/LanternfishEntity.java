package sirjain.aquaticplus.entity.entities;

import sirjain.aquaticplus.entity.entities.template.APSchoolingFishEntity;
import sirjain.aquaticplus.entity.entities.template.NoBucketSchoolingFishEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.FleeEntityGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.world.World;

public class LanternfishEntity extends NoBucketSchoolingFishEntity {
	public LanternfishEntity(EntityType<? extends APSchoolingFishEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void initGoals() {
		super.initGoals();
		this.goalSelector.add(0, new FleeEntityGoal<>(this, LivingEntity.class, 7, 6, 8));
	}

	public static DefaultAttributeContainer.Builder createLanternfishAttributes() {
		return SchoolingFishEntity
			.createFishAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 5)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 8); // TODO: Make them way faster
	}
}