package sirjain.aquaticplus.client.entity.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import sirjain.aquaticplus.entity.entities.NarwhalEntity;
import sirjain.aquaticplus.entity.entities.SwordfishEntity;

public class SwordfishModel extends EntityModel<SwordfishEntity> {
	private final ModelPart root;

	public SwordfishModel(ModelPart part) {
		root = part;
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		return TexturedModelData.of(modelData, 128, 128);
	}

	@Override
	public void setAngles(SwordfishEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
//		saddle.visible = entity.isSaddled();
//		horn2.visible = entity.isDoubleTusked();
//		horn1.pivotX = !entity.isDoubleTusked() ? 1.75f : 0.25f;
//
//		tail.pitch = MathHelper.cos(animationProgress * 0.2f) * 0.25f;
//		tail2.pitch = MathHelper.cos(-20 + animationProgress * 0.2f) * 0.32f;
//		narwhal.pivotY = -(MathHelper.cos(animationProgress * 0.2f) * 1.5f);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}
}
