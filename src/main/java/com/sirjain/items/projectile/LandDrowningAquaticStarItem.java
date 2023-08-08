package com.sirjain.items.projectile;

import com.sirjain.entities.entity.projectile.LandDrowningAquaticStarEntity;
import com.sirjain.entities.entity.template.AbstractAquaticStarEntity;
import com.sirjain.items.abstract_item.AbstractAquaticStarItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class LandDrowningAquaticStarItem extends AbstractAquaticStarItem {
	public LandDrowningAquaticStarItem(Settings settings) {
		super(settings);
	}

	@Override
	public AbstractAquaticStarEntity getEntity(World world, PlayerEntity user) {
		return new LandDrowningAquaticStarEntity(world, user);
	}
}