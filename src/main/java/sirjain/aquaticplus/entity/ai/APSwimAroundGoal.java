package sirjain.aquaticplus.entity.ai;

import net.minecraft.entity.ai.brain.task.LookTargetUtil;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;

public class APSwimAroundGoal extends WanderAroundGoal {
	private final int horziontalRange;
	private final int verticalRange;

	public APSwimAroundGoal(PathAwareEntity pathAwareEntity, double speed, int chance, int horziontalRange, int verticalRange) {
		super(pathAwareEntity, speed, chance);
		this.horziontalRange = horziontalRange;
		this.verticalRange = verticalRange;
	}

	@Nullable
	@Override
	protected Vec3d getWanderTarget() {
		return LookTargetUtil.find(this.mob, horziontalRange, verticalRange);
	}
}
