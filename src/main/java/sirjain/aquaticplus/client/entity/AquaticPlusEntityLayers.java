package sirjain.aquaticplus.client.entity;

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.client.entity.models.*;
import sirjain.aquaticplus.client.entity.models.projectile.PlasmaModel;
import sirjain.aquaticplus.client.entity.models.projectile.SeaTridentModel;
import sirjain.aquaticplus.entity.entities.IvySeahorseEntity;
import sirjain.aquaticplus.entity.entities.MythicalSeahorseEntity;

public class AquaticPlusEntityLayers {
	public static EntityModelLayer JOHNSON_LAYER;
	public static EntityModelLayer MINDINATOR_LAYER;
	public static EntityModelLayer SPIRITED_FISH_LAYER;
	public static EntityModelLayer MAXILLA_MORTIS_LAYER;
	public static EntityModelLayer PARROTFISH_LAYER;
	public static EntityModelLayer KELP_EEL_LAYER;
	public static EntityModelLayer SHADOW_SARDEL_LAYER;
	public static EntityModelLayer BONEFISH_LAYER;
	public static EntityModelLayer LONG_BONEFISH_LAYER;
	public static EntityModelLayer OCULI_MAGNI_LAYER;
	public static EntityModelLayer VIPERFISH_LAYER;
	public static EntityModelLayer MANTA_RAY_LAYER;
	public static EntityModelLayer DUMBO_BLOB_LAYER;
	public static EntityModelLayer PINK_SUNFISH_LAYER;
	public static EntityModelLayer LANTERNFISH_LAYER;
	public static EntityModelLayer BLUEFIN_TUNA_LAYER;
	public static EntityModelLayer GULPER_EEL_LAYER;
	public static EntityModelLayer HALIBUT_LAYER;
	public static EntityModelLayer SARDINE_LAYER;
	public static EntityModelLayer MINNOW_LAYER;
	public static EntityModelLayer LIONFISH_LAYER;
	public static EntityModelLayer FROSTED_SPLASHER_LAYER;
	public static EntityModelLayer JELLYFISH_LAYER;
	public static EntityModelLayer NARWHAL_LAYER;
	public static EntityModelLayer SWORDFISH_LAYER;
	public static EntityModelLayer NEON_CRAB_LAYER;
	public static EntityModelLayer ALLIGATOR_GAR_LAYER;
	public static EntityModelLayer SEA_PEN_LAYER;
	public static EntityModelLayer VOLAN_AURORA_LAYER;
	public static EntityModelLayer PIKE_LAYER;
	public static EntityModelLayer RIBBON_EEL_LAYER;
	public static EntityModelLayer DEEP_SEA_ISOPOD_LAYER;
	public static EntityModelLayer YETI_CRAB_LAYER;
	public static EntityModelLayer STONEFISH_LAYER;
	public static EntityModelLayer SLIMY_SHRIMP_LAYER;
	public static EntityModelLayer IVY_SEAHORSE_LAYER;
	public static EntityModelLayer MYTHICAL_SEAHORSE_LAYER;
	public static EntityModelLayer VERMILLION_JELLY_LAYER;
	public static EntityModelLayer PHANTOM_JELLYFISH_LAYER;

	public static EntityModelLayer PLASMA_LAYER;
	public static EntityModelLayer SEA_TRIDENT_LAYER;

