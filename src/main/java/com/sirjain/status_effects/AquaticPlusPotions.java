package com.sirjain.status_effects;

import com.sirjain.AquaticPlus;
import com.sirjain.mixins.BrewingRecipeRegistryMixin;
import com.sirjain.registries.AquaticPlusItems;
import com.sirjain.registries.AquaticPlusStatusEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class AquaticPlusPotions {
    public static Potion NUMBING_POTION;

    public static void registerPotions() {
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