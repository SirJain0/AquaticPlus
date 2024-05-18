package com.aquaticplus.entities.renderers;

import com.aquaticplus.AquaticPlus;
import com.aquaticplus.entities.entity.NeonCrabEntity;
import com.aquaticplus.entities.models.NeonCrabModel;
import com.aquaticplus.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class NeonCrabRenderer extends MobEntityRenderer<NeonCrabEntity, NeonCrabModel> {
	public NeonCrabRenderer(EntityRendererFactory.Context context) {
		super(context, new NeonCrabModel(context.getPart(AquaticPlusEntities.NEON_CRAB_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(NeonCrabEntity entity) {
		String variantName = entity.getVariant().name().toLowerCase();
		return new Identifier(AquaticPlus.MOD_ID, "textures/entity/neon_crab/neon_crab_" + variantName + ".png");
	}
}