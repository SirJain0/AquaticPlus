package com.sirjain.entities.models;

import com.sirjain.entities.entity.AlligatorGarEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class AlligatorGarModel extends EntityModel<AlligatorGarEntity> {
	private final ModelPart root;
	private final ModelPart gar;
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart tail1;
	private final ModelPart tail2;

	public AlligatorGarModel(ModelPart part) {
		root = part;
		gar = root.getChild("gar");
		head = gar.getChild("head");
		body = gar.getChild("body");
		tail1 = body.getChild("tail");
		tail2 = tail1.getChild("tail2");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData gar = modelPartData.addChild("gar", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -5.0F, -1.0F, 4.0F, 5.0F, 12.0F, new Dilation(0.0F))
			.uv(0, 17).cuboid(-1.0F, -1.0F, 6.0F, 0.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		ModelPartData cube_r1 = gar.addChild("cube_r1", ModelPartBuilder.create().uv(0, 13).mirrored().cuboid(0.0F, -3.0F, -2.0F, 0.0F, 4.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-4.5F, 0.375F, 2.0F, 0.0F, 0.0F, 0.829F));
		ModelPartData cube_r2 = gar.addChild("cube_r2", ModelPartBuilder.create().uv(0, 13).cuboid(0.0F, -3.0F, -2.0F, 0.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(2.5F, 0.375F, 2.0F, 0.0F, 0.0F, -0.829F));
		ModelPartData body = gar.addChild("body", ModelPartBuilder.create().uv(0, 17).cuboid(-2.0F, -2.5F, 0.0F, 4.0F, 5.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, -2.5F, 11.0F));
		ModelPartData cube_r3 = body.addChild("cube_r3", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, -3.0F, 0.0F, 4.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.0F, 7.5F, -0.2618F, 0.0F, -3.1416F));
		ModelPartData cube_r4 = body.addChild("cube_r4", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, -3.0F, 0.0F, 4.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 7.5F, -0.2618F, 0.0F, 0.0F));
		ModelPartData tail = body.addChild("tail", ModelPartBuilder.create().uv(32, 8).cuboid(-1.0F, -1.5F, 0.0F, 2.0F, 3.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 9.0F));
		ModelPartData tail2 = tail.addChild("tail2", ModelPartBuilder.create().uv(17, 7).cuboid(0.0F, -3.5F, -1.0F, 0.0F, 7.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 2.0F));
		ModelPartData head = gar.addChild("head", ModelPartBuilder.create().uv(0, 31).cuboid(-2.0F, -2.1667F, -4.3333F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F))
			.uv(19, 24).cuboid(-1.0F, -0.9167F, -11.3333F, 2.0F, 1.0F, 7.0F, new Dilation(0.0F))
			.uv(20, 0).cuboid(-1.0F, 0.0833F, -11.3333F, 2.0F, 1.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, -2.0833F, -0.6667F));

		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(AlligatorGarEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		body.yaw = MathHelper.cos(animationProgress * 0.2f) * 0.25f;
		tail1.yaw = MathHelper.cos(-20 + animationProgress * 0.2f) * 0.32f;
		tail2.yaw = MathHelper.cos(-40 + animationProgress * 0.2f) * 0.34f;
		head.yaw = -(MathHelper.cos(animationProgress * 0.2f) * 0.08f);
		root.pivotX = -(MathHelper.cos(animationProgress * 0.2f) * 1.65f);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}
}
