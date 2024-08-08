package sirjain.aquaticplus.item.combat;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import sirjain.aquaticplus.entity.entities.projectile.CrimsonSeaTridentEntity;
import sirjain.aquaticplus.entity.entities.template.SeaTridentEntity;
import sirjain.aquaticplus.item.abstract_item.SeaTridentItem;

public class CrimsonSeaTridentItem extends SeaTridentItem {
	@Override
	public SeaTridentEntity getEntity(World world, PlayerEntity user) {
		return new CrimsonSeaTridentEntity(world, user);
	}
}
