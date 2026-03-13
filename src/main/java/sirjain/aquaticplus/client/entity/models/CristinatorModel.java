package sirjain.aquaticplus.client.entity.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import sirjain.aquaticplus.entity.entities.ShadowSardelEasterEggEntity;

public class CristinatorModel extends EntityModel<ShadowSardelEasterEggEntity> {
	private final ModelPart root;
	private final ModelPart cristinator;
	private final ModelPart tail;
	private final ModelPart tail2;
	private final ModelPart head;

	public CristinatorModel(ModelPart part) {
		this.root = part;
		this.cristinator = root.getChild("cristinator");
		this.head = cristinator.getChild("head");
		this.tail = cristinator.getChild("tail");
		this.tail2 = tail.getChild("tail2");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData cristinator = modelPartData.addChild("cristinator", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		ModelPartData body = cristinator.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -6.0F, -1.0F, 7.0F, 6.0F, 9.0F, new Dilation(0.0F))
			.uv(48, 29).cuboid(-2.0F, -7.675F, 0.0F, 3.0F, 2.0F, 3.0F, new Dilation(0.0F))
			.uv(48, 34).cuboid(-1.0F, -7.675F, 4.0F, 3.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		ModelPartData tail = cristinator.addChild("tail", ModelPartBuilder.create().uv(0, 53).cuboid(-1.0F, -4.0F, 5.0F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F))
			.uv(12, 48).cuboid(-2.0F, -4.0F, 1.0F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F))
			.uv(0, 15).cuboid(-3.0F, -2.325F, 0.0F, 5.0F, 4.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.675F, 8.0F));
		ModelPartData tail2 = tail.addChild("tail2", ModelPartBuilder.create().uv(0, 29).cuboid(0.0F, -4.0F, -0.5F, 0.0F, 8.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, -0.325F, 9.5F));
		ModelPartData head = cristinator.addChild("head", ModelPartBuilder.create().uv(46, 43).cuboid(-2.5F, -2.5F, -6.0F, 5.0F, 5.0F, 6.0F, new Dilation(0.0F))
			.uv(0, 48).cuboid(-1.5F, -4.175F, -5.0F, 3.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.5F, -2.5F, -1.0F));
		ModelPartData jaw = head.addChild("jaw", ModelPartBuilder.create().uv(30, 15).cuboid(-1.0F, -2.0F, -10.0F, 2.0F, 4.0F, 10.0F, new Dilation(0.0F))
			.uv(22, 29).cuboid(-4.0F, -2.0F, -10.0F, 3.0F, 4.0F, 10.0F, new Dilation(-0.01F)), ModelTransform.of(1.0F, 0.0F, -6.0F, 0.0F, -0.3054F, 0.0F));
		ModelPartData jaw2 = head.addChild("jaw2", ModelPartBuilder.create().uv(30, 15).mirrored().cuboid(-1.0F, -2.0F, -10.0F, 2.0F, 4.0F, 10.0F, new Dilation(0.0F)).mirrored(false)
			.uv(22, 29).mirrored().cuboid(1.0F, -2.0F, -10.0F, 3.0F, 4.0F, 10.0F, new Dilation(-0.01F)).mirrored(false), ModelTransform.of(-1.0F, 0.0F, -6.0F, 0.0F, 0.3054F, 0.0F));

		return TexturedModelData.of(modelData, 128, 128);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}

	@Override
	public void setAngles(ShadowSardelEasterEggEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		head.yaw = -MathHelper.sin(-20 + animationProgress * 0.25f) * 0.1f;
		cristinator.pivotX = -MathHelper.sin(animationProgress * 0.25f) * 0.5f;
		tail.yaw = -MathHelper.sin(30 + animationProgress * 0.25f) * 0.16f;
		tail2.yaw = -MathHelper.sin(55 + animationProgress * 0.25f) * 0.26f;
	}
}