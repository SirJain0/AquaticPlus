package com.sirjain.items.projectile;

import com.sirjain.entities.entity.projectile.AquaticStarEntity;
import com.sirjain.entities.entity.template.AbstractAquaticStarEntity;
import com.sirjain.items.abstract_item.AbstractAquaticStarItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class AquaticStarItem extends AbstractAquaticStarItem {
	public AquaticStarItem(Settings settings) {
		super(settings);
	}

	@Override
	public AbstractAquaticStarEntity getEntity(World world, PlayerEntity user) {
		return new AquaticStarEntity(world, user);
	}
}