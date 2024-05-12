package com.sirjain.entities.renderers;

import com.sirjain.AquaticPlus;
import com.sirjain.entities.entity.SeaPenEntity;
import com.sirjain.entities.models.SeaPenModel;
import com.sirjain.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class SeaPenRenderer extends MobEntityRenderer<SeaPenEntity, SeaPenModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/sea_pen.png");

	public SeaPenRenderer(EntityRendererFactory.Context context) {
		super(context, new SeaPenModel(context.getPart(AquaticPlusEntities.SEA_PEN_LAYER)), 0.3f);
	}

	@Override
	public Identifier getTexture(SeaPenEntity entity) {
		return TEXTURE;
	}
}