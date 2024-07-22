package sirjain.aquaticplus.client.entity.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import sirjain.aquaticplus.entity.entities.SlimyShrimpEntity;

public class SlimyShrimpModel extends EntityModel<SlimyShrimpEntity> {
	private final ModelPart root;

	public SlimyShrimpModel(ModelPart part) {
		root = part;
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(SlimyShrimpEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		root.pivotX = -(MathHelper.cos(animationProgress * 0.2f) * 1.65f);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}
}
