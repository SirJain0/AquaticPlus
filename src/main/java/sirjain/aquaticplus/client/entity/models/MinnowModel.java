package sirjain.aquaticplus.client.entity.models;

import sirjain.aquaticplus.entity.entities.MinnowEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class MinnowModel extends EntityModel<MinnowEntity> {
	private final ModelPart root;
	private final ModelPart minnow;
	private final ModelPart tail;
	private final ModelPart tail2;

	public MinnowModel(ModelPart part) {
		root = part;
		minnow = root.getChild("minnow");
		tail = minnow.getChild("tail1");
		tail2 = tail.getChild("tail2");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData minnow = modelPartData.addChild("minnow", ModelPartBuilder.create().uv(0, 0).cuboid(-1.5F, -0.5994F, -5.7992F, 3.0F, 5.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 18.8494F, -5.4508F, 0.0F, 0.0873F, 0.0F));
		ModelPartData cube_r1 = minnow.addChild("cube_r1", ModelPartBuilder.create().uv(0, 12).cuboid(0.0F, -3.1224F, -5.4491F, 0.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 4.3546F, 4.7957F, 0.48F, 0.0F, 0.0F));
		ModelPartData cube_r2 = minnow.addChild("cube_r2", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -3.0F, -0.75F, 0.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.8494F, 3.4508F, -0.6414F, 0.0F, 0.0F));
		ModelPartData tail1 = minnow.addChild("tail1", ModelPartBuilder.create().uv(0, 16).cuboid(-1.0F, -4.0F, 0.0F, 2.0F, 3.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 4.4006F, 5.2008F, 0.0F, 0.3054F, 0.0F));
		ModelPartData cube_r3 = tail1.addChild("cube_r3", ModelPartBuilder.create().uv(0, 16).cuboid(0.0F, -0.8776F, 1.4491F, 0.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.454F, -0.4052F, 0.48F, 0.0F, 0.0F));
		ModelPartData tail2 = tail1.addChild("tail2", ModelPartBuilder.create().uv(12, 10).cuboid(0.0F, -4.0F, -1.75F, 0.0F, 8.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.5F, 7.75F, 0.0F, 0.6109F, 0.0F));

		return TexturedModelData.of(modelData, 32, 32);
	}

	@Override
	public void setAngles(MinnowEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		tail.yaw = MathHelper.sin(-40 + animationProgress * 0.4f) * 0.3f;
		tail2.yaw = MathHelper.sin(-80 + animationProgress * 0.4f) * 0.27f;
		minnow.pivotX = MathHelper.sin(animationProgress * 0.4f);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		minnow.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}
}
