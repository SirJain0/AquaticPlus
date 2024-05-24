package com.aquaticplus.entities.models;

import com.aquaticplus.entities.entity.KelpEelEntity;
import com.aquaticplus.entities.entity.RibbonEelEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class RibbonEelModel extends EntityModel<RibbonEelEntity> {
	private final ModelPart root;
	private final ModelPart main;
	private final ModelPart seg1;
	private final ModelPart seg2;
	private final ModelPart seg3;
	private final ModelPart seg4;

	public RibbonEelModel(ModelPart part) {
		root = part;
		main = root.getChild("ribbon_eel");
		seg1 = main.getChild("body_seg_1");
		seg2 = seg1.getChild("body_seg_2");
		seg3 = seg2.getChild("body_seg_3");
		seg4 = seg3.getChild("body_seg_4");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData ribbon_eel = modelPartData.addChild("ribbon_eel", ModelPartBuilder.create().uv(0, 0).cuboid(-1.5F, -2.6238F, -36.5141F, 3.0F, 5.0F, 4.0F, new Dilation(0.0F))
			.uv(0, 9).cuboid(-1.0F, -2.6268F, -40.5009F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F))
			.uv(20, 0).cuboid(-1.0F, 1.3743F, -40.5009F, 2.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 21.6137F, -1.7509F));

		ModelPartData body_seg_1 = ribbon_eel.addChild("body_seg_1", ModelPartBuilder.create().uv(18, 36).cuboid(-1.0F, -2.5F, 0.0F, 2.0F, 5.0F, 18.0F, new Dilation(0.0F))
			.uv(0, 27).cuboid(0.0F, -4.5F, 0.0F, 0.0F, 9.0F, 18.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.1238F, -32.4841F));

		ModelPartData body_seg_2 = body_seg_1.addChild("body_seg_2", ModelPartBuilder.create().uv(26, 13).cuboid(-1.0F, -2.5F, 0.0F, 2.0F, 5.0F, 18.0F, new Dilation(0.0F))
			.uv(0, 18).cuboid(0.0F, -4.5F, 0.0F, 0.0F, 9.0F, 18.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 18.0F));

		ModelPartData body_seg_3 = body_seg_2.addChild("body_seg_3", ModelPartBuilder.create().uv(26, 13).cuboid(-1.0F, -2.5F, 0.0F, 2.0F, 5.0F, 18.0F, new Dilation(0.0F))
			.uv(0, 18).cuboid(0.0F, -4.5F, 0.0F, 0.0F, 9.0F, 18.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 18.0F));

		ModelPartData body_seg_4 = body_seg_3.addChild("body_seg_4", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -4.5F, 0.0F, 0.0F, 9.0F, 22.0F, new Dilation(0.0F))
			.uv(0, 0).cuboid(-1.0F, -2.5F, 0.0F, 2.0F, 5.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 18.0F));
		return TexturedModelData.of(modelData, 128, 128);
	}

	@Override
	public void setAngles(RibbonEelEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		main.pivotX = -MathHelper.sin(animationProgress * 0.25f) * 6.3f;
		seg1.yaw = MathHelper.sin(-30 + animationProgress * 0.25f) * 0.3f;
		seg2.yaw = -MathHelper.sin(-60 + animationProgress * 0.25f) * 0.4f;
		seg3.yaw = MathHelper.sin(-90 + animationProgress * 0.25f) * 0.5f;
		seg4.yaw = MathHelper.sin(-110 + animationProgress * 0.25f) * 0.6f;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}
}
