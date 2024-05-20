package com.aquaticplus.entities.renderers;

import com.aquaticplus.AquaticPlus;
import com.aquaticplus.entities.entity.PikeEntity;
import com.aquaticplus.entities.entity.SardineEntity;
import com.aquaticplus.entities.models.PikeModel;
import com.aquaticplus.entities.models.SardineModel;
import com.aquaticplus.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class PikeRenderer extends MobEntityRenderer<PikeEntity, PikeModel> {
	public PikeRenderer(EntityRendererFactory.Context context) {
		super(context, new PikeModel(context.getPart(AquaticPlusEntities.PIKE_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(PikeEntity entity) {
		String variantName = entity.getVariant().name().toLowerCase();
		return new Identifier(AquaticPlus.MOD_ID, "textures/entity/pike/pike_" + variantName + ".png");
	}
}