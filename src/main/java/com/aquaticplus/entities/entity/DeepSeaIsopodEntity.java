package com.aquaticplus.entities.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.EscapeDangerGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

/*
TODO:
- Make the texture change depending on the name
- Animations
- Droppable shell item
- Spawns
- mountable feature
- Bellyrubs??
 */
public class DeepSeaIsopodEntity extends WaterCreatureEntity {
	public static final TrackedData<Boolean> IS_FROSTPOD = DataTracker.registerData(DeepSeaIsopodEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

	public DeepSeaIsopodEntity(EntityType<? extends WaterCreatureEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(0, new EscapeDangerGoal(this, 1.4f));
		this.goalSelector.add(1, new WanderAroundFarGoal(this, 1));
		this.goalSelector.add(3, new LookAroundGoal(this));
	}

	@Override
	public void setCustomName(@Nullable Text name) {
		super.setCustomName(name);

		if (name != null && name.equals(Text.literal("Frostpod")))
			this.setFrostpodState(true);
	}

	@Override
	protected void initDataTracker() {
		super.initDataTracker();
		this.dataTracker.startTracking(IS_FROSTPOD, false);
	}

	@Override
	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);
		nbt.putBoolean("is_frostpod", this.isFrostpod());
	}

	@Override
	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);
		this.setFrostpodState(nbt.getBoolean("is_frostpod"));
	}

	public boolean isFrostpod() {
		return this.dataTracker.get(IS_FROSTPOD);
	}

	public void setFrostpodState(boolean val) {
		this.dataTracker.set(IS_FROSTPOD, val);
	}

	public static DefaultAttributeContainer.Builder createIsopodAttributes() {
		return FishEntity
			.createFishAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 16)
			.add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 3)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.7f);
	}
}
