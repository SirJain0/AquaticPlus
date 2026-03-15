package sirjain.aquaticplus.entity.ai;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ai.goal.MoveToTargetPosGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;

import java.util.Arrays;
import java.util.List;

public class MoveToAndBreakBlockGoal extends MoveToTargetPosGoal {
	private static final List<BlockState> PREFERRED_BLOCKS = Arrays.asList(
		Blocks.STONE.getDefaultState(),
		Blocks.GRAVEL.getDefaultState(),

		Blocks.DEAD_TUBE_CORAL_BLOCK.getDefaultState(),
		Blocks.DEAD_BRAIN_CORAL_BLOCK.getDefaultState(),
		Blocks.DEAD_BUBBLE_CORAL_BLOCK.getDefaultState(),
		Blocks.DEAD_HORN_CORAL_BLOCK.getDefaultState(),
		Blocks.DEAD_BRAIN_CORAL.getDefaultState(),
		Blocks.DEAD_BUBBLE_CORAL.getDefaultState(),
		Blocks.DEAD_HORN_CORAL.getDefaultState(),
		Blocks.DEAD_TUBE_CORAL_FAN.getDefaultState(),
		Blocks.DEAD_HORN_CORAL_FAN.getDefaultState(),
		Blocks.DEAD_TUBE_CORAL.getDefaultState()
	);

	private int breakingTicks;

	public MoveToAndBreakBlockGoal(PathAwareEntity mob, double speed, int range, int maxYDifference) {
		super(mob, speed, range, maxYDifference);
	}

	@Override
	protected boolean isTargetPos(WorldView world, BlockPos pos) {
		return PREFERRED_BLOCKS.contains(world.getBlockState(pos));
	}

	@Override
	public void start() {
		super.start();
		this.breakingTicks = 0;
	}

	@Override
	public void tick() {
		super.tick();

		if (this.hasReached()) {
			this.breakingTicks++;

			if (this.breakingTicks >= 40) {
				this.mob.getWorld().breakBlock(this.targetPos, false);
				this.mob.heal(2);
				this.breakingTicks = 0;
			}
		}
	}

	@Override
	public double getDesiredDistanceToTarget() {
		return 1.5;
	}
}