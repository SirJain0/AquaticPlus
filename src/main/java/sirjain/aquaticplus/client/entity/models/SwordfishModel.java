package sirjain.aquaticplus.client.entity.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import sirjain.aquaticplus.entity.entities.SwordfishEntity;

public class SwordfishModel extends EntityModel<SwordfishEntity> {
	private final ModelPart swordfish;
	private final ModelPart root;
	private final ModelPart saddle;
	private final ModelPart head;
	private final ModelPart tail;
	private final ModelPart tail2;
	private final ModelPart leftFin;
	private final ModelPart rightFin;

	public SwordfishModel(ModelPart part) {
		this.root = part;
		this.swordfish = root.getChild("swordfish");
		this.saddle = swordfish.getChild("saddle");
		this.head = swordfish.getChild("head");
		this.tail = swordfish.getChild("tail");
		this.tail2 = tail.getChild("tail_fin");
		this.leftFin = swordfish.getChild("left_fin");
		this.rightFin = swordfish.getChild("right_fin");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData swordfish = modelPartData.addChild("swordfish", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0917F, -2.9692F, -8.9714F, 6.0F, 6.0F, 17.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.0675F, 20.9692F, 1.3414F));
		ModelPartData body_r1 = swordfish.addChild("body_r1", ModelPartBuilder.create().uv(20, 27).cuboid(-0.12F, -3.24F, -1.76F, 1.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-0.3017F, 4.518F, 5.565F, 0.6545F, 0.0F, 0.0F));
		ModelPartData body_r2 = swordfish.addChild("body_r2", ModelPartBuilder.create().uv(38, 35).cuboid(-1.19F, -2.16F, -1.76F, 1.0F, 7.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.7033F, -5.3292F, -3.8114F, -0.6545F, 0.0F, 0.0F));
		ModelPartData saddle = swordfish.addChild("saddle", ModelPartBuilder.create().uv(79, 1).cuboid(-3.504F, -6.024F, -5.386F, 6.0F, 6.0F, 17.0F, new Dilation(0.2F)), ModelTransform.pivot(0.3883F, 3.0308F, -3.6914F));
		ModelPartData head = swordfish.addChild("head", ModelPartBuilder.create().uv(0, 23).cuboid(-0.45F, -0.645F, -19.98F, 1.0F, 1.0F, 18.0F, new Dilation(0.0F))
			.uv(0, 23).cuboid(-2.05F, -1.855F, -4.02F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0283F, 0.0058F, -8.8514F));
		ModelPartData tail = swordfish.addChild("tail", ModelPartBuilder.create().uv(34, 23).cuboid(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.1017F, 0.0908F, 7.6286F));
		ModelPartData tail_fin = tail.addChild("tail_fin", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -6.5F, 0.0F, 1.0F, 13.0F, 4.0F, new Dilation(0.0F))
			.uv(10, 6).cuboid(-0.5F, -6.5F, 4.0F, 1.0F, 4.0F, 2.0F, new Dilation(0.0F))
			.uv(10, 0).cuboid(-0.5F, 2.5F, 4.0F, 1.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.12F, -0.1F, 4.52F));
		ModelPartData left_fin = swordfish.addChild("left_fin", ModelPartBuilder.create().uv(29, 0).cuboid(-0.12F, -4.0717F, -4.3295F, 1.0F, 3.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(3.0283F, 1.2708F, -1.9314F, 0.9599F, 0.0F, 2.0944F));
		ModelPartData right_fin = swordfish.addChild("right_fin", ModelPartBuilder.create().uv(29, 0).mirrored().cuboid(-0.88F, -4.0717F, -4.3295F, 1.0F, 3.0F, 9.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-2.8933F, 1.2708F, -1.9314F, 0.9599F, 0.0F, -2.0944F));

		return TexturedModelData.of(modelData, 128, 128);
	}

	@Override
	public void setAngles(SwordfishEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		saddle.visible = entity.isSaddled();

		tail.yaw = MathHelper.cos(animationProgress * 0.2f) * 0.2f;
		tail2.yaw = MathHelper.cos(-20 + animationProgress * 0.2f) * 0.27f;
		head.yaw = -(MathHelper.cos(animationProgress * 0.2f) * 0.1f);
		root.pivotX = -(MathHelper.cos(animationProgress * 0.2f));
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}
}
