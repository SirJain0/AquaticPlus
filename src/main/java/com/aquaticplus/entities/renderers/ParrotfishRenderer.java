package com.aquaticplus.entities.renderers;

import com.aquaticplus.AquaticPlus;
import com.aquaticplus.entities.entity.ParrotfishEntity;
import com.aquaticplus.entities.models.ParrotfishModel;
import com.aquaticplus.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class ParrotfishRenderer extends MobEntityRenderer<ParrotfishEntity, ParrotfishModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/parrotfish.png");

	public ParrotfishRenderer(EntityRendererFactory.Context context) {
		super(context, new ParrotfishModel(context.getPart(AquaticPlusEntities.PARROTFISH_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(ParrotfishEntity entity) {
		return TEXTURE;
	}
}