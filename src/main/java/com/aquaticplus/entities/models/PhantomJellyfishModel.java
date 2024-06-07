package com.aquaticplus.entities.models;

import com.aquaticplus.entities.entity.animation.GulperEelAnimations;
import com.aquaticplus.entities.entity.animation.PhantomJellyfishAnimations;
import com.aquaticplus.entities.entity.boss.PhantomJellyfishEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class PhantomJellyfishModel extends SinglePartEntityModel<PhantomJellyfishEntity> {
	private final ModelPart root;
	private final ModelPart phantomJellyfish;
	private final ModelPart head;
	private final ModelPart core;
	private final ModelPart tentacle1;
	private final ModelPart tentacle1seg9;
	private final ModelPart tentacle1seg10;
	private final ModelPart tentacle2;
	private final ModelPart tentacle1seg2;
	private final ModelPart tentacle1seg3;
	private final ModelPart tentacle3;
	private final ModelPart tentacle1seg4;
	private final ModelPart tentacle1seg5;
	private final ModelPart tentacle4;
	private final ModelPart tentacle1seg6;
	private final ModelPart tentacle1seg7;
	private final ModelPart tentacle5;
	private final ModelPart tentacle1seg8;
	private final ModelPart tentacle1seg11;
	private final ModelPart tentacle6;
	private final ModelPart tentacle1seg12;
	private final ModelPart tentacle1seg13;
	private final ModelPart tentacle7;
	private final ModelPart tentacle1seg14;
	private final ModelPart tentacle1seg15;
	private final ModelPart tentacle8;
	private final ModelPart tentacle1seg16;
	private final ModelPart tentacle1seg17;

	public PhantomJellyfishModel(ModelPart part) {
		this.root = part;
		this.phantomJellyfish = root.getChild("phantom");
		this.head = phantomJellyfish.getChild("head");
		this.core = head.getChild("core");
		this.tentacle1 = phantomJellyfish.getChild("tentacle1");
		this.tentacle1seg9 = tentacle1.getChild("tentacle1seg9");
		this.tentacle1seg10 = tentacle1seg9.getChild("tentacle1seg10");
		this.tentacle2 = phantomJellyfish.getChild("tentacle2");
		this.tentacle1seg2 = tentacle2.getChild("tentacle1seg2");
		this.tentacle1seg3 = tentacle1seg2.getChild("tentacle1seg3");
		this.tentacle3 = phantomJellyfish.getChild("tentacle3");
		this.tentacle1seg4 = tentacle3.getChild("tentacle1seg4");
		this.tentacle1seg5 = tentacle1seg4.getChild("tentacle1seg5");
		this.tentacle4 = phantomJellyfish.getChild("tentacle4");
		this.tentacle1seg6 = tentacle4.getChild("tentacle1seg6");
		this.tentacle1seg7 = tentacle1seg6.getChild("tentacle1seg7");
		this.tentacle5 = phantomJellyfish.getChild("tentacle5");
		this.tentacle1seg8 = tentacle5.getChild("tentacle1seg8");
		this.tentacle1seg11 = tentacle1seg8.getChild("tentacle1seg11");
		this.tentacle6 = phantomJellyfish.getChild("tentacle6");
		this.tentacle1seg12 = tentacle6.getChild("tentacle1seg12");
		this.tentacle1seg13 = tentacle1seg12.getChild("tentacle1seg13");
		this.tentacle7 = phantomJellyfish.getChild("tentacle7");
		this.tentacle1seg14 = tentacle7.getChild("tentacle1seg14");
		this.tentacle1seg15 = tentacle1seg14.getChild("tentacle1seg15");
		this.tentacle8 = phantomJellyfish.getChild("tentacle8");
		this.tentacle1seg16 = tentacle8.getChild("tentacle1seg16");
		this.tentacle1seg17 = tentacle1seg16.getChild("tentacle1seg17");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData phantom = modelPartData.addChild("phantom", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		ModelPartData head = phantom.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-11.0F, 0.0F, -11.0F, 22.0F, 7.0F, 22.0F, new Dilation(0.0F))
			.uv(0, 29).cuboid(-7.0F, -10.0F, -7.0F, 14.0F, 10.0F, 14.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -61.0F, 0.0F));
		ModelPartData core = head.addChild("core", ModelPartBuilder.create().uv(42, 29).cuboid(-4.0F, -3.0F, -4.0F, 8.0F, 6.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -5.0F, 0.0F));
		ModelPartData tentacle1 = phantom.addChild("tentacle1", ModelPartBuilder.create(), ModelTransform.of(-9.1312F, -54.0648F, -0.0484F, 3.1416F, 0.0F, 2.1817F));
		ModelPartData cube_r1 = tentacle1.addChild("cube_r1", ModelPartBuilder.create().uv(0, 0).cuboid(4.943F, 5.9689F, -3.0F, 3.0F, 10.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-8.585F, 1.8542F, 0.0F, 0.0F, 0.0F, -0.9599F));
		ModelPartData tentacle1seg9 = tentacle1.addChild("tentacle1seg9", ModelPartBuilder.create().uv(20, 53).cuboid(-1.0F, 0.0F, -1.5F, 2.0F, 26.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(7.6376F, 4.7518F, 0.0F, 0.0F, 0.0F, -0.9599F));
		ModelPartData tentacle1seg10 = tentacle1seg9.addChild("tentacle1seg10", ModelPartBuilder.create().uv(10, 53).cuboid(-1.0F, 0.0F, -1.5F, 2.0F, 26.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 26.0F, 0.0F));
		ModelPartData tentacle2 = phantom.addChild("tentacle2", ModelPartBuilder.create(), ModelTransform.of(9.1312F, -54.0648F, -0.0484F, 3.1416F, 0.0F, -2.1817F));
		ModelPartData cube_r2 = tentacle2.addChild("cube_r2", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-7.943F, 5.9689F, -3.0F, 3.0F, 10.0F, 6.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(8.585F, 1.8542F, 0.0F, 0.0F, 0.0F, 0.9599F));
		ModelPartData tentacle1seg2 = tentacle2.addChild("tentacle1seg2", ModelPartBuilder.create().uv(20, 53).mirrored().cuboid(-1.0F, 0.0F, -1.5F, 2.0F, 26.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-7.6376F, 4.7518F, 0.0F, 0.0F, 0.0F, 0.9599F));
		ModelPartData tentacle1seg3 = tentacle1seg2.addChild("tentacle1seg3", ModelPartBuilder.create().uv(10, 53).mirrored().cuboid(-1.0F, 0.0F, -1.5F, 2.0F, 26.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 26.0F, 0.0F));
		ModelPartData tentacle3 = phantom.addChild("tentacle3", ModelPartBuilder.create(), ModelTransform.of(0.1312F, -54.0648F, -9.0484F, 1.5708F, -0.6109F, -1.5708F));
		ModelPartData cube_r3 = tentacle3.addChild("cube_r3", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-7.943F, 5.9689F, -3.0F, 3.0F, 10.0F, 6.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(8.585F, 1.8542F, 0.0F, 0.0F, 0.0F, 0.9599F));
		ModelPartData tentacle1seg4 = tentacle3.addChild("tentacle1seg4", ModelPartBuilder.create().uv(20, 53).mirrored().cuboid(-1.0F, 0.0F, -1.5F, 2.0F, 26.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-7.6376F, 4.7518F, 0.0F, 0.0F, 0.0F, 0.9599F));
		ModelPartData tentacle1seg5 = tentacle1seg4.addChild("tentacle1seg5", ModelPartBuilder.create().uv(10, 53).mirrored().cuboid(-1.0F, 0.0F, -1.5F, 2.0F, 26.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 26.0F, 0.0F));
		ModelPartData tentacle4 = phantom.addChild("tentacle4", ModelPartBuilder.create(), ModelTransform.of(0.1312F, -54.0648F, 9.0484F, -1.5708F, 0.6109F, -1.5708F));
		ModelPartData cube_r4 = tentacle4.addChild("cube_r4", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-7.943F, 5.9689F, -3.0F, 3.0F, 10.0F, 6.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(8.585F, 1.8542F, 0.0F, 0.0F, 0.0F, 0.9599F));
		ModelPartData tentacle1seg6 = tentacle4.addChild("tentacle1seg6", ModelPartBuilder.create().uv(20, 53).mirrored().cuboid(-1.0F, 0.0F, -1.5F, 2.0F, 26.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-7.6376F, 4.7518F, 0.0F, 0.0F, 0.0F, 0.9599F));
		ModelPartData tentacle1seg7 = tentacle1seg6.addChild("tentacle1seg7", ModelPartBuilder.create().uv(10, 53).mirrored().cuboid(-1.0F, 0.0F, -1.5F, 2.0F, 26.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 26.0F, 0.0F));
		ModelPartData tentacle5 = phantom.addChild("tentacle5", ModelPartBuilder.create(), ModelTransform.of(-7.6188F, -54.0648F, 7.5484F, -0.6863F, 0.4176F, -1.1111F));
		ModelPartData cube_r5 = tentacle5.addChild("cube_r5", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-7.943F, 5.9689F, -3.0F, 3.0F, 10.0F, 6.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(8.585F, 1.8542F, 0.0F, 0.0F, 0.0F, 0.9599F));
		ModelPartData tentacle1seg8 = tentacle5.addChild("tentacle1seg8", ModelPartBuilder.create().uv(20, 53).mirrored().cuboid(-1.0F, 0.0F, -1.5F, 2.0F, 26.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-7.6376F, 4.7518F, 0.0F, 0.0F, 0.0F, 0.9599F));
		ModelPartData tentacle1seg11 = tentacle1seg8.addChild("tentacle1seg11", ModelPartBuilder.create().uv(10, 53).mirrored().cuboid(-1.0F, 0.0F, -1.5F, 2.0F, 26.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 26.0F, 0.0F));
		ModelPartData tentacle6 = phantom.addChild("tentacle6", ModelPartBuilder.create(), ModelTransform.of(7.6188F, -54.0648F, 7.5484F, -0.6863F, -0.4176F, 1.1111F));
		ModelPartData cube_r6 = tentacle6.addChild("cube_r6", ModelPartBuilder.create().uv(0, 0).cuboid(4.943F, 5.9689F, -3.0F, 3.0F, 10.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-8.585F, 1.8542F, 0.0F, 0.0F, 0.0F, -0.9599F));
		ModelPartData tentacle1seg12 = tentacle6.addChild("tentacle1seg12", ModelPartBuilder.create().uv(20, 53).cuboid(-1.0F, 0.0F, -1.5F, 2.0F, 26.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(7.6376F, 4.7518F, 0.0F, 0.0F, 0.0F, -0.9599F));
		ModelPartData tentacle1seg13 = tentacle1seg12.addChild("tentacle1seg13", ModelPartBuilder.create().uv(10, 53).cuboid(-1.0F, 0.0F, -1.5F, 2.0F, 26.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 26.0F, 0.0F));
		ModelPartData tentacle7 = phantom.addChild("tentacle7", ModelPartBuilder.create(), ModelTransform.of(7.6188F, -54.0648F, -7.5484F, 0.6863F, 0.4176F, 1.1111F));
		ModelPartData cube_r7 = tentacle7.addChild("cube_r7", ModelPartBuilder.create().uv(0, 0).cuboid(4.943F, 5.9689F, -3.0F, 3.0F, 10.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-8.585F, 1.8542F, 0.0F, 0.0F, 0.0F, -0.9599F));
		ModelPartData tentacle1seg14 = tentacle7.addChild("tentacle1seg14", ModelPartBuilder.create().uv(20, 53).cuboid(-1.0F, 0.0F, -1.5F, 2.0F, 26.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(7.6376F, 4.7518F, 0.0F, 0.0F, 0.0F, -0.9599F));
		ModelPartData tentacle1seg15 = tentacle1seg14.addChild("tentacle1seg15", ModelPartBuilder.create().uv(10, 53).cuboid(-1.0F, 0.0F, -1.5F, 2.0F, 26.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 26.0F, 0.0F));
		ModelPartData tentacle8 = phantom.addChild("tentacle8", ModelPartBuilder.create(), ModelTransform.of(-7.6188F, -54.0648F, -7.5484F, 0.6863F, -0.4176F, -1.1111F));
		ModelPartData cube_r8 = tentacle8.addChild("cube_r8", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-7.943F, 5.9689F, -3.0F, 3.0F, 10.0F, 6.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(8.585F, 1.8542F, 0.0F, 0.0F, 0.0F, 0.9599F));
		ModelPartData tentacle1seg16 = tentacle8.addChild("tentacle1seg16", ModelPartBuilder.create().uv(20, 53).mirrored().cuboid(-1.0F, 0.0F, -1.5F, 2.0F, 26.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-7.6376F, 4.7518F, 0.0F, 0.0F, 0.0F, 0.9599F));
		ModelPartData tentacle1seg17 = tentacle1seg16.addChild("tentacle1seg17", ModelPartBuilder.create().uv(10, 53).mirrored().cuboid(-1.0F, 0.0F, -1.5F, 2.0F, 26.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 26.0F, 0.0F));

		return TexturedModelData.of(modelData, 128, 128);
	}

	@Override
	public void setAngles(PhantomJellyfishEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.updateAnimation(entity.swimAnimationState, PhantomJellyfishAnimations.SWIM, animationProgress, 1f);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		phantomJellyfish.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}

	@Override
	public ModelPart getPart() {
		return phantomJellyfish;
	}
}
