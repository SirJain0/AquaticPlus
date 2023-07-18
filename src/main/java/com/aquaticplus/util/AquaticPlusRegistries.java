package com.aquaticplus.util;

import com.aquaticplus.AquaticPlus;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class AquaticPlusRegistries {
    public static void initContent() {
        registerItems();
        registerBlocks();
        registerBlockItems();
    }

    // Registeries for content of mod
    public static void registerItems() {
        // Register items here
    }

    public static void registerBlocks() {
        // Register blocks here
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

    public static Block registerBlock(String identifier, Block block) {
        return Registry.register(
            Registries.BLOCK,
            new Identifier(AquaticPlus.MOD_ID, identifier),
            block
        );
    }

    public static BlockItem registerBlockItem(String identifier, Item.Settings settings, Block block) {
        return Registry.register(
            Registries.ITEM,
            new Identifier(AquaticPlus.MOD_ID, identifier),
            new BlockItem(block, settings)
        );
    }
}
