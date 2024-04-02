package com.sirjain.entities.models;

import com.sirjain.entities.entity.HalibutEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class HalibutModel extends EntityModel<HalibutEntity> {
	private final ModelPart root;
	private final ModelPart halibut;
	private final ModelPart tail;
	private final ModelPart tail2;

	public HalibutModel(ModelPart part) {
		root = part;
		halibut = root.getChild("halibut");
		tail = halibut.getChild("tail");
		tail2 = tail.getChild("tail_2");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData halibut = modelPartData.addChild("halibut", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -3.8685F, -13.3608F, 4.0F, 8.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 17.3685F, -1.8892F));
		ModelPartData top_fin = halibut.addChild("top_fin", ModelPartBuilder.create().uv(0, 18).cuboid(0.0F, -4.0F, -9.0F, 0.0F, 7.0F, 13.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.8685F, -3.6108F));
		ModelPartData bottom_fin = halibut.addChild("bottom_fin", ModelPartBuilder.create().uv(0, 11).cuboid(0.0F, -3.0F, -5.25F, 0.0F, 7.0F, 13.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 4.1315F, -7.3608F));
		ModelPartData tail = halibut.addChild("tail", ModelPartBuilder.create().uv(26, 31).cuboid(-0.5F, -1.6932F, 2.0747F, 1.0F, 4.0F, 6.0F, new Dilation(0.0F))
			.uv(26, 18).cuboid(0.0F, -7.6932F, -0.1753F, 0.0F, 7.0F, 6.0F, new Dilation(0.0F))
			.uv(24, 0).cuboid(0.0F, 1.3068F, -0.1753F, 0.0F, 7.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.1753F, 0.5644F));
		ModelPartData tail_2 = tail.addChild("tail_2", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -4.0F, -0.25F, 0.0F, 8.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.3068F, 8.0747F));

		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(HalibutEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		tail.yaw = MathHelper.sin(-40 + animationProgress * 0.4f) * 0.3f;
		tail2.yaw = MathHelper.sin(-80 + animationProgress * 0.4f) * 0.27f;
		root.pivotX = MathHelper.sin(animationProgress * 0.4f);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}
}
