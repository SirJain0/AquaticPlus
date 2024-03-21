package com.sirjain.entities;

import com.sirjain.registries.AquaticPlusEntities;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;

public class AquaticPlusEntitySpawns {
	public static void initEntitySpawns() {
		initLocations();
		initRestrictions();
	}

	public static void initLocations() {
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.OCEAN, BiomeKeys.COLD_OCEAN, BiomeKeys.LUKEWARM_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.MAXILLA_MORTIS_ENTITY, 36, 1, 1);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.RIVER, BiomeKeys.WARM_OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.KELP_EEL_ENTITY, 42, 1, 2);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.OCEAN, BiomeKeys.WARM_OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.PARROTFISH_ENTITY, 90, 5, 6);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.RIVER), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.SHADOW_SARDEL_ENTITY, 50, 3, 5);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FROZEN_RIVER), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.SHADOW_SARDEL_ENTITY, 28, 2, 4);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FROZEN_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.COLD_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.SPIRITED_FISH_ENTITY, 30, 3, 6);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FROZEN_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.COLD_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.OCEAN, BiomeKeys.DEEP_FROZEN_OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.BONEFISH_ENTITY, 36, 2, 4);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FROZEN_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.COLD_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.OCEAN, BiomeKeys.DEEP_FROZEN_OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.LONG_BONEFISH_ENTITY, 34, 2, 3);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.RIVER, BiomeKeys.FROZEN_RIVER), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.LONG_BONEFISH_ENTITY, 30, 2, 3);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.RIVER, BiomeKeys.FROZEN_RIVER), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.BONEFISH_ENTITY, 30, 2, 3);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.RIVER, BiomeKeys.FROZEN_RIVER, BiomeKeys.OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.OCULI_MAGNI_ENTITY, 42, 1, 2);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FROZEN_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.COLD_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.SPIRITED_FISH_ENTITY, 30, 3, 6);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FROZEN_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.COLD_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.VIPERFISH_ENTITY, 29, 1, 2);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FROZEN_OCEAN, BiomeKeys.COLD_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.LANTERNFISH_ENTITY, 30, 1, 3);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.OCEAN, BiomeKeys.WARM_OCEAN, BiomeKeys.LUKEWARM_OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.MANTA_RAY_ENTITY, 26, 3, 5);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.DEEP_FROZEN_OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.DUMBO_BLOB_ENTITY, 33, 1, 1);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.RIVER), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.DUMBO_BLOB_ENTITY, 28, 1, 2);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.WARM_OCEAN, BiomeKeys.COLD_OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.DUMBO_BLOB_ENTITY, 50, 1, 2);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.WARM_OCEAN, BiomeKeys.COLD_OCEAN, BiomeKeys.RIVER, BiomeKeys.DEEP_LUKEWARM_OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.BLUEFIN_TUNA_ENTITY, 120, 5, 8);
	}

	public static void initRestrictions() {
		for (EntityType<? extends FishEntity> entity : AquaticPlusEntities.MOD_ENTITIES) {
			SpawnRestriction.register(entity, SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, FishEntity::canMobSpawn);
		}
	}
}