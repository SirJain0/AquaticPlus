package sirjain.aquaticplus.client.entity.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import sirjain.aquaticplus.entity.entities.ShadowSardelEntity;

public class ShadowSardelModel extends EntityModel<ShadowSardelEntity> {
	private final ModelPart main;
	private final ModelPart body;
	private final ModelPart backFin;
	private final ModelPart topFin;
	private final ModelPart head;

	public ShadowSardelModel(ModelPart part) {
		main = part;
		body = main.getChild("body");
		backFin = body.getChild("back_fin");
		topFin = body.getChild("top_fin");
		head = body.getChild("head");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -2.5F, -5.0F, 4.0F, 5.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 20.5F, 0.0F));
		ModelPartData back_fin = body.addChild("back_fin", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -4.0F, 0.0F, 0.0F, 7.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.5F, 5.0F));
		ModelPartData top_fin = body.addChild("top_fin", ModelPartBuilder.create().uv(0, 7).cuboid(0.0F, -3.0F, -4.0F, 0.0F, 3.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.5F, 0.0F));
		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(13, 15).cuboid(-1.5F, -1.5F, -3.0F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.5F, -5.0F));

		return TexturedModelData.of(modelData, 32, 32);
	}

	@Override
	public void setAngles(ShadowSardelEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		backFin.yaw = -MathHelper.sin(-40 + animationProgress * 0.5f) * 0.58f;
		head.yaw = -MathHelper.sin(animationProgress * 0.5f) * 0.22f;
		body.pivotX = -MathHelper.sin(animationProgress * 0.5f) * 0.58f;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		main.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}
}
