package sirjain.aquaticplus.item;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.blocks.AquaticPlusBlocks;
import sirjain.aquaticplus.entity.AquaticPlusEntities;
import sirjain.aquaticplus.item.combat.*;
import sirjain.aquaticplus.item.projectile.*;
import sirjain.aquaticplus.status_effect.AquaticPlusStatusEffects;
import sirjain.aquaticplus.status_effect.potion.AquaticPlusPotions;

public class AquaticPlusItems {
	public static Item STONIFIER;
	public static Item DESTONIFIER;
	public static Item AQUATIC_STAR;
	public static Item NUMBING_AQUATIC_STAR;
	public static Item LAND_DROWNING_AQUATIC_STAR;
	public static Item SEA_BANE_AQUATIC_STAR;
	public static Item LAND_DROWNING_ANTIDOTE;
	public static Item NUMBING_ANTIDOTE;
	public static Item SEA_BANE_ANTIDOTE;
	public static Item DEOXIDIZING_MATERIAL;
	public static Item FROSTING_SPECTRE;
	public static Item AURORA_STAFF;
	public static Item VERMILLION_GLOOM_STAFF;
	public static Item MIDNIGHT_PIKE;
	public static Item GULPER_DAGGER;
	public static Item CRIMSON_SEA_SWORD;
	public static Item AQUA_SEA_SWORD;
	public static Item CRIMSON_SEA_TRIDENT;
	public static Item AQUA_SEA_TRIDENT;
	public static Item CYAN_CRAB_CLAW;
	public static Item ORANGE_CRAB_CLAW;
	public static Item PINK_CRAB_CLAW;

	public static Item FROSTED_BALL;
	public static Item AURORA;
	public static Item FROST_SHARDS;
	public static Item STONE_ESSENCE;
	public static Item STONE_CORRODER;
	public static Item ANTIDOTE_ESSENCE;
	public static Item MORTIS_VENOM;
	public static Item STONEFISH_VENOM;
	public static Item MAXILLA_MORTIS_TOOTH;
	public static Item VIPER_TOOTH;
	public static Item GULPER_TOOTH;
	public static Item SUNFISH_TAIL;
	public static Item LIONFISH_SPIKE;
	public static Item GHOSTLY_MEMBRANE;
	public static Item PINK_JELLY;
	public static Item YELLOW_JELLY;
	public static Item WHITE_JELLY;
	public static Item NEON_LEAF;
	public static Item ISOPOD_SHELL;
	public static Item YETI_CRAB_SHELL;
	public static Item CRIMSON_SEAHORSE_SPIKE;
	public static Item AQUA_SEAHORSE_SPIKE;

	public static Item VIPERFISH;
	public static Item PARROTFISH;
	public static Item BLUEFIN_TUNA;
	public static Item SHADOW_SARDEL;
	public static Item HALIBUT;
	public static Item SARDINE;
	public static Item MINNOW;
	public static Item MORTIS_FLESH;
	public static Item SHRIMP;
	public static Item GAR_FLESH;
	public static Item PIKE_FLESH;
	public static Item BREAD_AND_JELLY;
	public static Item IVY_BERRIES;

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
	public static Item SWORDFISH_SPAWN_EGG;
	public static Item NEON_CRAB_SPAWN_EGG;
	public static Item ALLIGATOR_GAR_SPAWN_EGG;
	public static Item SEA_PEN_SPAWN_EGG;
	public static Item VOLAN_AURORA_SPAWN_EGG;
	public static Item PIKE_SPAWN_EGG;
	public static Item RIBBON_EEL_SPAWN_EGG;
	public static Item DEEP_SEA_ISOPOD_SPAWN_EGG;
	public static Item YETI_CRAB_SPAWN_EGG;
	public static Item STONEFISH_SPAWN_EGG;
	public static Item SLIMY_SHRIMP_SPAWN_EGG;
	public static Item IVY_SEAHORSE_SPAWN_EGG;
	public static Item MYTHICAL_SEAHORSE_SPAWN_EGG;
	public static Item VERMILLION_JELLY_SPAWN_EGG;
	public static Item PHANTOM_JELLYFISH_SUMMONER;

