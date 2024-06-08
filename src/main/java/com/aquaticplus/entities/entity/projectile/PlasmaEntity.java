package com.aquaticplus.entities.entity.projectile;

import com.aquaticplus.registries.AquaticPlusEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

public class PlasmaEntity extends ProjectileEntity {
	public PlasmaEntity(EntityType<? extends PlasmaEntity> entityType, World world) {
		super(entityType, world);
	}

	public PlasmaEntity(World world, LivingEntity owner) {
		super(AquaticPlusEntities.PLASMA_ENTITY, world);
		this.setOwner(owner);
	}

	@Override
	protected void initDataTracker() {

	}

	public void checkDespawn() {
		if (this.getWorld().getDifficulty() == Difficulty.PEACEFUL) this.discard();
	}
}
