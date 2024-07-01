package sirjain.aquaticplus.client.entity.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import sirjain.aquaticplus.entity.entities.ViperfishEntity;

public class ViperfishModel extends EntityModel<ViperfishEntity> {
	private final ModelPart root;
	private final ModelPart main;
	private final ModelPart body;
	private final ModelPart body2;
	private final ModelPart body3;
	private final ModelPart head;
	private final ModelPart lowerJaw;

	public ViperfishModel(ModelPart part) {
		root = part;
		main = root.getChild("viperfish");
		body = main.getChild("body");
		body2 = body.getChild("body_2");
		body3 = body2.getChild("body_3");
		head = main.getChild("head");
		lowerJaw = head.getChild("lower_jaw");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData viperfish = modelPartData.addChild("viperfish", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		ModelPartData body = viperfish.addChild("body", ModelPartBuilder.create().uv(0, 27).cuboid(-2.0F, -3.2235F, -1.125F, 4.0F, 5.0F, 10.0F, new Dilation(0.0F))
			.uv(18, 20).cuboid(0.0F, -8.2235F, 0.875F, 0.0F, 6.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -5.7765F, -13.125F));
		ModelPartData cube_r1 = body.addChild("cube_r1", ModelPartBuilder.create().uv(26, 12).mirrored().cuboid(-7.0F, 0.0F, -2.0F, 7.0F, 0.0F, 6.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-2.0F, 1.7765F, 2.875F, 0.0F, 0.0F, -0.3491F));
		ModelPartData cube_r2 = body.addChild("cube_r2", ModelPartBuilder.create().uv(26, 12).cuboid(0.0F, 0.0F, -2.0F, 7.0F, 0.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 1.7765F, 2.875F, 0.0F, 0.0F, 0.3491F));
		ModelPartData body_2 = body.addChild("body_2", ModelPartBuilder.create().uv(13, 11).cuboid(-2.0F, -0.75F, 0.0F, 4.0F, 5.0F, 11.0F, new Dilation(0.0F))
			.uv(18, 26).cuboid(0.0F, -3.75F, 4.0F, 0.0F, 4.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.4735F, 8.875F));
		ModelPartData body_3 = body_2.addChild("body_3", ModelPartBuilder.create().uv(28, 27).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 11.0F, new Dilation(0.0F))
			.uv(0, 0).cuboid(0.0F, -5.0F, 4.0F, 0.0F, 10.0F, 12.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 2.0F, 11.0F));
		ModelPartData head = viperfish.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -2.0F, -6.0F, 6.0F, 4.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -7.5F, -13.25F));
		ModelPartData lower_jaw = head.addChild("lower_jaw", ModelPartBuilder.create().uv(32, 0).cuboid(-3.5F, -2.5F, -6.5F, 7.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.5F, 0.075F, 0.1745F, 0.0F, 0.0F));

		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(ViperfishEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		body.yaw = MathHelper.cos(animationProgress * 0.2f) * 0.2f;
		body2.yaw = MathHelper.cos(-20 + animationProgress * 0.2f) * 0.25f;
		body3.yaw = MathHelper.cos(-40 + animationProgress * 0.2f) * 0.28f;
		head.yaw = -(MathHelper.cos(animationProgress * 0.2f) * 0.1f);
		main.pivotX = -(MathHelper.cos(animationProgress * 0.2f) * 0.87f);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}
}
