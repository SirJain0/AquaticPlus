package sirjain.aquaticplus.client.entity.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import sirjain.aquaticplus.entity.entities.SlimyShrimpEntity;

public class SlimyShrimpModel extends EntityModel<SlimyShrimpEntity> {
	private final ModelPart root;
	private final ModelPart shrimp;
	private final ModelPart bodyJelly;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart leg4;
	private final ModelPart leg5;
	private final ModelPart leg6;
	private final ModelPart tail;
	private final ModelPart tailJelly;
	private final ModelPart tail2;

	public SlimyShrimpModel(ModelPart part) {
		this.root = part;
		this.shrimp = root.getChild("shrimp");
		this.bodyJelly = shrimp.getChild("body_jelly");
		this.leg1 = shrimp.getChild("leg1");
		this.leg2 = shrimp.getChild("leg2");
		this.leg3 = shrimp.getChild("leg3");
		this.leg4 = shrimp.getChild("leg4");
		this.leg5 = shrimp.getChild("leg5");
		this.leg6 = shrimp.getChild("leg6");
		this.tail = shrimp.getChild("tail");
		this.tailJelly = tail.getChild("tail_jelly");
		this.tail2 = tail.getChild("tail2");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData shrimp = modelPartData.addChild("shrimp", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -1.732F, -1.397F, 4.0F, 3.0F, 6.0F, new Dilation(0.0F))
			.uv(0, 22).cuboid(-2.0F, -1.732F, -1.397F, 4.0F, 3.0F, 6.0F, new Dilation(0.1F))
			.uv(0, 10).cuboid(-1.5F, -1.732F, -4.397F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, 18.732F, -1.603F));
		ModelPartData cube_r1 = shrimp.addChild("cube_r1", ModelPartBuilder.create().uv(0, 2).mirrored().cuboid(0.0F, -0.5F, 0.0F, 0.0F, 1.0F, 7.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-1.75F, 0.018F, -4.397F, -0.134F, -0.2163F, 0.0289F));
		ModelPartData cube_r2 = shrimp.addChild("cube_r2", ModelPartBuilder.create().uv(0, 2).cuboid(0.0F, -0.5F, 0.0F, 0.0F, 1.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(1.75F, 0.018F, -4.397F, -0.134F, 0.2163F, -0.0289F));
		ModelPartData body_jelly = shrimp.addChild("body_jelly", ModelPartBuilder.create().uv(0, 39).cuboid(-3.0F, -4.0F, 1.0F, 4.0F, 3.0F, 6.0F, new Dilation(0.5F))
			.uv(9, 44).cuboid(1.0F, -0.5F, 5.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
			.uv(9, 44).cuboid(1.0F, -0.5F, 2.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F))
			.uv(9, 44).mirrored().cuboid(-3.25F, -0.5F, 4.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
			.uv(9, 44).mirrored().cuboid(-3.25F, -0.5F, 2.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(1.0F, 2.268F, -2.397F));
		ModelPartData leg1 = shrimp.addChild("leg1", ModelPartBuilder.create().uv(4, 0).cuboid(0.0F, -0.75F, -0.5F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.75F, 2.018F, 3.853F));
		ModelPartData leg2 = shrimp.addChild("leg2", ModelPartBuilder.create().uv(2, 3).cuboid(0.0F, -0.25F, -0.5F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.75F, 1.518F, 1.853F));
		ModelPartData leg3 = shrimp.addChild("leg3", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -0.25F, -0.5F, 0.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, 1.518F, -0.147F));
		ModelPartData leg4 = shrimp.addChild("leg4", ModelPartBuilder.create().uv(4, 2).cuboid(0.0F, -0.75F, -0.5F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.75F, 2.018F, 3.853F));
		ModelPartData leg5 = shrimp.addChild("leg5", ModelPartBuilder.create().uv(0, 3).cuboid(0.0F, -0.25F, -0.5F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.75F, 1.518F, 1.853F));
		ModelPartData leg6 = shrimp.addChild("leg6", ModelPartBuilder.create().uv(2, 0).cuboid(0.0F, -0.25F, -0.5F, 0.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, 1.518F, -0.147F));
		ModelPartData tail = shrimp.addChild("tail", ModelPartBuilder.create().uv(12, 9).cuboid(-1.0F, -0.6512F, -1.9253F, 2.0F, 4.0F, 3.0F, new Dilation(0.0F))
			.uv(22, 17).cuboid(-1.0F, -0.6512F, -1.9253F, 2.0F, 4.0F, 3.0F, new Dilation(0.1F)), ModelTransform.of(0.0F, -0.0418F, 4.4235F, 1.0908F, 0.0F, 0.0F));
		ModelPartData tail_jelly = tail.addChild("tail_jelly", ModelPartBuilder.create().uv(22, 0).cuboid(-2.0F, -2.0F, 5.0F, 2.0F, 4.0F, 3.0F, new Dilation(0.5F)), ModelTransform.pivot(1.0F, 1.3488F, -6.9253F));
		ModelPartData tail2 = tail.addChild("tail2", ModelPartBuilder.create().uv(0, 12).cuboid(0.0F, -1.0F, -3.5F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.2874F, -0.6744F, 0.48F, 0.0F, 0.0F));

		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(SlimyShrimpEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.bodyJelly.visible = !entity.isSheared();
		this.tailJelly.visible = !entity.isSheared();
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}
}
