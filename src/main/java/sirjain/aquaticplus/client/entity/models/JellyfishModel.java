package sirjain.aquaticplus.client.entity.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import sirjain.aquaticplus.entity.entities.JellyfishEntity;

public class JellyfishModel extends EntityModel<JellyfishEntity> {
	private final ModelPart root;
	private final ModelPart jellyfish;
	private final ModelPart tentacle1;
	private final ModelPart tentacle2;
	private final ModelPart tentacle3;
	private final ModelPart tentacle4;
	private final ModelPart tentacle5;
	private final ModelPart tentacle6;
	private final ModelPart tentacle7;
	private final ModelPart tentacle8;

	public JellyfishModel(ModelPart part) {
		root = part;
		jellyfish = root.getChild("jellyfish");
		tentacle1 = jellyfish.getChild("tentacle1");
		tentacle2 = jellyfish.getChild("tentacle2");
		tentacle3 = jellyfish.getChild("tentacle3");
		tentacle4 = jellyfish.getChild("tentacle4");
		tentacle5 = jellyfish.getChild("tentacle5");
		tentacle6 = jellyfish.getChild("tentacle6");
		tentacle7 = jellyfish.getChild("tentacle7");
		tentacle8 = jellyfish.getChild("tentacle8");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();

		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData jellyfish = modelPartData.addChild("jellyfish", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -19.5F, -8.0F, 16.0F, 9.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 22.5F, 0.0F));
		ModelPartData tentacle1 = jellyfish.addChild("tentacle1", ModelPartBuilder.create(), ModelTransform.of(-5.5F, -10.5F, 0.0F, 0.0F, 0.0F, 0.2618F));
		ModelPartData cube_r1 = tentacle1.addChild("cube_r1", ModelPartBuilder.create().uv(0, 25).cuboid(-1.5F, -10.5F, -7.0F, 3.0F, 21.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(5.5F, 10.5F, 0.0F, 0.0F, 1.5708F, 0.0F));
		ModelPartData tentacle2 = jellyfish.addChild("tentacle2", ModelPartBuilder.create(), ModelTransform.of(5.5F, -10.5F, 0.0F, 0.0F, 0.0F, -0.2618F));
		ModelPartData cube_r2 = tentacle2.addChild("cube_r2", ModelPartBuilder.create().uv(0, 25).cuboid(-1.5F, -10.5F, -7.0F, 3.0F, 21.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-5.5F, 10.5F, 0.0F, 0.0F, -1.5708F, 0.0F));
		ModelPartData tentacle3 = jellyfish.addChild("tentacle3", ModelPartBuilder.create(), ModelTransform.of(0.0F, -10.5F, -5.5F, -0.2618F, 0.0F, 0.0F));
		ModelPartData cube_r3 = tentacle3.addChild("cube_r3", ModelPartBuilder.create().uv(0, 25).cuboid(-1.5F, -10.5F, -7.0F, 3.0F, 21.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 10.5F, 5.5F, 0.0F, 0.0F, 0.0F));
		ModelPartData tentacle4 = jellyfish.addChild("tentacle4", ModelPartBuilder.create(), ModelTransform.of(0.0F, -10.5F, 5.5F, 0.2618F, 0.0F, 0.0F));
		ModelPartData cube_r4 = tentacle4.addChild("cube_r4", ModelPartBuilder.create().uv(0, 25).cuboid(-1.5F, -10.5F, -7.0F, 3.0F, 21.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 10.5F, -5.5F, -3.1416F, 0.0F, 3.1416F));
		ModelPartData tentacle5 = jellyfish.addChild("tentacle5", ModelPartBuilder.create(), ModelTransform.of(-4.5962F, -10.5F, -4.5962F, -0.1745F, 0.0F, 0.1745F));
		ModelPartData cube_r5 = tentacle5.addChild("cube_r5", ModelPartBuilder.create().uv(0, 25).cuboid(-1.5F, -10.5F, -8.0F, 3.0F, 21.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(4.5962F, 10.5F, 4.5962F, 0.0F, 0.7854F, 0.0F));
		ModelPartData tentacle6 = jellyfish.addChild("tentacle6", ModelPartBuilder.create(), ModelTransform.of(4.5962F, -10.5F, 4.5962F, 0.1745F, 0.0F, -0.1745F));
		ModelPartData cube_r6 = tentacle6.addChild("cube_r6", ModelPartBuilder.create().uv(0, 25).cuboid(-1.5F, -10.5F, -8.0F, 3.0F, 21.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-4.5962F, 10.5F, -4.5962F, -3.1416F, -0.7854F, 3.1416F));
		ModelPartData tentacle7 = jellyfish.addChild("tentacle7", ModelPartBuilder.create(), ModelTransform.of(4.7923F, -10.5F, -4.3913F, -0.1745F, 0.0F, -0.1745F));
		ModelPartData cube_r7 = tentacle7.addChild("cube_r7", ModelPartBuilder.create().uv(0, 25).cuboid(-1.75F, -10.5F, -8.0F, 3.0F, 21.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-4.7923F, 10.5F, 4.3913F, 0.0F, -0.829F, 0.0F));
		ModelPartData tentacle8 = jellyfish.addChild("tentacle8", ModelPartBuilder.create(), ModelTransform.of(-4.7923F, -10.5F, 4.3913F, 0.1745F, 0.0F, 0.1745F));
		ModelPartData cube_r8 = tentacle8.addChild("cube_r8", ModelPartBuilder.create().uv(0, 25).cuboid(-1.75F, -10.5F, -8.0F, 3.0F, 21.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(4.7923F, 10.5F, -4.3913F, -3.1416F, 0.829F, 3.1416F));

		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(JellyfishEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		tentacle1.roll = 0.5f + MathHelper.cos(-0.8f + animationProgress * 0.1f) * 0.25f;
		tentacle2.roll = -(0.5f + MathHelper.cos(-0.8f + animationProgress * 0.1f) * 0.25f);
		tentacle3.pitch = -(0.5f + MathHelper.cos(-0.8f + animationProgress * 0.1f) * 0.25f);
		tentacle4.pitch = 0.5f + MathHelper.cos(-0.8f + animationProgress * 0.1f) * 0.25f;
		tentacle5.roll = 0.42f + MathHelper.cos(animationProgress * 0.1f) * 0.22f;
		tentacle5.pitch = -(0.42f + MathHelper.cos(animationProgress * 0.1f) * 0.22f);
		tentacle6.roll = -(0.42f + MathHelper.cos(animationProgress * 0.1f) * 0.22f);
		tentacle6.pitch = 0.42f + MathHelper.cos(animationProgress * 0.1f) * 0.22f;
		tentacle7.roll = -(0.42f + MathHelper.cos(animationProgress * 0.1f) * 0.22f);
		tentacle7.pitch = -(0.42f + MathHelper.cos(animationProgress * 0.1f) * 0.22f);
		tentacle8.roll = 0.42f + MathHelper.cos(animationProgress * 0.1f) * 0.22f;
		tentacle8.pitch = 0.42f + MathHelper.cos(animationProgress * 0.1f) * 0.22f;

		jellyfish.pivotY = -(MathHelper.cos(40 + animationProgress * 0.1f) * 0.5f);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		jellyfish.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}
}
