package sirjain.aquaticplus.item.abstract_item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public abstract class SeaSwordItem extends SwordItem {
	public SeaSwordItem() {
		super(ToolMaterials.IRON, 7, 0, new Item.Settings().maxCount(1).maxDamage(450));
	}

	@Override
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		World world = target.getWorld();

		if (!world.isClient) {
			((ServerWorld) world).spawnParticles(getParticle(), target.getX(), target.getY(), target.getZ(), 20, 0.2f, 0.1f, 0.05f, 0.5f);
		}

		return super.postHit(stack, target, attacker);
	}

	abstract public ParticleEffect getParticle();
}