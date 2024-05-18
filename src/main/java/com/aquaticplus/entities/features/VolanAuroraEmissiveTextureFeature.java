package com.aquaticplus.entities.features;

import com.aquaticplus.AquaticPlus;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

import static com.aquaticplus.entities.entity.VolanAuroraEntity.IS_ANGRY;

@Environment(EnvType.CLIENT)
public class VolanAuroraEmissiveTextureFeature<T extends Entity, M extends EntityModel<T>> extends EyesFeatureRenderer<T, M> {
	private static final Identifier EMISSIVE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/volan_aurora/volan_aurora_emissive.png");
	private static final Identifier ANGRY_EMISSIVE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/volan_aurora/volan_aurora_angry_emissive.png");
	public boolean isAngry;

	public VolanAuroraEmissiveTextureFeature(FeatureRendererContext<T, M> featureRendererContext) {
		super(featureRendererContext);
	}

	@Override
	public RenderLayer getEyesTexture() {
		return RenderLayer.getEyes(isAngry ? ANGRY_EMISSIVE : EMISSIVE);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, T entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
		this.isAngry = entity.getDataTracker().get(IS_ANGRY);

		VertexConsumer vertexConsumer = vertexConsumers.getBuffer(this.getEyesTexture());
		this.getContextModel().render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 0.4F);
	}
}