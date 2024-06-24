package com.aquaticplus.entities.entity;

import com.aquaticplus.entities.entity.template.NoBucketSchoolingFishEntity;
import com.aquaticplus.entities.ai.TeleportAttackerGoal;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;

public class OculiMagniEntity extends NoBucketSchoolingFishEntity {
	public static final TrackedData<Boolean> HAS_TELEPORTED_ATTACKER = DataTracker.registerData(OculiMagniEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

	public OculiMagniEntity(EntityType<? extends NoBucketSchoolingFishEntity> entityType, World world) {
		super(entityType, world);

		this.setTeleportationTracker(false);
		this.experiencePoints = 40;
	}

	@Override
	protected void initGoals() {
		super.initGoals();
		this.goalSelector.add(4, new TeleportAttackerGoal(this, 8, 3, 8));
	}

	@Override
	protected void initDataTracker() {
		super.initDataTracker();
		this.dataTracker.startTracking(HAS_TELEPORTED_ATTACKER, false);
	}

	@Override
	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);
		nbt.putBoolean("has_teleported_attacker", this.hasTeleportedAttacker());
	}

	@Override
	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);
		this.dataTracker.set(HAS_TELEPORTED_ATTACKER, nbt.getBoolean("has_teleported_attacker"));
	}

	@Override
	public void tick() {
		super.tick();
		if (canResetTeleportationTracker()) setTeleportationTracker(false);
	}

	public boolean canResetTeleportationTracker() {
		return this.age % 110 == 0 && this.hasTeleportedAttacker();
	}

	public boolean hasTeleportedAttacker() {
		return this.dataTracker.get(HAS_TELEPORTED_ATTACKER);
	}

	public void setTeleportationTracker(boolean value) {
		this.dataTracker.set(HAS_TELEPORTED_ATTACKER, value);
	}

	public static DefaultAttributeContainer.Builder createOculiMagniAttributes() {
		return FishEntity
			.createFishAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 7)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 2);
	}
}