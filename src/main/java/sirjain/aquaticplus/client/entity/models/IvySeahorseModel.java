package sirjain.aquaticplus.client.entity.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import sirjain.aquaticplus.entity.entities.IvySeahorseEntity;

public class IvySeahorseModel extends EntityModel<IvySeahorseEntity> {
	private final ModelPart root;
	private final ModelPart ivySeahorse;
	private final ModelPart tail;
	private final ModelPart tail2;

	public IvySeahorseModel(ModelPart part) {
		this.root = part;
		this.ivySeahorse = root.getChild("seahorse");
		this.tail = ivySeahorse.getChild("tail");
		this.tail2 = tail.getChild("tail2");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData bone = modelPartData.addChild("seahorse", ModelPartBuilder.create().uv(0, 14).cuboid(-1.0F, -17.0F, -1.0F, 6.0F, 8.0F, 6.0F, new Dilation(0.0F))
			.uv(0, 0).cuboid(-1.0F, -17.0F, -1.0F, 6.0F, 8.0F, 6.0F, new Dilation(0.2F))
			.uv(10, 28).cuboid(-1.0F, -9.05F, -0.7F, 6.0F, 4.0F, 0.0F, new Dilation(0.0F))
			.uv(0, 0).cuboid(-0.999F, -9.05F, -0.7F, 0.0F, 4.0F, 2.0F, new Dilation(0.0F))
			.uv(0, 0).mirrored().cuboid(4.999F, -9.05F, -0.7F, 0.0F, 4.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
			.uv(19, 9).cuboid(-0.5F, -22.0F, 0.25F, 5.0F, 5.0F, 5.0F, new Dilation(0.0F))
			.uv(0, 23).cuboid(2.0F, -20.0F, 5.0F, 0.0F, 16.0F, 5.0F, new Dilation(0.0F))
			.uv(18, 0).cuboid(1.0F, -19.0F, -3.75F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 25.0F, -3.0F));
		ModelPartData tail = bone.addChild("tail", ModelPartBuilder.create().uv(24, 19).cuboid(-2.0F, -0.25F, -1.5F, 4.0F, 7.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, -8.75F, 3.5F));
		ModelPartData tail2 = tail.addChild("tail2", ModelPartBuilder.create().uv(27, 3).cuboid(-1.0F, -0.5F, -2.5F, 2.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 5.25F, -1.0F));

		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(IvySeahorseEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		// Animate
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		ivySeahorse.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}
}
