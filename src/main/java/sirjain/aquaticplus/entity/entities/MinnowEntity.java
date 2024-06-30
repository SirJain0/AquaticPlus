package sirjain.aquaticplus.entity.entities;

import sirjain.aquaticplus.entity.entities.template.APSchoolingFishEntity;
import sirjain.aquaticplus.item.AquaticPlusItems;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
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

public class MinnowEntity extends APSchoolingFishEntity {
	private static final TrackedData<Integer> MINNOW_TYPE = DataTracker.registerData(MinnowEntity.class, TrackedDataHandlerRegistry.INTEGER);
	public static final String BUCKET_VARIANT_TAG_KEY = "BucketVariantTag";

	public MinnowEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	public ItemStack getBucketItem() {
		return AquaticPlusItems.MINNOW_BUCKET.getDefaultStack();
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
			this.setVariant(MinnowType.byId(entityNbt.getInt(BUCKET_VARIANT_TAG_KEY)));
			return entityData;
		}

		this.initVariant();
		return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
	}

	protected void initVariant() {
		int textureID = this.random.nextInt(3);

		if (textureID == 0) this.setVariant(MinnowType.BLUE_WHITE);
		if (textureID == 1) this.setVariant(MinnowType.BROWN_RED);
		else if (textureID == 2) this.setVariant(MinnowType.GREEN_BEIGE);
	}

	@Override
	protected void initDataTracker() {
		super.initDataTracker();
		this.dataTracker.startTracking(MINNOW_TYPE, MinnowType.BLUE_WHITE.id);
	}

	@Override
	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);
		nbt.putInt("minnow_type", this.getVariant().id);
	}

	@Override
	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);
		this.setVariant(MinnowType.byId(nbt.getInt("minnow_type")));
	}

	public void setVariant(MinnowType minnowType) {
		this.dataTracker.set(MINNOW_TYPE, minnowType.id);
	}

	public MinnowType getVariant() {
		return MinnowType.byId(this.dataTracker.get(MINNOW_TYPE));
	}

	@Override
	public float getSpeedAmplifier() {
		return 0.02f;
	}

	public enum MinnowType implements StringIdentifiable {
		BLUE_WHITE(0, "blue_white"),
		BROWN_RED(1, "brown_red"),
		GREEN_BEIGE(2, "green_beige");

		private static final IntFunction<MinnowType> BY_ID = ValueLists.createIdToValueFunction(
			MinnowType::getId, values(), BLUE_WHITE
		);

		final int id;
		private final String name;

		MinnowType(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public String asString() {
			return this.name;
		}

		public int getId() {
			return this.id;
		}

		public static MinnowType byId(int id) {
			return BY_ID.apply(id);
		}
	}
}