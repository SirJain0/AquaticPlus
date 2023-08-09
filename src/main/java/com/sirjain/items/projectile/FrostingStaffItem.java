package com.sirjain.items.projectile;

import com.sirjain.entities.entity.projectile.FrostedSnowballProjectileEntity;
import com.sirjain.items.abstract_item.AbstractStaffItem;
import com.sirjain.registries.AquaticPlusItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.world.World;

public class FrostingStaffItem extends AbstractStaffItem {
	public FrostingStaffItem(Settings settings) {
		super(settings, 2, 1.1f, AquaticPlusItems.FROSTED_SNOWBALL, 4);
	}

	@Override
	public ThrownItemEntity getEntity(World world, LivingEntity user) {
		return new FrostedSnowballProjectileEntity(world, user);
	}
}
