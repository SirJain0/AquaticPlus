package sirjain.aquaticplus.client.entity.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import sirjain.aquaticplus.entity.entities.OculiMagniEntity;

public class OculiMagniModel extends EntityModel<OculiMagniEntity> {
	private final ModelPart root;
	private final ModelPart main;
	private final ModelPart head;
	private final ModelPart tail;
	private final ModelPart tail2;

	public OculiMagniModel(ModelPart part) {
		root = part;
		main = root.getChild("oculi_magni");
		head = main.getChild("head");
		tail = main.getChild("tail");
		tail2 = tail.getChild("tail2");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData oculi_magni = modelPartData.addChild("oculi_magni", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -2.2912F, -2.7222F, 6.0F, 6.0F, 12.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 20.2912F, -3.2778F));
		ModelPartData cube_r1 = oculi_magni.addChild("cube_r1", ModelPartBuilder.create().uv(0, 14).cuboid(0.0F, -2.0F, -5.0F, 0.0F, 2.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -2.2912F, 3.2778F, 0.0F, 0.0F, 0.3491F));
		ModelPartData cube_r2 = oculi_magni.addChild("cube_r2", ModelPartBuilder.create().uv(0, 14).cuboid(0.0F, -2.0F, -5.0F, 0.0F, 2.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -2.2912F, 3.2778F, 0.0F, 0.0F, -0.3491F));
		ModelPartData head = oculi_magni.addChild("head", ModelPartBuilder.create().uv(24, 0).cuboid(-2.5F, -2.75F, -5.0F, 5.0F, 5.0F, 5.0F, new Dilation(0.0F))
			.uv(28, 18).cuboid(-1.5F, 0.25F, -12.0F, 3.0F, 2.0F, 7.0F, new Dilation(0.0F))
			.uv(0, 27).cuboid(-1.5F, -1.75F, -12.0F, 3.0F, 2.0F, 7.0F, new Dilation(0.0F))
			.uv(27, 27).cuboid(-1.5F, -1.25F, -12.0F, 3.0F, 2.0F, 7.0F, new Dilation(-0.3F)), ModelTransform.pivot(0.0F, 1.2088F, -2.7222F));
		ModelPartData tail = oculi_magni.addChild("tail", ModelPartBuilder.create().uv(14, 24).cuboid(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.7088F, 9.2778F));
		ModelPartData tail2 = tail.addChild("tail2", ModelPartBuilder.create().uv(0, 18).cuboid(-5.0F, -0.5F, -0.5F, 10.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.5F, 5.5F));

		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}

	@Override
	public void setAngles(OculiMagniEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		tail.yaw = MathHelper.cos(animationProgress * 0.3f) * 0.2f;
		tail2.pitch = MathHelper.cos(-20 + animationProgress * 0.3f) * 0.3f;
		head.yaw = -(MathHelper.cos(animationProgress * 0.3f) * 0.1f);
		main.pivotX = -(MathHelper.cos(animationProgress * 0.3f) * 1.2f);
	}
}
