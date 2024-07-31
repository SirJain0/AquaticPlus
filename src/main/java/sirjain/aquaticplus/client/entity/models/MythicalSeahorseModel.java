package sirjain.aquaticplus.client.entity.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import sirjain.aquaticplus.entity.entities.MythicalSeahorseEntity;

public class MythicalSeahorseModel extends EntityModel<MythicalSeahorseEntity> {
	private final ModelPart root;
	private final ModelPart mythicalSeahorse;
	private final ModelPart tail;
	private final ModelPart tail2;
	private final ModelPart head;

	public MythicalSeahorseModel(ModelPart part) {
		this.root = part;
		this.mythicalSeahorse = root.getChild("mythical_seahorse");
		this.tail = mythicalSeahorse.getChild("tail");
		this.tail2 = tail.getChild("tail2");
		this.head = mythicalSeahorse.getChild("head");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData mythical_seahorse = modelPartData.addChild("mythical_seahorse", ModelPartBuilder.create().uv(0, 0).cuboid(-3.5F, -5.6667F, -7.6811F, 7.0F, 10.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 16.6667F, 3.6811F));
		ModelPartData cube_r1 = mythical_seahorse.addChild("cube_r1", ModelPartBuilder.create().uv(0, 9).mirrored().cuboid(0.0F, -8.0F, -1.0F, 0.0F, 16.0F, 8.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-1.0F, 0.3333F, -0.6811F, 0.0F, -0.3927F, 0.0F));
		ModelPartData cube_r2 = mythical_seahorse.addChild("cube_r2", ModelPartBuilder.create().uv(0, 9).cuboid(0.0F, -8.0F, -1.0F, 0.0F, 16.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 0.3333F, -0.6811F, 0.0F, 0.3927F, 0.0F));
		ModelPartData tail = mythical_seahorse.addChild("tail", ModelPartBuilder.create().uv(16, 27).cuboid(-2.0F, -1.0F, -2.0F, 4.0F, 8.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 4.3333F, -3.6811F));
		ModelPartData tail2 = tail.addChild("tail2", ModelPartBuilder.create().uv(28, 7).cuboid(-1.0F, -1.5F, -3.0F, 2.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.5F, -1.0F));
		ModelPartData head = mythical_seahorse.addChild("head", ModelPartBuilder.create().uv(16, 17).cuboid(-3.0F, -5.1794F, -2.8971F, 6.0F, 5.0F, 5.0F, new Dilation(0.0F))
			.uv(21, 0).cuboid(-1.0F, -2.1794F, -7.8971F, 2.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -5.4873F, -3.784F));
		ModelPartData cube_r3 = head.addChild("cube_r3", ModelPartBuilder.create().uv(32, 27).cuboid(-1.0F, -2.5F, -1.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -6.1794F, -0.3971F, -0.3927F, 0.0F, 0.0F));

		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(MythicalSeahorseEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		mythicalSeahorse.pivotY = -(MathHelper.cos(animationProgress * 0.08f) * 1.5f);
		tail.pitch = MathHelper.cos(animationProgress * 0.08f) * 0.3f;
		tail2.pitch = MathHelper.cos(-20 + animationProgress * 0.08f) * 0.8f;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		matrices.scale(1.2f, 1.2f, 1.2f);
		mythicalSeahorse.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}
}
