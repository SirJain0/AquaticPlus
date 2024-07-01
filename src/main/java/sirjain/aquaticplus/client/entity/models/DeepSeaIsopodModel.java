package sirjain.aquaticplus.client.entity.models;

import sirjain.aquaticplus.entity.entities.DeepSeaIsopodEntity;
import sirjain.aquaticplus.entity.entities.animation.DeepSeaIsopodAnimations;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;

public class DeepSeaIsopodModel extends SinglePartEntityModel<DeepSeaIsopodEntity> {
	private final ModelPart root;
	private final ModelPart isopod;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart leg4;
	private final ModelPart leg5;
	private final ModelPart leg6;
	private final ModelPart leg7;
	private final ModelPart leg8;
	private final ModelPart body;

	public DeepSeaIsopodModel(ModelPart part) {
		this.root = part;
		this.isopod = root.getChild("isopod");
		this.leg1 = isopod.getChild("leg1");
		this.leg2 = isopod.getChild("leg2");
		this.leg3 = isopod.getChild("leg3");
		this.leg4 = isopod.getChild("leg4");
		this.leg5 = isopod.getChild("leg5");
		this.leg6 = isopod.getChild("leg6");
		this.leg7 = isopod.getChild("leg7");
		this.leg8 = isopod.getChild("leg8");
		this.body = isopod.getChild("body");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData isopod = modelPartData.addChild("isopod", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 20.8733F, -0.9233F));
		ModelPartData leg1 = isopod.addChild("leg1", ModelPartBuilder.create().uv(33, 9).cuboid(-1.0F, -0.5F, -1.5F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 1.6267F, -2.5767F));
		ModelPartData leg2 = isopod.addChild("leg2", ModelPartBuilder.create().uv(7, 107).cuboid(-1.0F, -0.5F, -1.5F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 1.6267F, 1.4233F));
		ModelPartData leg3 = isopod.addChild("leg3", ModelPartBuilder.create().uv(33, 9).cuboid(-1.0F, -0.5F, -1.5F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 1.6267F, 5.4233F));
		ModelPartData leg4 = isopod.addChild("leg4", ModelPartBuilder.create().uv(7, 107).cuboid(-1.0F, -0.5F, -1.5F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 1.6267F, 9.4233F));
		ModelPartData leg5 = isopod.addChild("leg5", ModelPartBuilder.create().uv(33, 9).mirrored().cuboid(-1.0F, -0.5F, -1.5F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-2.0F, 1.6267F, -2.5767F));
		ModelPartData leg6 = isopod.addChild("leg6", ModelPartBuilder.create().uv(7, 107).mirrored().cuboid(-1.0F, -0.5F, -1.5F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-2.0F, 1.6267F, 1.4233F));
		ModelPartData leg7 = isopod.addChild("leg7", ModelPartBuilder.create().uv(33, 9).mirrored().cuboid(-1.0F, -0.5F, -1.5F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-2.0F, 1.6267F, 5.4233F));
		ModelPartData leg8 = isopod.addChild("leg8", ModelPartBuilder.create().uv(7, 107).mirrored().cuboid(-1.0F, -0.5F, -1.5F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-2.0F, 1.6267F, 9.4233F));
		ModelPartData body = isopod.addChild("body", ModelPartBuilder.create().uv(4, 0).mirrored().cuboid(-4.0F, -4.4429F, -19.5643F, 2.0F, 0.0F, 9.0F, new Dilation(0.0F)).mirrored(false)
			.uv(0, 24).cuboid(-4.0F, -7.4429F, -8.1643F, 8.0F, 7.0F, 17.0F, new Dilation(0.0F))
			.uv(0, 0).cuboid(-4.0F, -7.4429F, -7.4143F, 8.0F, 7.0F, 17.0F, new Dilation(0.2F))
			.uv(0, 55).cuboid(-4.0F, -7.4429F, -8.1643F, 8.0F, 7.0F, 17.0F, new Dilation(0.4F))
			.uv(33, 24).cuboid(-2.5F, -5.9429F, -12.3143F, 5.0F, 5.0F, 4.0F, new Dilation(0.0F))
			.uv(33, 0).cuboid(-2.5F, -6.3429F, -12.3143F, 5.0F, 5.0F, 4.0F, new Dilation(0.2F))
			.uv(4, 0).cuboid(2.0F, -4.4429F, -19.5643F, 2.0F, 0.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 1.5695F, 3.0876F));

		return TexturedModelData.of(modelData, 128, 128);
	}

	@Override
	public ModelPart getPart() {
		return this.isopod;
	}

	@Override
	public void setAngles(DeepSeaIsopodEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		if (entity.isBellyrubbed()) isopod.roll = 1.6F;
		this.animateMovement(DeepSeaIsopodAnimations.ISOPOD_WALK, limbSwing, limbSwingAmount, 9.0F, 100.0F);
	}
}
