package com.sirjain.entities.renderers;

import com.sirjain.AquaticPlus;
import com.sirjain.entities.entity.SardineEntity;
import com.sirjain.entities.models.SardineModel;
import com.sirjain.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class SardineRenderer extends MobEntityRenderer<SardineEntity, SardineModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/sardine/sardine.png");

	public SardineRenderer(EntityRendererFactory.Context context) {
		super(context, new SardineModel(context.getPart(AquaticPlusEntities.SARDINE_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(SardineEntity entity) {
		return TEXTURE;
	}
}
