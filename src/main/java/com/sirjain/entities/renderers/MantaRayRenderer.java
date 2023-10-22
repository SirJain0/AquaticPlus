package com.sirjain.entities.renderers;

import com.sirjain.AquaticPlus;
import com.sirjain.entities.entity.MantaRayEntity;
import com.sirjain.entities.models.MantaRayModel;
import com.sirjain.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.util.Identifier;

public class MantaRayRenderer extends LivingEntityRenderer<MantaRayEntity, MantaRayModel> {
	private static final Identifier DARK_TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/manta_ray/manta_ray_dark.png");
	private static final Identifier DARK_SPOTTED_TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/manta_ray/manta_ray_dark_spotted.png");
	private static final Identifier BLUE_TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/manta_ray/manta_ray_blue.png");

	public MantaRayRenderer(EntityRendererFactory.Context context) {
		super(context, new MantaRayModel(context.getPart(AquaticPlusEntities.MANTA_RAY_LAYER)), 0.75f);
	}

	@Override
	public Identifier getTexture(MantaRayEntity entity) {
		return switch(entity.getVariant()) {
			case DARK -> DARK_TEXTURE;
			case DARK_SPOTTED -> DARK_SPOTTED_TEXTURE;
			case BLUE -> BLUE_TEXTURE;
		};
	}
}