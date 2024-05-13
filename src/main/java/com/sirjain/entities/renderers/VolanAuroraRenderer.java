package com.sirjain.entities.renderers;

import com.sirjain.AquaticPlus;
import com.sirjain.entities.entity.VolanAuroraEntity;
import com.sirjain.entities.models.VolanAuroraModel;
import com.sirjain.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class VolanAuroraRenderer extends MobEntityRenderer<VolanAuroraEntity, VolanAuroraModel> {
	public VolanAuroraRenderer(EntityRendererFactory.Context context) {
		super(context, new VolanAuroraModel(context.getPart(AquaticPlusEntities.VOLAN_AURORA_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(VolanAuroraEntity entity) {
		boolean isAngry = false;
		return new Identifier(AquaticPlus.MOD_ID, "textures/entity/volan_aurora/volan_aurora" + (isAngry ? "_angry" : "") + ".png");
	}
}