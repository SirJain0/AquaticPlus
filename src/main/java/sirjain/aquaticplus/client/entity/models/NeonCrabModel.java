package sirjain.aquaticplus.client.entity.models;

import sirjain.aquaticplus.entity.entities.NeonCrabEntity;
import sirjain.aquaticplus.entity.entities.animation.NeonCrabAnimations;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;

public class NeonCrabModel extends SinglePartEntityModel<NeonCrabEntity> {
	private final ModelPart root;
	private final ModelPart neonCrab;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart leg4;
	private final ModelPart leg5;
	private final ModelPart leg6;
	private final ModelPart body;
	private final ModelPart leftPincer;
	private final ModelPart rightPincer;

	public NeonCrabModel(ModelPart part) {
		root = part;
		neonCrab = root.getChild("neon_crab");
		leg1 = neonCrab.getChild("leg1");
		leg2 = neonCrab.getChild("leg2");
		leg3 = neonCrab.getChild("leg3");
		leg4 = neonCrab.getChild("leg4");
		leg5 = neonCrab.getChild("leg5");
		leg6 = neonCrab.getChild("leg6");
		body = neonCrab.getChild("body");
		leftPincer = body.getChild("left_pincer");
		rightPincer = body.getChild("right_pincer");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData neon_crab = modelPartData.addChild("neon_crab", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		ModelPartData leg1 = neon_crab.addChild("leg1", ModelPartBuilder.create(), ModelTransform.of(4.7886F, -3.676F, -3.4001F, -0.137F, 0.5522F, -0.257F));
		ModelPartData cube_r1 = leg1.addChild("cube_r1", ModelPartBuilder.create().uv(0, 22).cuboid(-1.4716F, -2.0836F, -2.0746F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.855F, 1.371F, 1.6119F, 0.0F, 0.0F, -0.829F));
		ModelPartData leg2 = neon_crab.addChild("leg2", ModelPartBuilder.create(), ModelTransform.pivot(5.1142F, -3.426F, 0.0746F));
		ModelPartData cube_r2 = leg2.addChild("cube_r2", ModelPartBuilder.create().uv(0, 22).cuboid(-1.4716F, -2.0836F, 0.0746F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(1.2616F, 1.121F, -1.0746F, 0.0F, 0.0F, -0.829F));
		ModelPartData leg3 = neon_crab.addChild("leg3", ModelPartBuilder.create(), ModelTransform.of(4.7886F, -3.676F, 3.9001F, 0.0F, -0.5672F, 0.0F));
		ModelPartData cube_r3 = leg3.addChild("cube_r3", ModelPartBuilder.create().uv(0, 22).cuboid(-1.4716F, -2.0836F, 0.0746F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(1.1236F, 1.371F, -1.1902F, 0.0F, 0.0F, -0.829F));
		ModelPartData leg4 = neon_crab.addChild("leg4", ModelPartBuilder.create(), ModelTransform.of(-5.0386F, -3.676F, -3.4001F, 0.0F, -0.5672F, 0.0F));
		ModelPartData cube_r4 = leg4.addChild("cube_r4", ModelPartBuilder.create().uv(0, 22).mirrored().cuboid(-0.5284F, -2.0836F, -2.0746F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.6441F, 1.371F, 1.4776F, 0.0F, 0.0F, 0.829F));
		ModelPartData leg5 = neon_crab.addChild("leg5", ModelPartBuilder.create(), ModelTransform.pivot(-4.8642F, -3.676F, 0.0746F));
		ModelPartData cube_r5 = leg5.addChild("cube_r5", ModelPartBuilder.create().uv(0, 22).mirrored().cuboid(-0.5284F, -2.0836F, 0.0746F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-1.5116F, 1.371F, -1.0746F, 0.0F, 0.0F, 0.829F));
		ModelPartData leg6 = neon_crab.addChild("leg6", ModelPartBuilder.create(), ModelTransform.of(-4.7886F, -3.676F, 3.9001F, 0.0F, 0.5672F, 0.0F));
		ModelPartData cube_r6 = leg6.addChild("cube_r6", ModelPartBuilder.create().uv(0, 22).mirrored().cuboid(-0.5284F, -2.0836F, 0.0746F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-1.1236F, 1.371F, -1.1902F, 0.0F, 0.0F, 0.829F));
		ModelPartData body = neon_crab.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-5.0F, -2.4287F, -1.8419F, 10.0F, 5.0F, 10.0F, new Dilation(0.0F))
			.uv(0, 36).cuboid(-5.0F, -2.4287F, -1.8419F, 10.0F, 5.0F, 10.0F, new Dilation(0.15F))
			.uv(15, 15).cuboid(-5.0F, -4.1787F, 1.1581F, 10.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.8213F, -3.1581F));
		ModelPartData right_pincer = body.addChild("right_pincer", ModelPartBuilder.create(), ModelTransform.pivot(-2.8624F, 1.5181F, -1.7371F));
		ModelPartData cube_r7 = right_pincer.addChild("cube_r7", ModelPartBuilder.create().uv(0, 15).cuboid(-3.0F, -2.5F, -0.5F, 6.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-1.3876F, 0.5532F, -1.6048F, 2.6172F, 1.2088F, 2.5193F));
		ModelPartData left_pincer = body.addChild("left_pincer", ModelPartBuilder.create(), ModelTransform.pivot(3.1124F, 1.5181F, -1.7371F));
		ModelPartData cube_r8 = left_pincer.addChild("cube_r8", ModelPartBuilder.create().uv(0, 15).mirrored().cuboid(-3.0F, -2.5F, -0.5F, 6.0F, 4.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.1376F, 0.5532F, -1.6048F, 2.6172F, -1.2088F, -2.5193F));

		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public ModelPart getPart() {
		return this.neonCrab;
	}

	@Override
	public void setAngles(NeonCrabEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.animateMovement(NeonCrabAnimations.WALK, limbSwing, limbSwingAmount, 9.0F, 100.0F);
	}
}
