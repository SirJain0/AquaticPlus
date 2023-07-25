package com.sirjain.registries;

import com.sirjain.AquaticPlus;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class AquaticPlusPotions {
    public static Potion NUMBING_POTION;

    public static void registerPotions() {
        // TODO: Add these potions to custom item group, not default group
        NUMBING_POTION = registerPotion("numbing_potion", new Potion(new StatusEffectInstance(AquaticPlusStatusEffects.NUMBING, 20*10, 0)));
    }

    private static Potion registerPotion(String name, Potion potion) {
        return Registry.register(
                Registries.POTION,
                new Identifier(AquaticPlus.MOD_ID, name),
                potion
        );
    }

    public static void registerPotionRecipes() {
        // TODO: Add numbing potion recipe with fibula and stonefish venom
    }
}