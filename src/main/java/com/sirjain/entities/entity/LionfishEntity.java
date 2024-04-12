package com.sirjain.entities.entity;

import com.sirjain.entities.entity.template.NoBucketSchoolingFishEntity;
import com.sirjain.registries.AquaticPlusStatusEffects;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.goal.UniversalAngerGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.Angerable;
import net.minecraft.entity.passive.CodEntity;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.TimeHelper;
import net.minecraft.util.function.ValueLists;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;
import java.util.function.IntFunction;

/* TODO: 
lionfish spike
Sea Bane effect icon
make lionfish get angered by any mob not just players
 */
public class LionfishEntity extends NoBucketSchoolingFishEntity implements Angerable {
	private static final TrackedData<Integer> LIONFISH_TYPE = DataTracker.registerData(LionfishEntity.class, TrackedDataHandlerRegistry.INTEGER);
	private static final TrackedData<Integer> ANGER_TIME = DataTracker.registerData(LionfishEntity.class, TrackedDataHandlerRegistry.INTEGER);
	private static final UniformIntProvider ANGER_TIME_RANGE = TimeHelper.betweenSeconds(20, 39);
	private UUID angryAt;

	public LionfishEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void initGoals() {
		super.initGoals();

		this.goalSelector.add(1, new MeleeAttackGoal(this, 1.0, true));
		this.targetSelector.add(1, new UniversalAngerGoal(this, true));
		this.targetSelector.add(3, new ActiveTargetGoal<>(this, ParrotfishEntity.class, true));
		this.targetSelector.add(3, new ActiveTargetGoal<>(this, CodEntity.class, true));
		this.targetSelector.add(2, (new RevengeGoal(this)).setGroupRevenge());
		this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, 10, true, false, this::shouldAngerAt));
	}

	@Override
	public boolean tryAttack(Entity entity) {
		boolean canAttack = super.tryAttack(entity) && entity instanceof LivingEntity;
		if (canAttack) ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(AquaticPlusStatusEffects.SEA_BANE, 6 * 20, 0), this);

		return canAttack;
	}

	public static DefaultAttributeContainer.Builder createLionfishAttributes() {
		return FishEntity
			.createFishAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 8)
			.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 4f);
	}

	@Nullable
	@Override
	public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
		this.initVariant();
		return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
	}

	protected void initVariant() {
		int textureID = this.random.nextInt(2);

		if (textureID == 0) this.setVariant(LionfishType.RED);
		else if (textureID == 1) this.setVariant(LionfishType.BROWN);
	}

	@Override
	protected void initDataTracker() {
		super.initDataTracker();

		this.dataTracker.startTracking(LIONFISH_TYPE, LionfishType.RED.id);
		this.dataTracker.startTracking(ANGER_TIME, 0);
	}

	@Override
	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);

		nbt.putInt("lionfish_type", this.getVariant().id);
		this.writeAngerToNbt(nbt);
	}

	@Override
	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);

		this.setVariant(LionfishType.byId(nbt.getInt("lionfish_type")));
		this.readAngerFromNbt(this.getWorld(), nbt);
	}

	public void setVariant(LionfishType sardineType) {
		this.dataTracker.set(LIONFISH_TYPE, sardineType.id);
	}

	public LionfishType getVariant() {
		return LionfishType.byId(this.dataTracker.get(LIONFISH_TYPE));
	}

	// Universally Angry - from Angerable interface
	public int getAngerTime() {
		return this.dataTracker.get(ANGER_TIME);
	}

	public void setAngerTime(int angerTime) {
		this.dataTracker.set(ANGER_TIME, angerTime);
	}

	public void chooseRandomAngerTime() {
		this.setAngerTime(ANGER_TIME_RANGE.get(this.random));
	}

	@Nullable
	public UUID getAngryAt() {
		return this.angryAt;
	}

	public void setAngryAt(@Nullable UUID angryAt) {
		this.angryAt = angryAt;
	}

	public enum LionfishType implements StringIdentifiable {
		RED(0, "lionfish_red"),
		BROWN(1, "lionfish_brown");

		private static final IntFunction<LionfishType> BY_ID = ValueLists.createIdToValueFunction(
			LionfishType::getId, values(), RED
		);

		final int id;
		private final String name;

		LionfishType(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public String asString() {
			return this.name;
		}

		public int getId() {
			return this.id;
		}

		public static LionfishType byId(int id) {
			return BY_ID.apply(id);
		}
	}
}
