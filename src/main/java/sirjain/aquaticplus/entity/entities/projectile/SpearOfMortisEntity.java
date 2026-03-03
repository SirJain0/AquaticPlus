package sirjain.aquaticplus.entity.entities.projectile;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import sirjain.aquaticplus.entity.AquaticPlusEntities;
import sirjain.aquaticplus.entity.entities.template.SeaTridentEntity;
import sirjain.aquaticplus.item.AquaticPlusItems;
import sirjain.aquaticplus.status_effect.AquaticPlusStatusEffects;

public class SpearOfMortisEntity extends SeaTridentEntity {
	public SpearOfMortisEntity(EntityType<? extends SeaTridentEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void onEntityHit(EntityHitResult entityHitResult) {
		Entity entityFromHit = entityHitResult.getEntity();
		World world = entityFromHit.getWorld();

		if (entityFromHit instanceof LivingEntity target) {
			target.addStatusEffect(new StatusEffectInstance(AquaticPlusStatusEffects.NUMBING, 20*3, 1));
		}

		super.onEntityHit(entityHitResult);
	}

	public SpearOfMortisEntity(World world, PlayerEntity player) {
		super(AquaticPlusEntities.SPEAR_OF_MORTIS_ENTITY, world, player);
	}

	@Override
	protected ItemStack asItemStack() {
		return AquaticPlusItems.SPEAR_OF_MORTIS.getDefaultStack();
	}

	@Override
	public ParticleEffect getParticle() {
		return ParticleTypes.BUBBLE;
	}
}
