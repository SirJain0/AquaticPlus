package com.aquaticplus.entities.models;

import com.aquaticplus.entities.entity.VermillionJellyEntity;
import com.aquaticplus.entities.entity.animation.VermillionJellyAnimations;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class VermillionJellyModel extends SinglePartEntityModel<VermillionJellyEntity> {
	private final ModelPart root;
	private final ModelPart vermillionJelly;
	private final ModelPart head;
	private final ModelPart headJelly;
	private final ModelPart shortTentacle1;
	private final ModelPart shortTentacle2;
	private final ModelPart shortTentacle3;
	private final ModelPart shortTentacle4;
	private final ModelPart longTentacle1;
	private final ModelPart longTentacle2;
	private final ModelPart longTentacle3;
	private final ModelPart longTentacle4;

	public VermillionJellyModel(ModelPart part) {
		this.root = part;
		this.vermillionJelly = root.getChild("vermillion_jelly");
		this.head = vermillionJelly.getChild("head");
		this.headJelly = head.getChild("head_jelly");
		this.shortTentacle1 = vermillionJelly.getChild("short_tentacle_1");
		this.shortTentacle2 = vermillionJelly.getChild("short_tentacle_2");
		this.shortTentacle3 = vermillionJelly.getChild("short_tentacle_3");
		this.shortTentacle4 = vermillionJelly.getChild("short_tentacle_4");
		this.longTentacle1 = vermillionJelly.getChild("long_tentacle_1");
		this.longTentacle2 = vermillionJelly.getChild("long_tentacle_2");
		this.longTentacle3 = vermillionJelly.getChild("long_tentacle_3");
		this.longTentacle4 = vermillionJelly.getChild("long_tentacle_4");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData vermillion_jelly = modelPartData.addChild("vermillion_jelly", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 22.0F, 0.0F));
		ModelPartData head = vermillion_jelly.addChild("head", ModelPartBuilder.create().uv(0, 17).cuboid(-5.0F, -6.0F, -5.0F, 10.0F, 6.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -8.0F, 0.0F));
		ModelPartData head_jelly = head.addChild("head_jelly", ModelPartBuilder.create().uv(0, 0).cuboid(-5.0F, -3.0F, -5.0F, 10.0F, 3.0F, 10.0F, new Dilation(0.5F)), ModelTransform.pivot(0.0F, 1.0F, 0.0F));
		ModelPartData short_tentacle_1 = vermillion_jelly.addChild("short_tentacle_1", ModelPartBuilder.create().uv(30, 0).cuboid(-1.0F, -0.25F, -1.0F, 2.0F, 6.0F, 2.0F, new Dilation(-0.2F)), ModelTransform.of(-3.25F, -7.75F, -3.25F, -3.1416F, -1.5708F, 3.1416F));
		ModelPartData short_tentacle_2 = vermillion_jelly.addChild("short_tentacle_2", ModelPartBuilder.create().uv(30, 0).cuboid(-1.0F, -0.25F, -1.0F, 2.0F, 6.0F, 2.0F, new Dilation(-0.2F)), ModelTransform.pivot(-3.25F, -7.75F, 3.25F));
		ModelPartData short_tentacle_3 = vermillion_jelly.addChild("short_tentacle_3", ModelPartBuilder.create().uv(30, 0).mirrored().cuboid(-1.0F, -0.25F, -1.0F, 2.0F, 6.0F, 2.0F, new Dilation(-0.2F)).mirrored(false), ModelTransform.pivot(3.25F, -7.75F, 3.25F));
		ModelPartData short_tentacle_4 = vermillion_jelly.addChild("short_tentacle_4", ModelPartBuilder.create().uv(30, 0).mirrored().cuboid(-1.0F, -0.25F, -1.0F, 2.0F, 6.0F, 2.0F, new Dilation(-0.2F)).mirrored(false), ModelTransform.of(3.25F, -7.75F, -3.25F, 0.0F, 1.5708F, 0.0F));
		ModelPartData long_tentacle_1 = vermillion_jelly.addChild("long_tentacle_1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -7.75F, -3.0F));
		ModelPartData cube_r1 = long_tentacle_1.addChild("cube_r1", ModelPartBuilder.create().uv(0, 33).cuboid(-4.0F, -3.5F, -1.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.5F, 3.0F, 0.0F, -1.5708F, 0.0F));
		ModelPartData long_tentacle_2 = vermillion_jelly.addChild("long_tentacle_2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -7.75F, 3.0F));
		ModelPartData cube_r2 = long_tentacle_2.addChild("cube_r2", ModelPartBuilder.create().uv(0, 33).cuboid(-4.0F, -3.5F, -1.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.5F, -3.0F, 0.0F, 1.5708F, 0.0F));
		ModelPartData long_tentacle_3 = vermillion_jelly.addChild("long_tentacle_3", ModelPartBuilder.create(), ModelTransform.of(3.0F, -7.75F, 0.0F, 0.0F, 1.5708F, 0.0F));
		ModelPartData cube_r3 = long_tentacle_3.addChild("cube_r3", ModelPartBuilder.create().uv(0, 33).cuboid(-1.0F, -3.5F, 2.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, 3.5F, 0.0F, 0.0F, 1.5708F, 0.0F));
		ModelPartData long_tentacle_4 = vermillion_jelly.addChild("long_tentacle_4", ModelPartBuilder.create(), ModelTransform.of(-3.0F, -7.75F, 0.0F, 0.0F, -1.5708F, 0.0F));
		ModelPartData cube_r4 = long_tentacle_4.addChild("cube_r4", ModelPartBuilder.create().uv(0, 33).mirrored().cuboid(-1.0F, -3.5F, 2.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(3.0F, 3.5F, 0.0F, 0.0F, -1.5708F, 0.0F));

		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		matrices.translate(0, 0.6f, 0);
		root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}

	@Override
	public ModelPart getPart() {
		return this.vermillionJelly;
	}

	@Override
	public void setAngles(VermillionJellyEntity entity, float limbAngle, float limbDistance, float animTime, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);

		// Animate the two tentacles (short 1 and 2)
		this.updateAnimation(entity.swimAnimationState, VermillionJellyAnimations.SWIM, animTime, 1f);
	}
}
