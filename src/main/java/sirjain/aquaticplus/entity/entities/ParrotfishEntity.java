package sirjain.aquaticplus.entity.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sirjain.aquaticplus.entity.ai.MoveToAndBreakBlockGoal;
import sirjain.aquaticplus.entity.entities.template.APSchoolingFishEntity;
import sirjain.aquaticplus.item.AquaticPlusItems;

public class ParrotfishEntity extends APSchoolingFishEntity {
	public ParrotfishEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void initGoals() {
		super.initGoals();
		this.goalSelector.add(1, new MoveToAndBreakBlockGoal(this, 1.3f, 10, 1));
	}

	public static DefaultAttributeContainer.Builder createParrotfishAttributes() {
		return FishEntity
			.createFishAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 8)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 3);
	}

	@Override
	public ItemStack getBucketItem() {
		return AquaticPlusItems.PARROTFISH_SPAWN_EGG.getDefaultStack();
	}
}
