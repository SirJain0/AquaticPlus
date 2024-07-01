package sirjain.aquaticplus.client.entity.models.projectile;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import sirjain.aquaticplus.entity.entities.projectile.PlasmaEntity;

public class PlasmaModel<T extends PlasmaEntity> extends SinglePartEntityModel<T> {
	private final ModelPart root;
	private final ModelPart plasma;

	public PlasmaModel(ModelPart root) {
		this.root = root;
		this.plasma = root.getChild("plasma");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData plasma = modelPartData.addChild("plasma", ModelPartBuilder.create().uv(30, 10).cuboid(-5.0F, -13.0F, -5.0F, 10.0F, 10.0F, 10.0F, new Dilation(0.0F))
			.uv(0, 20).cuboid(-5.0F, -13.0F, -5.0F, 10.0F, 10.0F, 10.0F, new Dilation(0.3F))
			.uv(0, 0).cuboid(-5.0F, -13.0F, -5.0F, 10.0F, 10.0F, 10.0F, new Dilation(-0.6F)), ModelTransform.pivot(0.0F, 31.0F, 0.0F));

		return TexturedModelData.of(modelData, 128, 128);
	}

	@Override
	public ModelPart getPart() {
		return this.root;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		matrices.translate(0, -0.8f, 0);
		plasma.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}

	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

	}
}