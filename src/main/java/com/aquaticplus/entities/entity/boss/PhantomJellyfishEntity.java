package com.aquaticplus.entities.entity.boss;

import com.aquaticplus.entities.ai.AwesomeRangedAttack;
import com.aquaticplus.entities.ai.CoolRangedAttack;
import com.aquaticplus.entities.ai.LegendaryRangedAttack;
import com.aquaticplus.entities.entity.template.APFishEntity;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.world.World;
import net.tslat.smartbrainlib.api.SmartBrainOwner;
import net.tslat.smartbrainlib.api.core.BrainActivityGroup;
import net.tslat.smartbrainlib.api.core.SmartBrainProvider;
import net.tslat.smartbrainlib.api.core.behaviour.FirstApplicableBehaviour;
import net.tslat.smartbrainlib.api.core.behaviour.OneRandomBehaviour;
import net.tslat.smartbrainlib.api.core.behaviour.custom.attack.AnimatableRangedAttack;
import net.tslat.smartbrainlib.api.core.behaviour.custom.misc.Idle;
import net.tslat.smartbrainlib.api.core.behaviour.custom.move.MoveToWalkTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.path.SetRandomWalkTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.target.InvalidateAttackTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.target.SetRandomLookTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.target.TargetOrRetaliate;
import net.tslat.smartbrainlib.api.core.sensor.ExtendedSensor;
import net.tslat.smartbrainlib.api.core.sensor.vanilla.NearbyLivingEntitySensor;
import net.tslat.smartbrainlib.api.core.sensor.vanilla.NearbyPlayersSensor;

import java.util.List;

public class PhantomJellyfishEntity extends APFishEntity implements SmartBrainOwner<PhantomJellyfishEntity> {
	public final AnimationState swimAnimationState = new AnimationState();
	public int idleAnimationTimeout = 0;

	public PhantomJellyfishEntity(EntityType<? extends FishEntity> entityType, World world) {
		super(entityType, world);
	}

	// We are using brains for this entity
	@Override
	protected void initGoals() {
	}

	@Override
	public void tick() {
		super.tick();
		if (this.getWorld().isClient) this.setupAnimationStates();
	}

	private void setupAnimationStates() {
		if (this.idleAnimationTimeout <= 0) {
			this.idleAnimationTimeout = 80;
			this.swimAnimationState.start(this.age);
		} else {
			--this.idleAnimationTimeout;
		}
	}

	public static DefaultAttributeContainer.Builder createPhantomJellyfishAttributes() {
		return FishEntity
			.createFishAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 110)
			.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 10);
	}

	// Brain

	// Replaces Vanilla brain
	@Override
	protected Brain.Profile<?> createBrainProfile() {
		return new SmartBrainProvider<>(this);
	}

	// Tick the brain so it functions
	@Override
	protected void mobTick() {
		super.mobTick();
		this.tickBrain(this);
	}

	// Gives the entity sensors - things it is conscious of
	@Override
	public List<? extends ExtendedSensor<? extends PhantomJellyfishEntity>> getSensors() {
		return ObjectArrayList.of(
			new NearbyPlayersSensor<>(),            // Tracks nearby players
			new NearbyLivingEntitySensor<>()        // Tracks nearby entities
		);
	}

	// Usually run all the time
	@Override
	public BrainActivityGroup<PhantomJellyfishEntity> getCoreTasks() {
		return BrainActivityGroup.coreTasks(
			new MoveToWalkTarget<>()                // Walk towards the current walk target
		);
	}

	// Tasks run when nothing else is happening
	@Override
	public BrainActivityGroup<PhantomJellyfishEntity> getIdleTasks() {
		return BrainActivityGroup.idleTasks(
			// Try each one in order
			new FirstApplicableBehaviour<PhantomJellyfishEntity>(
				new TargetOrRetaliate<>(),      // Set the attack target and walk target based on nearby entities
				new SetRandomLookTarget<>()     // Set a random look target
			),

			// Pick a random one
			new OneRandomBehaviour<>(
				new SetRandomWalkTarget<>(),    // Set a random walk target to a nearby position
				new Idle<>().runFor(entity -> entity.getRandom().nextBetween(20, 40))  // Idle task
			)
		);
	}

	// Runs when the entity is fighting
	@Override
	public BrainActivityGroup<PhantomJellyfishEntity> getFightTasks() {
		return BrainActivityGroup.fightTasks(
			new InvalidateAttackTarget<>(),         // Cancel fighting if the target is no longer valid

			// Pick a random one
			new OneRandomBehaviour<>(
				new CoolRangedAttack<>(50),     // Attack #1
				new AwesomeRangedAttack<>(50),  // Attack #2
				new LegendaryRangedAttack<>(50) // Attack #3
			)
		);
	}
}
