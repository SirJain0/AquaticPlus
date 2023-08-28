package com.sirjain.entities.renderers;

import com.sirjain.AquaticPlus;
import com.sirjain.entities.entity.KelpEelEntity;
import com.sirjain.entities.models.KelpEelModel;
import com.sirjain.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class KelpEelRenderer extends MobEntityRenderer<KelpEelEntity, KelpEelModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entities/eels/kelp_eel.png");

	public KelpEelRenderer(EntityRendererFactory.Context context) {
		super(context, new KelpEelModel(context.getPart(AquaticPlusEntities.KELP_EEL_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(KelpEelEntity entity) {
		return TEXTURE;
	}
}
