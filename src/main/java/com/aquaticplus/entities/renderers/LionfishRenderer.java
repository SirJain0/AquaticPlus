package com.aquaticplus.entities.renderers;

import com.aquaticplus.AquaticPlus;
import com.aquaticplus.entities.entity.LionfishEntity;
import com.aquaticplus.entities.models.LionfishModel;
import com.aquaticplus.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class LionfishRenderer extends MobEntityRenderer<LionfishEntity, LionfishModel> {
	public LionfishRenderer(EntityRendererFactory.Context context) {
		super(context, new LionfishModel(context.getPart(AquaticPlusEntities.LIONFISH_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(LionfishEntity entity) {
		String variantName = entity.getVariant().name().toLowerCase();
		return new Identifier(AquaticPlus.MOD_ID, "textures/entity/lionfish/" + variantName + ".png");
	}
}
