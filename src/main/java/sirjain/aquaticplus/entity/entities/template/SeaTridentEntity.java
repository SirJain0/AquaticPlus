package sirjain.aquaticplus.entity.entities.template;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sirjain.aquaticplus.item.AquaticPlusItems;

public abstract class SeaTridentEntity extends PersistentProjectileEntity {
	public SeaTridentEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
		super(entityType, world);
	}

	public SeaTridentEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world, LivingEntity owner) {
		super(entityType, owner, world);
	}

	@Override
	protected ItemStack asItemStack() {
		return AquaticPlusItems.AQUA_SEA_TRIDENT.getDefaultStack();
	}

	@Override
	public boolean hasNoGravity() {
		return true;
	}
}
