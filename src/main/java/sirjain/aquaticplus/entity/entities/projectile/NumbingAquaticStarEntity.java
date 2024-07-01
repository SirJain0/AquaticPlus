package sirjain.aquaticplus.entity.entities.projectile;

import sirjain.aquaticplus.entity.entities.template.AbstractAquaticStarEntity;
import sirjain.aquaticplus.entity.AquaticPlusEntities;
import sirjain.aquaticplus.item.AquaticPlusItems;
import sirjain.aquaticplus.status_effect.AquaticPlusStatusEffects;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class NumbingAquaticStarEntity extends AbstractAquaticStarEntity {
	public NumbingAquaticStarEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
		super(entityType, world);
	}

	public NumbingAquaticStarEntity(World world, LivingEntity owner) {
		super(AquaticPlusEntities.NUMBING_AQUATIC_STAR_ENTITY, world, owner);
	}

	@Override
	protected Item getDefaultItem() {
		return AquaticPlusItems.NUMBING_AQUATIC_STAR;
	}

	@Override
	public StatusEffect getConditionalEffect() {
		return AquaticPlusStatusEffects.NUMBING;
	}
}
