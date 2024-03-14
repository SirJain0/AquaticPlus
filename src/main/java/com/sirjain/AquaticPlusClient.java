package com.sirjain;

import com.sirjain.registries.AquaticPlusBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class AquaticPlusClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(AquaticPlusBlocks.GHOSTLY_GEL_BLOCK, RenderLayer.getTranslucent());
	}
}