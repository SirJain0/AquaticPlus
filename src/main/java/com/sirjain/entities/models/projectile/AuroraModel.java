package com.sirjain.entities.models.projectile;

import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class AuroraModel<T extends Entity> extends SinglePartEntityModel<T> {
	private final ModelPart root;

	public AuroraModel(ModelPart root) {
//		super(RenderLayer::getEntityTranslucent);
		this.root = root;
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData bone = modelPartData.addChild("bone", ModelPartBuilder.create().uv(0, 8).cuboid(-10.0F, -8.0F, 6.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F))
			.uv(0, 0).cuboid(-10.0F, -8.0F, 6.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.7F)), ModelTransform.pivot(8.0F, 24.0F, -8.0F));

		return TexturedModelData.of(modelData, 16, 16);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}

	@Override
	public ModelPart getPart() {
		return this.root;
	}

	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

	}
}