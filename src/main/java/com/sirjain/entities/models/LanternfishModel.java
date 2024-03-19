package com.sirjain.entities.models;

import com.sirjain.entities.entity.LanternfishEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class LanternfishModel extends EntityModel<LanternfishEntity> {
	private final ModelPart root;
	private final ModelPart lanternFish;
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart body2;
	private final ModelPart body3;
	private final ModelPart tail;

	public LanternfishModel(ModelPart part) {
		root = part;
		lanternFish = root.getChild("lanternfish");
		head = lanternFish.getChild("head");
		body = lanternFish.getChild("body");
		body2 = body.getChild("body_2");
		body3 = body2.getChild("body_3");
		tail = body3.getChild("tail");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData lanternfish = modelPartData.addChild("lanternfish", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 3.8375F));
		ModelPartData body = lanternfish.addChild("body", ModelPartBuilder.create().uv(16, 14).cuboid(-2.0F, -3.2235F, -1.125F, 4.0F, 5.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -5.7765F, -13.125F));
		ModelPartData cube_r1 = body.addChild("cube_r1", ModelPartBuilder.create().uv(12, 0).mirrored().cuboid(-7.0F, 0.0F, -2.0F, 7.0F, 0.0F, 6.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-2.0F, 1.7765F, 2.875F, 0.0F, 0.0F, -0.3491F));
		ModelPartData cube_r2 = body.addChild("cube_r2", ModelPartBuilder.create().uv(12, 0).cuboid(0.0F, 0.0F, -2.0F, 7.0F, 0.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 1.7765F, 2.875F, 0.0F, 0.0F, 0.3491F));
		ModelPartData body_2 = body.addChild("body_2", ModelPartBuilder.create().uv(0, 22).cuboid(-2.0F, -0.75F, 0.0F, 4.0F, 5.0F, 7.0F, new Dilation(0.0F))
			.uv(22, 28).cuboid(0.0F, 3.25F, 2.0F, 0.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.4735F, 6.875F));
		ModelPartData cube_r3 = body_2.addChild("cube_r3", ModelPartBuilder.create().uv(22, 21).cuboid(0.0F, -3.0F, -3.0F, 0.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.75F, 4.0F, -0.3491F, 0.0F, 0.0F));
		ModelPartData body_3 = body_2.addChild("body_3", ModelPartBuilder.create().uv(24, 0).cuboid(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 2.0F, 7.0F));
		ModelPartData tail = body_3.addChild("tail", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -5.0F, -4.0F, 0.0F, 10.0F, 12.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 6.0F));
		ModelPartData head = lanternfish.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -1.5F, -6.0F, 6.0F, 5.0F, 6.0F, new Dilation(0.05F)), ModelTransform.pivot(0.0F, -7.5F, -13.75F));

		return TexturedModelData.of(modelData, 64, 64);
	}


	@Override
	public void setAngles(LanternfishEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		body.yaw = MathHelper.cos(animationProgress * 0.2f) * 0.2f;
		body2.yaw = MathHelper.cos(-20 + animationProgress * 0.2f) * 0.25f;
		body3.yaw = MathHelper.cos(-40 + animationProgress * 0.2f) * 0.28f;
		head.yaw = -(MathHelper.cos(animationProgress * 0.2f) * 0.1f);
		root.pivotX = -(MathHelper.cos(animationProgress * 0.2f));
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}
}