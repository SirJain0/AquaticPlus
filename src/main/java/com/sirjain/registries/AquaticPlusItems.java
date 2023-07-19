package com.sirjain.registries;

import com.sirjain.AquaticPlus;
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
    public static Item JOHNSON_SPAWN_EGG;
    public static Item SPIRITED_FISH_SPAWN_EGG;
    public static Item SPIRITED_FISH_BUCKET;

    public static void registerItems() {
        registerSpawnEggs();
        registerBucketItems();
    }

    public static void registerSpawnEggs() {
        JOHNSON_SPAWN_EGG = registerSpawnEggItem("johnson_spawn_egg", AquaticPlusEntities.JOHNSON_ENTITY, 0x564529, 0x2b2a28, new Item.Settings());
        SPIRITED_FISH_SPAWN_EGG = registerSpawnEggItem("spirited_fish_spawn_egg", AquaticPlusEntities.SPIRITED_FISH_ENTITY, 0xc7cae0, 0xd2c3d3, new Item.Settings());
    }

    public static void registerBucketItems() {
        SPIRITED_FISH_BUCKET = registerBucketItem("spirited_fish_bucket", AquaticPlusEntities.SPIRITED_FISH_ENTITY, new Item.Settings()); // TODO: Add texture
    }

    public static void registerBlockItems() {
        // Register block items here
    }

    // Helper registry methods
    public static Item registerItem(String identifier, Item.Settings settings) {
        return Registry.register(
                Registries.ITEM,
                new Identifier(AquaticPlus.MOD_ID, identifier),
                new Item(settings)
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