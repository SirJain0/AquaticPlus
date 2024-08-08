package sirjain.aquaticplus.entity.entities.projectile;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import sirjain.aquaticplus.entity.AquaticPlusEntities;
import sirjain.aquaticplus.entity.entities.template.SeaTridentEntity;
import sirjain.aquaticplus.item.AquaticPlusItems;
import sirjain.aquaticplus.status_effect.AquaticPlusStatusEffects;

import java.util.List;

public class CrimsonSeaTridentEntity extends SeaTridentEntity {
	public CrimsonSeaTridentEntity(EntityType<? extends SeaTridentEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void onEntityHit(EntityHitResult entityHitResult) {
		Entity entityFromHit = entityHitResult.getEntity();
		World world = entityFromHit.getWorld();

		if (entityFromHit instanceof LivingEntity target) {
			List<Entity> entities = world.getOtherEntities(target, target.getBoundingBox().expand(2), EntityPredicates.VALID_LIVING_ENTITY);

			for (Entity entityAround : entities) {
				if (entityAround == this.getOwner()) return;
				entityAround.setOnFireFor(4);
			}
		}

		super.onEntityHit(entityHitResult);
	}

	@Override
	public ParticleEffect getParticle() {
		return ParticleTypes.FLAME;
	}

	public CrimsonSeaTridentEntity(World world, PlayerEntity player) {
		super(AquaticPlusEntities.CRIMSON_SEA_TRIDENT_ENTITY, world, player);
	}

	@Override
	protected ItemStack asItemStack() {
		return AquaticPlusItems.CRIMSON_SEA_TRIDENT.getDefaultStack();
	}
}
