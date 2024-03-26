package com.sirjain.entities.models;

import com.sirjain.entities.entity.PinkSunfishEntity;
import com.sirjain.entities.entity.animation.DumboBlobAnimations;
import com.sirjain.entities.entity.animation.PinkSunfishAnimations;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class PinkSunfishModel extends SinglePartEntityModel<PinkSunfishEntity> {
	private final ModelPart root;
	private final ModelPart sunfish;
	private final ModelPart tail;
	private final ModelPart topFin;
	private final ModelPart bottomFin;

	public PinkSunfishModel(ModelPart part) {
		root = part;
		sunfish = root.getChild("sunfish");
		tail = sunfish.getChild("tail");
		topFin = sunfish.getChild("top_fin");
		bottomFin = sunfish.getChild("bottom_fin");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData sunfish = modelPartData.addChild("sunfish", ModelPartBuilder.create().uv(5, 0).mirrored().cuboid(2.0F, -7.0F, 7.0F, 3.0F, 0.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
			.uv(5, 0).cuboid(-5.0F, -7.0F, 7.0F, 3.0F, 0.0F, 4.0F, new Dilation(0.0F))
			.uv(0, 0).cuboid(-2.0F, -15.0F, -1.0F, 4.0F, 15.0F, 18.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 23.0F, -14.25F));
		ModelPartData tail = sunfish.addChild("tail", ModelPartBuilder.create().uv(20, 26).cuboid(0.0F, -8.5F, 0.0F, 0.0F, 17.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -7.5F, 17.0F));
		ModelPartData bottom_fin = sunfish.addChild("bottom_fin", ModelPartBuilder.create().uv(0, 33).cuboid(-1.0F, -0.5F, -4.0F, 2.0F, 11.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.5F, 12.0F));
		ModelPartData top_fin = sunfish.addChild("top_fin", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -10.0F, -2.5F, 2.0F, 10.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -15.0F, 12.5F));

		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public ModelPart getPart() {
		return sunfish;
	}

	@Override
	public void setAngles(PinkSunfishEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);

		this.animateMovement(PinkSunfishAnimations.PINK_SUNFISH_SWIM, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.swimAnimationState, PinkSunfishAnimations.PINK_SUNFISH_SWIM, ageInTicks, 1f);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}
}