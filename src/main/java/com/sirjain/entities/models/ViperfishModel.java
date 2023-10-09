package com.sirjain.entities.models;

import com.sirjain.entities.entity.ViperfishEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class ViperfishModel extends EntityModel<ViperfishEntity> {
	private final ModelPart root;

	public ViperfishModel(ModelPart part) {
		root = part;
	}

	@Override
	public void setAngles(ViperfishEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		// TODO: Aniamte
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {

	}
}
