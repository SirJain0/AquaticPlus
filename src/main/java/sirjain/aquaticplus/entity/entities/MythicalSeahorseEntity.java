package sirjain.aquaticplus.entity.entities;

import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.ProjectileAttackGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.function.ValueLists;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import sirjain.aquaticplus.entity.entities.projectile.SeahorseSpikeEntity;
import sirjain.aquaticplus.entity.entities.template.NoBucketSchoolingFishEntity;
import sirjain.aquaticplus.item.AquaticPlusItems;

import java.util.function.IntFunction;

/*
TODO for tridents
- Handling when trident hits entity
- Do everything for crimson version
- Crafting recipes
 */
public class MythicalSeahorseEntity extends NoBucketSchoolingFishEntity implements RangedAttackMob {
	private static final TrackedData<Integer> MYTHICAL_SEAHORSE_TYPE = DataTracker.registerData(MythicalSeahorseEntity.class, TrackedDataHandlerRegistry.INTEGER);

	public MythicalSeahorseEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void initGoals() {
		super.initGoals();

		this.goalSelector.add(0, new ProjectileAttackGoal(this, 1, 40, 15));
		this.targetSelector.add(0, new RevengeGoal(this));
	}

	@Override
	protected void dropInventory() {
		if (this.getVariant().id == 0) this.dropItem(AquaticPlusItems.CRIMSON_SEAHORSE_SPIKE);
		else if (this.getVariant().id == 1) this.dropItem(AquaticPlusItems.AQUA_SEAHORSE_SPIKE);

		super.dropInventory();
	}

	@Override
	public void attack(LivingEntity target, float pullProgress) {
		double xCoord = target.getX() - this.getX();
		double zCoord = target.getZ() - this.getZ();
		double velPath = Math.sqrt(xCoord * xCoord + zCoord * zCoord);

		ThrownItemEntity projectile = new SeahorseSpikeEntity(this.getWorld(), this);

		if (this.getVariant().id == 1) {
			projectile.setItem(AquaticPlusItems.AQUA_SEAHORSE_SPIKE.getDefaultStack());
		}

		double yCoord = target.getBodyY(0.3f) - projectile.getY();

		projectile.setVelocity(xCoord, yCoord + velPath * (double) 0.2f + 0.1f, zCoord, 1, 0);
		this.getWorld().spawnEntity(projectile);
	}

	@Override
	public void tick() {
		World world = this.getWorld();

		if (!world.isClient && this.age % 3 == 0) {
			((ServerWorld) world).spawnParticles(ParticleTypes.ENCHANT, this.getX(), this.getY() + 1, this.getZ(), 5, 0, 0.2f, 0.1f, 1);
		}

		super.tick();
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
		return FishEntity
			.createFishAttributes()
			.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 10)
			.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2)
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 15);
	}
}