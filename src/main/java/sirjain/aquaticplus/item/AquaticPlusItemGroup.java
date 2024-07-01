package sirjain.aquaticplus.item;

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
import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.status_effect.potion.AquaticPlusPotions;

public class AquaticPlusItemGroup {
	public static ItemGroup AQUATICPLUS_ITEM_GROUP;

	public static void registerItemGroup() {
		AQUATICPLUS_ITEM_GROUP = Registry.register(
			Registries.ITEM_GROUP,
			new Identifier(AquaticPlus.MOD_ID, "aquaticplus_item_group"),

			FabricItemGroup.builder()
				.displayName(Text.translatable("itemGroup.aquaticplus"))
				.icon(() -> new ItemStack(AquaticPlusItems.AQUATIC_STAR))

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
					entries.add(AquaticPlusItems.LANTERNFISH_SPAWN_EGG);
					entries.add(AquaticPlusItems.BLUEFIN_TUNA_SPAWN_EGG);
					entries.add(AquaticPlusItems.GULPER_EEL_SPAWN_EGG);
					entries.add(AquaticPlusItems.HALIBUT_SPAWN_EGG);
					entries.add(AquaticPlusItems.SARDINE_SPAWN_EGG);
					entries.add(AquaticPlusItems.MINNOW_SPAWN_EGG);
					entries.add(AquaticPlusItems.LIONFISH_SPAWN_EGG);
					entries.add(AquaticPlusItems.FROSTED_SPLASHER_SPAWN_EGG);
					entries.add(AquaticPlusItems.JELLYFISH_SPAWN_EGG);
					entries.add(AquaticPlusItems.NARWHAL_SPAWN_EGG);
					entries.add(AquaticPlusItems.NEON_CRAB_SPAWN_EGG);
					entries.add(AquaticPlusItems.ALLIGATOR_GAR_SPAWN_EGG);
					entries.add(AquaticPlusItems.SEA_PEN_SPAWN_EGG);
					entries.add(AquaticPlusItems.VOLAN_AURORA_SPAWN_EGG);
					entries.add(AquaticPlusItems.PIKE_SPAWN_EGG);
					entries.add(AquaticPlusItems.RIBBON_EEL_SPAWN_EGG);
					entries.add(AquaticPlusItems.DEEP_SEA_ISOPOD_SPAWN_EGG);
					entries.add(AquaticPlusItems.YETI_CRAB_SPAWN_EGG);
					entries.add(AquaticPlusItems.STONEFISH_SPAWN_EGG);
					entries.add(AquaticPlusItems.VERMILLION_JELLY_SPAWN_EGG);
					entries.add(AquaticPlusItems.PHANTOM_JELLYFISH_SUMMONER);

					entries.add(AquaticPlusItems.SPIRITED_FISH_BUCKET);
					entries.add(AquaticPlusItems.PARROTFISH_BUCKET);
					entries.add(AquaticPlusItems.SHADOW_SARDEL_BUCKET);
					entries.add(AquaticPlusItems.DUMBO_BLOB_BUCKET);
					entries.add(AquaticPlusItems.BLUEFIN_TUNA_BUCKET);
					entries.add(AquaticPlusItems.HALIBUT_BUCKET);
					entries.add(AquaticPlusItems.SARDINE_BUCKET);
					entries.add(AquaticPlusItems.MINNOW_BUCKET);

					entries.add(AquaticPlusItems.VIPERFISH);
					entries.add(AquaticPlusItems.PARROTFISH);
					entries.add(AquaticPlusItems.BLUEFIN_TUNA);
					entries.add(AquaticPlusItems.SHADOW_SARDEL);
					entries.add(AquaticPlusItems.HALIBUT);
					entries.add(AquaticPlusItems.SARDINE);
					entries.add(AquaticPlusItems.MINNOW);
					entries.add(AquaticPlusItems.MORTIS_FLESH);
					entries.add(AquaticPlusItems.GAR_FLESH);
					entries.add(AquaticPlusItems.PIKE_FLESH);
					entries.add(AquaticPlusItems.BREAD_AND_JELLY);

					entries.add(AquaticPlusItems.AQUATIC_STAR);
					entries.add(AquaticPlusItems.NUMBING_AQUATIC_STAR);
					entries.add(AquaticPlusItems.LAND_DROWNING_AQUATIC_STAR);
					entries.add(AquaticPlusItems.SEA_BANE_AQUATIC_STAR);
					entries.add(AquaticPlusItems.AURORA);
					entries.add(AquaticPlusItems.FROSTED_BALL);
					entries.add(AquaticPlusItems.FROST_SHARDS);
					entries.add(AquaticPlusItems.STONE_ESSENCE);
					entries.add(AquaticPlusItems.STONE_CORRODER);
					entries.add(AquaticPlusItems.STONEFISH_VENOM);
					entries.add(AquaticPlusItems.MORTIS_VENOM);
					entries.add(AquaticPlusItems.MAXILLA_MORTIS_TOOTH);
					entries.add(AquaticPlusItems.VIPER_TOOTH);
					entries.add(AquaticPlusItems.LIONFISH_SPIKE);
					entries.add(AquaticPlusItems.SUNFISH_TAIL);
					entries.add(AquaticPlusItems.GHOSTLY_MEMBRANE);
					entries.add(AquaticPlusItems.PINK_JELLY);
					entries.add(AquaticPlusItems.YELLOW_JELLY);
					entries.add(AquaticPlusItems.WHITE_JELLY);
					entries.add(AquaticPlusItems.NEON_LEAF);
					entries.add(AquaticPlusItems.ISOPOD_SHELL);
					entries.add(AquaticPlusItems.YETI_CRAB_SHELL);
					entries.add(AquaticPlusItems.DEOXIDIZING_MATERIAL);
					entries.add(AquaticPlusItems.STONIFIER);
					entries.add(AquaticPlusItems.DESTONIFIER);
					entries.add(AquaticPlusItems.FROSTING_SPECTRE);
					entries.add(AquaticPlusItems.AURORA_STAFF);
					entries.add(AquaticPlusItems.VERMILLION_GLOOM_STAFF);
					entries.add(AquaticPlusItems.MIDNIGHT_PIKE);
					entries.add(AquaticPlusItems.CYAN_CRAB_CLAW);
					entries.add(AquaticPlusItems.ORANGE_CRAB_CLAW);
					entries.add(AquaticPlusItems.PINK_CRAB_CLAW);

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
			for (Identifier id : AquaticPlusPotions.POTION_IDS) {
				if (entry.matchesId(id)) return true;
			}

			return false;
		}).map((entry) -> PotionUtil.setPotion(new ItemStack(item), entry.value())).forEach(entries::add);
	}
}