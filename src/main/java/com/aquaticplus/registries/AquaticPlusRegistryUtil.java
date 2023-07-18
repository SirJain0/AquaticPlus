package com.aquaticplus.registries;

public class AquaticPlusRegistryUtil {
    public static void initContent() {
        AquaticPlusEntities.registerEntities();
        AquaticPlusItems.registerItems();
        AquaticPlusBlocks.registerBlocks();
        AquaticPlusItems.registerBlockItems();
    }
}