package com.sirjain.items;

import com.sirjain.AquaticPlus;
import com.sirjain.registries.AquaticPlusItems;
import com.sirjain.registries.AquaticPlusPotions;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class AquaticPlusItemGroup {
	public static ItemGroup AQUATICPLUS_ITEM_GROUP;

	public static void registerItemGroup() {
		AQUATICPLUS_ITEM_GROUP = Registry.register(
			Registries.ITEM_GROUP,
			new Identifier(AquaticPlus.MOD_ID, "aquaticplus_item_group"),

			FabricItemGroup.builder()
				.displayName(Text.translatable("itemGroup.aquaticplus"))
				.icon(() -> new ItemStack(Items.BEDROCK)) // TODO: Change later

				.entries((displayContext, entries) -> {
					entries.add(AquaticPlusItems.JOHNSON_SPAWN_EGG);
					entries.add(AquaticPlusItems.MINDINATOR_SPAWN_EGG);
					entries.add(AquaticPlusItems.SPIRITED_FISH_SPAWN_EGG);
					entries.add(AquaticPlusItems.MAXILLA_MORTIS_SPAWN_EGG);
					entries.add(AquaticPlusItems.PARROTFISH_SPAWN_EGG);
					entries.add(AquaticPlusItems.KELP_EEL_SPAWN_EGG);
					entries.add(AquaticPlusItems.SHADOW_SARDEL_SPAWN_EGG);
					entries.add(AquaticPlusItems.BONEFISH_SPAWN_EGG);
					entries.add(AquaticPlusItems.LONG_BONEFISH_SPAWN_EGG);
					entries.add(AquaticPlusItems.OCULI_MAGNI_SPAWN_EGG);
					entries.add(AquaticPlusItems.VIPERFISH_SPAWN_EGG);
					entries.add(AquaticPlusItems.MANTA_RAY_SPAWN_EGG);
					entries.add(AquaticPlusItems.DUMBO_BLOB_SPAWN_EGG);
					entries.add(AquaticPlusItems.PINK_SUNFISH_SPAWN_EGG);

					entries.add(AquaticPlusItems.SPIRITED_FISH_BUCKET);
					entries.add(AquaticPlusItems.PARROTFISH_BUCKET);
					entries.add(AquaticPlusItems.SHADOW_SARDEL_BUCKET);
					entries.add(AquaticPlusItems.DUMBO_BLOB_BUCKET);

					entries.add(AquaticPlusItems.PARROTFISH);
					entries.add(AquaticPlusItems.SHADOW_SARDEL);

					entries.add(AquaticPlusItems.AQUATIC_STAR);
					entries.add(AquaticPlusItems.NUMBING_AQUATIC_STAR);
					entries.add(AquaticPlusItems.LAND_DROWNING_AQUATIC_STAR);
					entries.add(AquaticPlusItems.FROSTED_BALL);
					entries.add(AquaticPlusItems.FROST_SHARDS);
					entries.add(AquaticPlusItems.STONE_ESSENCE);
					entries.add(AquaticPlusItems.MAXILLA_MORTIS_TOOTH);
					entries.add(AquaticPlusItems.VIPER_TOOTH);
					entries.add(AquaticPlusItems.SUNFISH_TAIL);
					entries.add(AquaticPlusItems.GHOSTLY_MEMBRANE);
					entries.add(AquaticPlusItems.DEOXIDIZING_MATERIAL);
					entries.add(AquaticPlusItems.STONIFIER);
					entries.add(AquaticPlusItems.DESTONIFIER);
					entries.add(AquaticPlusItems.FROSTING_SPECTRE);

					entries.add(AquaticPlusItems.GHOSTLY_GEL_ITEM);

					displayContext.lookup().getOptionalWrapper(RegistryKeys.POTION).ifPresent((wrapper) -> {
						addPotions(entries, wrapper, Items.POTION);
						addPotions(entries, wrapper, Items.SPLASH_POTION);
						addPotions(entries, wrapper, Items.LINGERING_POTION);
						addPotions(entries, wrapper, Items.TIPPED_ARROW);
					});
				}).build()
		);
	}

	private static void addPotions(ItemGroup.Entries entries, RegistryWrapper<Potion> registryWrapper, Item item) {
		registryWrapper.streamEntries().filter((entry) -> !entry.matchesKey(Potions.EMPTY_KEY)).filter((entry) -> {
			for (Identifier id : AquaticPlusPotions.POTION_IDS)
				if (entry.matchesId(id)) return true;

			return false;
		}).map((entry) -> PotionUtil.setPotion(new ItemStack(item), entry.value())).forEach(entries::add);
	}
}