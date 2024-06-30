package sirjain.aquaticplus.entity.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.world.World;

public class LongBonefishEntity extends BonefishEntity {
	public LongBonefishEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
		super(entityType, world);
	}

	public static DefaultAttributeContainer.Builder createLongBonefishAttributes() {
		return createFishAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 13);
	}

	@Override
	public boolean isScaredOfSpiritedFish() {
		return false;
	}
}
