package com.aquaticplus.entities.renderers;

import com.aquaticplus.AquaticPlus;
import com.aquaticplus.entities.entity.VolanAuroraEntity;
import com.aquaticplus.entities.features.VolanAuroraEmissiveTextureFeature;
import com.aquaticplus.entities.models.VolanAuroraModel;
import com.aquaticplus.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class VolanAuroraRenderer extends MobEntityRenderer<VolanAuroraEntity, VolanAuroraModel> {
	public VolanAuroraRenderer(EntityRendererFactory.Context context) {
		super(context, new VolanAuroraModel(context.getPart(AquaticPlusEntities.VOLAN_AURORA_LAYER)), 0.5f);
		this.addFeature(new VolanAuroraEmissiveTextureFeature<>(this));
	}

	@Override
	public Identifier getTexture(VolanAuroraEntity entity) {
		boolean isAngry = entity.isAngry();
		return new Identifier(AquaticPlus.MOD_ID, "textures/entity/volan_aurora/volan_aurora" + (isAngry ? "_angry" : "") + ".png");
	}
}