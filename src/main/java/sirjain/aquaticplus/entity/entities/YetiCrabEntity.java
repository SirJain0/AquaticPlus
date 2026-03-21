package sirjain.aquaticplus.entity.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.world.World;
import sirjain.aquaticplus.entity.entities.template.AbstractCrabEntity;

// TODO: Make Yeti Crab spawn around hydrothermal vents (which requires a new structure)
public class YetiCrabEntity extends AbstractCrabEntity {
	public YetiCrabEntity(EntityType<? extends AbstractCrabEntity> entityType, World world) {
		super(entityType, world);
	}
}
