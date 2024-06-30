package sirjain.aquaticplus.entity.entities;

import sirjain.aquaticplus.entity.entities.template.NoBucketSchoolingFishEntity;
import sirjain.aquaticplus.entity.ai.APSwimAroundGoal;
import sirjain.aquaticplus.item.AquaticPlusItems;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.EscapeDangerGoal;
import net.minecraft.entity.ai.goal.FleeEntityGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.function.ValueLists;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.IntFunction;

public class JellyfishEntity extends NoBucketSchoolingFishEntity implements Mount {
	private static final TrackedData<Integer> JELLYFISH_TYPE = DataTracker.registerData(JellyfishEntity.class, TrackedDataHandlerRegistry.INTEGER);
	private static final TrackedData<Float> SCALE = DataTracker.registerData(JellyfishEntity.class, TrackedDataHandlerRegistry.FLOAT);

	public JellyfishEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(2, new APSwimAroundGoal(this, 1, 1, 10, 3));
		this.goalSelector.add(0, new EscapeDangerGoal(this, 1.5f));
	}

	public static DefaultAttributeContainer.Builder createJellyfishAttributes() {
		return FishEntity
			.createFishAttributes()
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5f)
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 12);
	}

	@Nullable
	@Override
	public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
		this.initVariant();

		int rand = this.getRandom().nextInt(8);
		this.setModelScale(0.6f + (rand / 10f));

		if (this.isAlbinoVariant()) {
			this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(15);
			this.heal(this.getMaxHealth());
		}

		return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
	}

	public boolean isAlbinoVariant() {
		return this.getVariant().id == 2;
	}

	public float getModelScale() {
		return this.dataTracker.get(SCALE);
	}

	public void setModelScale(float newScale) {
		this.dataTracker.set(SCALE, newScale);
	}

	@Override
	public void tick() {
		super.tick();

		Goal fleeGoal = new FleeEntityGoal<>(this, PlayerEntity.class, 10, 1.4, 1.9);
		List<Entity> entities = this.getWorld()
			.getOtherEntities(this, this.getBoundingBox()
			.expand(0.6f), EntityPredicates.VALID_LIVING_ENTITY);

		// Handles the Flee goal depending on the health
		if (this.getHealth() < 6) this.goalSelector.add(1, fleeGoal);
		else this.goalSelector.remove(fleeGoal);

		// Hurts entities that "touch" it
		for (Entity entity : entities) {
			if (!(entity instanceof LivingEntity)) continue;
			entity.damage(entity.getDamageSources().mobAttackNoAggro(this), 1);
		}
	}

	@Override
	protected void dropInventory() {
		super.dropInventory();

		if (this.getVariant().id == 0) this.dropItem(AquaticPlusItems.PINK_JELLY);
		else if (this.getVariant().id == 1) this.dropItem(AquaticPlusItems.YELLOW_JELLY);
		else if (this.isAlbinoVariant()) this.dropItem(AquaticPlusItems.WHITE_JELLY);
	}

	@Override
	protected ActionResult interactMob(PlayerEntity player, Hand hand) {
		if (this.isAlbinoVariant() && hand == Hand.MAIN_HAND) {
			this.setRiding(player);
			return ActionResult.SUCCESS;
		}

		return super.interactMob(player, hand);
	}

	private void setRiding(PlayerEntity player) {
		player.setYaw(this.getYaw());
		player.setPitch(this.getPitch());
		player.startRiding(this);
	}

	@Override
	public double getMountedHeightOffset() {
		return 1.1f;
	}

	@Override
	public Vec3d updatePassengerForDismount(LivingEntity passenger) {
		Direction direction = this.getMovementDirection();

		if (direction.getAxis() == Direction.Axis.Y) {
			return super.updatePassengerForDismount(passenger);
		}

		int[][] is = Dismounting.getDismountOffsets(direction);
		BlockPos blockPos = this.getBlockPos();
		BlockPos.Mutable mutable = new BlockPos.Mutable();
		for (EntityPose entityPose : passenger.getPoses()) {
			Box box = passenger.getBoundingBox(entityPose);

			for (int[] js : is) {
				mutable.set(blockPos.getX() + js[0], blockPos.getY(), blockPos.getZ() + js[1]);
				double d = this.getWorld().getDismountHeight(mutable);

				if (!Dismounting.canDismountInBlock(d)) continue;
				Vec3d vec3d = Vec3d.ofCenter(mutable, d);
				if (!Dismounting.canPlaceEntityAt(this.getWorld(), passenger, box.offset(vec3d))) continue;
				passenger.setPose(entityPose);

				return vec3d;
			}
		}

		return super.updatePassengerForDismount(passenger);
	}

	protected void initVariant() {
		int textureID = this.random.nextInt(5);

		if (textureID == 0 || textureID == 1) this.setVariant(JellyfishType.PINK);
		else if (textureID == 2 || textureID == 3) this.setVariant(JellyfishType.YELLOW);
		else if (textureID == 4) this.setVariant(JellyfishType.ALBINO);
	}

	@Override
	protected void initDataTracker() {
		super.initDataTracker();

		this.dataTracker.startTracking(JELLYFISH_TYPE, JellyfishType.PINK.id);
		this.dataTracker.startTracking(SCALE, 1F);
	}

	@Override
	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);

		nbt.putInt("jellyfish_type", this.getVariant().id);
		nbt.putFloat("scale", this.getModelScale());
	}

	@Override
	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);

		this.setVariant(JellyfishType.byId(nbt.getInt("jellyfish_type")));
		this.dataTracker.set(SCALE, nbt.getFloat("scale"));
	}

	public void setVariant(JellyfishType sardineType) {
		this.dataTracker.set(JELLYFISH_TYPE, sardineType.id);
	}

	public JellyfishType getVariant() {
		return JellyfishType.byId(this.dataTracker.get(JELLYFISH_TYPE));
	}

	public enum JellyfishType implements StringIdentifiable {
		PINK(0, "pink"),
		YELLOW(1, "yellow"),
		ALBINO(2, "albino");

		private static final IntFunction<JellyfishType> BY_ID = ValueLists.createIdToValueFunction(
			JellyfishType::getId, values(), PINK
		);

		final int id;
		private final String name;

		JellyfishType(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public String asString() {
			return this.name;
		}

		public int getId() {
			return this.id;
		}

		public static JellyfishType byId(int id) {
			return BY_ID.apply(id);
		}
	}
}
