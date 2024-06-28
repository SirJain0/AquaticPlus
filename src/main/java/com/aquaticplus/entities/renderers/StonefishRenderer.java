package com.aquaticplus.entities.renderers;

import com.aquaticplus.AquaticPlus;
import com.aquaticplus.entities.entity.AlligatorGarEntity;
import com.aquaticplus.entities.entity.SardineEntity;
import com.aquaticplus.entities.entity.StonefishEntity;
import com.aquaticplus.entities.models.AlligatorGarModel;
import com.aquaticplus.entities.models.StonefishModel;
import com.aquaticplus.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class StonefishRenderer extends MobEntityRenderer<StonefishEntity, StonefishModel> {
	public StonefishRenderer(EntityRendererFactory.Context context) {
		super(context, new StonefishModel(context.getPart(AquaticPlusEntities.STONEFISH_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(StonefishEntity entity) {
		String variantName = entity.getVariant().name().toLowerCase();
		return new Identifier(AquaticPlus.MOD_ID, "textures/entity/stonefish/stonefish_" + variantName + ".png");
	}
}