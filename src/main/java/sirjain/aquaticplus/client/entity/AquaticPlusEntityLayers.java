package sirjain.aquaticplus.client.entity;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import sirjain.aquaticplus.AquaticPlus;

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
	public static EntityModelLayer NEON_CRAB_LAYER;
	public static EntityModelLayer ALLIGATOR_GAR_LAYER;
	public static EntityModelLayer SEA_PEN_LAYER;
	public static EntityModelLayer VOLAN_AURORA_LAYER;
	public static EntityModelLayer PIKE_LAYER;
	public static EntityModelLayer RIBBON_EEL_LAYER;
	public static EntityModelLayer DEEP_SEA_ISOPOD_LAYER;
	public static EntityModelLayer YETI_CRAB_LAYER;
	public static EntityModelLayer STONEFISH_LAYER;
	public static EntityModelLayer VERMILLION_JELLY_LAYER;
	public static EntityModelLayer PHANTOM_JELLYFISH_LAYER;
	public static EntityModelLayer PLASMA_LAYER;

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
		NEON_CRAB_LAYER = registerEntityLayer("neon_crab");
		ALLIGATOR_GAR_LAYER = registerEntityLayer("alligator_gar");
		SEA_PEN_LAYER = registerEntityLayer("sea_pen");
		VOLAN_AURORA_LAYER = registerEntityLayer("volan_aurora");
		PIKE_LAYER = registerEntityLayer("pike");
		RIBBON_EEL_LAYER = registerEntityLayer("ribbon_eel");
		DEEP_SEA_ISOPOD_LAYER = registerEntityLayer("deep_sea_isopod");
		YETI_CRAB_LAYER = registerEntityLayer("yeti_crab");
		STONEFISH_LAYER = registerEntityLayer("stonefish");
		VERMILLION_JELLY_LAYER = registerEntityLayer("vermillion_jelly");
		PHANTOM_JELLYFISH_LAYER = registerEntityLayer("phantom_jellyfish");

		// Projectile
		PLASMA_LAYER = new EntityModelLayer(new Identifier(AquaticPlus.MOD_ID, "plasma"), "root");
	}

	public static EntityModelLayer registerEntityLayer(String name) {
		return new EntityModelLayer(new Identifier(AquaticPlus.MOD_ID, name), "root");
	}
}