package com.aquaticplus.entities.entity;

import com.aquaticplus.entities.entity.template.NoBucketFishEntity;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.WalkTarget;
import net.minecraft.entity.ai.brain.task.WalkTowardsPosTask;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.function.ValueLists;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.tslat.smartbrainlib.api.SmartBrainOwner;
import net.tslat.smartbrainlib.api.core.BrainActivityGroup;
import net.tslat.smartbrainlib.api.core.SmartBrainProvider;
import net.tslat.smartbrainlib.api.core.behaviour.FirstApplicableBehaviour;
import net.tslat.smartbrainlib.api.core.behaviour.custom.attack.AnimatableMeleeAttack;
import net.tslat.smartbrainlib.api.core.behaviour.custom.look.LookAtTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.misc.Idle;
import net.tslat.smartbrainlib.api.core.behaviour.custom.move.WalkOrRunToWalkTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.path.SetWalkTargetToAttackTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.target.InvalidateAttackTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.target.SetRandomLookTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.target.TargetOrRetaliate;
import net.tslat.smartbrainlib.api.core.sensor.ExtendedSensor;
import net.tslat.smartbrainlib.api.core.sensor.vanilla.NearbyLivingEntitySensor;
import net.tslat.smartbrainlib.api.core.sensor.vanilla.NearbyPlayersSensor;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.IntFunction;

/*
TODO:
- Make it sink to ground and stop animation when it has no target
- Make it give numbing effect when biting target
 */
public class StonefishEntity extends NoBucketFishEntity implements SmartBrainOwner<StonefishEntity> {
	private static final TrackedData<Integer> STONEFISH_TYPE = DataTracker.registerData(StonefishEntity.class, TrackedDataHandlerRegistry.INTEGER);

	public StonefishEntity(EntityType<? extends NoBucketFishEntity> entityType, World world) {
		super(entityType, world);
	}

	// Overriding with nothing because the entity uses brain system
	@Override
	protected void initGoals() {
	}

	@Nullable
	@Override
	public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
		this.initVariant();
		return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
	}

	protected void initVariant() {
		int textureID = this.random.nextInt(6);

		if (textureID == 0 || textureID == 1) this.setVariant(StonefishType.GRAY);
		else if (textureID == 2) this.setVariant(StonefishType.RED);
		else if (textureID == 3) this.setVariant(StonefishType.GREEN);
		else if (textureID == 4) this.setVariant(StonefishType.BLUE);
		else if (textureID == 5) this.setVariant(StonefishType.YELLOW);
	}

	@Override
	protected void initDataTracker() {
		super.initDataTracker();
		this.dataTracker.startTracking(STONEFISH_TYPE, StonefishType.GREEN.id);
	}

	@Override
	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);
		nbt.putInt("stonefish_type", this.getVariant().id);
	}

	@Override
	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);
		this.setVariant(StonefishType.byId(nbt.getInt("stonefish_type")));
	}

	public void setVariant(StonefishType stonefishType) {
		this.dataTracker.set(STONEFISH_TYPE, stonefishType.id);
	}

	public StonefishType getVariant() {
		return StonefishType.byId(this.dataTracker.get(STONEFISH_TYPE));
	}

	public static DefaultAttributeContainer.Builder createStonefishAttributes() {
		return SchoolingFishEntity
			.createFishAttributes()
			.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 12)
			.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 1)
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 14);
	}

	@Override
	protected Brain.Profile<?> createBrainProfile() {
		return new SmartBrainProvider<>(this);
	}

	@Override
	public float getSpeedAmplifier() {
		return 0.06f;
	}

	// Tick the brain so it functions, and update bossbar percent
	@Override
	protected void mobTick() {
		super.mobTick();

		this.tickBrain(this);
	}

	// Gives the entity sensors - things it is conscious of
	@Override
	public List<? extends ExtendedSensor<? extends StonefishEntity>> getSensors() {
		return ObjectArrayList.of(
			new NearbyPlayersSensor<>(),
			new NearbyLivingEntitySensor<StonefishEntity>()
				.setPredicate((target, entity) -> target instanceof PlayerEntity)
		);
	}

	// Usually run all the time
	@Override
	public BrainActivityGroup<StonefishEntity> getCoreTasks() {
		return BrainActivityGroup.coreTasks(
			new LookAtTarget<>(),
			new WalkOrRunToWalkTarget<>()
		);
	}

	// Run when the entity is idle
	@Override
	public BrainActivityGroup<StonefishEntity> getIdleTasks() {
		return BrainActivityGroup.idleTasks(
			// Try each one in order
			new FirstApplicableBehaviour(
				new TargetOrRetaliate<>()
					.attackablePredicate(target ->
						target.isAlive() && this.getBoundingBox().expand(6).contains(target.getPos())),
				new SetRandomLookTarget<>(),
				new Idle<>().stopIf(target -> this.getTarget() != null)
			)
		);
	}

	@Override
	public BrainActivityGroup<? extends StonefishEntity> getFightTasks() {
		return BrainActivityGroup.fightTasks(
			new InvalidateAttackTarget<>().invalidateIf((entity, target) -> !entity.getBoundingBox().expand(9).contains(target.getPos())),
			new SetWalkTargetToAttackTarget<>(),
			new AnimatableMeleeAttack<>(40)
		);
	}

	public enum StonefishType implements StringIdentifiable {
		GRAY(0, "grey"),
		GREEN(1, "green"),
		RED(2, "red"),
		YELLOW(3, "yellow"),
		BLUE(4, "blue");

		private static final IntFunction<StonefishType> BY_ID = ValueLists.createIdToValueFunction(
			StonefishType::getId, values(), GREEN
		);

		final int id;
		private final String name;

		StonefishType(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public String asString() {
			return this.name;
		}

		public int getId() {
			return this.id;
		}

		public static StonefishType byId(int id) {
			return BY_ID.apply(id);
		}
	}
}