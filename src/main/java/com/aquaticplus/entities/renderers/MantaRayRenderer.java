package com.aquaticplus.entities.renderers;

import com.aquaticplus.AquaticPlus;
import com.aquaticplus.entities.entity.MantaRayEntity;
import com.aquaticplus.entities.models.MantaRayModel;
import com.aquaticplus.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class MantaRayRenderer extends MobEntityRenderer<MantaRayEntity, MantaRayModel> {
	public MantaRayRenderer(EntityRendererFactory.Context context) {
		super(context, new MantaRayModel(context.getPart(AquaticPlusEntities.MANTA_RAY_LAYER)), 0.75f);
	}

	@Override
	public Identifier getTexture(MantaRayEntity entity) {
		String variantName = entity.getVariant().name().toLowerCase();
		return new Identifier(AquaticPlus.MOD_ID, "textures/entity/manta_ray/manta_ray_" + variantName + ".png");
	}
}