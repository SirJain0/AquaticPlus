package com.sirjain.entities.renderers;

import com.sirjain.AquaticPlus;
import com.sirjain.entities.entity.DumboBlobEntity;
import com.sirjain.entities.features.DumboBlobEmissiveTextureFeature;
import com.sirjain.entities.models.DumboBlobModel;
import com.sirjain.registries.AquaticPlusEntities;
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
		return switch(entity.getVariant()) {
			case BLUE_PURPLE -> buildTextureID("blue_purple");
			case PINK_ORANGE -> buildTextureID("pink_orange");
			case GREEN -> buildTextureID("green");
			case ORANGE_YELLOW -> buildTextureID("orange_yellow");
		};
	}

	public static Identifier buildTextureID(String id) {
		return new Identifier(AquaticPlus.MOD_ID, "textures/entity/dumbo_blob/dumbo_blob_" + id + ".png");
	}
}