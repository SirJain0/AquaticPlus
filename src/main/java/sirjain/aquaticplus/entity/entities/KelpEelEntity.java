package sirjain.aquaticplus.entity.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.world.World;
import sirjain.aquaticplus.entity.entities.template.AbstractEelEntity;

public class KelpEelEntity extends AbstractEelEntity {
	public KelpEelEntity(EntityType<? extends AbstractEelEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void initGoals() {
		super.initGoals();
		this.goalSelector.add(2, new TemptGoal(this, 0.8f, Ingredient.ofItems(Items.KELP), false));
	}

	public static DefaultAttributeContainer.Builder createKelpEelAttributes() {
		return AbstractEelEntity
			.createGenericEelAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 12);
	}
}