package sirjain.aquaticplus.entity.entities.projectile;

import sirjain.aquaticplus.entity.entities.template.APProjectileEntity;
import sirjain.aquaticplus.entity.AquaticPlusEntities;
import sirjain.aquaticplus.item.AquaticPlusItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.GuardianEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class AuroraEntity extends APProjectileEntity {
	public AuroraEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
		super(entityType, world);
	}

	public AuroraEntity(World world, LivingEntity owner) {
		super(AquaticPlusEntities.AURORA_ENTITY, world, owner);
	}

	@Override
	protected Item getDefaultItem() {
		return AquaticPlusItems.AURORA;
	}

	@Override
	protected void onEntityHit(EntityHitResult entityHitResult) {
		super.onEntityHit(entityHitResult);

		Entity entity = entityHitResult.getEntity();

		if (entity instanceof GuardianEntity guardian)
			guardian.damage(guardian.getDamageSources().magic(), 2);
	}

	@Override
	public void tick() {
		super.tick();

		World world = this.getWorld();

		if (world.isClient && this.age % 3 == 0) {
			world.addParticle(
				ParticleTypes.END_ROD,
				this.getX(), this.getRandomBodyY(), this.getZ(),
				0, 0, 0
			);
		}
	}
}