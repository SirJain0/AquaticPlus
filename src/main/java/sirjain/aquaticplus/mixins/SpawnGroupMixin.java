package sirjain.aquaticplus.mixins;

import net.minecraft.entity.SpawnGroup;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SpawnGroup.class)
public class SpawnGroupMixin {
	@Inject(method = "getCapacity", at = @At("HEAD"), cancellable = true)
	private void aquaticplus$increaseWaterCreatureCap(CallbackInfoReturnable<Integer> cir) {
		if ((Object) this == SpawnGroup.WATER_CREATURE) {
			cir.setReturnValue(20);
		}
	}
}

