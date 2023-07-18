package com.aquaticplus.registries;

import com.aquaticplus.AquaticPlus;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class AquaticPlusItems {
    public static void registerItems() {
        // Register items here
        registerSpawnEggs();
    }

    public static void registerSpawnEggs() {
        // Register spawn eggs here
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
}