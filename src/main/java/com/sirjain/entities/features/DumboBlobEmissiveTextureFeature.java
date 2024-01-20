package com.sirjain.entities.features;

import com.sirjain.AquaticPlus;
import com.sirjain.entities.entity.DumboBlobEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class DumboBlobEmissiveTextureFeature<M extends EntityModel<DumboBlobEntity>> extends EyesFeatureRenderer<DumboBlobEntity, M> {
	private String variantID;

	public DumboBlobEmissiveTextureFeature(FeatureRendererContext<DumboBlobEntity, M> featureRendererContext) {
		super(featureRendererContext);
	}

	@Override
	public RenderLayer getEyesTexture() {
		return RenderLayer.getEyes(new Identifier(AquaticPlus.MOD_ID, "textures/entity/dumbo_blob/dumbo_blob_" + variantID + ".png"));
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, DumboBlobEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
		this.variantID = entity.getVariant().asString();

		VertexConsumer vertexConsumer = vertexConsumers.getBuffer(this.getEyesTexture());
		this.getContextModel().render(matrices, vertexConsumer, 20, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 0.4F);
	}
}
