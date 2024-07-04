package sirjain.aquaticplus.client.entity.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import sirjain.aquaticplus.entity.entities.OculiMagniEntity;

// TODO: Remodel
public class OculiMagniModel extends EntityModel<OculiMagniEntity> {
	private final ModelPart root;
	private final ModelPart main;
	private final ModelPart head;
	private final ModelPart tail;

	public OculiMagniModel(ModelPart part) {
		root = part;
		main = root.getChild("oculi_magni");
		head = main.getChild("head");
		tail = main.getChild("tail");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData oculi_magni = modelPartData.addChild("oculi_magni", ModelPartBuilder.create().uv(0, 0).cuboid(-2.5F, -0.75F, -5.0F, 5.0F, 4.0F, 10.0F, new Dilation(0.0F))
			.uv(0, 4).cuboid(0.0F, -1.75F, -5.0F, 0.0F, 1.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 18.75F, -1.0F));
		ModelPartData tail = oculi_magni.addChild("tail", ModelPartBuilder.create().uv(0, 7).cuboid(0.0F, -3.0F, 0.0F, 0.0F, 6.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 1.25F, 5.0F));
		ModelPartData head = oculi_magni.addChild("head", ModelPartBuilder.create().uv(16, 14).cuboid(-1.5F, -2.0F, -4.0F, 3.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 1.25F, -5.0F));

		return TexturedModelData.of(modelData, 32, 32);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}

	@Override
	public void setAngles(OculiMagniEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		tail.yaw = -MathHelper.sin(-40 + animationProgress * 0.4f) * 0.35f;
		main.pivotX = -MathHelper.sin(animationProgress * 0.4f) * 0.35f;
	}
}
