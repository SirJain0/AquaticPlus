package com.aquaticplus.entities.renderers;

import com.aquaticplus.AquaticPlus;
import com.aquaticplus.entities.entity.OculiMagniEntity;
import com.aquaticplus.entities.models.OculiMagniModel;
import com.aquaticplus.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class OculiMagniRenderer extends MobEntityRenderer<OculiMagniEntity, OculiMagniModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/oculi_magni.png");

	public OculiMagniRenderer(EntityRendererFactory.Context context) {
		super(context, new OculiMagniModel(context.getPart(AquaticPlusEntities.OCULI_MAGNI_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(OculiMagniEntity entity) {
		return TEXTURE;
	}
}
