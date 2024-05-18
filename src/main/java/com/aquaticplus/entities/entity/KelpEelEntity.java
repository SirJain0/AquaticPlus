package com.aquaticplus.entities.entity;

import com.aquaticplus.entities.entity.template.AbstractEelEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.EscapeDangerGoal;
import net.minecraft.entity.ai.goal.FleeEntityGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.world.World;

public class KelpEelEntity extends AbstractEelEntity {
	public KelpEelEntity(EntityType<? extends AbstractEelEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void initGoals() {
		super.initGoals();
		this.goalSelector.add(0, new EscapeDangerGoal(this, 1.5f));
		this.goalSelector.add(2, new TemptGoal(this, 0.8f, Ingredient.ofItems(Items.KELP), false));
		this.goalSelector.add(4, new FleeEntityGoal<>(this, PlayerEntity.class, 9, 1.0, 1.5));
	}

	public static DefaultAttributeContainer.Builder createKelpEelAttributes() {
		return AbstractEelEntity
			.createGenericEelAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 12);
	}
}