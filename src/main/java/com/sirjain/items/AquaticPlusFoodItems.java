package com.sirjain.items;

import net.minecraft.item.FoodComponent;

public class AquaticPlusFoodItems {
        public static FoodComponent PARROTFISH;

        public static void registerFoodComponents() {
                PARROTFISH = new FoodComponent.Builder()
                        .hunger(2)
                        .build();
        }
}