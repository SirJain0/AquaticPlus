package com.aquaticplus;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AquaticPlusMain implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("aquaticplus");

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Aquatic Plus mod!");
	}
}