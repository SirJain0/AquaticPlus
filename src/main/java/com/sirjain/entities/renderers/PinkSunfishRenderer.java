package com.sirjain.entities.renderers;

import com.sirjain.AquaticPlus;
import com.sirjain.entities.entity.PinkSunfishEntity;
import com.sirjain.entities.models.PinkSunfishModel;
import com.sirjain.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class PinkSunfishRenderer extends MobEntityRenderer<PinkSunfishEntity, PinkSunfishModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/pink_sunfish/pink_sunfish.png");

	public PinkSunfishRenderer(EntityRendererFactory.Context context) {
		super(context, new PinkSunfishModel(context.getPart(AquaticPlusEntities.PINK_SUNFISH_LAYER)), 0.75f);
	}

	@Override
	public Identifier getTexture(PinkSunfishEntity entity) {
		return TEXTURE;
	}
}