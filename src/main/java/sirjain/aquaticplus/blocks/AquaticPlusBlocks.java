package sirjain.aquaticplus.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import sirjain.aquaticplus.AquaticPlus;

public class AquaticPlusBlocks {
	public static Block GHOSTLY_GEL_BLOCK;

	public static void registerBlocks() {
		GHOSTLY_GEL_BLOCK = registerAdvancedBlock("ghostly_gel", new GhostlyGelBlock());
	}

	public static Block registerAdvancedBlock(String identifier, Block block) {
		return Registry.register(
			Registries.BLOCK,
			new Identifier(AquaticPlus.MOD_ID, identifier),
			block
		);
	}

	public static Block registerBasicBlock(String identifier, FabricBlockSettings settings) {
		return Registry.register(
			Registries.BLOCK,
			new Identifier(AquaticPlus.MOD_ID, identifier),
			new Block(settings)
		);
	}
}
