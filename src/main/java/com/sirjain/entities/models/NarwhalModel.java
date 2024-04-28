package com.sirjain.entities.models;

import com.sirjain.entities.entity.NarwhalEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class NarwhalModel extends EntityModel<NarwhalEntity> {
	private final ModelPart root;
	private final ModelPart narwhal;
	private final ModelPart saddle;
	private final ModelPart head;
	private final ModelPart horn1;
	private final ModelPart horn2;

	public NarwhalModel(ModelPart part) {
		root = part;
		narwhal = root.getChild("narwhal");
		saddle = narwhal.getChild("saddle");
		head = narwhal.getChild("head");
		horn1 = head.getChild("horn1");
		horn2 = head.getChild("horn2");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData body = modelPartData.addChild("narwhal", ModelPartBuilder.create().uv(0, 28).cuboid(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 21.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, -3.0F));
		ModelPartData saddle = body.addChild("saddle", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -7.0F, -7.0F, 8.0F, 7.0F, 21.0F, new Dilation(0.2F)), ModelTransform.pivot(0.0F, 0.0F, 3.0F));
		ModelPartData head = body.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		ModelPartData horn1 = head.addChild("horn1", ModelPartBuilder.create().uv(37, 0).mirrored().cuboid(-2.75F, -4.25F, -8.0F, 2.0F, 2.0F, 14.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.25F, 0.0F, -10.0F));
		ModelPartData horn2 = head.addChild("horn2", ModelPartBuilder.create().uv(37, 0).cuboid(0.75F, -4.25F, -21.0F, 2.0F, 2.0F, 14.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 3.0F));
		ModelPartData tail = body.addChild("tail", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -3.0F, 3.0F, 4.0F, 5.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.5F, 14.0F));
		ModelPartData tail_fin = tail.addChild("tail_fin", ModelPartBuilder.create().uv(37, 28).cuboid(-5.0F, -1.0F, -1.0F, 10.0F, 1.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 9.0F));
		ModelPartData left_fin = body.addChild("left_fin", ModelPartBuilder.create().uv(0, 28).cuboid(0.0F, -5.6383F, -2.6472F, 1.0F, 4.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -2.0F, 5.0F, 0.9599F, 0.0F, 1.8675F));
		ModelPartData right_fin = body.addChild("right_fin", ModelPartBuilder.create().uv(0, 28).mirrored().cuboid(-1.0F, -5.6383F, -2.6472F, 1.0F, 4.0F, 7.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-3.0F, -2.0F, 5.0F, 0.9599F, 0.0F, -1.8675F));

		return TexturedModelData.of(modelData, 128, 128);
	}

	@Override
	public void setAngles(NarwhalEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		saddle.visible = entity.isSaddled();
		horn2.visible = entity.isDoubleTusked();
		horn1.pivotX = !entity.isDoubleTusked() ? 1.75f : 0.25f;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}
}
