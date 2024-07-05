package sirjain.aquaticplus;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.projectile.thrown.ThrownEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import sirjain.aquaticplus.blocks.AquaticPlusBlocks;
import sirjain.aquaticplus.entity.AquaticPlusEntities;
import sirjain.aquaticplus.entity.AquaticPlusEntitySpawns;
import sirjain.aquaticplus.entity.entities.projectile.PlasmaEntity;
import sirjain.aquaticplus.item.AquaticPlusFoodItems;
import sirjain.aquaticplus.item.AquaticPlusItemGroup;
import sirjain.aquaticplus.item.AquaticPlusItems;
import sirjain.aquaticplus.particle.AquaticPlusParticles;
import sirjain.aquaticplus.status_effect.AquaticPlusStatusEffects;
import sirjain.aquaticplus.status_effect.potion.AquaticPlusPotions;

import java.util.Arrays;
import java.util.List;

// TODO: Populate this with random helper methods and fields in mod code
public class AquaticPlusUtil {
	// Makes the entity go the same speed underwater as in air
	public static final double UNDERWATER_VELOCITY_MULTIPLIER = 1 / 0.8;

	// Used in the registerEntityLists() method - vars declared here so they can be used elsewhere
	public static List<EntityType<? extends MobEntity>> SWIMMING_ENTITIES;
	public static List<EntityType<? extends MobEntity>> GROUND_ENTITIES;

	// Phantom Jellyfish Attack: Shoots Plasma particles in line to target
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
		playPlasmaFireSound(attacker);
	}

	// Phantom Jellyfish Attack: Shoots Plasma core particles to target
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

		playPlasmaFireSound(attacker);
	}

	// Phantom Jellyfish Attack: Shoots particles in a radius circle
	public static void performShockwaveAttack(LivingEntity attacker, @Nullable LivingEntity target) {
		World world = attacker.getWorld();
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
				lavaProjectile.setPos(attacker.getX(), attacker.getY(), attacker.getZ());
				lavaProjectile.setVelocity(velocityX, 0, velocityZ, 1.2f, 0);
			}

			lavaProjectile.velocityDirty = true;
			world.spawnEntity(lavaProjectile);
		}

		playPlasmaFireSound(attacker);
	}

	// Helper method that plays the shoot sound of the plasma
	public static void playPlasmaFireSound(LivingEntity attacker) {
		attacker.getWorld().playSound(attacker, attacker.getBlockPos(), SoundEvents.ENTITY_BLAZE_SHOOT, SoundCategory.NEUTRAL, 0.8f,0.7f);
	}

	// Registers lists of swimming and ground entities, used in spawning
	public static void registerEntityLists() {
		SWIMMING_ENTITIES = Arrays.asList(
			AquaticPlusEntities.JOHNSON_ENTITY,
			AquaticPlusEntities.MINDINATOR_ENTITY,
			AquaticPlusEntities.SPIRITED_FISH_ENTITY,
			AquaticPlusEntities.MAXILLA_MORTIS_ENTITY,
			AquaticPlusEntities.PARROTFISH_ENTITY,
			AquaticPlusEntities.KELP_EEL_ENTITY,
			AquaticPlusEntities.SHADOW_SARDEL_ENTITY,
			AquaticPlusEntities.BONEFISH_ENTITY,
			AquaticPlusEntities.LONG_BONEFISH_ENTITY,
			AquaticPlusEntities.OCULI_MAGNI_ENTITY,
			AquaticPlusEntities.MANTA_RAY_ENTITY,
			AquaticPlusEntities.VIPERFISH_ENTITY,
			AquaticPlusEntities.DUMBO_BLOB_ENTITY,
			AquaticPlusEntities.PINK_SUNFISH_ENTITY,
			AquaticPlusEntities.LANTERNFISH_ENTITY,
			AquaticPlusEntities.BLUEFIN_TUNA_ENTITY,
			AquaticPlusEntities.GULPER_EEL_ENTITY,
			AquaticPlusEntities.HALIBUT_ENTITY,
			AquaticPlusEntities.SARDINE_ENTITY,
			AquaticPlusEntities.MINNOW_ENTITY,
			AquaticPlusEntities.LIONFISH_ENTITY,
			AquaticPlusEntities.FROSTED_SPLASHER_ENTITY,
			AquaticPlusEntities.JELLYFISH_ENTITY,
			AquaticPlusEntities.NARWHAL_ENTITY,
			AquaticPlusEntities.ALLIGATOR_GAR_ENTITY,
			AquaticPlusEntities.VOLAN_AURORA_ENTITY,
			AquaticPlusEntities.PIKE_ENTITY,
			AquaticPlusEntities.RIBBON_EEL_ENTITY,
			AquaticPlusEntities.STONEFISH_ENTITY,
			AquaticPlusEntities.VERMILLION_JELLY_ENTITY,
			AquaticPlusEntities.PHANTOM_JELLYFISH_ENTITY
		);

		GROUND_ENTITIES = Arrays.asList(
			AquaticPlusEntities.NEON_CRAB_ENTITY,
			AquaticPlusEntities.SEA_PEN_ENTITY,
			AquaticPlusEntities.DEEP_SEA_ISOPOD_ENTITY,
			AquaticPlusEntities.YETI_CRAB_ENTITY
		);
	}

	// Registers all of the mod's (non-client) content
	public static void registerContent() {
		AquaticPlusEntities.registerEntityTypes();
		AquaticPlusUtil.registerEntityLists();
		AquaticPlusEntities.registerAttributes();
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