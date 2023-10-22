package com.sirjain.entities.models;

import com.sirjain.entities.entity.MantaRayEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class MantaRayModel extends EntityModel<MantaRayEntity> {
	public ModelPart root;
	public ModelPart main;
	public ModelPart leftPincer;
	public ModelPart rightPincer;
	public ModelPart tail;
	public ModelPart leftWing;
	public ModelPart rightWing;
	private final ModelPart saddle;

	public MantaRayModel(ModelPart part) {
		root = part;
		main = root.getChild("mantaray");
		leftPincer = main.getChild("left_pincer");
		rightPincer = main.getChild("right_pincer");
		tail = main.getChild("tail");
		leftWing = main.getChild("left_wing");
		rightWing = main.getChild("right_wing");
		saddle = main.getChild("saddle");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData mantaray = modelPartData.addChild("mantaray", ModelPartBuilder.create().uv(0, 0).cuboid(-4.25F, -2.25F, -4.25F, 14.0F, 4.0F, 20.0F, new Dilation(0.0F))
			.uv(0, 0).cuboid(-4.25F, -1.25F, -7.25F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.75F, 20.25F, -12.0F));
		ModelPartData left_pincer = mantaray.addChild("left_pincer", ModelPartBuilder.create().uv(0, 0).cuboid(-1.5F, -1.5F, -3.0F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(8.25F, 0.25F, -4.25F));
		ModelPartData right_pincer = mantaray.addChild("right_pincer", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.5F, -1.5F, -3.0F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-2.75F, 0.25F, -4.25F));
		ModelPartData tail = mantaray.addChild("tail", ModelPartBuilder.create().uv(0, 24).cuboid(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 27.0F, new Dilation(0.0F)), ModelTransform.pivot(2.75F, -2.25F, 15.75F));
		ModelPartData left_wing = mantaray.addChild("left_wing", ModelPartBuilder.create().uv(31, 24).cuboid(0.0F, -1.0F, -7.0F, 15.0F, 2.0F, 14.0F, new Dilation(0.0F)), ModelTransform.pivot(9.75F, -1.25F, 6.75F));
		ModelPartData right_wing = mantaray.addChild("right_wing", ModelPartBuilder.create().uv(31, 24).mirrored().cuboid(-15.0F, -1.0F, -7.0F, 15.0F, 2.0F, 14.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-4.25F, -1.25F, 6.75F));
		ModelPartData saddle = mantaray.addChild("saddle", ModelPartBuilder.create().uv(0, 55).cuboid(-4.25F, -2.25F, -4.25F, 14.0F, 4.0F, 20.0F, new Dilation(0.2F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		return TexturedModelData.of(modelData, 128, 128);
	}

	@Override
	public void setAngles(MantaRayEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.saddle.visible = entity.isSaddled();
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		main.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}
}