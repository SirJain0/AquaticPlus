package com.sirjain.entities.features;

import com.sirjain.AquaticPlus;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

import static com.sirjain.entities.entity.ViperfishEntity.SHOULD_ILLUMINATE;

@Environment(EnvType.CLIENT)
public class ViperfishEmissiveTextureFeature<T extends Entity, M extends EntityModel<T>> extends EyesFeatureRenderer<T, M> {
	private static final Identifier EMISSIVE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/viperfish/viperfish_e.png");

	public ViperfishEmissiveTextureFeature(FeatureRendererContext<T, M> featureRendererContext) {
		super(featureRendererContext);
	}

	@Override
	public RenderLayer getEyesTexture() {
		return RenderLayer.getEyes(EMISSIVE);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, T entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
		if (entity.getDataTracker().get(SHOULD_ILLUMINATE))
			super.render(matrices, vertexConsumers, light, entity, limbAngle, limbDistance, tickDelta, animationProgress, headYaw, headPitch);
	}
}