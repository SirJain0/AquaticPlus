package sirjain.aquaticplus.entity;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;
import sirjain.aquaticplus.AquaticPlusUtil;

// TODO: Custom spawn group with higher cap to make the waterbodies filled with life
public class AquaticPlusEntitySpawns {
	public static void initEntitySpawns() {
		initLocations();
		initRestrictions();
	}

	public static void initLocations() {
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.RIVER, BiomeKeys.WARM_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.FROZEN_RIVER, BiomeKeys.OCEAN, BiomeKeys.SWAMP, BiomeKeys.MANGROVE_SWAMP), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.SARDINE_ENTITY, 55, 6, 10);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.RIVER, BiomeKeys.WARM_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.FROZEN_RIVER, BiomeKeys.OCEAN, BiomeKeys.SWAMP, BiomeKeys.MANGROVE_SWAMP), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.MINNOW_ENTITY, 50, 5, 8);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.RIVER, BiomeKeys.WARM_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.FROZEN_RIVER, BiomeKeys.OCEAN, BiomeKeys.SWAMP, BiomeKeys.MANGROVE_SWAMP), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.HALIBUT_ENTITY, 48, 5, 8);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.WARM_OCEAN, BiomeKeys.COLD_OCEAN, BiomeKeys.RIVER, BiomeKeys.DEEP_LUKEWARM_OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.BLUEFIN_TUNA_ENTITY, 45, 4, 7);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FROZEN_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.COLD_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.OCEAN, BiomeKeys.SWAMP, BiomeKeys.MANGROVE_SWAMP, BiomeKeys.DEEP_FROZEN_OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.BONEFISH_ENTITY, 40, 3, 5);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.RIVER, BiomeKeys.FROZEN_RIVER), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.BONEFISH_ENTITY, 35, 2, 4);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FROZEN_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.COLD_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.OCEAN, BiomeKeys.SWAMP, BiomeKeys.MANGROVE_SWAMP, BiomeKeys.DEEP_FROZEN_OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.LONG_BONEFISH_ENTITY, 35, 2, 4);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.RIVER, BiomeKeys.FROZEN_RIVER), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.LONG_BONEFISH_ENTITY, 30, 2, 3);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.OCEAN, BiomeKeys.WARM_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.LUKEWARM_OCEAN, BiomeKeys.RIVER, BiomeKeys.DEEP_OCEAN, BiomeKeys.FROZEN_OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.SLIMY_SHRIMP_ENTITY, 42, 4, 7);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.RIVER, BiomeKeys.WARM_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.FROZEN_RIVER, BiomeKeys.OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.SEA_PEN_ENTITY, 60, 5, 8);

		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.OCEAN, BiomeKeys.WARM_OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.PARROTFISH_ENTITY, 38, 4, 6);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.WARM_OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.JELLYFISH_ENTITY, 38, 4, 7);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.LUKEWARM_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.JELLYFISH_ENTITY, 30, 3, 5);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.WARM_OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.LIONFISH_ENTITY, 34, 3, 5);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.LUKEWARM_OCEAN, BiomeKeys.OCEAN, BiomeKeys.SWAMP, BiomeKeys.MANGROVE_SWAMP), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.LIONFISH_ENTITY, 28, 2, 4);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.WARM_OCEAN, BiomeKeys.OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.LUKEWARM_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.PIKE_ENTITY, 32, 3, 5);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.SWAMP, BiomeKeys.MANGROVE_SWAMP), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.PIKE_ENTITY, 38, 3, 5);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DEEP_OCEAN, BiomeKeys.WARM_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.LUKEWARM_OCEAN, BiomeKeys.COLD_OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.SWORDFISH_ENTITY, 32, 2, 4);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DEEP_OCEAN, BiomeKeys.DEEP_FROZEN_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.FROZEN_OCEAN, BiomeKeys.FROZEN_RIVER, BiomeKeys.COLD_OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.NARWHAL_ENTITY, 32, 3, 6);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.RIVER, BiomeKeys.WARM_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.FROZEN_RIVER, BiomeKeys.OCEAN, BiomeKeys.SWAMP, BiomeKeys.MANGROVE_SWAMP), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.ALLIGATOR_GAR_ENTITY, 34, 2, 4);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.RIVER), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.SHADOW_SARDEL_ENTITY, 35, 3, 5);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FROZEN_RIVER), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.SHADOW_SARDEL_ENTITY, 25, 2, 4);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FROZEN_OCEAN, BiomeKeys.COLD_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.LANTERNFISH_ENTITY, 30, 2, 4);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.OCEAN, BiomeKeys.WARM_OCEAN, BiomeKeys.LUKEWARM_OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.MANTA_RAY_ENTITY, 28, 2, 4);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.RIVER, BiomeKeys.FROZEN_RIVER, BiomeKeys.OCEAN, BiomeKeys.WARM_OCEAN, BiomeKeys.LUKEWARM_OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.NEON_CRAB_ENTITY, 32, 2, 4);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.COLD_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.IVY_SEAHORSE_ENTITY, 32, 3, 6);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.COLD_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.MYTHICAL_SEAHORSE_ENTITY, 28, 2, 4);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.RIVER), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.MYTHICAL_SEAHORSE_ENTITY, 22, 2, 4);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.WARM_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.COLD_OCEAN, BiomeKeys.LUKEWARM_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.VOLAN_AURORA_ENTITY, 25, 2, 4);

		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.OCEAN, BiomeKeys.COLD_OCEAN, BiomeKeys.LUKEWARM_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.MAXILLA_MORTIS_ENTITY, 20, 1, 2);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FROZEN_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.COLD_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.VIPERFISH_ENTITY, 18, 1, 3);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FROZEN_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.COLD_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.SPIRITED_FISH_ENTITY, 24, 3, 5);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.OCEAN, BiomeKeys.WARM_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.LUKEWARM_OCEAN, BiomeKeys.RIVER, BiomeKeys.SWAMP), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.STONEFISH_ENTITY, 22, 1, 2);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DEEP_FROZEN_OCEAN, BiomeKeys.FROZEN_OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.FROSTED_SPLASHER_ENTITY, 26, 1, 3);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FROZEN_RIVER), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.FROSTED_SPLASHER_ENTITY, 18, 1, 2);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.RIVER, BiomeKeys.WARM_OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.RIBBON_EEL_ENTITY, 22, 1, 3);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.RIVER, BiomeKeys.WARM_OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.KELP_EEL_ENTITY, 24, 1, 3);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.RIVER, BiomeKeys.FROZEN_RIVER, BiomeKeys.OCEAN, BiomeKeys.SWAMP, BiomeKeys.MANGROVE_SWAMP), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.OCULI_MAGNI_ENTITY, 22, 1, 3);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.DEEP_FROZEN_OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.DUMBO_BLOB_ENTITY, 20, 1, 2);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.DEEP_OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.VERMILLION_JELLY_ENTITY, 24, 2, 4);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DEEP_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.DEEP_FROZEN_OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.DEEP_SEA_ISOPOD_ENTITY, 26, 2, 4);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DEEP_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.DEEP_FROZEN_OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.YETI_CRAB_ENTITY, 18, 1, 2);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.WARM_OCEAN, BiomeKeys.LUKEWARM_OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.PINK_SUNFISH_ENTITY, 18, 1, 2);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DEEP_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN), SpawnGroup.WATER_CREATURE, AquaticPlusEntities.GULPER_EEL_ENTITY, 16, 1, 2);
	}

	public static void initRestrictions() {
		for (EntityType<? extends MobEntity> entity : AquaticPlusUtil.SWIMMING_ENTITIES)
			SpawnRestriction.register(entity, SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canMobSpawn);

		for (EntityType<? extends MobEntity> entity : AquaticPlusUtil.GROUND_ENTITIES)
			SpawnRestriction.register(entity, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canMobSpawn);
	}
}