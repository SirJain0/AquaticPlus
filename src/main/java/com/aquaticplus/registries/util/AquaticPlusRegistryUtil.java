package com.aquaticplus.registries.util;

import com.aquaticplus.entities.AquaticPlusEntitySpawns;
import com.aquaticplus.items.AquaticPlusFoodItems;
import com.aquaticplus.items.AquaticPlusItemGroup;
import com.aquaticplus.particle.AquaticPlusParticles;
import com.aquaticplus.registries.*;

public class AquaticPlusRegistryUtil {
	public static void initContent() {
		AquaticPlusEntities.registerAttributes();
		AquaticPlusEntities.registerEntityRenderers();
		AquaticPlusStatusEffects.registerModEffects();
		AquaticPlusFoodItems.registerFoodComponents();
		AquaticPlusParticles.registerParticles();
		AquaticPlusItems.registerItems();
		AquaticPlusPotions.registerPotionRecipes();
		AquaticPlusBlocks.registerBlocks();
		AquaticPlusItems.registerBlockItems();
		AquaticPlusItemGroup.registerItemGroup();
		AquaticPlusEntitySpawns.initEntitySpawns();
	}
}