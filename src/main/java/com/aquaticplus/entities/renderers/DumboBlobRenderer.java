package com.aquaticplus.entities.renderers;

import com.aquaticplus.AquaticPlus;
import com.aquaticplus.entities.entity.DumboBlobEntity;
import com.aquaticplus.entities.features.DumboBlobEmissiveTextureFeature;
import com.aquaticplus.entities.models.DumboBlobModel;
import com.aquaticplus.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class DumboBlobRenderer extends MobEntityRenderer<DumboBlobEntity, DumboBlobModel> {
	public DumboBlobRenderer(EntityRendererFactory.Context context) {
		super(context, new DumboBlobModel(context.getPart(AquaticPlusEntities.DUMBO_BLOB_LAYER)), 0.75f);
		this.addFeature(new DumboBlobEmissiveTextureFeature<>(this));
	}

	@Override
	public Identifier getTexture(DumboBlobEntity entity) {
		String variantName = entity.getVariant().name().toLowerCase();
		return new Identifier(AquaticPlus.MOD_ID, "textures/entity/dumbo_blob/dumbo_blob_" + variantName + ".png");
	}
}