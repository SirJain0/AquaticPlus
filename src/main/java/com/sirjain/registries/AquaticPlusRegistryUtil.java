package com.sirjain.registries;

import com.sirjain.items.AquaticPlusItemGroup;

public class AquaticPlusRegistryUtil {
        public static void initContent() {
                AquaticPlusEntities.registerAttributes();
                AquaticPlusEntities.registerEntityRender();
                AquaticPlusStatusEffects.registerModEffects();
                AquaticPlusItems.registerItems();
                AquaticPlusPotions.registerPotionRecipes();
                AquaticPlusBlocks.registerBlocks();
                AquaticPlusItems.registerBlockItems();
                AquaticPlusItemGroup.registerItemGroup();
        }
}