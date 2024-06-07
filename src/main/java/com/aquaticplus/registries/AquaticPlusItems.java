package com.aquaticplus.registries;

import com.aquaticplus.AquaticPlus;
import com.aquaticplus.entities.models.YetiCrabModel;
import com.aquaticplus.items.*;
import com.aquaticplus.items.combat.AuroraStaffItem;
import com.aquaticplus.items.combat.FrostingSpectreItem;
import com.aquaticplus.items.combat.VermillionGloomStaffItem;
import com.aquaticplus.items.projectile.*;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class AquaticPlusItems {
	public static Item STONIFIER;
	public static Item DESTONIFIER;
	public static Item AQUATIC_STAR;
	public static Item NUMBING_AQUATIC_STAR;
	public static Item LAND_DROWNING_AQUATIC_STAR;
	public static Item SEA_BANE_AQUATIC_STAR;
	public static Item DEOXIDIZING_MATERIAL;
	public static Item FROSTING_SPECTRE;
	public static Item AURORA_STAFF;
	public static Item VERMILLION_GLOOM_STAFF;
	public static Item MIDNIGHT_PIKE;
	public static Item CYAN_CRAB_CLAW;
	public static Item ORANGE_CRAB_CLAW;
	public static Item PINK_CRAB_CLAW;

	public static Item FROSTED_BALL;
	public static Item AURORA;
	public static Item FROST_SHARDS;
	public static Item STONE_ESSENCE;
	public static Item STONE_CORRODER;
	public static Item MORTIS_VENOM;
	public static Item MAXILLA_MORTIS_TOOTH;
	public static Item VIPER_TOOTH;
	public static Item SUNFISH_TAIL;
	public static Item LIONFISH_SPIKE;
	public static Item GHOSTLY_MEMBRANE;
	public static Item PINK_JELLY;
	public static Item YELLOW_JELLY;
	public static Item WHITE_JELLY;
	public static Item NEON_LEAF;
	public static Item ISOPOD_SHELL;
	public static Item YETI_CRAB_SHELL;

	public static Item VIPERFISH;
	public static Item PARROTFISH;
	public static Item BLUEFIN_TUNA;
	public static Item SHADOW_SARDEL;
	public static Item HALIBUT;
	public static Item SARDINE;
	public static Item MINNOW;
	public static Item MORTIS_FLESH;
	public static Item GAR_FLESH;
	public static Item PIKE_FLESH;
	public static Item BREAD_AND_JELLY;

	public static Item JOHNSON_SPAWN_EGG;
	public static Item MINDINATOR_SPAWN_EGG;
	public static Item SPIRITED_FISH_SPAWN_EGG;
	public static Item MAXILLA_MORTIS_SPAWN_EGG;
	public static Item PARROTFISH_SPAWN_EGG;
	public static Item KELP_EEL_SPAWN_EGG;
	public static Item SHADOW_SARDEL_SPAWN_EGG;
	public static Item BONEFISH_SPAWN_EGG;
	public static Item LONG_BONEFISH_SPAWN_EGG;
	public static Item OCULI_MAGNI_SPAWN_EGG;
	public static Item VIPERFISH_SPAWN_EGG;
	public static Item MANTA_RAY_SPAWN_EGG;
	public static Item DUMBO_BLOB_SPAWN_EGG;
	public static Item PINK_SUNFISH_SPAWN_EGG;
	public static Item LANTERNFISH_SPAWN_EGG;
	public static Item BLUEFIN_TUNA_SPAWN_EGG;
	public static Item GULPER_EEL_SPAWN_EGG;
	public static Item HALIBUT_SPAWN_EGG;
	public static Item SARDINE_SPAWN_EGG;
	public static Item MINNOW_SPAWN_EGG;
	public static Item LIONFISH_SPAWN_EGG;
	public static Item DEBUG_SWORD;
	public static Item FROSTED_SPLASHER_SPAWN_EGG;
	public static Item JELLYFISH_SPAWN_EGG;
	public static Item NARWHAL_SPAWN_EGG;
	public static Item NEON_CRAB_SPAWN_EGG;
	public static Item ALLIGATOR_GAR_SPAWN_EGG;
	public static Item SEA_PEN_SPAWN_EGG;
	public static Item VOLAN_AURORA_SPAWN_EGG;
	public static Item PIKE_SPAWN_EGG;
	public static Item RIBBON_EEL_SPAWN_EGG;
	public static Item DEEP_SEA_ISOPOD_SPAWN_EGG;
	public static Item YETI_CRAB_SPAWN_EGG;

	public static Item SPIRITED_FISH_BUCKET;
	public static Item PARROTFISH_BUCKET;
	public static Item SHADOW_SARDEL_BUCKET;
	public static Item DUMBO_BLOB_BUCKET;
	public static Item BLUEFIN_TUNA_BUCKET;
	public static Item HALIBUT_BUCKET;
	public static Item SARDINE_BUCKET;
	public static Item MINNOW_BUCKET;

	public static Item GHOSTLY_GEL_ITEM;

	public static void registerItems() {
		registerSpawnEggs();
		registerBucketItems();
		registerFoodItems();
		registerBasicItems();
		registerAdvancedItems();
		AquaticPlusPotions.registerPotions();
	}

	public static void registerBasicItems() {
		FROSTED_BALL = registerBasicItem("frosted_ball", new Item.Settings().maxCount(1).maxCount(16));
		AURORA = registerCustomItem("aurora", new AuroraItem(new Item.Settings().maxCount(1).maxCount(16)));
		FROST_SHARDS = registerBasicItem("frost_shards");
		STONE_ESSENCE = registerBasicItem("stone_essence");
		STONE_CORRODER = registerBasicItem("stone_corroder");
		MORTIS_VENOM = registerBasicItem("mortis_venom");
		MAXILLA_MORTIS_TOOTH = registerBasicItem("maxilla_mortis_tooth");
		VIPER_TOOTH = registerBasicItem("viper_tooth");
		SUNFISH_TAIL = registerBasicItem("sunfish_tail");
		GHOSTLY_MEMBRANE = registerBasicItem("ghostly_membrane");
		PINK_JELLY = registerBasicItem("pink_jelly");
		YELLOW_JELLY = registerBasicItem("yellow_jelly");
		WHITE_JELLY = registerBasicItem("white_jelly");
		NEON_LEAF = registerBasicItem("neon_leaf");
		ISOPOD_SHELL = registerBasicItem("isopod_shell");
		YETI_CRAB_SHELL = registerBasicItem("yeti_crab_shell");
	}

	public static void registerAdvancedItems() {
		STONIFIER = registerCustomItem("stonifier", new StonifierItem(new Item.Settings().maxCount(1).maxDamage(40)));
		DESTONIFIER = registerCustomItem("destonifier", new DestonifierItem(new Item.Settings().maxCount(1).maxDamage(40)));
		AQUATIC_STAR = registerCustomItem("aquatic_star", new AquaticStarItem());
		NUMBING_AQUATIC_STAR = registerCustomItem("numbing_aquatic_star", new NumbingAquaticStarItem());
		LAND_DROWNING_AQUATIC_STAR = registerCustomItem("land_drowning_aquatic_star", new LandDrowningAquaticStarItem());
		SEA_BANE_AQUATIC_STAR = registerCustomItem("sea_bane_aquatic_star", new SeaBaneAquaticStarItem());
		DEOXIDIZING_MATERIAL = registerCustomItem("deoxidizing_material", new DeoxidizingMaterialItem(new Item.Settings()));
		FROSTING_SPECTRE = registerCustomItem("frosting_spectre", new FrostingSpectreItem(new Item.Settings().maxDamage(70)));
		AURORA_STAFF = registerCustomItem("aurora_staff", new AuroraStaffItem());
		VERMILLION_GLOOM_STAFF = registerCustomItem("vermillion_gloom_staff", new VermillionGloomStaffItem());
		MIDNIGHT_PIKE = registerCustomItem("midnight_pike", new MidnightPikeItem());
		CYAN_CRAB_CLAW = registerCustomItem("cyan_crab_claw", new CrabClawItem());
		PINK_CRAB_CLAW = registerCustomItem("pink_crab_claw", new CrabClawItem());
		ORANGE_CRAB_CLAW = registerCustomItem("orange_crab_claw", new CrabClawItem());
		LIONFISH_SPIKE = registerCustomItem("lionfish_spike", new LionfishSpikeItem());
		DEBUG_SWORD = registerCustomItem("debug_sword", new SwordItem(ToolMaterials.DIAMOND, 10000, 1, new Item.Settings()));
	}

	public static void registerFoodItems() {
		VIPERFISH = registerFoodItem("viperfish", AquaticPlusFoodItems.VIPERFISH);
		PARROTFISH = registerFoodItem("parrotfish", AquaticPlusFoodItems.PARROTFISH);
		BLUEFIN_TUNA = registerFoodItem("bluefin_tuna", AquaticPlusFoodItems.BLUEFIN_TUNA);
		SHADOW_SARDEL = registerFoodItem("shadow_sardel", AquaticPlusFoodItems.SHADOW_SARDEL);
		HALIBUT = registerFoodItem("halibut", AquaticPlusFoodItems.HALIBUT);
		SARDINE = registerFoodItem("sardine", AquaticPlusFoodItems.SARDINE);
		MINNOW = registerFoodItem("minnow", AquaticPlusFoodItems.MINNOW);
		MORTIS_FLESH = registerFoodItem("mortis_flesh", AquaticPlusFoodItems.MORTIS_FLESH);
		GAR_FLESH = registerFoodItem("gar_flesh", AquaticPlusFoodItems.GAR_FLESH);
		PIKE_FLESH = registerFoodItem("pike_flesh", AquaticPlusFoodItems.PIKE_FLESH);
		BREAD_AND_JELLY = registerFoodItem("bread_and_jelly", AquaticPlusFoodItems.BREAD_AND_JELLY);
	}

	public static void registerSpawnEggs() {
		JOHNSON_SPAWN_EGG = registerSpawnEggItem("johnson_spawn_egg", AquaticPlusEntities.JOHNSON_ENTITY, 0x564529, 0x2b2a28);
		MINDINATOR_SPAWN_EGG = registerSpawnEggItem("mindinator_spawn_egg", AquaticPlusEntities.MINDINATOR_ENTITY, 0x6b3469, 0x2b2a28);
		SPIRITED_FISH_SPAWN_EGG = registerSpawnEggItem("spirited_fish_spawn_egg", AquaticPlusEntities.SPIRITED_FISH_ENTITY, 0xc7cae0, 0xd2c3d3);
		MAXILLA_MORTIS_SPAWN_EGG = registerSpawnEggItem("maxilla_mortis_spawn_egg", AquaticPlusEntities.MAXILLA_MORTIS_ENTITY, 0x323334, 0x31948e);
		PARROTFISH_SPAWN_EGG = registerSpawnEggItem("parrotfish_spawn_egg", AquaticPlusEntities.PARROTFISH_ENTITY, 0x55b3dd, 0x48ff8d);
		KELP_EEL_SPAWN_EGG = registerSpawnEggItem("kelp_eel_spawn_egg", AquaticPlusEntities.KELP_EEL_ENTITY, 0x4a6650, 0x973e36);
		SHADOW_SARDEL_SPAWN_EGG = registerSpawnEggItem("shadow_sardel_spawn_egg", AquaticPlusEntities.SHADOW_SARDEL_ENTITY, 0x34353b, 0x222124);
		BONEFISH_SPAWN_EGG = registerSpawnEggItem("bonefish_spawn_egg", AquaticPlusEntities.BONEFISH_ENTITY, 0xd3d3d3, 0x989898);
		LONG_BONEFISH_SPAWN_EGG = registerSpawnEggItem("long_bonefish_spawn_egg", AquaticPlusEntities.LONG_BONEFISH_ENTITY, 0xd3d3d3, 0x989898);
		OCULI_MAGNI_SPAWN_EGG = registerSpawnEggItem("oculi_magni_spawn_egg", AquaticPlusEntities.OCULI_MAGNI_ENTITY, 0x2f2f2f, 0x3d5456);
		VIPERFISH_SPAWN_EGG = registerSpawnEggItem("viperfish_spawn_egg", AquaticPlusEntities.VIPERFISH_ENTITY, 0x263641, 0xdfe18e);
		MANTA_RAY_SPAWN_EGG = registerSpawnEggItem("manta_ray_spawn_egg", AquaticPlusEntities.MANTA_RAY_ENTITY, 0x282a34, 0x999daa);
		DUMBO_BLOB_SPAWN_EGG = registerSpawnEggItem("dumbo_blob_spawn_egg", AquaticPlusEntities.DUMBO_BLOB_ENTITY, 0x3981d2, 0xc36afa);
		PINK_SUNFISH_SPAWN_EGG = registerSpawnEggItem("pink_sunfish_spawn_egg", AquaticPlusEntities.PINK_SUNFISH_ENTITY, 0xcb8fbc, 0x68759d);
		LANTERNFISH_SPAWN_EGG = registerSpawnEggItem("lanternfish_spawn_egg", AquaticPlusEntities.LANTERNFISH_ENTITY, 0x33333b, 0x34d7e8);
		BLUEFIN_TUNA_SPAWN_EGG = registerSpawnEggItem("bluefin_tuna_spawn_egg", AquaticPlusEntities.BLUEFIN_TUNA_ENTITY, 0xd2d3d9, 0x313575);
		GULPER_EEL_SPAWN_EGG = registerSpawnEggItem("gulper_eel_spawn_egg", AquaticPlusEntities.GULPER_EEL_ENTITY, 0x413b4a, 0x422e4d);
		HALIBUT_SPAWN_EGG = registerSpawnEggItem("halibut_spawn_egg", AquaticPlusEntities.HALIBUT_ENTITY, 0x432d24, 0x644832);
		SARDINE_SPAWN_EGG = registerSpawnEggItem("sardine_spawn_egg", AquaticPlusEntities.SARDINE_ENTITY, 0xbdbdbe, 0xb8ad9e);
		MINNOW_SPAWN_EGG = registerSpawnEggItem("minnow_spawn_egg", AquaticPlusEntities.MINNOW_ENTITY, 0x50602d, 0xcfbd82);
		LIONFISH_SPAWN_EGG = registerSpawnEggItem("lionfish_spawn_egg", AquaticPlusEntities.LIONFISH_ENTITY, 0xa46e3f, 0xd1c8bb);
		FROSTED_SPLASHER_SPAWN_EGG = registerSpawnEggItem("frosted_splasher_spawn_egg", AquaticPlusEntities.FROSTED_SPLASHER_ENTITY, 0xe2d6af, 0x8bcee6);
		JELLYFISH_SPAWN_EGG = registerSpawnEggItem("jellyfish_spawn_egg", AquaticPlusEntities.JELLYFISH_ENTITY, 0x956ebd, 0xff9fec);
		NARWHAL_SPAWN_EGG = registerSpawnEggItem("narwhal_spawn_egg", AquaticPlusEntities.NARWHAL_ENTITY, 0xbcbac5, 0xe6e2db);
		NEON_CRAB_SPAWN_EGG = registerSpawnEggItem("neon_crab_spawn_egg", AquaticPlusEntities.NEON_CRAB_ENTITY, 0x4bb7b0, 0x5bc33b);
		ALLIGATOR_GAR_SPAWN_EGG = registerSpawnEggItem("alligator_gar_spawn_egg", AquaticPlusEntities.ALLIGATOR_GAR_ENTITY, 0xbba461, 0x51566d);
		SEA_PEN_SPAWN_EGG = registerSpawnEggItem("sea_pen_spawn_egg", AquaticPlusEntities.SEA_PEN_ENTITY, 0xd2a746, 0x9a5f32);
		VOLAN_AURORA_SPAWN_EGG = registerSpawnEggItem("volan_aurora_spawn_egg", AquaticPlusEntities.VOLAN_AURORA_ENTITY, 0x4d9fd8, 0xb3a6e8); // TODO: Make this have a custom texture to incorporate purple
		PIKE_SPAWN_EGG = registerSpawnEggItem("pike_spawn_egg", AquaticPlusEntities.PIKE_ENTITY, 0x544631, 0x7c7051);
		RIBBON_EEL_SPAWN_EGG = registerSpawnEggItem("ribbon_eel_spawn_egg", AquaticPlusEntities.RIBBON_EEL_ENTITY, 0x50acf2, 0xffd444);
		DEEP_SEA_ISOPOD_SPAWN_EGG = registerSpawnEggItem("deep_sea_isopod_spawn_egg", AquaticPlusEntities.DEEP_SEA_ISOPOD_ENTITY, 0xd6ccab, 0x917f6d);
		YETI_CRAB_SPAWN_EGG = registerSpawnEggItem("yeti_crab_spawn_egg", AquaticPlusEntities.YETI_CRAB_ENTITY, 0xc1a489, 0xd7c098);
	}

	public static void registerBucketItems() {
		SPIRITED_FISH_BUCKET = registerBucketItem("spirited_fish_bucket", AquaticPlusEntities.SPIRITED_FISH_ENTITY);
		PARROTFISH_BUCKET = registerBucketItem("parrotfish_bucket", AquaticPlusEntities.PARROTFISH_ENTITY);
		SHADOW_SARDEL_BUCKET = registerBucketItem("shadow_sardel_bucket", AquaticPlusEntities.SHADOW_SARDEL_ENTITY);
		DUMBO_BLOB_BUCKET = registerBucketItem("dumbo_blob_bucket", AquaticPlusEntities.DUMBO_BLOB_ENTITY);
		BLUEFIN_TUNA_BUCKET = registerBucketItem("bluefin_tuna_bucket", AquaticPlusEntities.BLUEFIN_TUNA_ENTITY);
		HALIBUT_BUCKET = registerBucketItem("halibut_bucket", AquaticPlusEntities.HALIBUT_ENTITY);
		SARDINE_BUCKET = registerBucketItem("sardine_bucket", AquaticPlusEntities.SARDINE_ENTITY);
		MINNOW_BUCKET = registerBucketItem("minnow_bucket", AquaticPlusEntities.MINNOW_ENTITY);
	}

	public static void registerBlockItems() {
		GHOSTLY_GEL_ITEM = registerBlockItem("ghostly_gel", AquaticPlusBlocks.GHOSTLY_GEL_BLOCK);
	}

	// Helper registry methods
	public static Item registerBasicItem(String identifier, Item.Settings settings) {
		return Registry.register(
			Registries.ITEM,
			new Identifier(AquaticPlus.MOD_ID, identifier),
			new Item(settings)
		);
	}

	public static Item registerBasicItem(String identifier) {
		return registerBasicItem(identifier, new Item.Settings());
	}

	public static Item registerFoodItem(String identifier, FoodComponent food) {
		return registerBasicItem(identifier, new Item.Settings().food(food));
	}

	public static Item registerCustomItem(String identifier, Item item) {
		return Registry.register(
			Registries.ITEM,
			new Identifier(AquaticPlus.MOD_ID, identifier),
			item
		);
	}

	public static BlockItem registerBlockItem(String identifier, Block block) {
		return Registry.register(
			Registries.ITEM,
			new Identifier(AquaticPlus.MOD_ID, identifier),
			new BlockItem(block, new Item.Settings())
		);
	}

	public static Item registerSpawnEggItem(String identifier, EntityType<? extends MobEntity> entityType, int primaryColor, int secondaryColor) {
		return Registry.register(
			Registries.ITEM,
			new Identifier(AquaticPlus.MOD_ID, identifier),
			new SpawnEggItem(entityType, primaryColor, secondaryColor, new Item.Settings())
		);
	}

	public static Item registerBucketItem(String identifier, EntityType<? extends MobEntity> entityType) {
		return Registry.register(
			Registries.ITEM,
			new Identifier(AquaticPlus.MOD_ID, identifier),
			new EntityBucketItem(entityType, Fluids.WATER, SoundEvents.ITEM_BUCKET_EMPTY_FISH, new Item.Settings())
		);
	}
}