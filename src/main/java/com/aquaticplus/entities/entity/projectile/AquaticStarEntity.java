package com.aquaticplus.entities.entity.projectile;

import com.aquaticplus.entities.entity.template.AbstractAquaticStarEntity;
import com.aquaticplus.registries.AquaticPlusEntities;
import com.aquaticplus.registries.AquaticPlusItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class AquaticStarEntity extends AbstractAquaticStarEntity {
	public AquaticStarEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
		super(entityType, world);
	}

	public AquaticStarEntity(World world, PlayerEntity player) {
		super(AquaticPlusEntities.AQUATIC_STAR_ENTITY, world, player);
	}

	@Override
	protected Item getDefaultItem() {
		return AquaticPlusItems.AQUATIC_STAR;
	}

	@Override
	public StatusEffect getConditionalEffect() {
		return null;
	}
}
