package sirjain.aquaticplus;

import sirjain.aquaticplus.blocks.AquaticPlusBlocks;
import sirjain.aquaticplus.entity.AquaticPlusEntities;
import sirjain.aquaticplus.entity.AquaticPlusEntitySpawns;
import sirjain.aquaticplus.entity.entities.projectile.PlasmaEntity;
import sirjain.aquaticplus.item.AquaticPlusFoodItems;
import sirjain.aquaticplus.item.AquaticPlusItemGroup;
import sirjain.aquaticplus.item.AquaticPlusItems;
import sirjain.aquaticplus.particle.AquaticPlusParticles;
import sirjain.aquaticplus.status_effect.potion.AquaticPlusPotions;
import sirjain.aquaticplus.status_effect.AquaticPlusStatusEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownEntity;
import net.minecraft.server.world.ServerWorld;
import org.jetbrains.annotations.Nullable;

// TODO: Populate this with random helper methods and fields in mod code
public class AquaticPlusUtil {
	// Makes the entity go the same speed underwater as in air
	public static final double UNDERWATER_VELOCITY_MULTIPLIER = 1 / 0.8;

	// Phantom Jellyfish Attack: Shoots Plasma particles in line to target
	// TODO: Add shooting sound
	public static void performPlasmaBeamShootAttack(LivingEntity attacker, @Nullable LivingEntity target) {
		ThrownEntity projectile = new PlasmaEntity(attacker.getWorld(), attacker, true);

		if (target != null) {
			double xCoord = target.getX() - attacker.getX();
			double zCoord = target.getZ() - attacker.getZ();
			double velPath = Math.sqrt(xCoord * xCoord + zCoord * zCoord);

			double yCoord = target.getBodyY(0.3f) - projectile.getY() - 2;

			projectile.setVelocity(xCoord, yCoord + velPath * (double) 0.2f, zCoord, 1.3f, 0);
			attacker.getWorld().spawnEntity(projectile);
		} else {
			projectile.setVelocity(attacker, attacker.getPitch(), attacker.getYaw(), 0.0F, 1.3f, 0);
		}

		attacker.getWorld().spawnEntity(projectile);
	}

	// Phantom Jellyfish Attack: Shoots Plasma core particles to target
	// TODO: Add shooting sound
	public static void performPlasmaBallShootAttack(LivingEntity attacker, @Nullable LivingEntity target, int numParticles) {
		if (target != null) {
			double xCoord = target.getX() - attacker.getX();
			double zCoord = target.getZ() - attacker.getZ();
			double velPath = Math.sqrt(xCoord * xCoord + zCoord * zCoord);

			for (int i = 0; i < numParticles; i++) {
				ThrownEntity projectile = new PlasmaEntity(attacker.getWorld(), attacker, false);
				double yCoord = target.getBodyY(0.3f) - projectile.getY() - 2;

				projectile.setVelocity(xCoord, yCoord + velPath * (double) 0.2f, zCoord, 1.3f, 16);
				attacker.getWorld().spawnEntity(projectile);
			}
		} else {
			for (int i = 0; i < numParticles; i++) {
				ThrownEntity projectile = new PlasmaEntity(attacker.getWorld(), attacker, false);

				projectile.setVelocity(attacker, attacker.getPitch(), attacker.getYaw(), 0.0F, 1.3f, 14);
				attacker.getWorld().spawnEntity(projectile);
			}
		}
	}

	// Phantom Jellyfish Attack: Shoots particles in a radius circle
	// TODO: Add shooting sound
	public static void performShockwaveAttack(LivingEntity attacker, @Nullable LivingEntity target) {
		ServerWorld world = (ServerWorld) attacker.getWorld();
		int particleAmount = 15;
		float angleInterval = 360f / (float) particleAmount;

		for (int i = 0; i < particleAmount; i++) {
			double rotationIncrement = angleInterval * i;

			float velocityX = (float) Math.cos(rotationIncrement);
			float velocityZ = (float) Math.sin(rotationIncrement);

			ThrownEntity lavaProjectile = new PlasmaEntity(attacker.getWorld(), attacker, false);

			if (target != null) {
				double yCoord = target.getY() - lavaProjectile.getY();

				lavaProjectile.setPos(attacker.getX(), attacker.getY() + 3.2f, attacker.getZ());
				lavaProjectile.setVelocity(velocityX, (yCoord * (double) 0.1f) - 0.25f, velocityZ, 1.2f, 0);
			}  else {
				lavaProjectile.setPos(attacker.getX(), attacker.getY() + 3.2f, attacker.getZ());
				lavaProjectile.setVelocity(velocityX, 0, velocityZ, 1.2f, 0);
			}

			lavaProjectile.velocityDirty = true;
			world.spawnEntity(lavaProjectile);
		}
	}

	// Method that registers all of the mod's (non-client) content
	public static void registerContent() {
		AquaticPlusEntities.registerAttributes();
		AquaticPlusEntities.registerEntityRenderers();
		AquaticPlusStatusEffects.registerModEffects();
		AquaticPlusFoodItems.registerFoodComponents();
		AquaticPlusParticles.registerParticles();
		AquaticPlusItems.registerItems();
		AquaticPlusPotions.registerPotionRecipes();
		AquaticPlusBlocks.registerBlocks();
		AquaticPlusItems.registerBlockItems();
		AquaticPlusItemGroup.registerItemGroup();
		AquaticPlusEntitySpawns.initEntitySpawns();
	}
}