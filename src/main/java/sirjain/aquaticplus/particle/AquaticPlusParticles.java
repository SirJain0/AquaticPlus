package sirjain.aquaticplus.particle;

import sirjain.aquaticplus.AquaticPlus;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class AquaticPlusParticles {
	public static DefaultParticleType VERMILLION_RADIATION;

	public static void registerParticles() {
		VERMILLION_RADIATION = registerParticle("vermillion_radiation", true);
	}

	public static DefaultParticleType registerParticle(String name, boolean alwaysSpawn) {
		return Registry.register(
			Registries.PARTICLE_TYPE,
			new Identifier(AquaticPlus.MOD_ID, name),
			FabricParticleTypes.simple(alwaysSpawn)
		);
	}

	public static void registerParticleFactories() {
		ParticleFactoryRegistry factoryRegistry = ParticleFactoryRegistry.getInstance();

		factoryRegistry.register(VERMILLION_RADIATION, VermillionRadiationParticle.VermillionRadiationFactory::new);
	}
}
