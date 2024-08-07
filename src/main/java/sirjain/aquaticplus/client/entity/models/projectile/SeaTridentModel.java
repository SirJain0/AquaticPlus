package sirjain.aquaticplus.client.entity.models.projectile;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import sirjain.aquaticplus.entity.entities.template.SeaTridentEntity;

public class SeaTridentModel<T extends SeaTridentEntity> extends SinglePartEntityModel<T> {
	private final ModelPart root;
	private final ModelPart seaTrident;

	public SeaTridentModel(ModelPart root) {
		this.root = root;
		this.seaTrident = root.getChild("sea_trident");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData group = modelPartData.addChild("sea_trident", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 16.0F, 0.0F));

		ModelPartData head = group.addChild("head", ModelPartBuilder.create().uv(14, 4).cuboid(-3.0F, -23.0F, 0.0F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F))
			.uv(4, 16).cuboid(-2.0F, -1.0F, 0.5F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
			.uv(14, 12).cuboid(-1.0F, -21.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
			.uv(14, 2).cuboid(-4.0F, -18.0F, 0.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
			.uv(14, 0).cuboid(-5.0F, -19.0F, 0.0F, 5.0F, 1.0F, 1.0F, new Dilation(0.0F))
			.uv(14, 9).cuboid(-5.0F, -21.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
			.uv(14, 15).cuboid(-4.0F, -1.0F, 0.5F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
			.uv(4, 8).cuboid(-2.0F, -17.0F, 0.5F, 5.0F, 8.0F, 0.0F, new Dilation(0.0F))
			.uv(4, 0).cuboid(-8.0F, -17.0F, 0.5F, 5.0F, 8.0F, 0.0F, new Dilation(0.0F))
			.uv(0, 0).cuboid(-3.0F, -17.0F, 0.0F, 1.0F, 18.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, 7.0F, -1.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}

	@Override
	public ModelPart getPart() {
		return seaTrident;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		matrices.translate(0, -0.8f, 0);
		seaTrident.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}

	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

	}
}
