package com.sirjain.entities.entity;

import com.sirjain.entities.entity.template.NoBucketSchoolingFishEntity;
import com.sirjain.entities.goals.APSwimAroundGoal;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.EscapeDangerGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.ServerAdvancementLoader;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.function.ValueLists;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.function.IntFunction;

/*
Todo list:
- Remove boosts
- Add jumping
- Add animations
- Improve pathfinding AI
- Render saddle on model
 */

public class MantaRayEntity extends NoBucketSchoolingFishEntity implements Saddleable {
	private static final TrackedData<Integer> MANTA_RAY_TYPE = DataTracker.registerData(MantaRayEntity.class, TrackedDataHandlerRegistry.INTEGER);
	private static final TrackedData<Boolean> SADDLED = DataTracker.registerData(MantaRayEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
	private static final TrackedData<Integer> BOOST_TIME = DataTracker.registerData(MantaRayEntity.class, TrackedDataHandlerRegistry.INTEGER);

	private final SaddledComponent saddledComponent;

	public MantaRayEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
		super(entityType, world);
		this.saddledComponent = new SaddledComponent(this.dataTracker, BOOST_TIME, SADDLED);
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(0, new EscapeDangerGoal(this, 1.4f));
		this.goalSelector.add(1, new APSwimAroundGoal(this, 1, 1, 2, 10));
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
		this.dataTracker.startTracking(SADDLED, false);
		this.dataTracker.startTracking(BOOST_TIME, 0);
	}

	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);
		nbt.putInt("MantaRayType", this.getVariant().id);
		this.saddledComponent.writeNbt(nbt);
	}

	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);
		this.setVariant(MantaRayEntity.MantaRayType.byId(nbt.getInt("MantaRayType")));
		this.saddledComponent.readNbt(nbt);
	}

	protected void initVariant() {
		int textureID = this.random.nextInt(3);

		if (textureID == 0) this.setVariant(MantaRayType.DARK);
		else if (textureID == 1) this.setVariant(MantaRayType.DARK_SPOTTED);
		else if (textureID == 2) this.setVariant(MantaRayType.BLUE);
	}

	public static DefaultAttributeContainer.Builder createMantaRayAttributes() {
		return SchoolingFishEntity
			.createFishAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 22)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 5f);
	}

	public void setVariant(MantaRayType mantaRayType) {
		this.dataTracker.set(MANTA_RAY_TYPE, mantaRayType.id);
	}

	// == SADDLE SHIT ==
	public MantaRayEntity.MantaRayType getVariant() {
		return MantaRayEntity.MantaRayType.byId(this.dataTracker.get(MANTA_RAY_TYPE));
	}

	@Override
	public boolean canBeSaddled() {
		return !this.isBaby() && this.isAlive();
	}

	@Override
	public void saddle(@Nullable SoundCategory sound) {
		this.saddledComponent.setSaddled(true);
	}

	@Override
	public boolean isSaddled() {
		return this.saddledComponent.isSaddled();
	}

	@Override
	protected void dropInventory() {
		super.dropInventory();

		if (this.isSaddled())
			this.dropItem(Items.SADDLE);
	}

	@Override
	public void tick() {
		super.tick();

		if (this.isSaddled()) System.out.println("Saddled!");
		else System.out.println("Not Saddled!");
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