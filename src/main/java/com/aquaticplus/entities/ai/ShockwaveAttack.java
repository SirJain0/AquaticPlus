package com.aquaticplus.entities.ai;

import com.aquaticplus.entities.entity.projectile.PlasmaEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.thrown.ThrownEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.tslat.smartbrainlib.api.core.behaviour.custom.attack.AnimatableRangedAttack;
import net.tslat.smartbrainlib.util.BrainUtils;
import org.joml.Vector3f;

import java.util.List;

public class ShockwaveAttack<E extends LivingEntity & RangedAttackMob> extends AnimatableRangedAttack<E> {
	public ShockwaveAttack(int delayTicks) {
		super(delayTicks);
	}

	@Override
	protected void doDelayedAction(E boss) {
		if (this.target == null)
			return;

		if (!BrainUtils.canSee(boss, this.target) || boss.squaredDistanceTo(this.target) > this.attackRadius)
			return;

		// Attack here
		System.out.println("Cool attack!");
		ServerWorld world = (ServerWorld) boss.getWorld();
		int particleAmount = 12;
		float angleInterval = 360f / (float) particleAmount;

		for (int i = 0; i < particleAmount; i++) {
			double rotationIncrement = angleInterval * i;

			float velocityX = (float) Math.cos(rotationIncrement);
			float velocityZ = (float) Math.sin(rotationIncrement);

			ThrownEntity lavaProjectile = new PlasmaEntity(boss.getWorld(), boss, false);

			double xCoord = target.getX() - boss.getX();
			double zCoord = target.getZ() - boss.getZ();
			double yPath = Math.sqrt(xCoord * xCoord + zCoord * zCoord);
			double yCoord = target.getY() - lavaProjectile.getY();

			lavaProjectile.setPos(boss.getX(), boss.getY() + 3.2f, boss.getZ());
			lavaProjectile.setVelocity(velocityX, yCoord * (double) 0.2f, velocityZ, 1.2f, 0);
			lavaProjectile.velocityDirty = true;

			world.spawnEntity(lavaProjectile);
		}

		BrainUtils.setForgettableMemory(boss, MemoryModuleType.ATTACK_COOLING_DOWN, true, this.attackIntervalSupplier.apply(boss));
	}
}
