package sirjain.aquaticplus.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class GhostlyGelBlock extends Block {
	public GhostlyGelBlock() {
		super(FabricBlockSettings.copyOf(Blocks.SLIME_BLOCK).noCollision().luminance(3).nonOpaque().breakInstantly().notSolid());
	}

	public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
		entity.slowMovement(state, new Vec3d(0.3, 0.1, 0.3));
	}
}