package sirjain.aquaticplus.entity.entities;

import sirjain.aquaticplus.entity.entities.template.AbstractCrabEntity;
import sirjain.aquaticplus.item.AquaticPlusItems;
import net.minecraft.entity.*;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.item.Item;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.function.ValueLists;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.function.IntFunction;

public class NeonCrabEntity extends AbstractCrabEntity {
	private static final TrackedData<Integer> NEON_CRAB_TYPE = DataTracker.registerData(NeonCrabEntity.class, TrackedDataHandlerRegistry.INTEGER);

	public NeonCrabEntity(EntityType<? extends AbstractCrabEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void dropInventory() {
		super.dropInventory();

		if (this.getRandom().nextInt(10) == 0) {
			Item droppedClaw;

			if (this.getVariant().id == 0) droppedClaw = AquaticPlusItems.CYAN_CRAB_CLAW;
			else if (this.getVariant().id == 1) droppedClaw = AquaticPlusItems.PINK_CRAB_CLAW;
			else droppedClaw = AquaticPlusItems.ORANGE_CRAB_CLAW;

			this.dropItem(droppedClaw);
		}
	}

	@Nullable
	@Override
	public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
		this.initVariant();
		return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
	}

	protected void initVariant() {
		int textureID = this.random.nextInt(3);

		if (textureID == 0) this.setVariant(NeonCrabType.CYAN);
		if (textureID == 1) this.setVariant(NeonCrabType.PINK);
		else if (textureID == 2) this.setVariant(NeonCrabType.ORANGE);
	}

	@Override
	protected void initDataTracker() {
		super.initDataTracker();
		this.dataTracker.startTracking(NEON_CRAB_TYPE, NeonCrabType.CYAN.id);
	}

	@Override
	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);
		nbt.putInt("neon_crab_type", this.getVariant().id);
	}

	@Override
	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);
		this.setVariant(NeonCrabType.byId(nbt.getInt("neon_crab_type")));
	}

	public void setVariant(NeonCrabType sardineType) {
		this.dataTracker.set(NEON_CRAB_TYPE, sardineType.id);
	}

	public NeonCrabType getVariant() {
		return NeonCrabType.byId(this.dataTracker.get(NEON_CRAB_TYPE));
	}

	public enum NeonCrabType implements StringIdentifiable {
		CYAN(0, "cyan"),
		PINK(1, "pink"),
		ORANGE(2, "orange");

		private static final IntFunction<NeonCrabType> BY_ID = ValueLists.createIdToValueFunction(
			NeonCrabType::getId, values(), CYAN
		);

		final int id;
		private final String name;

		NeonCrabType(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public String asString() {
			return this.name;
		}

		public int getId() {
			return this.id;
		}

		public static NeonCrabType byId(int id) {
			return BY_ID.apply(id);
		}
	}
}
