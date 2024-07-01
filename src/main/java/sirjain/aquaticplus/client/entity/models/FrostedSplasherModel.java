package sirjain.aquaticplus.client.entity.models;

import sirjain.aquaticplus.entity.entities.FrostedSplasherEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class FrostedSplasherModel extends EntityModel<FrostedSplasherEntity> {
	private final ModelPart root;
	private final ModelPart frostedSplasher;
	private final ModelPart head;
	private final ModelPart tail1;
	private final ModelPart tail2;
	private final ModelPart tail3;

	public FrostedSplasherModel(ModelPart part) {
		root = part;
		frostedSplasher = root.getChild("splasher");
		head = frostedSplasher.getChild("head");
		tail1 = frostedSplasher.getChild("tail1");
		tail2 = tail1.getChild("tail2");
		tail3 = tail2.getChild("tail3");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData root = modelPartData.addChild("splasher", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -5.5F, -11.0F, 7.0F, 6.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		ModelPartData head = root.addChild("head", ModelPartBuilder.create().uv(24, 0).cuboid(-2.625F, -0.625F, -5.125F, 5.0F, 4.0F, 5.0F, new Dilation(0.0F))
			.uv(0, 6).cuboid(-0.875F, -2.375F, -4.375F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.375F, -3.375F, -10.875F));
		ModelPartData front_fin_l = root.addChild("front_fin_l", ModelPartBuilder.create(), ModelTransform.pivot(5.0F, -1.5F, -7.5F));
		ModelPartData cube_r1 = front_fin_l.addChild("cube_r1", ModelPartBuilder.create().uv(16, 29).cuboid(-2.75F, -1.0F, 2.0F, 6.0F, 2.0F, 1.0F, new Dilation(0.0F))
			.uv(16, 36).cuboid(4.25F, -1.0F, 1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F))
			.uv(30, 20).cuboid(-2.75F, -1.0F, -1.0F, 9.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.3491F, 0.0F));
		ModelPartData front_fin_r = root.addChild("front_fin_r", ModelPartBuilder.create(), ModelTransform.pivot(-5.0F, -1.5F, -7.5F));
		ModelPartData cube_r2 = front_fin_r.addChild("cube_r2", ModelPartBuilder.create().uv(16, 29).mirrored().cuboid(-3.25F, -1.0F, 2.0F, 6.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
			.uv(16, 36).mirrored().cuboid(-6.25F, -1.0F, 1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
			.uv(30, 20).mirrored().cuboid(-6.25F, -1.0F, -1.0F, 9.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.3491F, 0.0F));
		ModelPartData top_ice = root.addChild("top_ice", ModelPartBuilder.create(), ModelTransform.pivot(-1.75F, -7.5F, -8.5F));
		ModelPartData cube_r3 = top_ice.addChild("cube_r3", ModelPartBuilder.create().uv(0, 42).cuboid(-1.75F, -0.25F, 0.25F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.3927F, 1.0472F, 0.0F));
		ModelPartData cube_r4 = top_ice.addChild("cube_r4", ModelPartBuilder.create().uv(8, 42).cuboid(-1.0F, -2.5F, -1.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.75F, 0.0F, 0.0F, 0.3927F, 0.0F));
		ModelPartData tail1 = root.addChild("tail1", ModelPartBuilder.create().uv(26, 29).cuboid(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.5F, -2.25F, -1.0F));
		ModelPartData mid_ice = tail1.addChild("mid_ice", ModelPartBuilder.create(), ModelTransform.pivot(0.25F, -3.75F, 2.0F));
		ModelPartData cube_r5 = mid_ice.addChild("cube_r5", ModelPartBuilder.create().uv(0, 28).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.3927F, 0.0F));
		ModelPartData cube_r6 = mid_ice.addChild("cube_r6", ModelPartBuilder.create().uv(0, 0).cuboid(-0.25F, -0.75F, 0.25F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.3927F, -1.0472F, 0.0F));
		ModelPartData mid_fin_l = tail1.addChild("mid_fin_l", ModelPartBuilder.create(), ModelTransform.pivot(-4.5F, 0.75F, 2.5F));
		ModelPartData cube_r7 = mid_fin_l.addChild("cube_r7", ModelPartBuilder.create().uv(0, 34).cuboid(-2.75F, -1.0F, 2.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F))
			.uv(16, 32).cuboid(-2.75F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(9.25F, 0.0F, 1.0F, 0.0F, -0.3491F, 0.0F));
		ModelPartData mid_fin_r = tail1.addChild("mid_fin_r", ModelPartBuilder.create(), ModelTransform.pivot(4.5F, 0.75F, 2.5F));
		ModelPartData cube_r8 = mid_fin_r.addChild("cube_r8", ModelPartBuilder.create().uv(0, 34).mirrored().cuboid(-0.25F, -1.0F, 2.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
			.uv(16, 32).mirrored().cuboid(-1.25F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-9.25F, 0.0F, 1.0F, 0.0F, 0.3491F, 0.0F));
		ModelPartData tail2 = tail1.addChild("tail2", ModelPartBuilder.create().uv(14, 16).cuboid(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 8.0F));
		ModelPartData tail3 = tail2.addChild("tail3", ModelPartBuilder.create().uv(0, 4).cuboid(0.0F, -4.5F, -2.0F, 0.0F, 9.0F, 12.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 7.0F));

		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(FrostedSplasherEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		tail1.yaw = MathHelper.cos(animationProgress * 0.2f) * 0.2f;
		tail2.yaw = MathHelper.cos(-20 + animationProgress * 0.2f) * 0.25f;
		tail3.yaw = MathHelper.cos(-40 + animationProgress * 0.2f) * 0.32f;
		head.yaw = MathHelper.cos(-35 + animationProgress * 0.2f) * 0.12f;
		frostedSplasher.pivotX = -(MathHelper.cos(animationProgress * 0.2f) * 1.5f);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		frostedSplasher.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}
}