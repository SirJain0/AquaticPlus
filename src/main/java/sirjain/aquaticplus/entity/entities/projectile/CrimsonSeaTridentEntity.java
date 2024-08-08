package sirjain.aquaticplus.entity.entities.projectile;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import sirjain.aquaticplus.entity.AquaticPlusEntities;
import sirjain.aquaticplus.entity.entities.template.SeaTridentEntity;

public class CrimsonSeaTridentEntity extends SeaTridentEntity {
	public CrimsonSeaTridentEntity(EntityType<? extends SeaTridentEntity> entityType, World world) {
		super(entityType, world);
	}

	public CrimsonSeaTridentEntity(World world, PlayerEntity player) {
		super(AquaticPlusEntities.CRIMSON_SEA_TRIDENT_ENTITY, world, player);
	}
}
