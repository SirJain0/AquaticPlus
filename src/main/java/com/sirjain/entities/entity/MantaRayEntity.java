package com.sirjain.entities.entity;

import com.sirjain.entities.entity.template.NoBucketSchoolingFishEntity;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.function.ValueLists;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.function.IntFunction;

public class MantaRayEntity extends NoBucketSchoolingFishEntity {
	private static final TrackedData<Integer> MANTA_RAY_TYPE = DataTracker.registerData(MantaRayEntity.class, TrackedDataHandlerRegistry.INTEGER);

	public MantaRayEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
		super(entityType, world);
	}

	@Nullable
	@Override
	public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
		this.initVariant();
		return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
	}

	protected void initDataTracker() {
		super.initDataTracker();
		this.dataTracker.startTracking(MANTA_RAY_TYPE, MantaRayType.DARK.id);
	}

	protected void initVariant() {
		int textureID = this.random.nextInt(3);

		if (textureID == 0) this.setVariant(MantaRayType.DARK);
		else if (textureID == 1) this.setVariant(MantaRayType.DARK_SPOTTED);
		else if (textureID == 2) this.setVariant(MantaRayType.BLUE);
	}

	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);
		nbt.putInt("MantaRayType", this.getVariant().id);
	}

	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);
		this.setVariant(MantaRayEntity.MantaRayType.byId(nbt.getInt("MantaRayType")));
	}

	public static DefaultAttributeContainer.Builder createMantaRayAttributes() {
		return SchoolingFishEntity
			.createFishAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 22)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 3.6f);
	}

	public void setVariant(MantaRayType mantaRayType) {
		this.dataTracker.set(MANTA_RAY_TYPE, mantaRayType.id);
	}

	public MantaRayEntity.MantaRayType getVariant() {
		return MantaRayEntity.MantaRayType.byId(this.dataTracker.get(MANTA_RAY_TYPE));
	}

	public enum MantaRayType implements StringIdentifiable {
		DARK(0, "dark"),
		DARK_SPOTTED(1, "dark_spotted"),
		BLUE(2, "blue");

		private static final IntFunction<MantaRayEntity.MantaRayType> BY_ID = ValueLists.createIdToValueFunction(MantaRayEntity.MantaRayType::getId, values(), DARK);
		final int id;
		private final String name;

		MantaRayType(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public String asString() {
			return this.name;
		}

		public int getId() {
			return this.id;
		}

		public static MantaRayEntity.MantaRayType byId(int id) {
			return BY_ID.apply(id);
		}
	}
}