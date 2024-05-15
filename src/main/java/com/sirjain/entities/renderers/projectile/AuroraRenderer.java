package com.sirjain.entities.renderers.projectile;

import com.sirjain.AquaticPlus;
import com.sirjain.entities.entity.projectile.AuroraEntity;
import com.sirjain.entities.models.projectile.AuroraModel;
import com.sirjain.registries.AquaticPlusEntities;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

public class AuroraRenderer extends EntityRenderer<AuroraEntity> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/projectile/aurora.png");
	private static final RenderLayer LAYER = RenderLayer.getEntityTranslucent(TEXTURE);
	private final AuroraModel<AuroraEntity> model;

	public AuroraRenderer(EntityRendererFactory.Context ctx) {
		super(ctx);
		this.model = new AuroraModel<>(ctx.getPart(AquaticPlusEntities.VOLAN_AURORA_LAYER));
	}

	@Override
	public Identifier getTexture(AuroraEntity entity) {
		return TEXTURE;
	}
}