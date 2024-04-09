package com.sirjain.entities.models;

import com.sirjain.entities.entity.LionfishEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class LionfishModel extends EntityModel<LionfishEntity> {
	private final ModelPart root;
	private final ModelPart lionfish;
	private final ModelPart head;
	private final ModelPart tail;
	private final ModelPart tail2;

	public LionfishModel(ModelPart part) {
		root = part;
		lionfish = root.getChild("lionfish");
		head = lionfish.getChild("head");
		tail = lionfish.getChild("tail");
		tail2 = tail.getChild("tail2");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData lionfish = modelPartData.addChild("lionfish", ModelPartBuilder.create().uv(0, 9).cuboid(-3.0F, -2.6377F, -5.0F, 6.0F, 7.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 18.6377F, -3.5F));
		ModelPartData cube_r1 = lionfish.addChild("cube_r1", ModelPartBuilder.create().uv(18, 18).mirrored().cuboid(0.0F, -3.0F, -4.0F, 0.0F, 6.0F, 8.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-2.25F, -4.3127F, -1.0F, 0.0F, 0.0F, -0.4363F));
		ModelPartData cube_r2 = lionfish.addChild("cube_r2", ModelPartBuilder.create().uv(18, 18).cuboid(0.0F, -3.0F, -4.0F, 0.0F, 6.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(2.25F, -4.3127F, -1.0F, 0.0F, 0.0F, 0.4363F));
		ModelPartData cube_r3 = lionfish.addChild("cube_r3", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-7.6F, -0.5F, -2.5F, 12.0F, 0.0F, 9.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-3.0F, 3.6123F, -1.5F, 0.0F, 0.0F, -0.6109F));
		ModelPartData cube_r4 = lionfish.addChild("cube_r4", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-12.0F, -0.5F, -2.5F, 12.0F, 0.0F, 9.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-3.0F, 3.6123F, -1.5F, 0.0F, 0.0F, 0.6109F));
		ModelPartData cube_r5 = lionfish.addChild("cube_r5", ModelPartBuilder.create().uv(0, 0).cuboid(-4.4F, -0.5F, -2.5F, 12.0F, 0.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, 3.6123F, -1.5F, 0.0F, 0.0F, 0.6109F));
		ModelPartData cube_r6 = lionfish.addChild("cube_r6", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -0.5F, -2.5F, 12.0F, 0.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, 3.6123F, -1.5F, 0.0F, 0.0F, -0.6109F));
		ModelPartData tail = lionfish.addChild("tail", ModelPartBuilder.create().uv(13, 32).cuboid(-2.0F, -2.1667F, 0.5F, 4.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.5289F, 4.5F));
		ModelPartData cube_r7 = tail.addChild("cube_r7", ModelPartBuilder.create().uv(32, 12).cuboid(0.0F, -2.5F, -3.0F, 0.0F, 5.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.8333F, 1.5F, 0.5236F, 0.0F, 0.0F));
		ModelPartData cube_r8 = tail.addChild("cube_r8", ModelPartBuilder.create().uv(31, 31).cuboid(0.0F, -2.5F, -3.0F, 0.0F, 5.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -4.1667F, 1.5F, -0.3927F, 0.0F, 0.0F));
		ModelPartData tail2 = tail.addChild("tail2", ModelPartBuilder.create().uv(0, 17).cuboid(0.0F, -5.5F, -1.0F, 0.0F, 11.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.3333F, 5.5F));
		ModelPartData head = lionfish.addChild("head", ModelPartBuilder.create().uv(29, 27).cuboid(-2.5F, -2.0F, -5.25F, 5.0F, 5.0F, 5.0F, new Dilation(0.0F))
			.uv(0, 31).cuboid(0.0F, 1.0F, -4.25F, 0.0F, 5.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.6123F, -4.75F));

		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(LionfishEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		tail.yaw = MathHelper.sin(-40 + animationProgress * 0.4f) * 0.3f;
		tail2.yaw = MathHelper.sin(-80 + animationProgress * 0.4f) * 0.27f;
		head.yaw = MathHelper.sin(-15 + animationProgress * 0.4f) * 0.1f;
		root.pivotX = MathHelper.sin(animationProgress * 0.4f);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		lionfish.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}
}
