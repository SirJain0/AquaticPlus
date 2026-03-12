package sirjain.aquaticplus.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import sirjain.aquaticplus.status_effect.AquaticPlusStatusEffects;

// TODO: Make it waterloggable like other aquatic plants
public class AirleechPlantBlock extends HorizontalFacingBlock {
	public AirleechPlantBlock() {
		super(FabricBlockSettings.copyOf(Blocks.WITHER_ROSE).noCollision().notSolid());
		this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
	}

	public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
		if (entity instanceof LivingEntity livingEntity) {
			livingEntity.addStatusEffect(new StatusEffectInstance(AquaticPlusStatusEffects.LAND_DROWNING, 20*8, 2));
		}
	}

	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}
}
