package sirjain.aquaticplus.entity.entities;

import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SeaPenEntity extends WaterCreatureEntity {
	private static final TrackedData<Float> SCALE = DataTracker.registerData(SeaPenEntity.class, TrackedDataHandlerRegistry.FLOAT);

	public SeaPenEntity(EntityType<? extends WaterCreatureEntity> entityType, World world) {
		super(entityType, world);
	}

	public static DefaultAttributeContainer.Builder createSeaPenAttributes() {
		return LivingEntity
			.createLivingAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 2)
			.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 4)
			.add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 2);
	}

	@Override
	public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
		int rand = this.getRandom().nextInt(3);
		this.setModelScale(0.8f + (rand / 10f));

		return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
	}

	public float getModelScale() {
		return this.dataTracker.get(SCALE);
	}

	public void setModelScale(float newScale) {
		this.dataTracker.set(SCALE, newScale);
	}

	@Override
	protected void initDataTracker() {
		super.initDataTracker();
		this.dataTracker.startTracking(SCALE, 1F);
	}

	@Override
	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);
		nbt.putFloat("scale", this.getModelScale());
	}

	@Override
	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);
		this.dataTracker.set(SCALE, nbt.getFloat("scale"));
	}

	@Override
	public boolean isPushable() {
		return false;
	}
}
