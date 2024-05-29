package com.aquaticplus.entities.renderers;

import com.aquaticplus.AquaticPlus;
import com.aquaticplus.entities.entity.DeepSeaIsopodEntity;
import com.aquaticplus.entities.entity.NeonCrabEntity;
import com.aquaticplus.entities.models.DeepSeaIsopodModel;
import com.aquaticplus.entities.models.NeonCrabModel;
import com.aquaticplus.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class DeepSeaIsopodRenderer extends MobEntityRenderer<DeepSeaIsopodEntity, DeepSeaIsopodModel> {
	public DeepSeaIsopodRenderer(EntityRendererFactory.Context context) {
		super(context, new DeepSeaIsopodModel(context.getPart(AquaticPlusEntities.DEEP_SEA_ISOPOD_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(DeepSeaIsopodEntity entity) {
		return buildTexture(entity);
	}

	public Identifier buildTexture(DeepSeaIsopodEntity entity) {
		String variantName = entity.isFrostpod() ? "frostpod" : "deep_sea_isopod";
		return new Identifier(AquaticPlus.MOD_ID, "textures/entity/deep_sea_isopod/" + variantName + ".png");
	}
}