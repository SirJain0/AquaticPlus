package com.sirjain.entities.renderers;

import com.sirjain.AquaticPlus;
import com.sirjain.entities.entity.ParrotfishEntity;
import com.sirjain.entities.models.ParrotfishModel;
import com.sirjain.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class ParrotfishRenderer extends MobEntityRenderer<ParrotfishEntity, ParrotfishModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/parrotfish/parrotfish.png");

	public ParrotfishRenderer(EntityRendererFactory.Context context) {
		super(context, new ParrotfishModel(context.getPart(AquaticPlusEntities.PARROTFISH_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(ParrotfishEntity entity) {
		return TEXTURE;
	}
}