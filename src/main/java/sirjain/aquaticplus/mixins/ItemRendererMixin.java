package sirjain.aquaticplus.mixins;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.item.AquaticPlusItems;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
	@ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
	public BakedModel useRadiationStaffModel(BakedModel value, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
		boolean isHeldInHand = renderMode == ModelTransformationMode.FIRST_PERSON_LEFT_HAND ||
			renderMode == ModelTransformationMode.FIRST_PERSON_RIGHT_HAND ||
			renderMode == ModelTransformationMode.THIRD_PERSON_LEFT_HAND ||
			renderMode == ModelTransformationMode.THIRD_PERSON_RIGHT_HAND;

		if (stack.isOf(AquaticPlusItems.CYAN_CRAB_CLAW) && isHeldInHand) return generateModel("cyan_crab_claw_model");
		if (stack.isOf(AquaticPlusItems.PINK_CRAB_CLAW) && isHeldInHand) return generateModel("pink_crab_claw_model");
		if (stack.isOf(AquaticPlusItems.ORANGE_CRAB_CLAW) && isHeldInHand) return generateModel("orange_crab_claw_model");
		if (stack.isOf(AquaticPlusItems.AURORA) && (!isHeldInHand && !(renderMode == ModelTransformationMode.GUI))) return generateModel("aurora_model");

		return value;
	}

	public BakedModel generateModel(String id) {
		return ((ItemRendererAccessor) this).getModels().getModelManager().getModel(new ModelIdentifier(AquaticPlus.MOD_ID, id, "inventory"));
	}
}