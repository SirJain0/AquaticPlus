package sirjain.aquaticplus.client.entity.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import sirjain.aquaticplus.entity.entities.BluefinTunaEntity;

public class BluefinTunaModel extends EntityModel<BluefinTunaEntity> {
	private final ModelPart root;
	private final ModelPart tuna;
	private final ModelPart tail;
	private final ModelPart tail2;

	public BluefinTunaModel(ModelPart part) {
		root = part;
		tuna = root.getChild("bluefin_tuna");
		tail = tuna.getChild("tail");
		tail2 = tail.getChild("tail_2");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData bluefin_tuna = modelPartData.addChild("bluefin_tuna", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -3.8685F, -13.3608F, 4.0F, 8.0F, 14.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 16.3685F, 0.1108F));
		ModelPartData top_fin = bluefin_tuna.addChild("top_fin", ModelPartBuilder.create().uv(22, 18).cuboid(0.0F, -4.0F, -4.0F, 0.0F, 4.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.8685F, -3.6108F));
		ModelPartData bottom_fin = bluefin_tuna.addChild("bottom_fin", ModelPartBuilder.create().uv(22, 14).cuboid(0.0F, 0.0F, -4.0F, 0.0F, 4.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 4.1315F, -7.3608F));
		ModelPartData tail = bluefin_tuna.addChild("tail", ModelPartBuilder.create().uv(22, 0).cuboid(-0.5F, -1.6932F, 0.0747F, 1.0F, 4.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.1753F, 0.5644F));
		ModelPartData cube_r1 = tail.addChild("cube_r1", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, -2.5F, 0.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.3068F, 2.5747F, 0.4363F, 0.0F, 0.0F));
		ModelPartData cube_r2 = tail.addChild("cube_r2", ModelPartBuilder.create().uv(22, 26).cuboid(0.0F, -4.0F, -2.5F, 0.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.5182F, 1.0747F, -0.2618F, 0.0F, 0.0F));
		ModelPartData tail_2 = tail.addChild("tail_2", ModelPartBuilder.create().uv(0, 11).cuboid(0.0F, -6.0F, -3.5F, 0.0F, 12.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.3068F, 5.5747F));

		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(BluefinTunaEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		tail.yaw = MathHelper.sin(-40 + animationProgress * 0.4f) * 0.3f;
		tail2.yaw = MathHelper.sin(-80 + animationProgress * 0.4f) * 0.27f;
		root.pivotX = MathHelper.sin(animationProgress * 0.4f);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}
}
