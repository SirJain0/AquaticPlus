package com.aquaticplus.entities.renderers;

import com.aquaticplus.AquaticPlus;
import com.aquaticplus.entities.entity.KelpEelEntity;
import com.aquaticplus.entities.entity.RibbonEelEntity;
import com.aquaticplus.entities.models.KelpEelModel;
import com.aquaticplus.entities.models.RibbonEelModel;
import com.aquaticplus.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class RibbonEelRenderer extends MobEntityRenderer<RibbonEelEntity, RibbonEelModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/eels/ribbon_eel.png");

	public RibbonEelRenderer(EntityRendererFactory.Context context) {
		super(context, new RibbonEelModel(context.getPart(AquaticPlusEntities.RIBBON_EEL_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(RibbonEelEntity entity) {
		return TEXTURE;
	}
}