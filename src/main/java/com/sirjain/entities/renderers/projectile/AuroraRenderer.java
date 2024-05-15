package com.sirjain.entities.renderers.projectile;

import com.sirjain.AquaticPlus;
import com.sirjain.entities.entity.projectile.AuroraEntity;
import com.sirjain.entities.models.projectile.AuroraModel;
import com.sirjain.registries.AquaticPlusEntities;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class AuroraRenderer extends EntityRenderer<AuroraEntity> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/projectile/aurora.png");
	private static final RenderLayer LAYER = RenderLayer.getEntitySolid(TEXTURE);
	private final AuroraModel<AuroraEntity> model;

	public AuroraRenderer(EntityRendererFactory.Context ctx) {
		super(ctx);
		this.model = new AuroraModel<>(ctx.getPart(AquaticPlusEntities.AURORA_LAYER));
	}

	@Override
	public Identifier getTexture(AuroraEntity entity) {
		return TEXTURE;
	}

	@Override
	public void render(AuroraEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
		matrices.push();
		VertexConsumer vertexConsumer2 = vertexConsumers.getBuffer(LAYER);
		this.model.render(matrices, vertexConsumer2, light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 0.15F);
		matrices.pop();
	}
}