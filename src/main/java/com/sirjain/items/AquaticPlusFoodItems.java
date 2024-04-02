package com.sirjain.items;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class AquaticPlusFoodItems {
	public static FoodComponent VIPERFISH;
	public static FoodComponent PARROTFISH;
	public static FoodComponent BLUEFIN_TUNA;
	public static FoodComponent SHADOW_SARDEL;
	public static FoodComponent HALIBUT;
	public static FoodComponent SARDINE;

	public static void registerFoodComponents() {
		VIPERFISH = registerBasicFoodComponent(3);
		PARROTFISH = registerBasicFoodComponent(2);
		BLUEFIN_TUNA = registerBasicFoodComponent(4);
		HALIBUT = registerBasicFoodComponent(4);
		SARDINE = registerBasicFoodComponent(3);

		SHADOW_SARDEL = new FoodComponent.Builder()
			.hunger(2)
			.statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20 * 5, 1), 1)
			.statusEffect(new StatusEffectInstance(StatusEffects.WITHER, 20 * 3, 0), 0.25f)
			.build();

	}

	public static FoodComponent registerBasicFoodComponent(int hunger) {
		return new FoodComponent.Builder()
			.hunger(hunger)
			.build();
	}
}