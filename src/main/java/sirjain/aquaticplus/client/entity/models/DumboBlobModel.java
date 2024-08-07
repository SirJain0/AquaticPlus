package sirjain.aquaticplus.client.entity.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import sirjain.aquaticplus.entity.entities.DumboBlobEntity;
import sirjain.aquaticplus.entity.entities.animation.DumboBlobAnimations;

public class DumboBlobModel extends SinglePartEntityModel<DumboBlobEntity> {
	private final ModelPart root;
	private final ModelPart blob;
	private final ModelPart head;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart leg4;

	public DumboBlobModel(ModelPart part) {
		root = part;
		blob = root.getChild("blob");
		head = blob.getChild("head");
		leg1 = blob.getChild("leg1");
		leg2 = blob.getChild("leg2");
		leg3 = blob.getChild("leg3");
		leg4 = blob.getChild("leg4");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData root = modelPartData.addChild("blob", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0025F, -2.225F, -2.0025F, 4.005F, 4.45F, 4.005F, new Dilation(0.0F)), ModelTransform.pivot(0.25F, 11.985F, 0.0F));
		ModelPartData head = root.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.2175F, 0.005F, 0.2175F));
		ModelPartData ear_left = head.addChild("ear_left", ModelPartBuilder.create().uv(16, 16).cuboid(-0.5F, -4.0F, -2.0F, 3.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(3.28F, -1.45F, -0.22F));
		ModelPartData ear_right = head.addChild("ear_right", ModelPartBuilder.create().uv(16, 16).mirrored().cuboid(-2.5F, -4.0F, -2.0F, 3.0F, 6.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-2.845F, -1.45F, -0.22F));
		ModelPartData leg1 = root.addChild("leg1", ModelPartBuilder.create(), ModelTransform.pivot(-0.2206F, 4.1606F, -2.7881F));
		ModelPartData cube_r1 = leg1.addChild("cube_r1", ModelPartBuilder.create().uv(0, 24).cuboid(-1.335F, -3.995F, -1.335F, 3.0F, 8.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-0.165F, 2.9594F, -0.16F, -0.2182F, 0.0F, 0.0F));
		ModelPartData leg3 = root.addChild("leg3", ModelPartBuilder.create(), ModelTransform.of(-0.2444F, 4.1606F, 2.1481F, 0.0F, 3.1416F, 0.0F));
		ModelPartData cube_r2 = leg3.addChild("cube_r2", ModelPartBuilder.create().uv(0, 24).cuboid(-1.335F, -3.995F, -1.335F, 3.0F, 8.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-0.165F, 2.9594F, -1.16F, -0.2182F, 0.0F, 0.0F));
		ModelPartData leg2 = root.addChild("leg2", ModelPartBuilder.create(), ModelTransform.pivot(1.7794F, 4.1606F, 0.0381F));
		ModelPartData cube_r3 = leg2.addChild("cube_r3", ModelPartBuilder.create().uv(0, 24).cuboid(-1.665F, -3.995F, -1.665F, 3.0F, 8.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(1.16F, 2.9594F, 0.165F, 0.0F, 0.0F, -0.2182F));
		ModelPartData leg4 = root.addChild("leg4", ModelPartBuilder.create(), ModelTransform.of(-2.2206F, 4.1606F, 0.0381F, 0.0F, 3.1416F, 0.0F));
		ModelPartData cube_r4 = leg4.addChild("cube_r4", ModelPartBuilder.create().uv(0, 24).cuboid(-1.665F, -3.995F, -1.665F, 3.0F, 8.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(1.16F, 2.9594F, 0.165F, 0.0F, 0.0F, -0.2182F));

		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(DumboBlobEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(entity, netHeadYaw, headPitch, ageInTicks);

		this.animateMovement(DumboBlobAnimations.DUMBO_BLOB_SWIM, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.bobAnimationState, DumboBlobAnimations.DUMBO_BLOB_BOB, ageInTicks, 1f);
	}

	private void setHeadAngles(DumboBlobEntity entity, float headYaw, float headPitch, float animationProgress) {
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		matrices.translate(0, 1, 0);
		matrices.scale(0.8f, 0.8f, 0.8f);
		root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}

	@Override
	public ModelPart getPart() {
		return this.blob;
	}
}
