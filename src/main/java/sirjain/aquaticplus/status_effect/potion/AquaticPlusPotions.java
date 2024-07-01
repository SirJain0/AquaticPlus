package sirjain.aquaticplus.status_effect.potion;

import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.item.AquaticPlusItems;
import sirjain.aquaticplus.status_effect.AquaticPlusStatusEffects;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.Arrays;
import java.util.List;

// TODO: Refactor this system
// TODO: Change water bottles to whatever suitable starter potion (awk, mundane, etc)
public class AquaticPlusPotions {
	public static Potion NUMBING_POTION, NUMBING_LONG_POTION, NUMBING_STRONG_POTION;
	public static Potion LAND_DROWNING_POTION, LAND_DROWNING_LONG_POTION, LAND_DROWNING_STRONG_POTION;
	public static Potion SUNFISH_GRACE_POTION, SUNFISH_GRACE_LONG_POTION, SUNFISH_GRACE_STRONG_POTION;
	public static Potion SEA_BANE_POTION, SEA_BANE_LONG_POTION, SEA_BANE_STRONG_POTION;

	public static List<Identifier> POTION_IDS = Arrays.asList(
		buildPotionID("numbing_potion"),
		buildPotionID("numbing_long_potion"),
		buildPotionID("numbing_strong_potion"),

		buildPotionID("land_drowning_potion"),
		buildPotionID("land_drowning_long_potion"),
		buildPotionID("land_drowning_strong_potion"),

		buildPotionID("sunfish_grace_potion"),
		buildPotionID("sunfish_grace_long_potion"),
		buildPotionID("sunfish_grace_strong_potion"),

		buildPotionID("sea_bane_potion"),
		buildPotionID("sea_bane_long_potion"),
		buildPotionID("sea_bane_strong_potion")
	);

	public static void registerPotions() {
		NUMBING_POTION = registerPotion("numbing_potion", new Potion(new StatusEffectInstance(AquaticPlusStatusEffects.NUMBING, 20 * 35, 0)));
		NUMBING_LONG_POTION = registerPotion("numbing_long_potion", new Potion(new StatusEffectInstance(AquaticPlusStatusEffects.NUMBING, 20 * 65, 0)));
		NUMBING_STRONG_POTION = registerPotion("numbing_strong_potion", new Potion(new StatusEffectInstance(AquaticPlusStatusEffects.NUMBING, 20 * 18, 1)));

		LAND_DROWNING_POTION = registerPotion("land_drowning_potion", new Potion(new StatusEffectInstance(AquaticPlusStatusEffects.LAND_DROWNING, 20 * 16, 0)));
		LAND_DROWNING_LONG_POTION = registerPotion("land_drowning_long_potion", new Potion(new StatusEffectInstance(AquaticPlusStatusEffects.LAND_DROWNING, 20 * 33, 0)));
		LAND_DROWNING_STRONG_POTION = registerPotion("land_drowning_strong_potion", new Potion(new StatusEffectInstance(AquaticPlusStatusEffects.LAND_DROWNING, 20 * 12, 1)));

		SUNFISH_GRACE_POTION = registerPotion("sunfish_grace_potion", new Potion(new StatusEffectInstance(AquaticPlusStatusEffects.SUNFISH_GRACE, 20 * 12, 0)));
		SUNFISH_GRACE_LONG_POTION = registerPotion("sunfish_grace_long_potion", new Potion(new StatusEffectInstance(AquaticPlusStatusEffects.SUNFISH_GRACE, 20 * 25, 0)));
		SUNFISH_GRACE_STRONG_POTION = registerPotion("sunfish_grace_strong_potion", new Potion(new StatusEffectInstance(AquaticPlusStatusEffects.SUNFISH_GRACE, 20 * 7, 1)));

		SEA_BANE_POTION = registerPotion("sea_bane_potion", new Potion(new StatusEffectInstance(AquaticPlusStatusEffects.SEA_BANE, 20 * 12, 0)));
		SEA_BANE_LONG_POTION = registerPotion("sea_bane_long_potion", new Potion(new StatusEffectInstance(AquaticPlusStatusEffects.SEA_BANE, 20 * 25, 0)));
		SEA_BANE_STRONG_POTION = registerPotion("sea_bane_strong_potion", new Potion(new StatusEffectInstance(AquaticPlusStatusEffects.SEA_BANE, 20 * 7, 1)));
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
		registerSunfishGracePotions();
		registerSeaBanePotions();
	}

	public static void registerNumbingRecipes() {
		FabricBrewingRecipeRegistry.registerPotionRecipe(Potions.WATER, Ingredient.ofItems(AquaticPlusItems.MORTIS_VENOM), NUMBING_POTION);
		FabricBrewingRecipeRegistry.registerPotionRecipe(Potions.WATER, Ingredient.ofItems(AquaticPlusItems.STONEFISH_VENOM), NUMBING_POTION);

		FabricBrewingRecipeRegistry.registerPotionRecipe(NUMBING_POTION, Ingredient.ofItems(Items.REDSTONE), NUMBING_LONG_POTION);
		FabricBrewingRecipeRegistry.registerPotionRecipe(NUMBING_LONG_POTION, Ingredient.ofItems(Items.GLOWSTONE), NUMBING_STRONG_POTION);
	}

	// TODO: Add recipe for Land drowning potion when the plant gets added
	public static void registerLandDrowningPotions() {
		FabricBrewingRecipeRegistry.registerPotionRecipe(LAND_DROWNING_POTION, Ingredient.ofItems(Items.REDSTONE), LAND_DROWNING_LONG_POTION);
		FabricBrewingRecipeRegistry.registerPotionRecipe(LAND_DROWNING_LONG_POTION, Ingredient.ofItems(Items.GLOWSTONE), LAND_DROWNING_STRONG_POTION);
	}

	public static void registerSunfishGracePotions() {
		FabricBrewingRecipeRegistry.registerPotionRecipe(Potions.WATER, Ingredient.ofItems(AquaticPlusItems.SUNFISH_TAIL), SUNFISH_GRACE_POTION);

		FabricBrewingRecipeRegistry.registerPotionRecipe(SUNFISH_GRACE_POTION, Ingredient.ofItems(Items.REDSTONE), SUNFISH_GRACE_LONG_POTION);
		FabricBrewingRecipeRegistry.registerPotionRecipe(SUNFISH_GRACE_LONG_POTION, Ingredient.ofItems(Items.GLOWSTONE), SUNFISH_GRACE_STRONG_POTION);
	}

	public static void registerSeaBanePotions() {
		FabricBrewingRecipeRegistry.registerPotionRecipe(Potions.WATER, Ingredient.ofItems(AquaticPlusItems.LIONFISH_SPIKE), SEA_BANE_POTION);

		FabricBrewingRecipeRegistry.registerPotionRecipe(SEA_BANE_POTION, Ingredient.ofItems(Items.REDSTONE), SEA_BANE_LONG_POTION);
		FabricBrewingRecipeRegistry.registerPotionRecipe(SEA_BANE_LONG_POTION, Ingredient.ofItems(Items.GLOWSTONE), SEA_BANE_STRONG_POTION);
	}

	public static Identifier buildPotionID(String identifier) {
		return new Identifier(AquaticPlus.MOD_ID, identifier);
	}
}