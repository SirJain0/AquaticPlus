package sirjain.aquaticplus.entity.entities;

import sirjain.aquaticplus.entity.entities.template.NoBucketSchoolingFishEntity;
import sirjain.aquaticplus.entity.ai.HurtAttackerGoal;
import sirjain.aquaticplus.status_effect.AquaticPlusStatusEffects;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.EscapeDangerGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.world.World;

import java.util.List;

public class PinkSunfishEntity extends NoBucketSchoolingFishEntity {
	public static final TrackedData<Boolean> HAS_HURT_ATTACKER = DataTracker.registerData(PinkSunfishEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

	public final AnimationState swimAnimationState = new AnimationState();
	private int idleAnimationTimeout = 0;

	public PinkSunfishEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void initGoals() {
		super.initGoals();
		this.goalSelector.add(0, new EscapeDangerGoal(this, 3));
		this.goalSelector.add(0, new HurtAttackerGoal(this));
	}

	@Override
	protected void initDataTracker() {
		super.initDataTracker();
		this.dataTracker.startTracking(HAS_HURT_ATTACKER, false);
	}

	@Override
	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);
		nbt.putBoolean("has_hurt_attacker", this.hasHurtAttacker());
	}

	public boolean hasHurtAttacker() {
		return this.dataTracker.get(HAS_HURT_ATTACKER);
	}

	public void setAttackTracker(boolean value) {
		this.dataTracker.set(HAS_HURT_ATTACKER, value);
	}

	public boolean canResetAttackTracker() {
		return this.age % 160 == 0 && this.hasHurtAttacker();
	}

	@Override
	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);
		this.dataTracker.set(HAS_HURT_ATTACKER, nbt.getBoolean("has_hurt_attacker"));
	}

	@Override
	protected void updateLimbs(float v) {
		float f = this.getPose() == EntityPose.STANDING ? Math.min(v * 6.0F, 1.0F) : 0;
		this.limbAnimator.updateLimbs(f, 0.2F);
	}

	@Override
	public void tick() {
		super.tick();

		if (this.getWorld().isClient)
			this.setupAnimationStates();

		List<Entity> entitiesAround = this.getWorld().getOtherEntities(null, this.getBoundingBox().expand(5), EntityPredicates.VALID_LIVING_ENTITY);

		for (Entity entity : entitiesAround) {
			if (entity instanceof LivingEntity mob && !(mob instanceof FishEntity)) {
				mob.addStatusEffect(new StatusEffectInstance(AquaticPlusStatusEffects.SUNFISH_GRACE, 20*5, 0));
			}
		}
	}

	private void setupAnimationStates() {
		if (this.idleAnimationTimeout <= 0) {
			this.idleAnimationTimeout = 80;
			this.swimAnimationState.start(this.age);
		} else {
			--this.idleAnimationTimeout;
		}
	}

	public static DefaultAttributeContainer.Builder createPinkSunfishAttributes() {
		return FishEntity
			.createFishAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 14)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 2.5f);
	}
}
