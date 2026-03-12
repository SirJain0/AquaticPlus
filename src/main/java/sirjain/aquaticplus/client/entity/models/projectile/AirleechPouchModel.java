package sirjain.aquaticplus.client.entity.models.projectile;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import sirjain.aquaticplus.entity.entities.projectile.AirleechPouchEntity;

public class AirleechPouchModel<T extends AirleechPouchEntity> extends SinglePartEntityModel<T> {
	ModelPart root;
	ModelPart airleechPouch;

	public AirleechPouchModel(ModelPart root) {
		this.root = root;
		this.airleechPouch = root.getChild("airleech_pouch");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData airleech_pouch = modelPartData.addChild("airleech_pouch", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		ModelPartData cube_r1 = airleech_pouch.addChild("cube_r1", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-3.5F, -3.0F, -3.5F, 7.0F, 6.0F, 7.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
		ModelPartData cube_r2 = airleech_pouch.addChild("cube_r2", ModelPartBuilder.create().uv(0, 0).cuboid(-3.5F, -3.0F, -3.5F, 7.0F, 6.0F, 7.0F, new Dilation(-0.5F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		return TexturedModelData.of(modelData, 32, 32);
	}

	@Override
	public ModelPart getPart() {
		return root;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		matrices.translate(0, -1f, 0);
		airleechPouch.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}

	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

	}
}
