package sirjain.aquaticplus.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.entity.entities.*;
import sirjain.aquaticplus.entity.entities.boss.PhantomJellyfishEntity;
import sirjain.aquaticplus.entity.entities.projectile.*;
import sirjain.aquaticplus.entity.entities.template.AbstractCrabEntity;

/*
TODO for entities:
- Check all hitboxes and shadow radiuses
- Make API for being saddleable/mountable
 */

public class AquaticPlusEntities<T extends Entity> {
	public static EntityType<ShadowSardelEasterEggEntity> JOHNSON_ENTITY;
	public static EntityType<ShadowSardelEasterEggEntity> MINDINATOR_ENTITY;
	public static EntityType<SpiritedFishEntity> SPIRITED_FISH_ENTITY;
	public static EntityType<MaxillaMortisEntity> MAXILLA_MORTIS_ENTITY;
	public static EntityType<ParrotfishEntity> PARROTFISH_ENTITY;
	public static EntityType<KelpEelEntity> KELP_EEL_ENTITY;
	public static EntityType<ShadowSardelEntity> SHADOW_SARDEL_ENTITY;
	public static EntityType<BonefishEntity> BONEFISH_ENTITY;
	public static EntityType<LongBonefishEntity> LONG_BONEFISH_ENTITY;
	public static EntityType<OculiMagniEntity> OCULI_MAGNI_ENTITY;
	public static EntityType<ViperfishEntity> VIPERFISH_ENTITY;
	public static EntityType<MantaRayEntity> MANTA_RAY_ENTITY;
	public static EntityType<DumboBlobEntity> DUMBO_BLOB_ENTITY;
	public static EntityType<PinkSunfishEntity> PINK_SUNFISH_ENTITY;
	public static EntityType<LanternfishEntity> LANTERNFISH_ENTITY;
	public static EntityType<BluefinTunaEntity> BLUEFIN_TUNA_ENTITY;
	public static EntityType<GulperEelEntity> GULPER_EEL_ENTITY;
	public static EntityType<HalibutEntity> HALIBUT_ENTITY;
	public static EntityType<SardineEntity> SARDINE_ENTITY;
	public static EntityType<MinnowEntity> MINNOW_ENTITY;
	public static EntityType<LionfishEntity> LIONFISH_ENTITY;
	public static EntityType<FrostedSplasherEntity> FROSTED_SPLASHER_ENTITY;
	public static EntityType<JellyfishEntity> JELLYFISH_ENTITY;
	public static EntityType<NarwhalEntity> NARWHAL_ENTITY;
	public static EntityType<SwordfishEntity> SWORDFISH_ENTITY;
	public static EntityType<NeonCrabEntity> NEON_CRAB_ENTITY;
	public static EntityType<AlligatorGarEntity> ALLIGATOR_GAR_ENTITY;
	public static EntityType<SeaPenEntity> SEA_PEN_ENTITY;
	public static EntityType<VolanAuroraEntity> VOLAN_AURORA_ENTITY;
	public static EntityType<PikeEntity> PIKE_ENTITY;
	public static EntityType<RibbonEelEntity> RIBBON_EEL_ENTITY;
	public static EntityType<DeepSeaIsopodEntity> DEEP_SEA_ISOPOD_ENTITY;
	public static EntityType<YetiCrabEntity> YETI_CRAB_ENTITY;
	public static EntityType<StonefishEntity> STONEFISH_ENTITY;
	public static EntityType<VermillionJellyEntity> VERMILLION_JELLY_ENTITY;
	public static EntityType<PhantomJellyfishEntity> PHANTOM_JELLYFISH_ENTITY;
	public static EntityType<AquaticStarEntity> AQUATIC_STAR_ENTITY;
	public static EntityType<NumbingAquaticStarEntity> NUMBING_AQUATIC_STAR_ENTITY;
	public static EntityType<LandDrowningAquaticStarEntity> LAND_DROWNING_AQUATIC_STAR_ENTITY;
	public static EntityType<SeaBaneAquaticStarEntity> SEA_BANE_AQUATIC_STAR_ENTITY;
	public static EntityType<FrostedSnowballEntity> FROSTED_SNOWBALL_ENTITY;
	public static EntityType<AuroraEntity> AURORA_ENTITY;
	public static EntityType<PlasmaEntity> PLASMA_ENTITY;

