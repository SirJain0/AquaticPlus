package com.sirjain.registries;

import com.sirjain.AquaticPlus;
import com.sirjain.mixins.BrewingRecipeRegistryMixin;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.Arrays;
import java.util.List;

public class AquaticPlusPotions {
        public static Potion NUMBING_POTION;
        public static Potion LAND_DROWNING_POTION;

        public static List<Identifier> POTION_IDS = Arrays.asList(
                buildPotionID("numbing_potion"),
                buildPotionID("land_drowning_potion")
        );

        public static void registerPotions() {
                NUMBING_POTION = registerPotion("numbing_potion", new Potion(new StatusEffectInstance(AquaticPlusStatusEffects.NUMBING, 20 * 12, 0)));
                LAND_DROWNING_POTION = registerPotion("land_drowning_potion", new Potion(new StatusEffectInstance(AquaticPlusStatusEffects.LAND_DROWNING, 20 * 10, 0)));
        }

        private static Potion registerPotion(String name, Potion potion) {
                return Registry.register(
                        Registries.POTION,
                        new Identifier(AquaticPlus.MOD_ID, name),
                        potion
                );
        }

        // TODO: Add numbing potion recipe with fibula and stonefish venom
        public static void registerPotionRecipes() {
                BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, AquaticPlusItems.SHADOW_SARDEL, Potions.SLOWNESS);
        }

        public static Identifier buildPotionID(String identifier) {
                return new Identifier(AquaticPlus.MOD_ID, identifier);
        }
}