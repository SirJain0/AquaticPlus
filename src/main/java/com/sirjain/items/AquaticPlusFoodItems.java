package com.sirjain.items;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class AquaticPlusFoodItems {
        public static FoodComponent PARROTFISH;
        public static FoodComponent SHADOW_SARDEL;

        public static void registerFoodComponents() {
                PARROTFISH = new FoodComponent.Builder()
                        .hunger(2)
                        .build();

                SHADOW_SARDEL = new FoodComponent.Builder()
                        .hunger(2)
                        .statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20*5, 1), 1)
                        .statusEffect(new StatusEffectInstance(StatusEffects.WITHER, 20*3, 0), 0.25f)
                        .build();
        }
}