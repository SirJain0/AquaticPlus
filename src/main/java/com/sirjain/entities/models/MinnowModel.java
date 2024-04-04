package com.sirjain.entities.models;

import com.sirjain.entities.entity.MinnowEntity;
import com.sirjain.entities.entity.SardineEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class MinnowModel extends EntityModel<MinnowEntity> {
	private final ModelPart root;

	public MinnowModel(ModelPart part) {
		root = part;
	}

	// TODO: Change
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		return TexturedModelData.of(modelData, 32, 32);
	}

	@Override
	public void setAngles(MinnowEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
//		tail.yaw = MathHelper.sin(-40 + animationProgress * 0.4f) * 0.3f;
//		tail2.yaw = MathHelper.sin(-80 + animationProgress * 0.4f) * 0.27f;
		root.pivotX = MathHelper.sin(animationProgress * 0.4f);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}
}
