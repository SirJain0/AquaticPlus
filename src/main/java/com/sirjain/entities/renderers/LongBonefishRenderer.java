package com.sirjain.entities.renderers;

import com.sirjain.AquaticPlus;
import com.sirjain.entities.entity.LongBonefishEntity;
import com.sirjain.entities.models.LongBonefishModel;
import com.sirjain.registries.AquaticPlusEntities;
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