	public static void registerEntityLayers() {
		JOHNSON_LAYER = registerEntityLayer("johnson");
		MINDINATOR_LAYER = registerEntityLayer("mindinator");
		SPIRITED_FISH_LAYER = registerEntityLayer("spirited_fish");
		MAXILLA_MORTIS_LAYER = registerEntityLayer("maxilla_mortis");
		PARROTFISH_LAYER = registerEntityLayer("parrotfish");
		KELP_EEL_LAYER = registerEntityLayer("kelp_eel");
		SHADOW_SARDEL_LAYER = registerEntityLayer("shadow_sardel");
		BONEFISH_LAYER = registerEntityLayer("bonefish");
		LONG_BONEFISH_LAYER = registerEntityLayer("long_bonefish");
		OCULI_MAGNI_LAYER = registerEntityLayer("oculi_magni");
		VIPERFISH_LAYER = registerEntityLayer("viperfish");
		MANTA_RAY_LAYER = registerEntityLayer("manta_ray");
		DUMBO_BLOB_LAYER = registerEntityLayer("dumbo_blob");
		PINK_SUNFISH_LAYER = registerEntityLayer("pink_sunfish");
		LANTERNFISH_LAYER = registerEntityLayer("lanternfish");
		BLUEFIN_TUNA_LAYER = registerEntityLayer("bluefin_tuna");
		GULPER_EEL_LAYER = registerEntityLayer("gulper_eel");
		HALIBUT_LAYER = registerEntityLayer("halibut");
		SARDINE_LAYER = registerEntityLayer("sardine");
		MINNOW_LAYER = registerEntityLayer("minnow");
		LIONFISH_LAYER = registerEntityLayer("lionfish");
		FROSTED_SPLASHER_LAYER = registerEntityLayer("frosted_splasher");
		JELLYFISH_LAYER = registerEntityLayer("jellyfish");
		NARWHAL_LAYER = registerEntityLayer("narwhal");
		SWORDFISH_LAYER = registerEntityLayer("swordfish");
		NEON_CRAB_LAYER = registerEntityLayer("neon_crab");
		ALLIGATOR_GAR_LAYER = registerEntityLayer("alligator_gar");
		SEA_PEN_LAYER = registerEntityLayer("sea_pen");
		VOLAN_AURORA_LAYER = registerEntityLayer("volan_aurora");
		PIKE_LAYER = registerEntityLayer("pike");
		RIBBON_EEL_LAYER = registerEntityLayer("ribbon_eel");
		DEEP_SEA_ISOPOD_LAYER = registerEntityLayer("deep_sea_isopod");
		YETI_CRAB_LAYER = registerEntityLayer("yeti_crab");
		STONEFISH_LAYER = registerEntityLayer("stonefish");
		SLIMY_SHRIMP_LAYER = registerEntityLayer("slimy_shrimp");
		IVY_SEAHORSE_LAYER = registerEntityLayer("ivy_seahorse");
		MYTHICAL_SEAHORSE_LAYER = registerEntityLayer("mythical_seahorse");
		VERMILLION_JELLY_LAYER = registerEntityLayer("vermillion_jelly");
		PHANTOM_JELLYFISH_LAYER = registerEntityLayer("phantom_jellyfish");

		// Projectiles
		PLASMA_LAYER = new EntityModelLayer(new Identifier(AquaticPlus.MOD_ID, "plasma"), "root");
		SEA_TRIDENT_LAYER = new EntityModelLayer(new Identifier(AquaticPlus.MOD_ID, "sea_trident"), "root");
	}

	public static void registerEntityModels() {
		EntityModelLayerRegistry.registerModelLayer(JOHNSON_LAYER, JohnsonModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(MINDINATOR_LAYER, MindinatorModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(SPIRITED_FISH_LAYER, SpiritedFishModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(MAXILLA_MORTIS_LAYER, MaxillaMortisModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(PARROTFISH_LAYER, ParrotfishModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(KELP_EEL_LAYER, KelpEelModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(SHADOW_SARDEL_LAYER, ShadowSardelModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(BONEFISH_LAYER, BonefishModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(LONG_BONEFISH_LAYER, LongBonefishModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(OCULI_MAGNI_LAYER, OculiMagniModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(VIPERFISH_LAYER, ViperfishModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(MANTA_RAY_LAYER, MantaRayModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(DUMBO_BLOB_LAYER, DumboBlobModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(PINK_SUNFISH_LAYER, PinkSunfishModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(LANTERNFISH_LAYER, LanternfishModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(BLUEFIN_TUNA_LAYER, BluefinTunaModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(GULPER_EEL_LAYER, GulperEelModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(HALIBUT_LAYER, HalibutModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(SARDINE_LAYER, SardineModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(MINNOW_LAYER, MinnowModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(LIONFISH_LAYER, LionfishModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(FROSTED_SPLASHER_LAYER, FrostedSplasherModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(JELLYFISH_LAYER, JellyfishModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(NARWHAL_LAYER, NarwhalModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(SWORDFISH_LAYER, SwordfishModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(NEON_CRAB_LAYER, NeonCrabModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(ALLIGATOR_GAR_LAYER, AlligatorGarModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(SEA_PEN_LAYER, SeaPenModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(VOLAN_AURORA_LAYER, VolanAuroraModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(PIKE_LAYER, PikeModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(RIBBON_EEL_LAYER, RibbonEelModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(DEEP_SEA_ISOPOD_LAYER, DeepSeaIsopodModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(YETI_CRAB_LAYER, YetiCrabModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(STONEFISH_LAYER, StonefishModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(SLIMY_SHRIMP_LAYER, SlimyShrimpModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(IVY_SEAHORSE_LAYER, IvySeahorseModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(MYTHICAL_SEAHORSE_LAYER, MythicalSeahorseModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(PHANTOM_JELLYFISH_LAYER, PhantomJellyfishModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(VERMILLION_JELLY_LAYER, VermillionJellyModel::getTexturedModelData);

		// Projectiles
		EntityModelLayerRegistry.registerModelLayer(PLASMA_LAYER, PlasmaModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(SEA_TRIDENT_LAYER, SeaTridentModel::getTexturedModelData);
	}

	public static EntityModelLayer registerEntityLayer(String name) {
		return new EntityModelLayer(new Identifier(AquaticPlus.MOD_ID, name), "root");
	}
}