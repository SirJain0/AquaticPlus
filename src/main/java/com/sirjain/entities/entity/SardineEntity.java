package com.sirjain.entities.entity;

import com.sirjain.entities.entity.template.APSchoolingFishEntity;
import com.sirjain.registries.AquaticPlusItems;
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
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.function.ValueLists;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.function.IntFunction;

public class SardineEntity extends APSchoolingFishEntity {
	private static final TrackedData<Integer> SARDINE_TYPE = DataTracker.registerData(SardineEntity.class, TrackedDataHandlerRegistry.INTEGER);
	public static final String BUCKET_VARIANT_TAG_KEY = "BucketVariantTag";

	public SardineEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	public ItemStack getBucketItem() {
		return AquaticPlusItems.SARDINE_BUCKET.getDefaultStack();
	}

	@Override
	public void copyDataToStack(ItemStack stack) {
		super.copyDataToStack(stack);

		NbtCompound nbtCompound = stack.getOrCreateNbt();
		nbtCompound.putInt(BUCKET_VARIANT_TAG_KEY, this.getVariant().id);
	}

	@Nullable
	@Override
	public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
		if (spawnReason == SpawnReason.BUCKET && entityNbt != null && entityNbt.contains(BUCKET_VARIANT_TAG_KEY, 3)) {
			this.setVariant(SardineType.byId(entityNbt.getInt(BUCKET_VARIANT_TAG_KEY)));
			return entityData;
		}

		this.initVariant();
		return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
	}

	protected void initVariant() {
		int textureID = this.random.nextInt(3);

		if (textureID == 0 || textureID == 1) this.setVariant(SardineType.GREY);
		else if (textureID == 2) this.setVariant(SardineType.BLUE_TOP);
	}

	@Override
	protected void initDataTracker() {
		super.initDataTracker();
		this.dataTracker.startTracking(SARDINE_TYPE, SardineType.GREY.id);
	}

	@Override
	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);
		nbt.putInt("sardine_type", this.getVariant().id);
	}

	@Override
	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);
		this.setVariant(SardineType.byId(nbt.getInt("sardine_type")));
	}

	public void setVariant(SardineType sardineType) {
		this.dataTracker.set(SARDINE_TYPE, sardineType.id);
	}

	public SardineType getVariant() {
		return SardineType.byId(this.dataTracker.get(SARDINE_TYPE));
	}

	public enum SardineType implements StringIdentifiable {
		GREY(0, "grey"),
		BLUE_TOP(1, "blue_top");

		private static final IntFunction<SardineType> BY_ID = ValueLists.createIdToValueFunction(
			SardineType::getId, values(), GREY
		);

		final int id;
		private final String name;

		SardineType(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public String asString() {
			return this.name;
		}

		public int getId() {
			return this.id;
		}

		public static SardineType byId(int id) {
			return BY_ID.apply(id);
		}
	}
}