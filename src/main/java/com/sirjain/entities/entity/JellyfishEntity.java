package com.sirjain.entities.entity;

import com.sirjain.entities.entity.template.NoBucketSchoolingFishEntity;
import net.minecraft.entity.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
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

import java.util.function.IntFunction;

/*
TODO:
- Add random scales
- Make it hurt you when you touch it
- Drops jelly and ghostly membrane
- Flee when it is below a certain health
- Animations
 */
public class JellyfishEntity extends NoBucketSchoolingFishEntity implements Mount {
	private static final TrackedData<Integer> JELLYFISH_TYPE = DataTracker.registerData(JellyfishEntity.class, TrackedDataHandlerRegistry.INTEGER);

	public JellyfishEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void initGoals() {
		super.initGoals();
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

		if (this.isFrostVariant()) {
			this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(15);
			this.heal(this.getMaxHealth());
		}

		return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
	}

	public boolean isFrostVariant() {
		return this.getVariant().id == 2;
	}

	@Override
	protected ActionResult interactMob(PlayerEntity player, Hand hand) {
		if (this.isFrostVariant() && hand == Hand.MAIN_HAND) {
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
		else if (textureID == 4) this.setVariant(JellyfishType.FROST);
	}

	@Override
	protected void initDataTracker() {
		super.initDataTracker();
		this.dataTracker.startTracking(JELLYFISH_TYPE, JellyfishType.PINK.id);
	}

	@Override
	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);
		nbt.putInt("jellyfish_type", this.getVariant().id);
	}

	@Override
	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);
		this.setVariant(JellyfishType.byId(nbt.getInt("jellyfish_type")));
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
		FROST(2, "frost");

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
