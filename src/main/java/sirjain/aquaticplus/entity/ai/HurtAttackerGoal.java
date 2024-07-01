package sirjain.aquaticplus.entity.ai;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import sirjain.aquaticplus.entity.entities.PinkSunfishEntity;

public class HurtAttackerGoal extends Goal {
	private final PinkSunfishEntity pinkSunfish;

	public HurtAttackerGoal(PinkSunfishEntity pinkSunfish) {
		this.pinkSunfish = pinkSunfish;
	}

	@Override
	public boolean canStart() {
		return pinkSunfish != null && pinkSunfish.getAttacker() != null;
	}

	@Override
	public void start() {
		if (pinkSunfish.getDataTracker().get(PinkSunfishEntity.HAS_HURT_ATTACKER)) return;

		LivingEntity attacker = pinkSunfish.getAttacker();
		if (attacker == null) return;

		float attackerHealth = attacker.getHealth();
		attacker.setHealth(attackerHealth - 1);

		pinkSunfish.setAttackTracker(true);
	}

	@Override
	public boolean canStop() {
		return pinkSunfish.hasHurtAttacker() && !pinkSunfish.canResetAttackTracker();
	}
}