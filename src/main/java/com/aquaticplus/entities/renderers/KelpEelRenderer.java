package com.aquaticplus.entities.renderers;

import com.aquaticplus.AquaticPlus;
import com.aquaticplus.entities.entity.KelpEelEntity;
import com.aquaticplus.entities.models.KelpEelModel;
import com.aquaticplus.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class KelpEelRenderer extends MobEntityRenderer<KelpEelEntity, KelpEelModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/eels/kelp_eel.png");

	public KelpEelRenderer(EntityRendererFactory.Context context) {
		super(context, new KelpEelModel(context.getPart(AquaticPlusEntities.KELP_EEL_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(KelpEelEntity entity) {
		return TEXTURE;
	}
}
