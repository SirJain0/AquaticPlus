package sirjain.aquaticplus.item.abstract_item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public abstract class ShootingStaffItem extends Item {
	public ShootingStaffItem(Settings settings) {
		super(settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		if (world.isClient) return TypedActionResult.pass(user.getStackInHand(hand));

		if (!user.getAbilities().creativeMode) {
			if (this.hasAmmoItem()) {
				int slotWithProjectile = user.getInventory().getSlotWithStack(getAmmoItem());

				if (slotWithProjectile < 0)
					return TypedActionResult.pass(user.getStackInHand(hand));

				user.getInventory().getStack(slotWithProjectile).decrement(1);
			}

			if (hasDurability()) {
				user.getStackInHand(hand).damage(durabilityDecrement(), user, (p) -> p.sendToolBreakStatus(user.getActiveHand()));
			}

			user.getItemCooldownManager().set(this, 10);
		}

		int divergence;
		if (getDivergence() != 0) divergence = world.random.nextInt(getDivergence());
		else divergence = 0;

		for (int i = 0; i < getNumProjectiles(); i++) {
			ProjectileEntity projectile = getEntity(world, user);

			if (projectile instanceof ThrownItemEntity thrownItemEntity) thrownItemEntity.setItem(getAmmoItem());

			projectile.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, getProjectileVelocity(), divergence);
			world.spawnEntity(projectile);
		}

		return super.use(world, user, hand);
	}

	abstract public ProjectileEntity getEntity(World world, LivingEntity user);

	abstract public boolean hasAmmoItem();

	@Nullable abstract public ItemStack getAmmoItem();

	abstract public float getProjectileVelocity();

	abstract public int getNumProjectiles();

	abstract public int getDivergence();

	abstract public boolean hasDurability();

	abstract public int durabilityDecrement();
}
