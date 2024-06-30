package sirjain.aquaticplus.entity.entities;

import sirjain.aquaticplus.entity.entities.template.NoBucketFishEntity;
import sirjain.aquaticplus.status_effect.AquaticPlusStatusEffects;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.function.ValueLists;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.function.IntFunction;

public class StonefishEntity extends NoBucketFishEntity/* implements SmartBrainOwner<StonefishEntity>*/ {
	private static final TrackedData<Integer> STONEFISH_TYPE = DataTracker.registerData(StonefishEntity.class, TrackedDataHandlerRegistry.INTEGER);

	public StonefishEntity(EntityType<? extends NoBucketFishEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(1, new LookAroundGoal(this));
		this.goalSelector.add(0, new MeleeAttackGoal(this, 1, false));

		this.targetSelector.add(0, new ActiveTargetGoal<>(this, LivingEntity.class, 10, true, true,
			target -> target instanceof HostileEntity || target instanceof PlayerEntity));
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
			.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 4)
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 14);
	}

	@Override
	public void tickMovement() {
		super.tickMovement();

		if (this.getTarget() == null) {
			this.setVelocity(this.getVelocity().add(0.0, -0.002, 0.0));
			this.velocityDirty = true;
		}
	}

	@Override
	public boolean tryAttack(Entity entity) {
		boolean canAttack = super.tryAttack(entity) && entity instanceof LivingEntity;
		if (canAttack && this.random.nextInt(3) == 0)
			((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(AquaticPlusStatusEffects.NUMBING, 4 * 20, 0), this);

		return canAttack;
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