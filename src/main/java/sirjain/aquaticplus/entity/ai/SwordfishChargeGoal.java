package sirjain.aquaticplus.entity.ai;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.Vec3d;
import sirjain.aquaticplus.entity.entities.SwordfishEntity;

import java.util.EnumSet;

// TODO: Finish this logic
public class SwordfishChargeGoal extends Goal {
	private final SwordfishEntity swordfish;
	private final double chargeSpeed;
	private final float attackDamage;
	private final double spikeRange;

	private LivingEntity target;
	private int cooldown;
	private boolean isCharging;

	public SwordfishChargeGoal(SwordfishEntity swordfish, double chargeSpeed, float attackDamage, double spikeRange) {
		this.swordfish = swordfish;
		this.chargeSpeed = chargeSpeed;
		this.attackDamage = attackDamage;
		this.spikeRange = spikeRange;
		this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
	}

	@Override
	public boolean canStart() {
		if (swordfish.hasPassengers() || swordfish.isSitting()) {
			return false;
		}

		if (cooldown > 0) {
			cooldown--;
			return false;
		}

		LivingEntity attacker = swordfish.getAttacker();
		if (attacker != null && attacker.isAlive() && swordfish.squaredDistanceTo(attacker) < 100) {
			target = attacker;
			return true;
		}

		return false;
	}

	@Override
	public boolean shouldContinue() {
		return target != null
			&& target.isAlive()
			&& !swordfish.hasPassengers()
			&& !swordfish.isSitting()
			&& swordfish.squaredDistanceTo(target) < 144;
	}

	@Override
	public void start() {
		isCharging = true;
		swordfish.setAccelerating(true);
	}

	@Override
	public void stop() {
		target = null;
		isCharging = false;
		swordfish.setAccelerating(false);
		cooldown = 40;
	}

	@Override
	public void tick() {
		if (target == null) return;

		swordfish.getLookControl().lookAt(target, 30.0F, 30.0F);

		swordfish.getNavigation().startMovingTo(target, chargeSpeed);

		if (isSpikeHittingTarget()) {
			target.damage(target.getDamageSources().mobAttack(swordfish), attackDamage);

			Vec3d knockback = swordfish.getRotationVector().multiply(0.5);
			target.addVelocity(knockback.x, 0.2, knockback.z);

			stop();
		}
	}

	private boolean isSpikeHittingTarget() {
		if (target == null) return false;

		Vec3d swordfishPos = swordfish.getPos();
		Vec3d lookDirection = swordfish.getRotationVector();
		Vec3d spikePos = swordfishPos.add(lookDirection.multiply(spikeRange));

		double distanceToSpike = target.squaredDistanceTo(spikePos);

		Vec3d toTarget = target.getPos().subtract(swordfishPos).normalize();
		double dotProduct = lookDirection.dotProduct(toTarget);
		return distanceToSpike < 4.0 && dotProduct > 0.5;
	}
}

