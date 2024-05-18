package com.aquaticplus.entities.renderers;

import com.aquaticplus.AquaticPlus;
import com.aquaticplus.entities.entity.ShadowSardelEasterEggEntity;
import com.aquaticplus.entities.models.MindinatorModel;
import com.aquaticplus.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class MindinatorRenderer extends MobEntityRenderer<ShadowSardelEasterEggEntity, MindinatorModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/shadow_sardel/mindinator.png");

	public MindinatorRenderer(EntityRendererFactory.Context context) {
		super(context, new MindinatorModel(context.getPart(AquaticPlusEntities.MINDINATOR_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(ShadowSardelEasterEggEntity entity) {
		return TEXTURE;
	}
}