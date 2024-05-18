package com.aquaticplus.entities.renderers;

import com.aquaticplus.AquaticPlus;
import com.aquaticplus.entities.entity.FrostedSplasherEntity;
import com.aquaticplus.entities.models.FrostedSplasherModel;
import com.aquaticplus.registries.AquaticPlusEntities;
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
