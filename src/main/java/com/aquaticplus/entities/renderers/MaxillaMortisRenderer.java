package com.aquaticplus.entities.renderers;

import com.aquaticplus.AquaticPlus;
import com.aquaticplus.entities.entity.MaxillaMortisEntity;
import com.aquaticplus.entities.features.MaxillaMortisEmissiveTextureFeature;
import com.aquaticplus.entities.models.MaxillaMortisModel;
import com.aquaticplus.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class MaxillaMortisRenderer extends MobEntityRenderer<MaxillaMortisEntity, MaxillaMortisModel> {
	private static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/maxilla_mortis/maxilla_mortis.png");
	private static final Identifier PURPLE_TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/maxilla_mortis/maxilla_mortis_purple.png");

	public MaxillaMortisRenderer(EntityRendererFactory.Context context) {
		super(context, new MaxillaMortisModel(context.getPart(AquaticPlusEntities.MAXILLA_MORTIS_LAYER)), 0.5f);
		this.addFeature(new MaxillaMortisEmissiveTextureFeature<>(this));
	}

	@Override
	public Identifier getTexture(MaxillaMortisEntity entity) {
		return entity.canRecolor() ? PURPLE_TEXTURE : TEXTURE;
	}
}