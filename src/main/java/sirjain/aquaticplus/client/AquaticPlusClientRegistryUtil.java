package sirjain.aquaticplus.client;

import sirjain.aquaticplus.client.entity.AquaticPlusEntityLayers;
import sirjain.aquaticplus.client.entity.AquaticPlusEntityRenderers;
import sirjain.aquaticplus.particle.AquaticPlusParticles;

public class AquaticPlusClientRegistryUtil {
	public static void registerClientContent() {
		AquaticPlusEntityLayers.registerEntityLayers();
		AquaticPlusEntityLayers.registerEntityModels();
		AquaticPlusEntityRenderers.registerEntityRenderers();
		AquaticPlusParticles.registerParticleFactories();
	}
}