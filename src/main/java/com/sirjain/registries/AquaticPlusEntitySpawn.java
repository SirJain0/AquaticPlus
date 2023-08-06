package com.sirjain.registries;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;

public class AquaticPlusEntitySpawn {
	public static void initEntitySpawns() {
		initLocations();
		initRestrictiona();
	}

	public static void initLocations() {
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.OCEAN, BiomeKeys.COLD_OCEAN, BiomeKeys.LUKEWARM_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.DEEP_COLD_OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.FIBULA_ENTITY, 36, 1, 1);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.RIVER, BiomeKeys.WARM_OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.KELP_EEL_ENTITY, 42, 1, 2);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.OCEAN, BiomeKeys.WARM_OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.PARROTFISH_ENTITY, 80, 5, 6);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.RIVER), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.SHADOW_SARDEL_ENTITY, 50, 3, 5);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FROZEN_RIVER), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.SHADOW_SARDEL_ENTITY, 28, 2, 4);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FROZEN_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.COLD_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.SPIRITED_FISH_ENTITY, 30, 3, 6);
	}

	public static void initRestrictiona() {
		SpawnRestriction.register(AquaticPlusEntities.FIBULA_ENTITY, SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, FishEntity::canMobSpawn);
		SpawnRestriction.register(AquaticPlusEntities.KELP_EEL_ENTITY, SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, FishEntity::canMobSpawn);
		SpawnRestriction.register(AquaticPlusEntities.PARROTFISH_ENTITY, SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, FishEntity::canMobSpawn);
		SpawnRestriction.register(AquaticPlusEntities.SHADOW_SARDEL_ENTITY, SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, FishEntity::canMobSpawn);
		SpawnRestriction.register(AquaticPlusEntities.SPIRITED_FISH_ENTITY, SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, FishEntity::canMobSpawn);
	}
}