package com.sirjain.entities.entity.projectile;

import com.sirjain.entities.entity.template.AbstractAquaticStarEntity;
import com.sirjain.registries.AquaticPlusEntities;
import com.sirjain.registries.AquaticPlusItems;
import com.sirjain.registries.AquaticPlusStatusEffects;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class NumbingAquaticStarEntity extends AbstractAquaticStarEntity {
	public NumbingAquaticStarEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
		super(entityType, world);
	}

	public NumbingAquaticStarEntity(World world, LivingEntity owner) {
		super(AquaticPlusEntities.NUMBING_AQUATIC_STAR_ENTITY, world, owner);
	}

	@Override
	protected Item getDefaultItem() {
		return AquaticPlusItems.NUMBING_AQUATIC_STAR;
	}

	@Override
	public StatusEffect getConditionalEffect() {
		return AquaticPlusStatusEffects.NUMBING;
	}
}
