package com.aquaticplus.entities.entity.projectile;

import com.aquaticplus.entities.entity.template.AbstractAquaticStarEntity;
import com.aquaticplus.registries.AquaticPlusEntities;
import com.aquaticplus.registries.AquaticPlusItems;
import com.aquaticplus.registries.AquaticPlusStatusEffects;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class LandDrowningAquaticStarEntity extends AbstractAquaticStarEntity {
	public LandDrowningAquaticStarEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
		super(entityType, world);
	}

	public LandDrowningAquaticStarEntity(World world, LivingEntity owner) {
		super(AquaticPlusEntities.LAND_DROWNING_AQUATIC_STAR_ENTITY, world, owner);
	}

	@Override
	protected Item getDefaultItem() {
		return AquaticPlusItems.LAND_DROWNING_AQUATIC_STAR;
	}

	@Override
	public StatusEffect getConditionalEffect() {
		return AquaticPlusStatusEffects.LAND_DROWNING;
	}
}
