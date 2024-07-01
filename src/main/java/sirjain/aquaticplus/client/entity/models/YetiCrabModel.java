package sirjain.aquaticplus.client.entity.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import sirjain.aquaticplus.entity.entities.YetiCrabEntity;
import sirjain.aquaticplus.entity.entities.animation.YetiCrabAnimations;

public class YetiCrabModel extends SinglePartEntityModel<YetiCrabEntity> {
	private final ModelPart root;
	private final ModelPart yetiCrab;
	private final ModelPart rightPincer;
	private final ModelPart leftPincer;
	private final ModelPart body;
	private final ModelPart frontRightLeg;
	private final ModelPart frontLeftLeg;
	private final ModelPart midRightLeg;
	private final ModelPart midLeftLeg;
	private final ModelPart backRightLeg;
	private final ModelPart backLeftLeg;

	public YetiCrabModel(ModelPart part) {
		this.root = part;
		this.yetiCrab = root.getChild("yeti_crab");
		this.rightPincer = yetiCrab.getChild("right_pincer");
		this.leftPincer = yetiCrab.getChild("left_pincer");
		this.body = yetiCrab.getChild("body");
		this.frontRightLeg = yetiCrab.getChild("front_right_leg");
		this.frontLeftLeg = yetiCrab.getChild("front_left_leg");
		this.midRightLeg = yetiCrab.getChild("mid_right_leg");
		this.midLeftLeg = yetiCrab.getChild("mid_left_leg");
		this.backRightLeg = yetiCrab.getChild("back_right_leg");
		this.backLeftLeg = yetiCrab.getChild("back_left_leg");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData yeti_crab = modelPartData.addChild("yeti_crab", ModelPartBuilder.create(), ModelTransform.of(-0.1358F, 21.0F, 4.6165F, -3.1416F, 0.0F, 3.1416F));
		ModelPartData right_pincer = yeti_crab.addChild("right_pincer", ModelPartBuilder.create(), ModelTransform.of(3.6308F, -0.4952F, 5.3077F, 0.0F, 0.1309F, 0.0F));
		ModelPartData cube_r1 = right_pincer.addChild("cube_r1", ModelPartBuilder.create().uv(22, 25).cuboid(0.0F, -1.6724F, -2.5512F, 2.0F, 2.0F, 6.0F, new Dilation(0.1F)), ModelTransform.of(0.6106F, 1.8731F, 8.934F, -0.0873F, 0.1745F, -0.0436F));
		ModelPartData cube_r2 = right_pincer.addChild("cube_r2", ModelPartBuilder.create().uv(0, 0).cuboid(2.0F, -1.0F, 7.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-3.6394F, 0.7566F, 3.4588F, -0.0873F, 0.0F, 0.0F));
		ModelPartData cube_r3 = right_pincer.addChild("cube_r3", ModelPartBuilder.create().uv(0, 14).cuboid(1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 11.0F, new Dilation(0.0F))
			.uv(17, 14).cuboid(1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 9.0F, new Dilation(0.2F)), ModelTransform.of(-2.6394F, 0.4952F, 0.4702F, -0.0873F, 0.0F, 0.0F));
		ModelPartData left_pincer = yeti_crab.addChild("left_pincer", ModelPartBuilder.create(), ModelTransform.of(-3.3592F, -0.4952F, 5.3077F, 0.0F, -0.1309F, 0.0F));
		ModelPartData cube_r4 = left_pincer.addChild("cube_r4", ModelPartBuilder.create().uv(22, 25).mirrored().cuboid(-2.0F, -1.6724F, -2.5512F, 2.0F, 2.0F, 6.0F, new Dilation(0.1F)).mirrored(false), ModelTransform.of(-0.6106F, 1.8731F, 8.934F, -0.0873F, -0.1745F, 0.0436F));
		ModelPartData cube_r5 = left_pincer.addChild("cube_r5", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-4.0F, -1.0F, 7.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(3.6394F, 0.7566F, 3.4588F, -0.0873F, 0.0F, 0.0F));
		ModelPartData cube_r6 = left_pincer.addChild("cube_r6", ModelPartBuilder.create().uv(0, 14).mirrored().cuboid(-4.0F, -1.0F, -1.0F, 3.0F, 2.0F, 11.0F, new Dilation(0.0F)).mirrored(false)
			.uv(17, 14).mirrored().cuboid(-4.0F, -1.0F, -1.0F, 3.0F, 2.0F, 9.0F, new Dilation(0.2F)).mirrored(false), ModelTransform.of(2.6394F, 0.4952F, 0.4702F, -0.0873F, 0.0F, 0.0F));
		ModelPartData body = yeti_crab.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-3.5F, -2.0F, -3.75F, 7.0F, 4.0F, 10.0F, new Dilation(0.0F))
			.uv(24, 0).cuboid(-3.5F, -2.0F, -3.75F, 7.0F, 4.0F, 5.0F, new Dilation(0.3F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		ModelPartData front_right_leg = yeti_crab.addChild("front_right_leg", ModelPartBuilder.create(), ModelTransform.of(3.6879F, 0.0898F, 1.708F, 0.0436F, 0.0F, 0.0F));
		ModelPartData cube_r7 = front_right_leg.addChild("cube_r7", ModelPartBuilder.create().uv(0, 27).cuboid(-4.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 1.0F, 2.0F, 0.0F, -0.7679F, 0.3709F));
		ModelPartData front_left_leg = yeti_crab.addChild("front_left_leg", ModelPartBuilder.create(), ModelTransform.of(-3.6879F, 0.0898F, 1.708F, 0.0305F, 0.0F, 0.0F));
		ModelPartData cube_r8 = front_left_leg.addChild("cube_r8", ModelPartBuilder.create().uv(0, 27).mirrored().cuboid(-4.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-2.0F, 1.0F, 2.0F, 0.0F, 0.7679F, -0.3709F));
		ModelPartData mid_right_leg = yeti_crab.addChild("mid_right_leg", ModelPartBuilder.create(), ModelTransform.pivot(3.8755F, -0.2056F, -0.25F));
		ModelPartData cube_r9 = mid_right_leg.addChild("cube_r9", ModelPartBuilder.create().uv(0, 31).cuboid(-3.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.384F));
		ModelPartData mid_left_leg = yeti_crab.addChild("mid_left_leg", ModelPartBuilder.create(), ModelTransform.pivot(-3.8755F, -0.2056F, -0.25F));
		ModelPartData cube_r10 = mid_left_leg.addChild("cube_r10", ModelPartBuilder.create().uv(0, 31).mirrored().cuboid(-3.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-1.5F, 1.0F, 0.0F, 0.0F, 0.0F, -0.384F));
		ModelPartData back_right_leg = yeti_crab.addChild("back_right_leg", ModelPartBuilder.create(), ModelTransform.of(3.7674F, -0.1709F, -1.5134F, 0.0F, 0.0F, 0.0873F));
		ModelPartData cube_r11 = back_right_leg.addChild("cube_r11", ModelPartBuilder.create().uv(32, 12).cuboid(-5.5F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(2.9261F, 1.6518F, -3.7366F, 0.0F, 0.7679F, 0.3709F));
		ModelPartData back_left_leg = yeti_crab.addChild("back_left_leg", ModelPartBuilder.create(), ModelTransform.of(-3.7674F, -0.1709F, -1.7634F, 0.0F, 0.0F, -0.0785F));
		ModelPartData cube_r12 = back_left_leg.addChild("cube_r12", ModelPartBuilder.create().uv(32, 12).mirrored().cuboid(-0.5F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-2.9261F, 1.6518F, -3.4866F, 0.0F, -0.7679F, -0.3709F));

		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public ModelPart getPart() {
		return this.yetiCrab;
	}

	@Override
	public void setAngles(YetiCrabEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.animateMovement(YetiCrabAnimations.WALK, limbSwing, limbSwingAmount, 9.0F, 100.0F);
	}
}
