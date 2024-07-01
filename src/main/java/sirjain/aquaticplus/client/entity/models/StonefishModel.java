package sirjain.aquaticplus.client.entity.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import sirjain.aquaticplus.entity.entities.StonefishEntity;

public class StonefishModel extends EntityModel<StonefishEntity> {
	private final ModelPart root;
	private final ModelPart stonefish;
	private final ModelPart head;
	private final ModelPart tail;
	private final ModelPart tail2;

	public StonefishModel(ModelPart part) {
		this.root = part;
		this.stonefish = root.getChild("stonefish");
		this.head = stonefish.getChild("head");
		this.tail = stonefish.getChild("tail");
		this.tail2 = tail.getChild("tail2");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData bone = modelPartData.addChild("stonefish", ModelPartBuilder.create().uv(0, 0).cuboid(-5.0F, -4.2917F, -8.375F, 10.0F, 10.0F, 16.0F, new Dilation(0.0F))
			.uv(0, 9).cuboid(0.0F, -8.2917F, -6.375F, 0.0F, 6.0F, 17.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 18.2917F, 1.375F));
		ModelPartData cube_r1 = bone.addChild("cube_r1", ModelPartBuilder.create().uv(0, 34).mirrored().cuboid(0.0F, -4.0F, -5.5F, 0.0F, 8.0F, 11.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-6.5F, 1.2083F, -5.875F, -0.7446F, -0.5956F, 1.024F));
		ModelPartData cube_r2 = bone.addChild("cube_r2", ModelPartBuilder.create().uv(0, 34).cuboid(0.0F, -4.0F, -5.5F, 0.0F, 8.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(6.5F, 1.2083F, -5.875F, -0.7446F, 0.5956F, -1.024F));
		ModelPartData head = bone.addChild("head", ModelPartBuilder.create().uv(36, 0).cuboid(-4.0F, -2.375F, -8.125F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
			.uv(0, 0).cuboid(2.0F, -3.375F, -6.125F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F))
			.uv(0, 0).mirrored().cuboid(-5.0F, -3.375F, -6.125F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, -0.4167F, -8.25F));
		ModelPartData cube_r3 = head.addChild("cube_r3", ModelPartBuilder.create().uv(22, 45).cuboid(-3.0F, -3.0F, -1.0F, 6.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.125F, -8.625F, 0.1178F, 0.0F, 0.0F));
		ModelPartData tail = bone.addChild("tail", ModelPartBuilder.create().uv(22, 26).cuboid(-3.0F, -3.1667F, 0.1667F, 6.0F, 7.0F, 12.0F, new Dilation(0.0F))
			.uv(0, 0).cuboid(0.0F, -8.1667F, 3.1667F, 0.0F, 6.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.875F, 7.4583F));
		ModelPartData cube_r4 = tail.addChild("cube_r4", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -3.0F, -3.5F, 0.0F, 6.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 4.8333F, 6.6667F, 0.0F, 0.0F, -3.1416F));
		ModelPartData tail2 = tail.addChild("tail2", ModelPartBuilder.create().uv(0, 21).cuboid(0.0F, -6.5F, -2.0F, 0.0F, 13.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.3333F, 12.1667F));

		return TexturedModelData.of(modelData, 128, 128);
	}

	@Override
	public void setAngles(StonefishEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		tail.yaw = MathHelper.cos(animationProgress * 0.2f) * 0.25f;
		tail2.yaw = MathHelper.cos(-20 + animationProgress * 0.2f) * 0.32f;
		head.yaw = -(MathHelper.cos(animationProgress * 0.2f) * 0.12f);
		stonefish.pivotX = -(MathHelper.cos(animationProgress * 0.2f) * 1.5f);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		matrices.scale(1.3f, 1.3f, 1.3f);
		root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}
}
