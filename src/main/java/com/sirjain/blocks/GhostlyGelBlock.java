package com.sirjain.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class GhostlyGelBlock extends Block {
	public GhostlyGelBlock(Settings settings) {
		super(settings);
	}

	public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
		entity.slowMovement(state, new Vec3d(0.3, 0.1, 0.3));
	}
}