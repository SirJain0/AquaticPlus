package com.aquaticplus.entities.renderers;

import com.aquaticplus.AquaticPlus;
import com.aquaticplus.entities.entity.NeonCrabEntity;
import com.aquaticplus.entities.entity.YetiCrabEntity;
import com.aquaticplus.entities.models.NeonCrabModel;
import com.aquaticplus.entities.models.YetiCrabModel;
import com.aquaticplus.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class YetiCrabRenderer extends MobEntityRenderer<YetiCrabEntity, YetiCrabModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/crab/yeti_crab.png");

	public YetiCrabRenderer(EntityRendererFactory.Context context) {
		super(context, new YetiCrabModel(context.getPart(AquaticPlusEntities.YETI_CRAB_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(YetiCrabEntity entity) {
		return TEXTURE;
	}
}