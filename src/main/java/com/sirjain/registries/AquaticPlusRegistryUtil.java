package com.sirjain.registries;

import com.sirjain.entities.AquaticPlusEntitySpawns;
import com.sirjain.items.AquaticPlusFoodItems;
import com.sirjain.items.AquaticPlusItemGroup;

public class AquaticPlusRegistryUtil {
	public static void initContent() {
		AquaticPlusEntities.registerAttributes();
		AquaticPlusEntities.registerEntityRenderers();
		AquaticPlusStatusEffects.registerModEffects();
		AquaticPlusFoodItems.registerFoodComponents();
		AquaticPlusItems.registerItems();
		AquaticPlusPotions.registerPotionRecipes();
		AquaticPlusBlocks.registerBlocks();
		AquaticPlusItems.registerBlockItems();
		AquaticPlusItemGroup.registerItemGroup();
		AquaticPlusEntitySpawns.initEntitySpawns();
	}
}