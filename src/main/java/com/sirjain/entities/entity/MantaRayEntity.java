package com.sirjain.entities.entity;

import com.sirjain.entities.entity.template.NoBucketSchoolingFishEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
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

public class MantaRayEntity extends NoBucketSchoolingFishEntity implements Mount {
	private static final TrackedData<Integer> MANTA_RAY_TYPE = DataTracker.registerData(MantaRayEntity.class, TrackedDataHandlerRegistry.INTEGER);

	public MantaRayEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
		super(entityType, world);
	}

	@Nullable
	@Override
	public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
		this.initVariant();
		return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
	}

	protected void initDataTracker() {
		super.initDataTracker();
		this.dataTracker.startTracking(MANTA_RAY_TYPE, MantaRayType.DARK.id);
	}

	protected void initVariant() {
		int textureID = this.random.nextInt(3);

		if (textureID == 0) this.setVariant(MantaRayType.DARK);
		else if (textureID == 1) this.setVariant(MantaRayType.DARK_SPOTTED);
		else if (textureID == 2) this.setVariant(MantaRayType.BLUE);
	}

	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);
		nbt.putInt("MantaRayType", this.getVariant().id);
	}

	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);
		this.setVariant(MantaRayEntity.MantaRayType.byId(nbt.getInt("MantaRayType")));
	}

	public static DefaultAttributeContainer.Builder createMantaRayAttributes() {
		return SchoolingFishEntity
			.createFishAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 22)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 3.6f);
	}

	public void setVariant(MantaRayType mantaRayType) {
		this.dataTracker.set(MANTA_RAY_TYPE, mantaRayType.id);
	}

	public MantaRayEntity.MantaRayType getVariant() {
		return MantaRayEntity.MantaRayType.byId(this.dataTracker.get(MANTA_RAY_TYPE));
	}

	@Override
	protected ActionResult interactMob(PlayerEntity player, Hand hand) {
		this.setRiding(player);
		return ActionResult.SUCCESS;
	}

	@Nullable
	@Override
	public LivingEntity getControllingPassenger() {
		return (LivingEntity) this.getFirstPassenger();
	}

	private void setRiding(PlayerEntity pPlayer) {
		pPlayer.setYaw(this.getYaw());
		pPlayer.setPitch(this.getPitch());
		pPlayer.startRiding(this);
	}

	@Override
	public void travel(Vec3d movementInput) {
		if (this.hasPassengers() && getControllingPassenger() instanceof PlayerEntity) {
			LivingEntity livingentity = this.getControllingPassenger();
			this.setYaw(livingentity.getYaw());
			this.prevYaw = this.getYaw();
			this.setPitch(livingentity.getPitch() * 0.5F);
			this.setRotation(this.getYaw(), this.getPitch());
			this.bodyYaw = this.getYaw();
			this.headYaw = this.bodyYaw;
			float f = livingentity.sidewaysSpeed * 0.5F;
			float f1 = livingentity.forwardSpeed;
			if (f1 <= 0.0F) {
				f1 *= 0.25F;
			}

			if (this.isLogicalSideForUpdatingMovement()) {
				float newSpeed = (float) this.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED);

				if (MinecraftClient.getInstance().options.sprintKey.isPressed()) {
					newSpeed *= 1.4f; // Change this to ~1.5 or so
				}

				this.setMovementSpeed(newSpeed);
				super.travel(new Vec3d(f, movementInput.y, f1));
			}
		} else {
			super.travel(movementInput);
		}
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

	public enum MantaRayType implements StringIdentifiable {
		DARK(0, "dark"),
		DARK_SPOTTED(1, "dark_spotted"),
		BLUE(2, "blue");

		private static final IntFunction<MantaRayEntity.MantaRayType> BY_ID = ValueLists.createIdToValueFunction(MantaRayEntity.MantaRayType::getId, values(), DARK);
		final int id;
		private final String name;

		MantaRayType(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public String asString() {
			return this.name;
		}

		public int getId() {
			return this.id;
		}

		public static MantaRayEntity.MantaRayType byId(int id) {
			return BY_ID.apply(id);
		}
	}
}