package sirjain.aquaticplus.client.entity.models;

import sirjain.aquaticplus.entity.entities.MaxillaMortisEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class MaxillaMortisModel extends EntityModel<MaxillaMortisEntity> {
	private final ModelPart root;
	private final ModelPart main;
	private final ModelPart head;
	private final ModelPart upperJaw;
	private final ModelPart lowerJaw;
	private final ModelPart tailSeg1;
	private final ModelPart tailSeg2;
	private final ModelPart tailSeg3;

	public MaxillaMortisModel(ModelPart part) {
		root = part;
		main = root.getChild("main");

		head = main.getChild("head");
		upperJaw = head.getChild("jaw_upper");
		lowerJaw = head.getChild("jaw_lower");

		tailSeg1 = main.getChild("tail_1");
		tailSeg2 = tailSeg1.getChild("tail_2");
		tailSeg3 = tailSeg2.getChild("tail_3");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData main = modelPartData.addChild("main", ModelPartBuilder.create().uv(0, 0).cuboid(-4.1F, -5.0555F, -10.2096F, 8.0F, 10.0F, 21.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 18.1965F, -9.0037F));
		ModelPartData upper_fin_r1 = main.addChild("upper_fin_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-1.6F, -9.1F, -2.6F, 3.0F, 13.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -5.4555F, -2.4096F, -0.7854F, 0.0F, 0.0F));
		ModelPartData side_fin_r_r1 = main.addChild("side_fin_r_r1", ModelPartBuilder.create().uv(37, 0).mirrored().cuboid(-9.0F, 0.3F, -7.8F, 9.0F, 1.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-3.9F, 2.3445F, 0.1904F, 0.0F, 0.0F, -0.1745F));
		ModelPartData side_fin_l_r1 = main.addChild("side_fin_l_r1", ModelPartBuilder.create().uv(37, 0).cuboid(0.1F, 0.3F, -7.8F, 9.0F, 1.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(3.9F, 2.3445F, 0.1904F, 0.0F, 0.0F, 0.1745F));
		ModelPartData head = main.addChild("head", ModelPartBuilder.create().uv(55, 38).cuboid(-3.75F, -4.1F, -7.7675F, 7.0F, 8.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.3945F, -10.2096F, 0.0F, -0.2182F, 0.0F));
		ModelPartData jaw_upper = head.addChild("jaw_upper", ModelPartBuilder.create().uv(0, 57).cuboid(-2.4F, -2.3596F, -5.6713F, 5.0F, 4.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.65F, -8.45F, -1.0472F, 0.0F, 0.0F));
		ModelPartData jaw_lower = head.addChild("jaw_lower", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.65F, -8.45F, 0.8727F, 0.0F, 0.0F));
		ModelPartData cube_r1 = jaw_lower.addChild("cube_r1", ModelPartBuilder.create().uv(0, 57).cuboid(-2.4F, -2.3239F, -5.6202F, 5.0F, 4.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 3.1416F));
		ModelPartData tail_1 = main.addChild("tail_1", ModelPartBuilder.create().uv(0, 31).cuboid(-2.4F, -4.1F, 0.0F, 5.0F, 8.0F, 18.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0695F, 10.5904F, 0.0F, 0.1745F, 0.0F));
		ModelPartData tail_2 = tail_1.addChild("tail_2", ModelPartBuilder.create().uv(32, 47).cuboid(-1.7F, -1.75F, 0.0F, 3.0F, 5.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.65F, 18.2F, 0.0F, 0.3927F, 0.0F));
		ModelPartData tail3 = tail_2.addChild("tail_3", ModelPartBuilder.create().uv(28, 13).cuboid(-0.1991F, -8.2F, -3.1458F, 0.0F, 16.0F, 18.0F, new Dilation(0.0F)), ModelTransform.of(-0.0304F, 0.65F, 10.7157F, 0.0F, 0.3491F, 0.0F));

		return TexturedModelData.of(modelData, 128, 128);
	}

	@Override
	public void setAngles(MaxillaMortisEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		tailSeg1.yaw = MathHelper.cos(animationProgress * 0.2f) * 0.25f;
		tailSeg2.yaw = MathHelper.cos(-20 + animationProgress * 0.2f) * 0.32f;
		tailSeg3.yaw = MathHelper.cos(-40 + animationProgress * 0.2f) * 0.34f;
		head.yaw = -(MathHelper.cos(animationProgress * 0.2f) * 0.12f);
		main.pivotX = -(MathHelper.cos(animationProgress * 0.2f) * 1.5f);

		if (entity.hasActiveTarget()) {
			upperJaw.pitch = -1;
			lowerJaw.pitch = 1;
		} else {
			upperJaw.pitch = -0.67f;
			lowerJaw.pitch = 0.67f;
		}
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		main.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.scale(1.3f, 1.3f, 1.3f);
		matrices.translate(0, 4, 0);
		matrices.pop();
	}
}
