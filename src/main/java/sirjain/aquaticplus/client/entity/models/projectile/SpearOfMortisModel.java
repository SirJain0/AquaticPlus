package sirjain.aquaticplus.client.entity.models.projectile;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import sirjain.aquaticplus.entity.entities.projectile.SpearOfMortisEntity;

public class SpearOfMortisModel<T extends SpearOfMortisEntity> extends SinglePartEntityModel<T> {
	private final ModelPart root;
	private final ModelPart spear;
	private final ModelPart head;
	private final ModelPart handle;

	public SpearOfMortisModel(ModelPart root) {
		this.root = root;
		this.spear = root.getChild("spear");
		this.head = spear.getChild("head");
		this.handle = spear.getChild("handle");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData spear = modelPartData.addChild("spear", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 16.0F, 0.0F));

		ModelPartData head = spear.addChild("head", ModelPartBuilder.create().uv(4, 0).cuboid(-4.0F, -21.0F, -1.0F, 3.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, 2.0F, -1.0F));

		ModelPartData handle = spear.addChild("handle", ModelPartBuilder.create().uv(0, 0).cuboid(2.0F, -31.0F, 0.0F, 1.0F, 22.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 17.0F, -1.0F));

		ModelPartData cube_r1 = handle.addChild("cube_r1", ModelPartBuilder.create().uv(4, 9).cuboid(-0.5F, 0.0F, -0.5F, 3.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -31.0F, 0.5F, 0.0F, 0.0F, 0.5236F));

		ModelPartData cube_r2 = handle.addChild("cube_r2", ModelPartBuilder.create().uv(4, 8).cuboid(-2.5F, 0.0F, -0.5F, 3.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, -31.0F, 0.5F, 0.0F, 0.0F, -0.5236F));

		return TexturedModelData.of(modelData, 32, 32);
	}

	@Override
	public ModelPart getPart() {
		return spear;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		spear.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}

	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

	}
}
