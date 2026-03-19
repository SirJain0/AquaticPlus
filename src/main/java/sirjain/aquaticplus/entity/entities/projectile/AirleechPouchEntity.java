package sirjain.aquaticplus.entity.entities.projectile;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import sirjain.aquaticplus.AquaticPlusUtil;
import sirjain.aquaticplus.entity.AquaticPlusEntities;
import sirjain.aquaticplus.entity.entities.template.APProjectileEntity;
import sirjain.aquaticplus.item.AquaticPlusItems;
import sirjain.aquaticplus.status_effect.AquaticPlusStatusEffects;

public class AirleechPouchEntity extends APProjectileEntity {
	public AirleechPouchEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
		super(entityType, world);
	}

	public AirleechPouchEntity(World world, LivingEntity owner) {
		super(AquaticPlusEntities.AIRLEECH_POUCH_ENTITY, world, owner);
	}

	@Override
	protected Item getDefaultItem() {
		return AquaticPlusItems.AIRLEECH_POUCH;
	}

	@Override
	protected float getGravity() {
		return 0.07f;
	}

	@Override
	protected void onEntityHit(EntityHitResult entityHitResult) {
		Entity hitEntity = entityHitResult.getEntity();

		if (hitEntity instanceof LivingEntity target) {
			target.addStatusEffect(new StatusEffectInstance(AquaticPlusStatusEffects.LAND_DROWNING, 20*3, 0));
			target.damage(target.getDamageSources().thrown(this, this.getOwner()), 0);
		}

		super.onEntityHit(entityHitResult);
	}

	@Override
	protected void onBlockCollision(BlockState state) {
		super.onBlockCollision(state);
	}

	@Override
	protected void onCollision(HitResult hitResult) {
		AquaticPlusUtil.summonParticlesOffCollision(ParticleTypes.BUBBLE, this.getWorld(), 15, hitResult.getPos());

		super.onCollision(hitResult);
	}
}
