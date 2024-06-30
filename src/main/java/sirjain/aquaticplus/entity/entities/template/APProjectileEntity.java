package sirjain.aquaticplus.entity.entities.template;

import sirjain.aquaticplus.AquaticPlusUtil;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public abstract class APProjectileEntity extends ThrownItemEntity {
	public APProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
		super(entityType, world);
	}

	public APProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world, LivingEntity owner) {
		super(entityType, owner, world);
	}

	// Destroys the particle if the particle has stopped moving and propels it in water
	@Override
	public void tick() {
		super.tick();

		final boolean hasStoppedMoving = this.getVelocity().x == 0 || this.getVelocity().y == 0 || this.getVelocity().z == 0;
		final boolean isIdle = hasStoppedMoving && this.age > 5;

		if (isIdle)
			this.kill();

		if (this.isSubmergedInWater())
			this.setVelocity(this.getVelocity().multiply(AquaticPlusUtil.UNDERWATER_VELOCITY_MULTIPLIER));
	}

	@Override
	protected void tickInVoid() {
		this.kill();
	}

	@Override
	protected void onCollision(HitResult hitResult) {
		super.onCollision(hitResult);
		this.kill();
	}

	@Override
	protected float getGravity() {
		return 0;
	}
}
