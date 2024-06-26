package sirjain.aquaticplus.entity.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.AttackGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sirjain.aquaticplus.entity.entities.template.APSchoolingFishEntity;
import sirjain.aquaticplus.item.AquaticPlusItems;

public class BluefinTunaEntity extends APSchoolingFishEntity {
	public BluefinTunaEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void initGoals() {
		super.initGoals();
		this.goalSelector.add(0, new AttackGoal(this));
		this.goalSelector.add(0, new ActiveTargetGoal<>(this, ShadowSardelEntity.class, true));
	}

	public static DefaultAttributeContainer.Builder createBluefinTunaAttributes() {
		return FishEntity
			.createFishAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 12)
			.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 4.5F);
	}

	@Override
	public ItemStack getBucketItem() {
		return AquaticPlusItems.BLUEFIN_TUNA_BUCKET.getDefaultStack();
	}
}
