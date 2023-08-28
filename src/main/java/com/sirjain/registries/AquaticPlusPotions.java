package com.sirjain.registries;

import com.sirjain.AquaticPlus;
import com.sirjain.mixins.BrewingRecipeRegistryMixin;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.Arrays;
import java.util.List;

public class AquaticPlusPotions {
	public static Potion NUMBING_POTION, NUMBING_LONG_POTION, NUMBING_STRONG_POTION;
	public static Potion LAND_DROWNING_POTION, LAND_DROWNING_LONG_POTION, LAND_DROWNING_STRONG_POTION;

	public static List<Identifier> POTION_IDS = Arrays.asList(
		buildPotionID("numbing_potion"),
		buildPotionID("numbing_long_potion"),
		buildPotionID("numbing_strong_potion"),

		buildPotionID("land_drowning_potion"),
		buildPotionID("land_drowning_long_potion"),
		buildPotionID("land_drowning_strong_potion")
	);

	public static void registerPotions() {
		NUMBING_POTION = registerPotion("numbing_potion", new Potion(new StatusEffectInstance(AquaticPlusStatusEffects.NUMBING, 20 * 35, 0)));
		NUMBING_LONG_POTION = registerPotion("numbing_long_potion", new Potion(new StatusEffectInstance(AquaticPlusStatusEffects.NUMBING, 20 * 65, 0)));
		NUMBING_STRONG_POTION = registerPotion("numbing_strong_potion", new Potion(new StatusEffectInstance(AquaticPlusStatusEffects.NUMBING, 20 * 18, 1)));

		LAND_DROWNING_POTION = registerPotion("land_drowning_potion", new Potion(new StatusEffectInstance(AquaticPlusStatusEffects.LAND_DROWNING, 20 * 16, 0)));
		LAND_DROWNING_LONG_POTION = registerPotion("land_drowning_long_potion", new Potion(new StatusEffectInstance(AquaticPlusStatusEffects.LAND_DROWNING, 20 * 33, 0)));
		LAND_DROWNING_STRONG_POTION = registerPotion("land_drowning_strong_potion", new Potion(new StatusEffectInstance(AquaticPlusStatusEffects.LAND_DROWNING, 20 * 12, 1)));
	}

	private static Potion registerPotion(String name, Potion potion) {
		return Registry.register(
			Registries.POTION,
			new Identifier(AquaticPlus.MOD_ID, name),
			potion
		);
	}

	public static void registerPotionRecipes() {
		registerNumbingRecipes();
		registerLandDrowningPotions();
	}

	// TODO: Add numbing potion recipe with Fibula and Stonefish venom
	public static void registerNumbingRecipes() {
		BrewingRecipeRegistryMixin.addRecipe(NUMBING_POTION, Items.REDSTONE, NUMBING_LONG_POTION);
		BrewingRecipeRegistryMixin.addRecipe(NUMBING_LONG_POTION, Items.GLOWSTONE, NUMBING_STRONG_POTION);
	}

	// TODO: Add recipe for Land drowning potion when the plant gets added
	public static void registerLandDrowningPotions() {
		BrewingRecipeRegistryMixin.addRecipe(LAND_DROWNING_POTION, Items.REDSTONE, LAND_DROWNING_LONG_POTION);
		BrewingRecipeRegistryMixin.addRecipe(LAND_DROWNING_LONG_POTION, Items.GLOWSTONE, LAND_DROWNING_STRONG_POTION);
	}

	public static Identifier buildPotionID(String identifier) {
		return new Identifier(AquaticPlus.MOD_ID, identifier);
	}
}