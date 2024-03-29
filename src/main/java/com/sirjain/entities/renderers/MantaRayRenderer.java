package com.sirjain.entities.renderers;

import com.sirjain.AquaticPlus;
import com.sirjain.entities.entity.MantaRayEntity;
import com.sirjain.entities.models.MantaRayModel;
import com.sirjain.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class MantaRayRenderer extends MobEntityRenderer<MantaRayEntity, MantaRayModel> {
	public MantaRayRenderer(EntityRendererFactory.Context context) {
		super(context, new MantaRayModel(context.getPart(AquaticPlusEntities.MANTA_RAY_LAYER)), 0.75f);
	}

	@Override
	public Identifier getTexture(MantaRayEntity entity) {
		return switch(entity.getVariant()) {
			case DARK -> buildTextureID("dark");
			case DARK_SPOTTED -> buildTextureID("dark_spotted");
			case BLUE -> buildTextureID("blue");
		};
	}

	public static Identifier buildTextureID(String id) {
		return new Identifier(AquaticPlus.MOD_ID, "textures/entity/manta_ray/manta_ray_" + id + ".png");
	}
}