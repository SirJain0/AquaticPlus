package com.aquaticplus.entities.renderers;

import com.aquaticplus.AquaticPlus;
import com.aquaticplus.entities.entity.LongBonefishEntity;
import com.aquaticplus.entities.models.LongBonefishModel;
import com.aquaticplus.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class LongBonefishRenderer extends MobEntityRenderer<LongBonefishEntity, LongBonefishModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/bonefish/long_bonefish.png");

	public LongBonefishRenderer(EntityRendererFactory.Context context) {
		super(context, new LongBonefishModel(context.getPart(AquaticPlusEntities.LONG_BONEFISH_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(LongBonefishEntity entity) {
		return TEXTURE;
	}
}