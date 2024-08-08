package sirjain.aquaticplus.entity.entities.template;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public abstract class SeaTridentEntity extends PersistentProjectileEntity {
	public SeaTridentEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
		super(entityType, world);
	}

	public SeaTridentEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world, LivingEntity owner) {
		super(entityType, owner, world);
	}

	@Override
	protected void onEntityHit(EntityHitResult entityHitResult) {
		Entity entity = entityHitResult.getEntity();
		World world = entity.getWorld();

		if (entity instanceof LivingEntity target) {
			if (!world.isClient) {
				((ServerWorld) world).spawnParticles(getParticle(), target.getX(), target.getY(), target.getZ(), 20, 0.2f, 0.1f, 0.05f, 0.5f);
			}

			target.damage(target.getDamageSources().arrow(this, this.getOwner()), 7);
		}

		super.onEntityHit(entityHitResult);
	}

	@Override
	public void tick() {
		super.tick();

		if (!this.getWorld().isClient && this.age % 6 == 0) {
			((ServerWorld) this.getWorld()).spawnParticles(ParticleTypes.ENCHANT, this.getX(), this.getY(), this.getZ(), 3, 0, 0.2f, 0.1f, 1);
		}

		if (!this.isNoClip()) {
			Vec3d vel = this.getVelocity();
			this.setVelocity(vel.x, vel.y - 0.001, vel.z);
		}
	}

	abstract public ParticleEffect getParticle();
}
