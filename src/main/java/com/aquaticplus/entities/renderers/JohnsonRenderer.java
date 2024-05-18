package com.aquaticplus.entities.renderers;

import com.aquaticplus.AquaticPlus;
import com.aquaticplus.entities.entity.ShadowSardelEasterEggEntity;
import com.aquaticplus.entities.models.JohnsonModel;
import com.aquaticplus.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class JohnsonRenderer extends MobEntityRenderer<ShadowSardelEasterEggEntity, JohnsonModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/shadow_sardel/johnson.png");

	public JohnsonRenderer(EntityRendererFactory.Context context) {
		super(context, new JohnsonModel(context.getPart(AquaticPlusEntities.JOHNNSON_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(ShadowSardelEasterEggEntity entity) {
		return TEXTURE;
	}
}