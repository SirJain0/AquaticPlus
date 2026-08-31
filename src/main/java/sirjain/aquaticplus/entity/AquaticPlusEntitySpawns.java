package sirjain.aquaticplus.entity;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;
import sirjain.aquaticplus.*;

public class AquaticPlusEntitySpawns {
	public static void initEntitySpawns() {
		initLocations();
		initRestrictions();
	}

	public static void initLocations() {
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.RIVER, BiomeKeys.WARM_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.FROZEN_RIVER, BiomeKeys.OCEAN, BiomeKeys.SWAMP, BiomeKeys.MANGROVE_SWAMP), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.SARDINE_ENTITY, 80, 6, 10);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.RIVER, BiomeKeys.WARM_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.FROZEN_RIVER, BiomeKeys.OCEAN, BiomeKeys.SWAMP, BiomeKeys.MANGROVE_SWAMP), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.MINNOW_ENTITY, 80, 5, 8);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.RIVER, BiomeKeys.WARM_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.FROZEN_RIVER, BiomeKeys.OCEAN, BiomeKeys.SWAMP, BiomeKeys.MANGROVE_SWAMP), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.HALIBUT_ENTITY, 58, 4, 6);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.WARM_OCEAN, BiomeKeys.COLD_OCEAN, BiomeKeys.RIVER, BiomeKeys.DEEP_LUKEWARM_OCEAN), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.BLUEFIN_TUNA_ENTITY, 65, 3, 5);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FROZEN_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.COLD_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.OCEAN, BiomeKeys.SWAMP, BiomeKeys.MANGROVE_SWAMP, BiomeKeys.DEEP_FROZEN_OCEAN), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.BONEFISH_ENTITY, 70, 3, 5);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.RIVER, BiomeKeys.FROZEN_RIVER), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.BONEFISH_ENTITY, 65, 2, 4);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FROZEN_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.COLD_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.OCEAN, BiomeKeys.SWAMP, BiomeKeys.MANGROVE_SWAMP, BiomeKeys.DEEP_FROZEN_OCEAN), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.LONG_BONEFISH_ENTITY, 65, 2, 4);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.RIVER, BiomeKeys.FROZEN_RIVER), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.LONG_BONEFISH_ENTITY, 60, 2, 3);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.OCEAN, BiomeKeys.WARM_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.LUKEWARM_OCEAN, BiomeKeys.RIVER, BiomeKeys.DEEP_OCEAN, BiomeKeys.FROZEN_OCEAN), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.SLIMY_SHRIMP_ENTITY, 72, 4, 7);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.RIVER, BiomeKeys.WARM_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.FROZEN_RIVER, BiomeKeys.OCEAN), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.SEA_PEN_ENTITY, 75, 5, 8);

		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.OCEAN, BiomeKeys.WARM_OCEAN), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.PARROTFISH_ENTITY, 40, 2, 4);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.WARM_OCEAN), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.JELLYFISH_ENTITY, 68, 4, 7);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.LUKEWARM_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.JELLYFISH_ENTITY, 60, 3, 5);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.WARM_OCEAN), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.LIONFISH_ENTITY, 64, 3, 5);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.LUKEWARM_OCEAN, BiomeKeys.OCEAN, BiomeKeys.SWAMP, BiomeKeys.MANGROVE_SWAMP), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.LIONFISH_ENTITY, 58, 2, 4);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.WARM_OCEAN, BiomeKeys.OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.LUKEWARM_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.PIKE_ENTITY, 52, 3, 5);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.SWAMP, BiomeKeys.MANGROVE_SWAMP), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.PIKE_ENTITY, 68, 3, 5);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DEEP_OCEAN, BiomeKeys.WARM_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.LUKEWARM_OCEAN, BiomeKeys.COLD_OCEAN), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.SWORDFISH_ENTITY, 62, 2, 4);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DEEP_OCEAN, BiomeKeys.DEEP_FROZEN_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.FROZEN_OCEAN, BiomeKeys.FROZEN_RIVER, BiomeKeys.COLD_OCEAN), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.NARWHAL_ENTITY, 32, 2, 3);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.RIVER, BiomeKeys.WARM_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.FROZEN_RIVER, BiomeKeys.OCEAN, BiomeKeys.SWAMP, BiomeKeys.MANGROVE_SWAMP), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.ALLIGATOR_GAR_ENTITY, 64, 2, 4);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.RIVER), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.SHADOW_SARDEL_ENTITY, 65, 3, 5);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FROZEN_RIVER), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.SHADOW_SARDEL_ENTITY, 55, 2, 4);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FROZEN_OCEAN, BiomeKeys.COLD_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.OCEAN), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.LANTERNFISH_ENTITY, 60, 2, 4);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.OCEAN, BiomeKeys.WARM_OCEAN, BiomeKeys.LUKEWARM_OCEAN), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.MANTA_RAY_ENTITY, 50, 2, 4);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.RIVER, BiomeKeys.OCEAN, BiomeKeys.WARM_OCEAN, BiomeKeys.LUKEWARM_OCEAN), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.NEON_CRAB_ENTITY, 40, 2, 4);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FROZEN_RIVER), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.NEON_CRAB_ENTITY, 62, 2, 4);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.COLD_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.IVY_SEAHORSE_ENTITY, 50, 3, 6);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.COLD_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.MYTHICAL_SEAHORSE_ENTITY, 20, 1, 2);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.RIVER), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.MYTHICAL_SEAHORSE_ENTITY, 20, 2, 4);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.WARM_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.COLD_OCEAN, BiomeKeys.LUKEWARM_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.VOLAN_AURORA_ENTITY, 30, 2, 4);

		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.OCEAN, BiomeKeys.COLD_OCEAN, BiomeKeys.LUKEWARM_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.MAXILLA_MORTIS_ENTITY, 7, 1, 1);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FROZEN_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.COLD_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.OCEAN), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.VIPERFISH_ENTITY, 48, 1, 3);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FROZEN_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.COLD_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.OCEAN), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.SPIRITED_FISH_ENTITY, 50, 3, 5);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.OCEAN, BiomeKeys.WARM_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.LUKEWARM_OCEAN, BiomeKeys.RIVER, BiomeKeys.SWAMP), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.STONEFISH_ENTITY, 52, 1, 2);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DEEP_FROZEN_OCEAN, BiomeKeys.FROZEN_OCEAN), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.FROSTED_SPLASHER_ENTITY, 60, 1, 3);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FROZEN_RIVER), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.FROSTED_SPLASHER_ENTITY, 55, 1, 2);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.RIVER, BiomeKeys.WARM_OCEAN), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.RIBBON_EEL_ENTITY, 52, 1, 3);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.RIVER, BiomeKeys.WARM_OCEAN), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.KELP_EEL_ENTITY, 54, 1, 3);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.RIVER, BiomeKeys.FROZEN_RIVER, BiomeKeys.OCEAN, BiomeKeys.SWAMP, BiomeKeys.MANGROVE_SWAMP), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.OCULI_MAGNI_ENTITY, 45, 1, 3);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.DEEP_FROZEN_OCEAN), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.DUMBO_BLOB_ENTITY, 40, 1, 2);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.DEEP_OCEAN), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.VERMILLION_JELLY_ENTITY, 40, 2, 4);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DEEP_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.DEEP_FROZEN_OCEAN), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.DEEP_SEA_ISOPOD_ENTITY, 56, 2, 4);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DEEP_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.DEEP_FROZEN_OCEAN), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.YETI_CRAB_ENTITY, 48, 1, 2);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.WARM_OCEAN, BiomeKeys.LUKEWARM_OCEAN), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.PINK_SUNFISH_ENTITY, 48, 1, 2);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DEEP_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN), AQPSpawnGroup.AQUATIC_PLUS, AquaticPlusEntities.GULPER_EEL_ENTITY, 46, 1, 2);
	}

	public static void initRestrictions() {
		for (EntityType<? extends MobEntity> entity : AquaticPlusUtil.SWIMMING_ENTITIES)
			SpawnRestriction.register(entity, SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canMobSpawn);

		for (EntityType<? extends MobEntity> entity : AquaticPlusUtil.GROUND_ENTITIES)
			SpawnRestriction.register(entity, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canMobSpawn);
	}
}