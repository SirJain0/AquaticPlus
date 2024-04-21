package com.sirjain.entities.renderers;

import com.sirjain.AquaticPlus;
import com.sirjain.entities.entity.FrostedSplasherEntity;
import com.sirjain.entities.models.FrostedSplasherModel;
import com.sirjain.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class FrostedSplasherRenderer extends MobEntityRenderer<FrostedSplasherEntity, FrostedSplasherModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/frosted_splasher/frosted_splasher.png");

	public FrostedSplasherRenderer(EntityRendererFactory.Context context) {
		super(context, new FrostedSplasherModel(context.getPart(AquaticPlusEntities.FROSTED_SPLASHER_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(FrostedSplasherEntity entity) {
		return TEXTURE;
	}
}
