package com.sirjain.entities.renderers;

import com.sirjain.AquaticPlus;
import com.sirjain.entities.entity.MaxillaMortisEntity;
import com.sirjain.entities.features.APEmissiveTextureFeature;
import com.sirjain.entities.models.MaxillaMortisModel;
import com.sirjain.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class MaxillaMortisRenderer extends MobEntityRenderer<MaxillaMortisEntity, MaxillaMortisModel> {
	private static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entities/maxilla_mortis/maxilla_mortis.png");
	private static final Identifier EMISSIVE = new Identifier(AquaticPlus.MOD_ID, "textures/entities/maxilla_mortis/maxilla_mortis_e.png");

	public MaxillaMortisRenderer(EntityRendererFactory.Context context) {
		super(context, new MaxillaMortisModel(context.getPart(AquaticPlusEntities.MAXILLA_MORTIS_LAYER)), 0.5f);
		this.addFeature(new APEmissiveTextureFeature<>(this, EMISSIVE));
	}

	@Override
	public Identifier getTexture(MaxillaMortisEntity entity) {
		return TEXTURE;
	}
}