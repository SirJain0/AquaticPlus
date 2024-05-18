package com.aquaticplus.items;

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
	public static FoodComponent MINNOW;
	public static FoodComponent MORTIS_FLESH;
	public static FoodComponent GAR_FLESH;
	public static FoodComponent BREAD_AND_JELLY;

	public static void registerFoodComponents() {
		VIPERFISH = registerBasicFoodComponent(3);
		PARROTFISH = registerBasicFoodComponent(2);
		BLUEFIN_TUNA = registerBasicFoodComponent(4);
		HALIBUT = registerBasicFoodComponent(4);
		SARDINE = registerBasicFoodComponent(3);
		MORTIS_FLESH = registerBasicFoodComponent(5);
		GAR_FLESH = registerBasicFoodComponent(4);
		BREAD_AND_JELLY = registerBasicFoodComponent(4);

		SHADOW_SARDEL = new FoodComponent.Builder()
			.hunger(2)
			.statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20 * 5, 1), 1)
			.statusEffect(new StatusEffectInstance(StatusEffects.WITHER, 20 * 3, 0), 0.25f)
			.build();

		MINNOW = new FoodComponent.Builder()
			.hunger(2)
			.statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20 * 4, 0), 0.5f)
			.build();
	}

	public static FoodComponent registerBasicFoodComponent(int hunger) {
		return new FoodComponent.Builder()
			.hunger(hunger)
			.build();
	}
}