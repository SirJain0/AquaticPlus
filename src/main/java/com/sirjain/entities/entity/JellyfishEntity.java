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
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.function.ValueLists;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.function.IntFunction;

/*
TODO:
- Increase HP when it is frost variant
- Add random scales
- Make it ridable but not controllable
- Make it hurt you when you touch it
- Drops jelly and ghostly membrane
- Flee when it is below a certain health
 */
public class JellyfishEntity extends NoBucketSchoolingFishEntity {
	private static final TrackedData<Integer> JELLYFISH_TYPE = DataTracker.registerData(JellyfishEntity.class, TrackedDataHandlerRegistry.INTEGER);

	public JellyfishEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void initGoals() {
		super.initGoals();
	}

	public static DefaultAttributeContainer.Builder createJellyfishAttributes() {
		return FishEntity
			.createFishAttributes()
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5f)
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 12);
	}

	@Nullable
	@Override
	public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
		this.initVariant();
		return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
	}

	protected void initVariant() {
		int textureID = this.random.nextInt(5);

		if (textureID == 0 || textureID == 1) this.setVariant(JellyfishType.PINK);
		else if (textureID == 2 || textureID == 3) this.setVariant(JellyfishType.YELLOW);
		else if (textureID == 4) this.setVariant(JellyfishType.FROST);
	}

	@Override
	protected void initDataTracker() {
		super.initDataTracker();
		this.dataTracker.startTracking(JELLYFISH_TYPE, JellyfishType.PINK.id);
	}

	@Override
	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);
		nbt.putInt("jellyfish_type", this.getVariant().id);
	}

	@Override
	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);
		this.setVariant(JellyfishType.byId(nbt.getInt("jellyfish_type")));
	}

	public void setVariant(JellyfishType sardineType) {
		this.dataTracker.set(JELLYFISH_TYPE, sardineType.id);
	}

	public JellyfishType getVariant() {
		return JellyfishType.byId(this.dataTracker.get(JELLYFISH_TYPE));
	}

	public enum JellyfishType implements StringIdentifiable {
		PINK(0, "pink"),
		YELLOW(1, "yellow"),
		FROST(2, "frost");

		private static final IntFunction<JellyfishType> BY_ID = ValueLists.createIdToValueFunction(
			JellyfishType::getId, values(), PINK
		);

		final int id;
		private final String name;

		JellyfishType(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public String asString() {
			return this.name;
		}

		public int getId() {
			return this.id;
		}

		public static JellyfishType byId(int id) {
			return BY_ID.apply(id);
		}
	}
}
