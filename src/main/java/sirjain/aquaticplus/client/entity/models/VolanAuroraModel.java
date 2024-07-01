package sirjain.aquaticplus.client.entity.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import sirjain.aquaticplus.entity.entities.VolanAuroraEntity;

public class VolanAuroraModel extends EntityModel<VolanAuroraEntity> {
	private final ModelPart root;
	private final ModelPart volanAurora;
	private final ModelPart wingL;
	private final ModelPart wingR;
	private final ModelPart head;
	private final ModelPart tail;
	private final ModelPart tail2;
	private final ModelPart tail3;

	public VolanAuroraModel(ModelPart part) {
		root = part;
		volanAurora = root.getChild("volan_aurora");
		wingL = volanAurora.getChild("wing_l");
		wingR = volanAurora.getChild("wing_r");
		head = volanAurora.getChild("head");
		tail = volanAurora.getChild("tail");
		tail2 = tail.getChild("tail2");
		tail3 = tail2.getChild("tail3");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData bone = modelPartData.addChild("volan_aurora", ModelPartBuilder.create().uv(0, 10).cuboid(-3.0F, -3.0F, -6.0F, 6.0F, 6.0F, 12.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 21.0F, -6.25F));
		ModelPartData wing_l = bone.addChild("wing_l", ModelPartBuilder.create().uv(36, 21).cuboid(0.0F, -1.0F, -1.25F, 10.0F, 2.0F, 2.0F, new Dilation(0.0F))
			.uv(0, 28).cuboid(0.0F, 0.0F, 0.75F, 10.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, 0.0F, -2.75F));
		ModelPartData wing_r = bone.addChild("wing_r", ModelPartBuilder.create().uv(36, 21).mirrored().cuboid(-10.0F, -1.0F, -1.25F, 10.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
			.uv(0, 28).mirrored().cuboid(-10.0F, 0.0F, 0.75F, 10.0F, 0.0F, 7.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-3.0F, 0.0F, -2.75F));
		ModelPartData head = bone.addChild("head", ModelPartBuilder.create().uv(22, 34).cuboid(-2.5F, -2.5F, -5.0F, 5.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.25F, -6.0F));
		ModelPartData tail = bone.addChild("tail", ModelPartBuilder.create().uv(24, 0).cuboid(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 6.0F));
		ModelPartData tail2 = tail.addChild("tail2", ModelPartBuilder.create().uv(27, 28).cuboid(-6.0F, -0.5F, -0.5F, 12.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 9.5F));
		ModelPartData tail3 = tail2.addChild("tail3", ModelPartBuilder.create().uv(0, 0).cuboid(-6.0F, 0.0F, 0.0F, 12.0F, 0.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.5F, 4.5F));

		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(VolanAuroraEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		tail.pitch = MathHelper.cos(animationProgress * 0.2f) * 0.2f;
		tail2.pitch = MathHelper.cos(-20 + animationProgress * 0.2f) * 0.3f;
		tail3.pitch = MathHelper.cos(-40 + animationProgress * 0.2f) * 0.35f;
		volanAurora.pivotY = -(MathHelper.cos(animationProgress * 0.2f) * 1.5f);
		wingL.roll = MathHelper.cos(-25 + animationProgress * 0.2f) * 0.35f;
		wingR.roll = -MathHelper.cos(-25 + animationProgress * 0.2f) * 0.35f;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		matrices.scale(1.2f, 1.2f, 1.2f);
		matrices.translate(0, 1, 0);
		root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}
}