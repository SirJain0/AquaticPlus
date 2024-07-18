package sirjain.aquaticplus.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;
import org.jetbrains.annotations.Nullable;

public class SpiritParticle extends AbstractSlowingParticle {
	public SpiritParticle(ClientWorld clientWorld, double d, double e, double f, double g, double h, double i) {
		super(clientWorld, d, e, f, g, h, i);
	}

	@Override
	public ParticleTextureSheet getType() {
		return ParticleTextureSheet.PARTICLE_SHEET_LIT;
	}

	@Override
	public float getSize(float tickDelta) {
		float f = ((float)this.age + tickDelta) / (float) this.maxAge;
		return this.scale * (1.1F - f * f * 0.3F) + 0.15f;
	}

	public static class SpiritFactory implements ParticleFactory<DefaultParticleType> {
		private final SpriteProvider spriteProvider;

		public SpiritFactory(SpriteProvider spriteProvider) {
			this.spriteProvider = spriteProvider;
		}

		@Nullable
		@Override
		public Particle createParticle(DefaultParticleType parameters, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
			SpiritParticle particle = new SpiritParticle(world, x, y, z, velocityX, velocityY, velocityZ);
			particle.setSprite(this.spriteProvider);

			return particle;
		}
	}
}
