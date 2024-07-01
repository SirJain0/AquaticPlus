package sirjain.aquaticplus.client.entity.models;

import sirjain.aquaticplus.entity.entities.PikeEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class PikeModel extends EntityModel<PikeEntity> {
	private final ModelPart root;
	private final ModelPart pike;
	private final ModelPart head;
	private final ModelPart topJaw;
	private final ModelPart bottomJaw;
	private final ModelPart body;
	private final ModelPart tail1;
	private final ModelPart tail2;

	public PikeModel(ModelPart part) {
		root = part;
		pike = root.getChild("pike");
		head = pike.getChild("head");
		bottomJaw = head.getChild("bottom_jaw");
		topJaw = head.getChild("top_jaw");
		body = pike.getChild("body2");
		tail1 = body.getChild("tail");
		tail2 = tail1.getChild("tail2");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData pike = modelPartData.addChild("pike", ModelPartBuilder.create().uv(0, 21).cuboid(-4.0F, -5.2696F, -5.1667F, 8.0F, 7.0F, 13.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 22.2696F, -8.3333F));
		ModelPartData cube_r1 = pike.addChild("cube_r1", ModelPartBuilder.create().uv(37, 47).mirrored().cuboid(-5.0F, 0.0F, -2.5F, 5.0F, 0.0F, 5.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-2.75F, -0.2696F, -0.6667F, 0.0F, 0.0F, -0.48F));
		ModelPartData cube_r2 = pike.addChild("cube_r2", ModelPartBuilder.create().uv(37, 47).cuboid(0.0F, 0.0F, -2.5F, 5.0F, 0.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(2.75F, -0.2696F, -0.6667F, 0.0F, 0.0F, 0.48F));
		ModelPartData body2 = pike.addChild("body2", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -4.5617F, 0.05F, 8.0F, 7.0F, 14.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.7078F, 7.7833F));
		ModelPartData cube_r3 = body2.addChild("cube_r3", ModelPartBuilder.create().uv(37, 47).cuboid(0.0F, 0.0F, -2.5F, 5.0F, 0.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(2.75F, 0.4383F, 2.55F, 0.0F, 0.0F, 0.48F));
		ModelPartData cube_r4 = body2.addChild("cube_r4", ModelPartBuilder.create().uv(37, 47).mirrored().cuboid(-5.0F, 0.0F, -2.5F, 5.0F, 0.0F, 5.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-2.75F, 0.4383F, 2.55F, 0.0F, 0.0F, -0.48F));
		ModelPartData cube_r5 = body2.addChild("cube_r5", ModelPartBuilder.create().uv(16, 33).cuboid(0.0F, -3.5F, -4.0F, 0.0F, 7.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.9383F, 12.05F, 0.0F, 0.0F, -3.1416F));
		ModelPartData cube_r6 = body2.addChild("cube_r6", ModelPartBuilder.create().uv(16, 33).cuboid(0.0F, -3.5F, -4.0F, 0.0F, 7.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -5.0617F, 12.05F, 0.0F, 0.0F, 0.0F));
		ModelPartData tail = body2.addChild("tail", ModelPartBuilder.create().uv(30, 0).cuboid(-2.0F, -2.5F, 0.0F, 4.0F, 5.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.0617F, 14.05F));
		ModelPartData tail2 = tail.addChild("tail2", ModelPartBuilder.create().uv(29, 10).cuboid(0.0F, -5.5F, -2.0F, 0.0F, 11.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 7.0F));
		ModelPartData head = pike.addChild("head", ModelPartBuilder.create().uv(35, 34).cuboid(-1.0F, -5.0F, -6.0F, 6.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 0.7304F, -6.1667F));
		ModelPartData top_jaw = head.addChild("top_jaw", ModelPartBuilder.create().uv(44, 25).cuboid(0.0F, -4.0F, -13.0F, 4.0F, 2.0F, 7.0F, new Dilation(0.2F)), ModelTransform.pivot(0.0F, 0.75F, 0.0F));
		ModelPartData bottom_jaw = head.addChild("bottom_jaw", ModelPartBuilder.create().uv(47, 0).cuboid(0.0F, -4.0F, -13.0F, 4.0F, 1.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 2.25F, 0.0F));

		return TexturedModelData.of(modelData, 128, 128);
	}

	@Override
	public void setAngles(PikeEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		body.yaw = MathHelper.cos(animationProgress * 0.14f) * 0.2f;
		tail1.yaw = MathHelper.cos(-20 + animationProgress * 0.14f) * 0.3f;
		tail2.yaw = MathHelper.cos(-40 + animationProgress * 0.14f) * 0.3f;
		head.yaw = -(MathHelper.cos(animationProgress * 0.14f) * 0.1f);
		root.pivotX = -(MathHelper.cos(animationProgress * 0.14f) * 0.9f);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}
}
