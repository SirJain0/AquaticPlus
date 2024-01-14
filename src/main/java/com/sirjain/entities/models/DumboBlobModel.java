package com.sirjain.entities.models;

import com.sirjain.entities.entity.DumboBlobEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class DumboBlobModel extends EntityModel<DumboBlobEntity> {
	private final ModelPart root;

	public DumboBlobModel(ModelPart part) {
		root = part;
		//
	}

	@Override
	public void setAngles(DumboBlobEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		// Animate
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}
}
