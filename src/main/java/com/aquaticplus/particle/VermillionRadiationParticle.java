package com.aquaticplus.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;
import org.jetbrains.annotations.Nullable;

public class VermillionRadiationParticle extends AbstractSlowingParticle {
	public VermillionRadiationParticle(ClientWorld clientWorld, double d, double e, double f, double g, double h, double i) {
		super(clientWorld, d, e, f, g, h, i);
	}

	@Override
	public ParticleTextureSheet getType() {
		return ParticleTextureSheet.PARTICLE_SHEET_LIT;
	}

	@Override
	public float getSize(float tickDelta) {
		float f = ((float)this.age + tickDelta) / (float)this.maxAge;
		return this.scale * (1.0F - f * f * 0.5F) + 0.5f;
	}

	public static class VermillionRadiationFactory implements ParticleFactory<DefaultParticleType> {
		private final SpriteProvider spriteProvider;

		public VermillionRadiationFactory(SpriteProvider spriteProvider) {
			this.spriteProvider = spriteProvider;
		}

		@Nullable
		@Override
		public Particle createParticle(DefaultParticleType parameters, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
			VermillionRadiationParticle radiationParticle = new VermillionRadiationParticle(world, x, y, z, velocityX, velocityY, velocityZ);
			radiationParticle.setSprite(this.spriteProvider);

			return radiationParticle;
		}
	}
}
