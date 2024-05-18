package com.aquaticplus;

import com.aquaticplus.registries.AquaticPlusBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.util.ModelIdentifier;

public class AquaticPlusClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(AquaticPlusBlocks.GHOSTLY_GEL_BLOCK, RenderLayer.getTranslucent());

		ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) -> new ModelIdentifier(AquaticPlus.MOD_ID, "cyan_crab_claw_model", "inventory"));
		ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) -> new ModelIdentifier(AquaticPlus.MOD_ID, "pink_crab_claw_model", "inventory"));
		ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) -> new ModelIdentifier(AquaticPlus.MOD_ID, "orange_crab_claw_model", "inventory"));
	}
}