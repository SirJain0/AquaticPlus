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

public class RibbonEelEntity extends AbstractEelEntity {
	public RibbonEelEntity(EntityType<? extends AbstractEelEntity> entityType, World world) {
		super(entityType, world);
	}

	public static DefaultAttributeContainer.Builder createRibbonEelAttributes() {
		return AbstractEelEntity
			.createGenericEelAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 8);
	}
}