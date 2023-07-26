package com.sirjain.items;

import com.sirjain.AquaticPlus;
import com.sirjain.registries.AquaticPlusItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
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
                            entries.add(AquaticPlusItems.SPIRITED_FISH_SPAWN_EGG);
                            entries.add(AquaticPlusItems.FIBULA_SPAWN_EGG);
                            entries.add(AquaticPlusItems.PARROTFISH_SPAWN_EGG);

                            entries.add(AquaticPlusItems.SPIRITED_FISH_BUCKET);

                            entries.add(AquaticPlusItems.STONIFIER);
                            entries.add(AquaticPlusItems.DESTONIFIER);
                            entries.add(AquaticPlusItems.DETOXIFYING_ACID);
                        }).build()
        );
    }
}