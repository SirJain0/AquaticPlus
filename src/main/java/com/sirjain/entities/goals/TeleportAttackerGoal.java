package com.sirjain.entities.goals;

import com.sirjain.entities.entity.OculiMagniEntity;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import static com.sirjain.entities.entity.OculiMagniEntity.HAS_TELEPORTED_ATTACKER;

public class TeleportAttackerGoal extends Goal {
	private final OculiMagniEntity oculiMagni;
	private final int destinationX;
	private final int destinationY;
	private final int destinationZ;

	public TeleportAttackerGoal(OculiMagniEntity oculiMagni, int destinationX, int destinationY, int destinationZ) {
		this.oculiMagni = oculiMagni;
		this.destinationX = destinationX;
		this.destinationY = destinationY;
		this.destinationZ = destinationZ;
	}

	@Override
	public boolean canStart() {
		return oculiMagni != null && oculiMagni.getAttacker() != null;
	}

	@Override
	public void start() {
		if (oculiMagni.getDataTracker().get(HAS_TELEPORTED_ATTACKER)) return;

		boolean locatedTopBlock = false;
		int yCounter = 0;
		int yPos = 0;
		int randX = oculiMagni.getRandom().nextInt(destinationX);
		int randZ = oculiMagni.getRandom().nextInt(destinationZ);

		LivingEntity attacker = oculiMagni.getAttacker();
		if (attacker == null) return;

		World world = oculiMagni.getWorld();
		Vec3d attackerPos = attacker.getPos();

		while (!locatedTopBlock) {
			BlockPos attackerBlockPos = attacker.getBlockPos();
			yCounter++;
			boolean isCorrectBlock = isAirBlock(world, attackerBlockPos, yCounter)
				|| isWaterBlock(world, attackerBlockPos, yCounter);

			if (isCorrectBlock) {
				locatedTopBlock = true;
				yCounter = 0;
				yPos = attackerBlockPos.up(yCounter).getY();
			}
		}

		// TODO: Add sound and particles when teleportation happens
		attacker.teleport(attackerPos.x - randX, yPos, attackerPos.z - randZ);
		oculiMagni.setTeleportationTracker(true);
	}

	private boolean isBlock(World world, BlockPos attackerBlockPos, int yCounter, Block block) {
		return world.getBlockState(attackerBlockPos.up(yCounter)).isOf(block);
	}

	private boolean isAirBlock(World world, BlockPos attackerBlockPos, int yCounter) {
		return isBlock(world, attackerBlockPos, yCounter, Blocks.AIR);
	}

	private boolean isWaterBlock(World world, BlockPos attackerBlockPos, int yCounter) {
		return isBlock(world, attackerBlockPos, yCounter, Blocks.WATER);
	}

	@Override
	public boolean canStop() {
		return oculiMagni.getDataTracker().get(HAS_TELEPORTED_ATTACKER) && !oculiMagni.canResetTeleportationTracker();
	}
}