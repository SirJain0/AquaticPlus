package sirjain.aquaticplus.client.entity.models;

import sirjain.aquaticplus.entity.entities.SeaPenEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class SeaPenModel extends EntityModel<SeaPenEntity> {
	private final ModelPart root;
	private final ModelPart seaPen;

	public SeaPenModel(ModelPart part) {
		root = part;
		seaPen = root.getChild("sea_pen");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData bone = modelPartData.addChild("sea_pen", ModelPartBuilder.create().uv(28, 0).cuboid(-1.0F, -10.0F, -1.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F))
			.uv(24, 15).cuboid(-2.0F, -3.0F, -2.0F, 4.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		ModelPartData cube_r1 = bone.addChild("cube_r1", ModelPartBuilder.create().uv(0, 19).cuboid(-4.0F, -6.5F, -3.0F, 8.0F, 13.0F, 6.0F, new Dilation(0.0F))
			.uv(0, 0).cuboid(-4.0F, -6.5F, -3.0F, 8.0F, 13.0F, 6.0F, new Dilation(0.3F))
			.uv(0, 0).cuboid(-4.0F, -6.5F, -3.0F, 8.0F, 13.0F, 6.0F, new Dilation(0.3F))
			.uv(0, 19).cuboid(-4.0F, -6.5F, -3.0F, 8.0F, 13.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -10.5F, 2.0F, -0.2182F, 0.0F, 0.0F));

		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(SeaPenEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		seaPen.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}
}
