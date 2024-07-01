package sirjain.aquaticplus.entity.entities;

import sirjain.aquaticplus.entity.entities.template.AbstractEelEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.world.World;

public class RibbonEelEntity extends AbstractEelEntity {
	public RibbonEelEntity(EntityType<? extends AbstractEelEntity> entityType, World world) {
		super(entityType, world);
	}

	public static DefaultAttributeContainer.Builder createRibbonEelAttributes() {
		return AbstractEelEntity
			.createGenericEelAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 8);
	}
}