	public static void registerEntityTypes() {
		JOHNSON_ENTITY = registerEntityType("johnson", ShadowSardelEasterEggEntity::new, 0.5f, 0.5f);
		MINDINATOR_ENTITY = registerEntityType("mindinator", ShadowSardelEasterEggEntity::new, 0.5f, 0.5f);
		SPIRITED_FISH_ENTITY = registerEntityType("spirited_fish", SpiritedFishEntity::new, 0.5f, 0.5f);
		MAXILLA_MORTIS_ENTITY = registerEntityType("maxilla_mortis", MaxillaMortisEntity::new, 0.7f, 0.8f);
		PARROTFISH_ENTITY = registerEntityType("parrotfish", ParrotfishEntity::new, 0.5f, 0.5f);
		KELP_EEL_ENTITY = registerEntityType("kelp_eel", KelpEelEntity::new, 0.6f, 0.6f);
		SHADOW_SARDEL_ENTITY = registerEntityType("shadow_sardel", ShadowSardelEntity::new, 0.5f, 0.5f);
		BONEFISH_ENTITY = registerEntityType("bonefish", BonefishEntity::new, 0.5f, 0.5f);
		LONG_BONEFISH_ENTITY = registerEntityType("long_bonefish", LongBonefishEntity::new, 0.5f, 0.5f);
		OCULI_MAGNI_ENTITY = registerEntityType("oculi_magni", OculiMagniEntity::new, 0.5f, 0.5f);
		VIPERFISH_ENTITY = registerEntityType("viperfish", ViperfishEntity::new, 0.6f, 0.6f);
		MANTA_RAY_ENTITY = registerEntityType("manta_ray", MantaRayEntity::new, 1.1f, 0.9f);
		DUMBO_BLOB_ENTITY = registerEntityType("dumbo_blob", DumboBlobEntity::new, 0.4f, 0.4f);
		PINK_SUNFISH_ENTITY = registerEntityType("pink_sunfish", PinkSunfishEntity::new, 0.3f, 0.6f);
		LANTERNFISH_ENTITY = registerEntityType("lanternfish", LanternfishEntity::new, 0.4f, 0.4f);
		BLUEFIN_TUNA_ENTITY = registerEntityType("bluefin_tuna", BluefinTunaEntity::new, 0.4f, 0.4f);
		GULPER_EEL_ENTITY = registerEntityType("gulper_eel", GulperEelEntity::new, 0.5f, 0.5f);
		HALIBUT_ENTITY = registerEntityType("halibut", HalibutEntity::new, 0.4f, 0.4f);
		SARDINE_ENTITY = registerEntityType("sardine", SardineEntity::new, 0.4f, 0.4f);
		MINNOW_ENTITY = registerEntityType("minnow", MinnowEntity::new, 0.4f, 0.4f);
		LIONFISH_ENTITY = registerEntityType("lionfish", LionfishEntity::new, 0.4f, 0.4f);
		FROSTED_SPLASHER_ENTITY = registerEntityType("frosted_splasher", FrostedSplasherEntity::new, 0.6f, 0.5f);
		JELLYFISH_ENTITY = registerEntityType("jellyfish", JellyfishEntity::new, 0.4f, 0.4f);
		NARWHAL_ENTITY = registerEntityType("narwhal", NarwhalEntity::new, 0.6f, 0.6f);
		SWORDFISH_ENTITY = registerEntityType("swordfish", SwordfishEntity::new, 0.6f, 0.6f);
		NEON_CRAB_ENTITY = registerEntityType("neon_crab_entity", NeonCrabEntity::new, 0.4f, 0.3f);
		ALLIGATOR_GAR_ENTITY = registerEntityType("alligator_gar", AlligatorGarEntity::new, 0.5f, 0.5f);
		SEA_PEN_ENTITY = registerEntityType("sea_pen", SeaPenEntity::new, 0.5f, 0.5f);
		VOLAN_AURORA_ENTITY = registerFireImmuneEntityType("volan_aurora", VolanAuroraEntity::new, 0.6f, 0.5f);
		PIKE_ENTITY = registerEntityType("pike", PikeEntity::new, 0.5f, 0.5f);
		RIBBON_EEL_ENTITY = registerEntityType("ribbon_eel", RibbonEelEntity::new, 0.4f, 0.4f);
		DEEP_SEA_ISOPOD_ENTITY = registerEntityType("deep_sea_isopod", DeepSeaIsopodEntity::new, 0.4f, 0.4f);
		YETI_CRAB_ENTITY = registerFireImmuneEntityType("yeti_crab", YetiCrabEntity::new, 0.5f, 0.5f);
		STONEFISH_ENTITY = registerEntityType("stonefish", StonefishEntity::new, 0.6f, 0.6f);
		VERMILLION_JELLY_ENTITY = registerFireImmuneEntityType("vermillion_jelly", VermillionJellyEntity::new, 0.5f, 0.5f);
		PHANTOM_JELLYFISH_ENTITY = registerFireImmuneEntityType("phantom_jellyfish", PhantomJellyfishEntity::new, 3, 3);

		// Projectiles
		AQUATIC_STAR_ENTITY = registerProjectileType("aquatic_star", AquaticStarEntity::new, 16, 10);
		NUMBING_AQUATIC_STAR_ENTITY = registerProjectileType("numbing_aquatic_star", NumbingAquaticStarEntity::new, 16, 10);
		LAND_DROWNING_AQUATIC_STAR_ENTITY = registerProjectileType("land_drowning_aquatic_star", LandDrowningAquaticStarEntity::new, 16, 10);
		SEA_BANE_AQUATIC_STAR_ENTITY = registerProjectileType("sea_bane_aquatic_star", SeaBaneAquaticStarEntity::new, 16, 10);
		FROSTED_SNOWBALL_ENTITY = registerProjectileType("frosted_snowball", FrostedSnowballEntity::new, 22, 20);
		AURORA_ENTITY = registerProjectileType("aurora", AuroraEntity::new, 22, 20);
		PLASMA_ENTITY = registerProjectileType("plasma", PlasmaEntity::new, 30, 20);
	}

