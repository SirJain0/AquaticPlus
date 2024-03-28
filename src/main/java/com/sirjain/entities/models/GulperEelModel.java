package com.sirjain.entities.models;

import com.sirjain.entities.entity.GulperEelEntity;
import com.sirjain.entities.entity.animation.GulperEelAnimations;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class GulperEelModel extends SinglePartEntityModel<GulperEelEntity> {
	private final ModelPart root;
	private final ModelPart main;
	private final ModelPart head;
	private final ModelPart lowerJaw;
	private final ModelPart tail;
	private final ModelPart tail2;
	private final ModelPart tail3;
	private final ModelPart tail4;

	public GulperEelModel(ModelPart part) {
		root = part;
		main = root.getChild("gulper_eel");
		head = main.getChild("head");
		lowerJaw = head.getChild("lower_jaw");
		tail = main.getChild("tail");
		tail2 = tail.getChild("tail2");
		tail3 = tail2.getChild("tail3");
		tail4 = tail3.getChild("tail4");
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		main.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData gulper_eel = modelPartData.addChild("gulper_eel", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 18.0F, -11.0F));
		ModelPartData head = gulper_eel.addChild("head", ModelPartBuilder.create().uv(0, 49).cuboid(-4.0F, -2.875F, -13.1875F, 8.0F, 4.0F, 0.0F, new Dilation(0.0F))
			.uv(0, 16).cuboid(-6.0F, 0.125F, -12.9375F, 12.0F, 1.0F, 13.0F, new Dilation(-0.1F))
			.uv(0, 0).cuboid(-6.0F, -2.375F, -12.9375F, 12.0F, 3.0F, 13.0F, new Dilation(0.0F))
			.uv(33, 21).cuboid(0.0F, 0.625F, 0.5625F, 0.0F, 1.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -5.625F, 2.9375F));
		ModelPartData lower_jaw = head.addChild("lower_jaw", ModelPartBuilder.create().uv(0, 30).cuboid(-5.0F, -1.5218F, -12.9115F, 10.0F, 2.0F, 13.0F, new Dilation(0.0F))
			.uv(33, 32).cuboid(-5.0F, -2.0218F, -12.9115F, 10.0F, 1.0F, 13.0F, new Dilation(-0.1F)), ModelTransform.of(0.0F, 0.875F, 0.0625F, 0.6545F, 0.0F, 0.0F));
		ModelPartData tail = gulper_eel.addChild("tail", ModelPartBuilder.create().uv(37, 16).cuboid(-1.5F, -1.5F, -0.25F, 3.0F, 3.0F, 9.0F, new Dilation(0.0F))
			.uv(0, 0).cuboid(0.0F, -2.0F, 6.75F, 0.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -6.4F, 3.25F));
		ModelPartData tail2 = tail.addChild("tail2", ModelPartBuilder.create().uv(36, 37).cuboid(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 9.0F, new Dilation(0.0F))
			.uv(23, 46).cuboid(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 8.75F));
		ModelPartData tail3 = tail2.addChild("tail3", ModelPartBuilder.create().uv(36, 37).cuboid(0.0F, -8.25F, 0.0F, 0.0F, 4.0F, 9.0F, new Dilation(0.0F))
			.uv(37, 52).cuboid(-1.0F, -7.25F, 0.0F, 2.0F, 2.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.25F, 9.0F));
		ModelPartData tail4 = tail3.addChild("tail4", ModelPartBuilder.create().uv(37, 0).cuboid(-1.0F, -7.25F, 0.0F, 2.0F, 2.0F, 11.0F, new Dilation(0.0F))
			.uv(0, 29).cuboid(0.0F, -8.25F, 0.0F, 0.0F, 4.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 9.0F));

		return TexturedModelData.of(modelData, 128, 128);
	}

	@Override
	public ModelPart getPart() {
		return main;
	}

	@Override
	public void setAngles(GulperEelEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
//		main.pivotX =

		this.getPart().traverse().forEach(ModelPart::resetTransform);

		this.updateAnimation(entity.swimAnimationState, GulperEelAnimations.GULPER_EEL_SWIM, ageInTicks, 1f);
		this.updateAnimation(entity.attackAnimationState, GulperEelAnimations.GULPER_EEL_BITE, ageInTicks, 1f);
	}
}
