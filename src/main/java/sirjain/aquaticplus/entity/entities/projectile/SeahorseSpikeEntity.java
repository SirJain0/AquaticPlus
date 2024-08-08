package sirjain.aquaticplus.entity.entities.projectile;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import sirjain.aquaticplus.AquaticPlusUtil;
import sirjain.aquaticplus.entity.AquaticPlusEntities;
import sirjain.aquaticplus.entity.entities.template.APProjectileEntity;
import sirjain.aquaticplus.item.AquaticPlusItems;

public class SeahorseSpikeEntity extends APProjectileEntity {
	public SeahorseSpikeEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
		super(entityType, world);
	}

	public SeahorseSpikeEntity(World world, LivingEntity owner) {
		super(AquaticPlusEntities.SEAHORSE_SPIKE_ENTITY, world, owner);
	}

	@Override
	protected Item getDefaultItem() {
		return AquaticPlusItems.CRIMSON_SEAHORSE_SPIKE;
	}

	@Override
	protected void onEntityHit(EntityHitResult entityHitResult) {
		Entity entity = entityHitResult.getEntity();

		if (entity instanceof LivingEntity target) {
			target.damage(entity.getDamageSources().mobProjectile(this, (LivingEntity) this.getOwner()), 3);

			if (this.random.nextInt(2) == 0) {
				target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 20*4, 0));
			}
		}

		super.onEntityHit(entityHitResult);
	}

	@Override
	public void tick() {
		super.tick();
		AquaticPlusUtil.summonAmbientParticles(this, ParticleTypes.ENCHANT, 5, true);
	}

	@Override
	protected float getGravity() {
		return 0.05f;
	}
}
