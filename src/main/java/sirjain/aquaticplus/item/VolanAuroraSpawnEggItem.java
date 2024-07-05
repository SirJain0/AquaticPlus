package sirjain.aquaticplus.item;

import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import sirjain.aquaticplus.entity.AquaticPlusEntities;

public class VolanAuroraSpawnEggItem extends SpawnEggItem {
	public VolanAuroraSpawnEggItem() {
		super(AquaticPlusEntities.VOLAN_AURORA_ENTITY, -1, -1, new Item.Settings());
	}
}
