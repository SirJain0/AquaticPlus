package sirjain.aquaticplus.entity.entities;

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
import sirjain.aquaticplus.entity.entities.template.AbstractEelEntity;
import sirjain.aquaticplus.entity.entities.template.NoBucketSchoolingFishEntity;

import java.util.function.IntFunction;

public class MythicalSeahorseEntity extends NoBucketSchoolingFishEntity {
	private static final TrackedData<Integer> MYTHICAL_SEAHORSE_TYPE = DataTracker.registerData(MythicalSeahorseEntity.class, TrackedDataHandlerRegistry.INTEGER);

	public MythicalSeahorseEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
		super(entityType, world);
	}

	// == VARIANTS ==

	@Nullable
	@Override
	public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
		this.initVariant();
		return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
	}

	protected void initVariant() {
		int textureID = this.random.nextInt(2);

		if (textureID == 0) this.setVariant(MythicalSeahorseType.CRIMSON);
		else if (textureID == 1) this.setVariant(MythicalSeahorseType.AQUA);
	}

	@Override
	protected void initDataTracker() {
		super.initDataTracker();
		this.dataTracker.startTracking(MYTHICAL_SEAHORSE_TYPE, MythicalSeahorseType.CRIMSON.id);
	}

	@Override
	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);
		nbt.putInt("mythical_seahorse_type", this.getVariant().id);
	}

	@Override
	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);
		this.setVariant(MythicalSeahorseType.byId(nbt.getInt("mythical_seahorse_type")));
	}

	public void setVariant(MythicalSeahorseType sardineType) {
		this.dataTracker.set(MYTHICAL_SEAHORSE_TYPE, sardineType.id);
	}

	public MythicalSeahorseType getVariant() {
		return MythicalSeahorseType.byId(this.dataTracker.get(MYTHICAL_SEAHORSE_TYPE));
	}

	public enum MythicalSeahorseType implements StringIdentifiable {
		CRIMSON(0, "crimson"),
		AQUA(1, "aqua");

		private static final IntFunction<MythicalSeahorseType> BY_ID = ValueLists.createIdToValueFunction(
			MythicalSeahorseType::getId, values(), CRIMSON
		);

		final int id;
		private final String name;

		MythicalSeahorseType(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public String asString() {
			return this.name;
		}

		public int getId() {
			return this.id;
		}

		public static MythicalSeahorseType byId(int id) {
			return BY_ID.apply(id);
		}
	}

	public static DefaultAttributeContainer.Builder createMythicalSeahorseAttributes() {
		return AbstractEelEntity
			.createGenericEelAttributes()
			.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 10)
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 15);
	}
}