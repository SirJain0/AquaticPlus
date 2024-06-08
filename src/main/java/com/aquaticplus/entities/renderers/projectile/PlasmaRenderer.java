package com.aquaticplus.entities.renderers.projectile;

import com.aquaticplus.AquaticPlus;
import com.aquaticplus.entities.entity.projectile.PlasmaEntity;
import com.aquaticplus.entities.models.projectile.PlasmaModel;
import com.aquaticplus.registries.AquaticPlusEntities;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class PlasmaRenderer extends EntityRenderer<PlasmaEntity> {
	private static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/plasma.png");
	private final PlasmaModel<PlasmaEntity> model;

	public PlasmaRenderer(EntityRendererFactory.Context context) {
		super(context);
		this.model = new PlasmaModel<>(context.getPart(AquaticPlusEntities.PLASMA_LAYER));
	}

	@Override
	protected int getBlockLight(PlasmaEntity entity, BlockPos pos) {
		return 15;
	}

	@Override
	protected int getSkyLight(PlasmaEntity entity, BlockPos pos) {
		return 15;
	}

	@Override
	public void render(PlasmaEntity entity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
		matrixStack.push();
		VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(this.model.getLayer(TEXTURE));
		this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
		matrixStack.pop();

		super.render(entity, f, g, matrixStack, vertexConsumerProvider, i);
	}

	@Override
	public Identifier getTexture(PlasmaEntity entity) {
		return TEXTURE;
	}
}
