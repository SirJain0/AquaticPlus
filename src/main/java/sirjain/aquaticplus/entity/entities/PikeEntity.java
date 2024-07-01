package sirjain.aquaticplus.entity.entities;

import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.AttackGoal;
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
import sirjain.aquaticplus.entity.entities.template.NoBucketSchoolingFishEntity;
import sirjain.aquaticplus.item.AquaticPlusItems;

import java.util.Objects;
import java.util.function.IntFunction;

public class PikeEntity extends NoBucketSchoolingFishEntity {
	private static final TrackedData<Integer> PIKE_TYPE = DataTracker.registerData(PikeEntity.class, TrackedDataHandlerRegistry.INTEGER);

	public PikeEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void initGoals() {
		super.initGoals();

		this.goalSelector.add(0, new AttackGoal(this));
		this.targetSelector.add(0, new ActiveTargetGoal<>(this, LivingEntity.class, false, entity -> !(entity instanceof PikeEntity)));
	}

	@Nullable
	@Override
	public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
		this.initVariant();
		return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
	}

	protected void initVariant() {
		int textureID = this.random.nextInt(40);

		if (textureID == 0) {
			this.setVariant(PikeType.MIDNIGHT);
			this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(30);
			this.heal(this.getMaxHealth());
		} else {
			this.setVariant(PikeType.BROWN);
		}
	}

	@Override
	protected void initDataTracker() {
		super.initDataTracker();
		this.dataTracker.startTracking(PIKE_TYPE, PikeType.BROWN.id);
	}

	@Override
	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);
		nbt.putInt("pike_type", this.getVariant().id);
	}

	@Override
	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);
		this.setVariant(PikeType.byId(nbt.getInt("pike_type")));
	}

	public void setVariant(PikeType pikeType) {
		this.dataTracker.set(PIKE_TYPE, pikeType.id);
	}

	public PikeType getVariant() {
		return PikeType.byId(this.dataTracker.get(PIKE_TYPE));
	}

	public boolean isMidnightVariant() {
		return Objects.equals(this.getVariant().name, PikeType.MIDNIGHT.name);
	}

	@Override
	protected void dropInventory() {
		if (this.isMidnightVariant()) this.dropItem(AquaticPlusItems.MIDNIGHT_PIKE);
		super.dropInventory();
	}

	public static DefaultAttributeContainer.Builder createPikeAttributes() {
		return SchoolingFishEntity
			.createFishAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 14)
			.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 2.4f)
			.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 2);
	}

	public enum PikeType implements StringIdentifiable {
		BROWN(0, "pike_brown"),
		MIDNIGHT(1, "pike_midnight");

		private static final IntFunction<PikeType> BY_ID = ValueLists.createIdToValueFunction(
			PikeType::getId, values(), BROWN
		);

		final int id;
		private final String name;

		PikeType(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public String asString() {
			return this.name;
		}

		public int getId() {
			return this.id;
		}

		public static PikeType byId(int id) {
			return BY_ID.apply(id);
		}
	}
}