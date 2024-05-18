package com.aquaticplus.registries;

import com.aquaticplus.entities.AquaticPlusEntitySpawns;
import com.aquaticplus.items.AquaticPlusFoodItems;
import com.aquaticplus.items.AquaticPlusItemGroup;

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