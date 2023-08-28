package com.sirjain.entities.renderers;

import com.sirjain.AquaticPlus;
import com.sirjain.entities.entity.OculiMagniEntity;
import com.sirjain.entities.models.OculiMagniModel;
import com.sirjain.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class OculiMagniRenderer extends MobEntityRenderer<OculiMagniEntity, OculiMagniModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entities/oculi_magni/oculi_magni.png");

	public OculiMagniRenderer(EntityRendererFactory.Context context) {
		super(context, new OculiMagniModel(context.getPart(AquaticPlusEntities.OCULI_MAGNI_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(OculiMagniEntity entity) {
		return TEXTURE;
	}
}
