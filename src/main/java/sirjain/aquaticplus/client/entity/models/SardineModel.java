package sirjain.aquaticplus.client.entity.models;

import sirjain.aquaticplus.entity.entities.SardineEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class SardineModel extends EntityModel<SardineEntity> {
	private final ModelPart root;
	private final ModelPart sardine;
	private final ModelPart tail;
	private final ModelPart tail2;

	public SardineModel(ModelPart part) {
		root = part;
		sardine = root.getChild("sardine");
		tail = sardine.getChild("tail1");
		tail2 = tail.getChild("tail2");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData sardine = modelPartData.addChild("sardine", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -0.5994F, -5.7992F, 4.0F, 5.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 18.8494F, -5.4508F));
		ModelPartData cube_r1 = sardine.addChild("cube_r1", ModelPartBuilder.create().uv(18, 17).cuboid(0.0F, -3.0F, -3.5F, 0.0F, 4.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0994F, -0.2992F, -0.6414F, 0.0F, 0.0F));
		ModelPartData tail1 = sardine.addChild("tail1", ModelPartBuilder.create().uv(0, 16).cuboid(-1.0F, -4.5F, 0.0F, 2.0F, 4.0F, 7.0F, new Dilation(0.0F))
			.uv(20, -6).cuboid(0.0F, -1.5F, -2.0F, 0.0F, 3.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 4.4006F, 5.2008F));
		ModelPartData tail2 = tail1.addChild("tail2", ModelPartBuilder.create().uv(18, 10).cuboid(0.0F, -4.0F, -1.0F, 0.0F, 8.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.5F, 5.0F));

		return TexturedModelData.of(modelData, 32, 32);
	}

	@Override
	public void setAngles(SardineEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		tail.yaw = MathHelper.sin(-40 + animationProgress * 0.4f) * 0.3f;
		tail2.yaw = MathHelper.sin(-80 + animationProgress * 0.4f) * 0.27f;
		root.pivotX = MathHelper.sin(animationProgress * 0.4f);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		sardine.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}
}
