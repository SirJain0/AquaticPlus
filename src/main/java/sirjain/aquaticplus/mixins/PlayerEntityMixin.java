package sirjain.aquaticplus.mixins;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.ItemCooldownManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShieldItem;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

// Helps with the custom shield
// Thanks Kaupenjoe
@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {
	protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
		super(entityType, world);
	}

	@Redirect(
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"
		),
		method = "damageShield"
	)

	protected boolean damageShield(ItemStack itemStack, Item item) {
		if (itemStack.getItem() instanceof ShieldItem && item == Items.SHIELD)
			return true;

		return itemStack.isOf(item);
	}

	@Redirect(
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/entity/player/ItemCooldownManager;set(Lnet/minecraft/item/Item;I)V"
		),
		method = "disableShield"
	)

	public void disableShield(ItemCooldownManager itemCooldownManager, Item item, int duration) {
		Item activeItem = this.activeItemStack.getItem();

		if (activeItem instanceof ShieldItem && item == Items.SHIELD) itemCooldownManager.set(activeItem, duration);
		else itemCooldownManager.set(item, duration);
	}
}
