package sirjain.aquaticplus.client.entity.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import sirjain.aquaticplus.entity.entities.ShadowSardelEasterEggEntity;

public class JohnsonModel extends EntityModel<ShadowSardelEasterEggEntity> {
	private final ModelPart root;
	private final ModelPart johnson;
	private final ModelPart tailConnector;
	private final ModelPart tail1;
	private final ModelPart tail2;
	private final ModelPart head;

	public JohnsonModel(ModelPart part) {
		this.root = part;
		this.johnson = root.getChild("johnson");
		this.head = johnson.getChild("head");
		this.tailConnector = johnson.getChild("tail");
		this.tail1 = tailConnector.getChild("tail1");
		this.tail2 = tailConnector.getChild("tail2");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData johnson = modelPartData.addChild("johnson", ModelPartBuilder.create().uv(0, 9).cuboid(-2.5F, -0.5F, -4.0F, 5.0F, 5.0F, 8.0F, new Dilation(0.0F))
			.uv(0, 0).cuboid(0.0F, -3.5F, -2.0F, 0.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.5F, 19.5F, 0.0F));
		ModelPartData head = johnson.addChild("head", ModelPartBuilder.create().uv(0, 7).cuboid(1.4167F, -2.0691F, -3.5403F, 1.0F, 3.0F, 3.0F, new Dilation(0.0F))
			.uv(18, 22).cuboid(-2.0833F, -1.3191F, -4.0403F, 4.0F, 3.0F, 4.0F, new Dilation(0.0F))
			.uv(26, 13).cuboid(-2.0833F, 1.4309F, -4.0403F, 4.0F, 1.0F, 4.0F, new Dilation(-0.1F))
			.uv(0, 0).cuboid(-4.0833F, 0.6809F, -9.0403F, 8.0F, 0.0F, 9.0F, new Dilation(0.0F))
			.uv(0, 7).mirrored().cuboid(-2.5833F, -2.0691F, -3.5403F, 1.0F, 3.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0833F, 2.0691F, -3.9597F));
		ModelPartData cube_r1 = head.addChild("cube_r1", ModelPartBuilder.create().uv(16, 29).cuboid(-1.5F, -1.0F, -0.5F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.4167F, -2.3191F, -2.5403F, -0.4363F, 0.0F, 0.0F));
		ModelPartData tail = johnson.addChild("tail", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -5.25F, 0.5F, 0.0F, 3.0F, 4.0F, new Dilation(0.0F))
			.uv(18, 1).cuboid(-2.0F, -2.25F, 0.0F, 4.0F, 4.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 2.25F, 4.0F));
		ModelPartData tail1 = tail.addChild("tail1", ModelPartBuilder.create().uv(0, 13).cuboid(0.0F, -4.0F, -1.5F, 0.0F, 8.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, -0.25F, 6.5F));
		ModelPartData tail2 = tail.addChild("tail2", ModelPartBuilder.create().uv(0, 13).mirrored().cuboid(0.0F, -4.0F, -1.5F, 0.0F, 8.0F, 9.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-1.0F, -0.25F, 6.5F));

		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}

	@Override
	public void setAngles(ShadowSardelEasterEggEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		head.yaw = -MathHelper.sin(-20 + animationProgress * 0.25f) * 0.15f;
		johnson.pivotX = -MathHelper.sin(animationProgress * 0.25f) * 0.5f;
		tailConnector.yaw = -MathHelper.sin(30 + animationProgress * 0.25f) * 0.24f;
		tail1.yaw = -MathHelper.sin(55 + animationProgress * 0.25f) * 0.26f;
		tail2.yaw = -MathHelper.sin(53 + animationProgress * 0.25f) * 0.26f;
	}
}