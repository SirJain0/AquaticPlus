package com.sirjain.entities.renderers;

import com.sirjain.AquaticPlus;
import com.sirjain.entities.entity.SardineEntity;
import com.sirjain.entities.models.SardineModel;
import com.sirjain.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class SardineRenderer extends MobEntityRenderer<SardineEntity, SardineModel> {
	public SardineRenderer(EntityRendererFactory.Context context) {
		super(context, new SardineModel(context.getPart(AquaticPlusEntities.SARDINE_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(SardineEntity entity) {
		String variantName = entity.getVariant().name().toLowerCase();
		return new Identifier(AquaticPlus.MOD_ID, "textures/entity/sardine/sardine_" + variantName + ".png");
	}
}