	public static <T extends Entity> EntityType<T> registerEntityType(String path, EntityType.EntityFactory<T> factory, float hitboxWidth, float hitboxHeight) {
		return Registry.register(
			Registries.ENTITY_TYPE,
			new Identifier(AquaticPlus.MOD_ID, path),
			FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, factory)
				.dimensions(EntityDimensions.fixed(hitboxWidth, hitboxHeight))
				.build()
		);
	}

	public static <T extends Entity> EntityType<T> registerFireImmuneEntityType(String path, EntityType.EntityFactory<T> factory, float hitboxWidth, float hitboxHeight) {
		return Registry.register(
			Registries.ENTITY_TYPE,
			new Identifier(AquaticPlus.MOD_ID, path),
			FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, factory)
				.dimensions(EntityDimensions.fixed(hitboxWidth, hitboxHeight))
				.fireImmune()
				.build()
		);
	}

	public static <T extends Entity> EntityType<T> registerProjectileType(String path, EntityType.EntityFactory<T> factory, int rangeBlocks, int updateRate) {
		return Registry.register(
			Registries.ENTITY_TYPE,
			new Identifier(AquaticPlus.MOD_ID, path),
			FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, factory)
				.dimensions(EntityDimensions.fixed(0.25f, 0.25f))
				.trackRangeBlocks(rangeBlocks)
				.trackedUpdateRate(updateRate)
				.build()
		);
	}

	public static void registerAttributes() {
		FabricDefaultAttributeRegistry.register(JOHNSON_ENTITY, ShadowSardelEasterEggEntity.createEasterEggAttributes());
		FabricDefaultAttributeRegistry.register(MINDINATOR_ENTITY, ShadowSardelEasterEggEntity.createEasterEggAttributes());
		FabricDefaultAttributeRegistry.register(SPIRITED_FISH_ENTITY, SpiritedFishEntity.createSpiritedFishAttributes());
		FabricDefaultAttributeRegistry.register(MAXILLA_MORTIS_ENTITY, MaxillaMortisEntity.createMaxillaMortisAttributes());
		FabricDefaultAttributeRegistry.register(PARROTFISH_ENTITY, ParrotfishEntity.createParrotfishAttributes());
		FabricDefaultAttributeRegistry.register(KELP_EEL_ENTITY, KelpEelEntity.createKelpEelAttributes());
		FabricDefaultAttributeRegistry.register(SHADOW_SARDEL_ENTITY, ShadowSardelEntity.createShadowSardelAttributes());
		FabricDefaultAttributeRegistry.register(BONEFISH_ENTITY, BonefishEntity.createBonefishAttributes());
		FabricDefaultAttributeRegistry.register(LONG_BONEFISH_ENTITY, LongBonefishEntity.createLongBonefishAttributes());
		FabricDefaultAttributeRegistry.register(OCULI_MAGNI_ENTITY, OculiMagniEntity.createOculiMagniAttributes());
		FabricDefaultAttributeRegistry.register(VIPERFISH_ENTITY, ViperfishEntity.createViperfishAttributes());
		FabricDefaultAttributeRegistry.register(MANTA_RAY_ENTITY, MantaRayEntity.createMantaRayAttributes());
		FabricDefaultAttributeRegistry.register(DUMBO_BLOB_ENTITY, DumboBlobEntity.createDumboBlobAttributes());
		FabricDefaultAttributeRegistry.register(PINK_SUNFISH_ENTITY, PinkSunfishEntity.createPinkSunfishAttributes());
		FabricDefaultAttributeRegistry.register(LANTERNFISH_ENTITY, LanternfishEntity.createLanternfishAttributes());
		FabricDefaultAttributeRegistry.register(BLUEFIN_TUNA_ENTITY, BluefinTunaEntity.createBluefinTunaAttributes());
		FabricDefaultAttributeRegistry.register(GULPER_EEL_ENTITY, GulperEelEntity.createGulperEelEntity());
		FabricDefaultAttributeRegistry.register(HALIBUT_ENTITY, HalibutEntity.createHalibutAttributes());
		FabricDefaultAttributeRegistry.register(SARDINE_ENTITY, FishEntity.createFishAttributes());
		FabricDefaultAttributeRegistry.register(MINNOW_ENTITY, FishEntity.createFishAttributes());
		FabricDefaultAttributeRegistry.register(LIONFISH_ENTITY, LionfishEntity.createLionfishAttributes());
		FabricDefaultAttributeRegistry.register(FROSTED_SPLASHER_ENTITY, FrostedSplasherEntity.createFrostedSplasherAttributes());
		FabricDefaultAttributeRegistry.register(JELLYFISH_ENTITY, JellyfishEntity.createJellyfishAttributes());
		FabricDefaultAttributeRegistry.register(NARWHAL_ENTITY, NarwhalEntity.createNarwhalAttributes());
		FabricDefaultAttributeRegistry.register(NEON_CRAB_ENTITY, AbstractCrabEntity.createCrabAttributes());
		FabricDefaultAttributeRegistry.register(ALLIGATOR_GAR_ENTITY, AlligatorGarEntity.createAlligatorGarAttributes());
		FabricDefaultAttributeRegistry.register(SEA_PEN_ENTITY, SeaPenEntity.createSeaPenAttributes());
		FabricDefaultAttributeRegistry.register(VOLAN_AURORA_ENTITY, VolanAuroraEntity.createVolanAuroraAttributes());
		FabricDefaultAttributeRegistry.register(PIKE_ENTITY, PikeEntity.createPikeAttributes());
		FabricDefaultAttributeRegistry.register(RIBBON_EEL_ENTITY, RibbonEelEntity.createRibbonEelAttributes());
		FabricDefaultAttributeRegistry.register(DEEP_SEA_ISOPOD_ENTITY, DeepSeaIsopodEntity.createIsopodAttributes());
		FabricDefaultAttributeRegistry.register(YETI_CRAB_ENTITY, NeonCrabEntity.createCrabAttributes());
		FabricDefaultAttributeRegistry.register(STONEFISH_ENTITY, StonefishEntity.createStonefishAttributes());
		FabricDefaultAttributeRegistry.register(PHANTOM_JELLYFISH_ENTITY, PhantomJellyfishEntity.createPhantomJellyfishAttributes());
		FabricDefaultAttributeRegistry.register(VERMILLION_JELLY_ENTITY, VermillionJellyEntity.createVermillionJellyAttributes());
	}
}