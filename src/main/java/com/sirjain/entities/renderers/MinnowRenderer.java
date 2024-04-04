package com.sirjain.entities.renderers;

import com.sirjain.AquaticPlus;
import com.sirjain.entities.entity.MinnowEntity;
import com.sirjain.entities.models.MinnowModel;
import com.sirjain.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class MinnowRenderer extends MobEntityRenderer<MinnowEntity, MinnowModel> {
	public MinnowRenderer(EntityRendererFactory.Context context) {
		super(context, new MinnowModel(context.getPart(AquaticPlusEntities.MINNOW_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(MinnowEntity entity) {
		String variantName = entity.getVariant().name().toLowerCase();
		return new Identifier(AquaticPlus.MOD_ID, "textures/entity/minnow/" + variantName + ".png");
	}
}