	public static Item SPIRITED_FISH_BUCKET;
	public static Item PARROTFISH_BUCKET;
	public static Item SHADOW_SARDEL_BUCKET;
	public static Item DUMBO_BLOB_BUCKET;
	public static Item BLUEFIN_TUNA_BUCKET;
	public static Item HALIBUT_BUCKET;
	public static Item SARDINE_BUCKET;
	public static Item MINNOW_BUCKET;
	public static Item SHRIMP_BUCKET;

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
		FROST_SHARDS = registerBasicItem("frost_shards");
		STONE_ESSENCE = registerBasicItem("stone_essence");
		STONE_CORRODER = registerBasicItem("stone_corroder");
		ANTIDOTE_ESSENCE = registerBasicItem("antidote_essence");
		MORTIS_VENOM = registerBasicItem("mortis_venom");
		STONEFISH_VENOM = registerBasicItem("stonefish_venom");
		MAXILLA_MORTIS_TOOTH = registerBasicItem("maxilla_mortis_tooth");
		VIPER_TOOTH = registerBasicItem("viper_tooth");
		GULPER_TOOTH = registerBasicItem("gulper_tooth");
		SUNFISH_TAIL = registerBasicItem("sunfish_tail");
		GHOSTLY_MEMBRANE = registerBasicItem("ghostly_membrane");
		PINK_JELLY = registerBasicItem("pink_jelly");
		YELLOW_JELLY = registerBasicItem("yellow_jelly");
		WHITE_JELLY = registerBasicItem("white_jelly");
		NEON_LEAF = registerBasicItem("neon_leaf");
		ISOPOD_SHELL = registerBasicItem("isopod_shell");
		YETI_CRAB_SHELL = registerBasicItem("yeti_crab_shell");
		CRIMSON_SEAHORSE_SPIKE = registerBasicItem("crimson_seahorse_spike");
		AQUA_SEAHORSE_SPIKE = registerBasicItem("aqua_seahorse_spike");
	}

	public static void registerAdvancedItems() {
		STONIFIER = registerCustomItem("stonifier", new StonifierItem(new Item.Settings().maxCount(1).maxDamage(40)));
		DESTONIFIER = registerCustomItem("destonifier", new DestonifierItem(new Item.Settings().maxCount(1).maxDamage(40)));
		AQUATIC_STAR = registerCustomItem("aquatic_star", new AquaticStarItem());
		NUMBING_AQUATIC_STAR = registerCustomItem("numbing_aquatic_star", new NumbingAquaticStarItem());
		LAND_DROWNING_AQUATIC_STAR = registerCustomItem("land_drowning_aquatic_star", new LandDrowningAquaticStarItem());
		SEA_BANE_AQUATIC_STAR = registerCustomItem("sea_bane_aquatic_star", new SeaBaneAquaticStarItem());
		LAND_DROWNING_ANTIDOTE = registerCustomItem("land_drowning_antidote", new AntidoteItem(AquaticPlusStatusEffects.LAND_DROWNING));
		NUMBING_ANTIDOTE = registerCustomItem("numbing_antidote", new AntidoteItem(AquaticPlusStatusEffects.NUMBING));
		SEA_BANE_ANTIDOTE = registerCustomItem("sea_bane_antidote", new AntidoteItem(AquaticPlusStatusEffects.SEA_BANE));
		DEOXIDIZING_MATERIAL = registerCustomItem("deoxidizing_material", new DeoxidizingMaterialItem(new Item.Settings()));
		FROSTING_SPECTRE = registerCustomItem("frosting_spectre", new FrostingSpectreItem(new Item.Settings().maxDamage(200)));
		AURORA = registerCustomItem("aurora", new AuroraItem(new Item.Settings().maxCount(1).maxCount(16)));
		AURORA_STAFF = registerCustomItem("aurora_staff", new AuroraStaffItem());
		VERMILLION_GLOOM_STAFF = registerCustomItem("vermillion_gloom_staff", new VermillionGloomStaffItem());
		MIDNIGHT_PIKE = registerCustomItem("midnight_pike", new MidnightPikeItem());
		GULPER_DAGGER = registerCustomItem("gulper_dagger", new GulperDaggerItem());
		CRIMSON_SEA_SWORD = registerCustomItem("crimson_sea_sword", new CrimsonSeaSwordItem());
		AQUA_SEA_SWORD = registerCustomItem("aqua_sea_sword", new AquaSeaSwordItem());
		CRIMSON_SEA_TRIDENT = registerCustomItem("crimson_sea_trident", new CrimsonSeaTridentItem());
		AQUA_SEA_TRIDENT = registerCustomItem("aqua_sea_trident", new AquaSeaTridentItem());
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
		SHRIMP = registerFoodItem("shrimp", AquaticPlusFoodItems.SHRIMP);
		GAR_FLESH = registerFoodItem("gar_flesh", AquaticPlusFoodItems.GAR_FLESH);
		PIKE_FLESH = registerFoodItem("pike_flesh", AquaticPlusFoodItems.PIKE_FLESH);
		BREAD_AND_JELLY = registerFoodItem("bread_and_jelly", AquaticPlusFoodItems.BREAD_AND_JELLY);
		IVY_BERRIES = registerCustomItem("ivy_berries", new IvyBerriesItem(new Item.Settings().food(AquaticPlusFoodItems.IVY_BERRIES)));
	}

	public static void registerSpawnEggs() {
		JOHNSON_SPAWN_EGG = registerSpawnEggItem("johnson", AquaticPlusEntities.JOHNSON_ENTITY, 0x564529, 0x2b2a28);
		MINDINATOR_SPAWN_EGG = registerSpawnEggItem("mindinator", AquaticPlusEntities.MINDINATOR_ENTITY, 0Xcdbddc, 0Xbcd4eb);
		SPIRITED_FISH_SPAWN_EGG = registerSpawnEggItem("spirited_fish", AquaticPlusEntities.SPIRITED_FISH_ENTITY, 0xc7cae0, 0xd2c3d3);
		MAXILLA_MORTIS_SPAWN_EGG = registerSpawnEggItem("maxilla_mortis", AquaticPlusEntities.MAXILLA_MORTIS_ENTITY, 0x323334, 0x31948e);
		PARROTFISH_SPAWN_EGG = registerSpawnEggItem("parrotfish", AquaticPlusEntities.PARROTFISH_ENTITY, 0x55b3dd, 0x48ff8d);
		KELP_EEL_SPAWN_EGG = registerSpawnEggItem("kelp_eel", AquaticPlusEntities.KELP_EEL_ENTITY, 0x4a6650, 0x973e36);
		SHADOW_SARDEL_SPAWN_EGG = registerSpawnEggItem("shadow_sardel", AquaticPlusEntities.SHADOW_SARDEL_ENTITY, 0x34353b, 0x222124);
		BONEFISH_SPAWN_EGG = registerSpawnEggItem("bonefish", AquaticPlusEntities.BONEFISH_ENTITY, 0xd3d3d3, 0x989898);
		LONG_BONEFISH_SPAWN_EGG = registerSpawnEggItem("long_bonefish", AquaticPlusEntities.LONG_BONEFISH_ENTITY, 0xd3d3d3, 0x989898);
		OCULI_MAGNI_SPAWN_EGG = registerSpawnEggItem("oculi_magni", AquaticPlusEntities.OCULI_MAGNI_ENTITY, 0x343537, 0Xb36cb4);
		VIPERFISH_SPAWN_EGG = registerSpawnEggItem("viperfish", AquaticPlusEntities.VIPERFISH_ENTITY, 0x263641, 0xdfe18e);
		MANTA_RAY_SPAWN_EGG = registerSpawnEggItem("manta_ray", AquaticPlusEntities.MANTA_RAY_ENTITY, 0x282a34, 0x999daa);
		DUMBO_BLOB_SPAWN_EGG = registerSpawnEggItem("dumbo_blob", AquaticPlusEntities.DUMBO_BLOB_ENTITY, 0x3981d2, 0xc36afa);
		PINK_SUNFISH_SPAWN_EGG = registerSpawnEggItem("pink_sunfish", AquaticPlusEntities.PINK_SUNFISH_ENTITY, 0xcb8fbc, 0x68759d);
		LANTERNFISH_SPAWN_EGG = registerSpawnEggItem("lanternfish", AquaticPlusEntities.LANTERNFISH_ENTITY, 0x33333b, 0x34d7e8);
		BLUEFIN_TUNA_SPAWN_EGG = registerSpawnEggItem("bluefin_tuna", AquaticPlusEntities.BLUEFIN_TUNA_ENTITY, 0xd2d3d9, 0x313575);
		GULPER_EEL_SPAWN_EGG = registerSpawnEggItem("gulper_eel", AquaticPlusEntities.GULPER_EEL_ENTITY, 0x413b4a, 0x422e4d);
		HALIBUT_SPAWN_EGG = registerSpawnEggItem("halibut", AquaticPlusEntities.HALIBUT_ENTITY, 0x432d24, 0x644832);
		SARDINE_SPAWN_EGG = registerSpawnEggItem("sardine", AquaticPlusEntities.SARDINE_ENTITY, 0xbdbdbe, 0xb8ad9e);
		MINNOW_SPAWN_EGG = registerSpawnEggItem("minnow", AquaticPlusEntities.MINNOW_ENTITY, 0x50602d, 0xcfbd82);
		LIONFISH_SPAWN_EGG = registerSpawnEggItem("lionfish", AquaticPlusEntities.LIONFISH_ENTITY, 0xa46e3f, 0xd1c8bb);
		FROSTED_SPLASHER_SPAWN_EGG = registerSpawnEggItem("frosted_splasher", AquaticPlusEntities.FROSTED_SPLASHER_ENTITY, 0xe2d6af, 0x8bcee6);
		JELLYFISH_SPAWN_EGG = registerSpawnEggItem("jellyfish", AquaticPlusEntities.JELLYFISH_ENTITY, 0x956ebd, 0xff9fec);
		NARWHAL_SPAWN_EGG = registerSpawnEggItem("narwhal", AquaticPlusEntities.NARWHAL_ENTITY, 0xbcbac5, 0xe6e2db);
		SWORDFISH_SPAWN_EGG = registerSpawnEggItem("swordfish", AquaticPlusEntities.SWORDFISH_ENTITY, 0x33586b, 0xa3bdc1);
		NEON_CRAB_SPAWN_EGG = registerSpawnEggItem("neon_crab", AquaticPlusEntities.NEON_CRAB_ENTITY, 0x4bb7b0, 0x5bc33b);
		ALLIGATOR_GAR_SPAWN_EGG = registerSpawnEggItem("alligator_gar", AquaticPlusEntities.ALLIGATOR_GAR_ENTITY, 0xbba461, 0x51566d);
		SEA_PEN_SPAWN_EGG = registerSpawnEggItem("sea_pen", AquaticPlusEntities.SEA_PEN_ENTITY, 0xd2a746, 0x9a5f32);
		VOLAN_AURORA_SPAWN_EGG = registerSpawnEggItem("volan_aurora", AquaticPlusEntities.VOLAN_AURORA_ENTITY, -1, -1);
		PIKE_SPAWN_EGG = registerSpawnEggItem("pike", AquaticPlusEntities.PIKE_ENTITY, 0x544631, 0x7c7051);
		RIBBON_EEL_SPAWN_EGG = registerSpawnEggItem("ribbon_eel", AquaticPlusEntities.RIBBON_EEL_ENTITY, 0x50acf2, 0xffd444);
		DEEP_SEA_ISOPOD_SPAWN_EGG = registerSpawnEggItem("deep_sea_isopod", AquaticPlusEntities.DEEP_SEA_ISOPOD_ENTITY, 0xd6ccab, 0x917f6d);
		YETI_CRAB_SPAWN_EGG = registerSpawnEggItem("yeti_crab", AquaticPlusEntities.YETI_CRAB_ENTITY, 0xc1a489, 0xd7c098);
		STONEFISH_SPAWN_EGG = registerSpawnEggItem("stonefish", AquaticPlusEntities.STONEFISH_ENTITY, 0x575959, 0x555151);
		SLIMY_SHRIMP_SPAWN_EGG = registerSpawnEggItem("slimy_shrimp", AquaticPlusEntities.SLIMY_SHRIMP_ENTITY, 0xbabfcb, 0xdb8d68);
		IVY_SEAHORSE_SPAWN_EGG = registerSpawnEggItem("ivy_seahorse", AquaticPlusEntities.IVY_SEAHORSE_ENTITY, 0x674f32, 0x459b4f);
		MYTHICAL_SEAHORSE_SPAWN_EGG = registerSpawnEggItem("mythical_seahorse", AquaticPlusEntities.MYTHICAL_SEAHORSE_ENTITY, 0xcd5858, 0xe3965b);
		VERMILLION_JELLY_SPAWN_EGG = registerSpawnEggItem("vermillion_jelly", AquaticPlusEntities.VERMILLION_JELLY_ENTITY, 0x83546c, 0x454245);
		PHANTOM_JELLYFISH_SUMMONER = registerCustomItem("phantom_jellyfish_summoner", new PhantomJellyfishSummonerItem());
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
		SHRIMP_BUCKET = registerBucketItem("shrimp_bucket", AquaticPlusEntities.SLIMY_SHRIMP_ENTITY);
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
			new Identifier(AquaticPlus.MOD_ID, identifier + "_spawn_egg"),
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