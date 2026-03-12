package sirjain.aquaticplus.item.combat;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import sirjain.aquaticplus.entity.entities.VolanAuroraEntity;
import sirjain.aquaticplus.entity.entities.projectile.AuroraEntity;
import sirjain.aquaticplus.item.AquaticPlusItems;
import sirjain.aquaticplus.item.abstract_item.ShootingStaffItem;

import java.util.List;

public class AuroraStaffItem extends ShootingStaffItem {
	public AuroraStaffItem() {
		super(new Item.Settings().maxCount(1).maxDamage(500));
	}

	@Override
	public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
		if (entity instanceof VolanAuroraEntity volanAurora) {
			if (volanAurora.getTarget() == null) volanAurora.isAttracted = !volanAurora.isAttracted;
			if (volanAurora.leader == null) volanAurora.leader = user;

			if (!user.getAbilities().creativeMode) {
				stack.damage(1, user, p -> p.sendToolBreakStatus(hand));
			}

			user.getWorld().playSound(user, user.getBlockPos(), SoundEvents.BLOCK_END_PORTAL_FRAME_FILL, SoundCategory.NEUTRAL, 0.8F, 0.5F);

			return ActionResult.SUCCESS;
		}

		return super.useOnEntity(stack, user, entity, hand);
	}

	@Override
	public ProjectileEntity getEntity(World world, LivingEntity user) {
		return new AuroraEntity(world, user);
	}

	@Override
	public boolean hasAmmoItem() {
		return false;
	}

	@Override
	public @Nullable ItemStack getProjectileItem() {
		return AquaticPlusItems.AURORA.getDefaultStack();
	}

	@Override
	public float getProjectileVelocity() {
		return 2f;
	}

	@Override
	public int getNumProjectiles() {
		return 1;
	}

	@Override
	public int getDivergence() {
		return 0;
	}

	@Override
	public boolean hasDurability() {
		return true;
	}

	@Override
	public int durabilityDecrement() {
		return 1;
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(Text.translatable("aquaticplus.aurora_staff.tooltip").formatted(Formatting.LIGHT_PURPLE));
		super.appendTooltip(stack, world, tooltip, context);
	}
}