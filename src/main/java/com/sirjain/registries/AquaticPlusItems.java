package com.sirjain.registries;

import com.sirjain.AquaticPlus;
import com.sirjain.items.AquaticPlusFoodItems;
import com.sirjain.items.DeoxidizingMaterialItem;
import com.sirjain.items.DestonifierItem;
import com.sirjain.items.StonifierItem;
import com.sirjain.items.projectile.AquaticStarItem;
import com.sirjain.items.projectile.LandDrowningAquaticStarItem;
import com.sirjain.items.projectile.NumbingAquaticStarItem;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItem;
import net.minecraft.item.EntityBucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class AquaticPlusItems {
        public static Item
                STONIFIER,
                DESTONIFIER,
                AQUATIC_STAR,
                NUMBING_AQUATIC_STAR,
                LAND_DROWNING_AQUATIC_STAR,
                DEOXIDIZING_MATERIAL;

        public static Item
                JOHNSON_SPAWN_EGG,
                MINDINATOR_SPAWN_EGG,
                SPIRITED_FISH_SPAWN_EGG,
                FIBULA_SPAWN_EGG,
                SHADOW_SARDEL_SPAWN_EGG,
                KELP_EEL_SPAWN_EGG,
                PARROTFISH_SPAWN_EGG;

        public static Item
                SPIRITED_FISH_BUCKET,
                PARROTFISH_BUCKET,
                SHADOW_SARDEL_BUCKET;

        public static Item
                PARROTFISH,
                SHADOW_SARDEL;

        public static void registerItems() {
                registerSpawnEggs();
                registerBucketItems();
                registerFoodItems();

                STONIFIER = registerCustomItem("stonifier", new StonifierItem(new Item.Settings().maxCount(1).maxDamage(60)));
                DESTONIFIER = registerCustomItem("destonifier", new DestonifierItem(new Item.Settings().maxCount(1).maxDamage(60)));
                AQUATIC_STAR = registerCustomItem("aquatic_star", new AquaticStarItem(new Item.Settings().maxCount(1).maxCount(16)));
                NUMBING_AQUATIC_STAR = registerCustomItem("numbing_aquatic_star", new NumbingAquaticStarItem(new Item.Settings().maxCount(1).maxCount(16)));
                LAND_DROWNING_AQUATIC_STAR = registerCustomItem("land_drowning_aquatic_star", new LandDrowningAquaticStarItem(new Item.Settings().maxCount(1).maxCount(16)));
                DEOXIDIZING_MATERIAL = registerCustomItem("deoxidizing_material", new DeoxidizingMaterialItem(new Item.Settings()));

                AquaticPlusPotions.registerPotions();
        }

        public static void registerSpawnEggs() {
                JOHNSON_SPAWN_EGG = registerSpawnEggItem("johnson_spawn_egg", AquaticPlusEntities.JOHNSON_ENTITY, 0x564529, 0x2b2a28, new Item.Settings());
                MINDINATOR_SPAWN_EGG = registerSpawnEggItem("mindinator_spawn_egg", AquaticPlusEntities.MINDINATOR_ENTITY, 0x6b3469, 0x2b2a28, new Item.Settings());
                SPIRITED_FISH_SPAWN_EGG = registerSpawnEggItem("spirited_fish_spawn_egg", AquaticPlusEntities.SPIRITED_FISH_ENTITY, 0xc7cae0, 0xd2c3d3, new Item.Settings());
                FIBULA_SPAWN_EGG = registerSpawnEggItem("fibula_spawn_egg", AquaticPlusEntities.FIBULA_ENTITY, 0x323334, 0x31948e, new Item.Settings());
                PARROTFISH_SPAWN_EGG = registerSpawnEggItem("parrotfish_spawn_egg", AquaticPlusEntities.PARROTFISH_ENTITY, 0x55b3dd, 0x48ff8d, new Item.Settings());
                KELP_EEL_SPAWN_EGG = registerSpawnEggItem("kelp_eel_spawn_egg", AquaticPlusEntities.KELP_EEL_ENTITY, 0x4a6650, 0x973e36, new Item.Settings());
                SHADOW_SARDEL_SPAWN_EGG = registerSpawnEggItem("shadow_sardel_spawn_egg", AquaticPlusEntities.SHADOW_SARDEL_ENTITY, 0x34353b, 0x222124, new Item.Settings());
        }

        public static void registerBucketItems() {
                SPIRITED_FISH_BUCKET = registerBucketItem("spirited_fish_bucket", AquaticPlusEntities.SPIRITED_FISH_ENTITY, new Item.Settings());
                PARROTFISH_BUCKET = registerBucketItem("parrotfish_bucket", AquaticPlusEntities.PARROTFISH_ENTITY, new Item.Settings());
                SHADOW_SARDEL_BUCKET = registerBucketItem("shadow_sardel_bucket", AquaticPlusEntities.SHADOW_SARDEL_ENTITY, new Item.Settings());
        }

        public static void registerFoodItems() {
                PARROTFISH = registerBasicItem("parrotfish", new Item.Settings().food(AquaticPlusFoodItems.PARROTFISH));
                SHADOW_SARDEL = registerBasicItem("shadow_sardel", new Item.Settings().food(AquaticPlusFoodItems.SHADOW_SARDEL));
        }

        public static void registerBlockItems() {
                // Register block items here
        }

        // Helper registry methods
        public static Item registerBasicItem(String identifier, Item.Settings settings) {
                return Registry.register(
                        Registries.ITEM,
                        new Identifier(AquaticPlus.MOD_ID, identifier),
                        new Item(settings)
                );
        }

        public static Item registerCustomItem(String identifier, Item item) {
                return Registry.register(
                        Registries.ITEM,
                        new Identifier(AquaticPlus.MOD_ID, identifier),
                        item
                );
        }

        public static BlockItem registerBlockItem(String identifier, Item.Settings settings, Block block) {
                return Registry.register(
                        Registries.ITEM,
                        new Identifier(AquaticPlus.MOD_ID, identifier),
                        new BlockItem(block, settings)
                );
        }

        public static Item registerSpawnEggItem(String identifier, EntityType<? extends MobEntity> entityType, int primaryColor, int secondaryColor, Item.Settings settings) {
                return Registry.register(
                        Registries.ITEM,
                        new Identifier(AquaticPlus.MOD_ID, identifier),
                        new SpawnEggItem(entityType, primaryColor, secondaryColor, settings)
                );
        }

        public static Item registerBucketItem(String identifier, EntityType<? extends MobEntity> entityType, Item.Settings settings) {
                return Registry.register(
                        Registries.ITEM,
                        new Identifier(AquaticPlus.MOD_ID, identifier),
                        new EntityBucketItem(entityType, Fluids.WATER, SoundEvents.ITEM_BUCKET_EMPTY_FISH, settings)
                );
        }
}