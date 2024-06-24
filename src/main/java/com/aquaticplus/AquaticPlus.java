package com.aquaticplus;

import com.aquaticplus.registries.util.AquaticPlusRegistryUtil;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AquaticPlus implements ModInitializer {
	public static final String MOD_ID = "aquaticplus";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Aquatic Plus mod!");
		AquaticPlusRegistryUtil.initContent();
	}
}