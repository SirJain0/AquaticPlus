package com.sirjain.entities.renderers;

import com.sirjain.AquaticPlus;
import com.sirjain.entities.entity.GulperEelEntity;
import com.sirjain.entities.models.GulperEelModel;
import com.sirjain.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class GulperEelRenderer extends MobEntityRenderer<GulperEelEntity, GulperEelModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/eels/gulper_eel.png");

	public GulperEelRenderer(EntityRendererFactory.Context context) {
		super(context, new GulperEelModel(context.getPart(AquaticPlusEntities.GULPER_EEL_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(GulperEelEntity entity) {
		return TEXTURE;
	}
}
