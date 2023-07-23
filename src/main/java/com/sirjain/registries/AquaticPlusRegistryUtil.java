package com.sirjain.registries;

import com.sirjain.items.AquaticPlusItemGroup;

public class AquaticPlusRegistryUtil {
    public static void initContent() {
        AquaticPlusEntities.registerAttributes();
        AquaticPlusEntities.registerEntityRender();
        AquaticPlusItems.registerItems();
        AquaticPlusBlocks.registerBlocks();
        AquaticPlusItems.registerBlockItems();
        AquaticPlusItemGroup.registerItemGroup();
        AquaticPlusStatusEffects.registerModEffects();
    }
}