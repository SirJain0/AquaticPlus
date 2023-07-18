package com.aquaticplus.registries;

import com.aquaticplus.AquaticPlus;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class AquaticPlusBlocks {
    public static void registerBlocks() {
        // Register blocks here
    }

    public static Block registerBlock(String identifier, Block block) {
        return Registry.register(
                Registries.BLOCK,
                new Identifier(AquaticPlus.MOD_ID, identifier),
                block
        );
    }
}
