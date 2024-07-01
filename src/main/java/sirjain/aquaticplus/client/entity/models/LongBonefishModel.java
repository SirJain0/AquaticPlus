package sirjain.aquaticplus.client.entity.models;

import sirjain.aquaticplus.entity.entities.LongBonefishEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class LongBonefishModel extends EntityModel<LongBonefishEntity> {
	private final ModelPart root;
	private final ModelPart main;
	private final ModelPart head;
	private final ModelPart finSeg1;
	private final ModelPart finSeg2;

	public LongBonefishModel(ModelPart part) {
		root = part;
		main = root.getChild("long_bonefish");
		head = main.getChild("head");
		finSeg1 = main.getChild("back_fin");
		finSeg2 = finSeg1.getChild("back_fin_2");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData long_bonefish = modelPartData.addChild("long_bonefish", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -2.5F, -4.5F, 6.0F, 5.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 20.5F, -1.75F));
		ModelPartData head = long_bonefish.addChild("head", ModelPartBuilder.create().uv(15, 18).cuboid(-2.0F, -2.0F, -5.0F, 4.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.25F, -4.5F));
		ModelPartData back_fin = long_bonefish.addChild("back_fin", ModelPartBuilder.create().uv(0, 14).cuboid(-2.0F, -1.5F, 0.0F, 4.0F, 3.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 4.5F));
		ModelPartData back_fin_2 = back_fin.addChild("back_fin_2", ModelPartBuilder.create().uv(14, 10).cuboid(0.0F, -3.5F, 0.0F, 0.0F, 2.0F, 6.0F, new Dilation(0.0F))
			.uv(14, 8).cuboid(0.0F, 1.5F, 0.0F, 0.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 3.0F));

		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(LongBonefishEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		main.pivotX = -MathHelper.sin(animationProgress * 0.25f) * 0.5f;
		finSeg1.yaw = -MathHelper.sin(30 + animationProgress * 0.25f) * 0.3f;
		finSeg2.yaw = -MathHelper.sin(55 + animationProgress * 0.25f) * 0.3f;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		main.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}
}
