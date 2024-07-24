package sirjain.aquaticplus.client.entity.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import sirjain.aquaticplus.entity.entities.ShadowSardelEasterEggEntity;

public class MindinatorModel extends EntityModel<ShadowSardelEasterEggEntity> {
	private final ModelPart main;
	private final ModelPart body;
	private final ModelPart tail;
	private final ModelPart tail2;
	private final ModelPart head;

	public MindinatorModel(ModelPart part) {
		main = part;
		body = main.getChild("mindinator");
		tail = body.getChild("tail");
		tail2 = tail.getChild("tail2");
		head = body.getChild("head");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bone = modelPartData.addChild("mindinator", ModelPartBuilder.create().uv(0, 0).cuboid(-3.8235F, -1.8529F, -5.8824F, 8.0F, 6.0F, 10.0F, new Dilation(0.0F))
			.uv(0, 23).cuboid(-2.8235F, -0.3529F, -4.8824F, 6.0F, 4.0F, 7.0F, new Dilation(0.0F))
			.uv(18, 32).cuboid(-3.0735F, -3.3529F, -3.8824F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F))
			.uv(10, 32).cuboid(1.1765F, -3.3529F, -0.8824F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F))
			.uv(18, 30).cuboid(3.1765F, -3.3529F, -3.8824F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F))
			.uv(10, 30).cuboid(-0.0735F, -3.3529F, -4.8824F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F))
			.uv(19, 21).cuboid(-1.3235F, -3.3529F, -0.8824F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.1765F, 20.8529F, 0.8824F));

		ModelPartData tail = bone.addChild("tail", ModelPartBuilder.create().uv(26, 0).cuboid(-3.0F, -2.3333F, 0.0F, 6.0F, 4.0F, 6.0F, new Dilation(0.0F))
			.uv(0, 4).cuboid(1.25F, -3.8333F, 1.0F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F))
			.uv(19, 19).cuboid(-1.25F, -3.8333F, 1.0F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.1765F, 1.4804F, 4.1176F));

		ModelPartData tail2 = tail.addChild("tail2", ModelPartBuilder.create().uv(0, 16).cuboid(-8.0F, -1.0F, -0.3333F, 16.0F, 2.0F, 5.0F, new Dilation(0.0F))
			.uv(0, 0).cuboid(7.25F, -2.5F, 1.4167F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F))
			.uv(0, 2).cuboid(-7.25F, -2.5F, 1.4167F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.3333F, 5.3333F));

		ModelPartData head = bone.addChild("head", ModelPartBuilder.create().uv(26, 23).cuboid(-2.5F, -2.625F, -4.875F, 5.0F, 5.0F, 5.0F, new Dilation(0.0F))
			.uv(19, 33).cuboid(-1.5F, -0.625F, -11.875F, 3.0F, 2.0F, 7.0F, new Dilation(0.0F))
			.uv(0, 34).cuboid(-1.5F, 1.375F, -11.875F, 3.0F, 1.0F, 4.0F, new Dilation(0.0F))
			.uv(32, 33).cuboid(-1.0F, 1.375F, -9.875F, 2.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.3235F, 1.5221F, -6.0074F));
		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(ShadowSardelEasterEggEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		tail.pitch = MathHelper.sin(-20 + animationProgress * 0.2f) * 0.4f;
		tail2.pitch = MathHelper.sin(-40 + animationProgress * 0.2f) * 0.4f;
		head.yaw = -MathHelper.sin(animationProgress * 0.2f) * 0.15f;
		body.pivotY = -MathHelper.sin(animationProgress * 0.2f) * 0.5f;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		main.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}
}
