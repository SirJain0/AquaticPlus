package com.sirjain.entities.renderers;

import com.sirjain.AquaticPlus;
import com.sirjain.entities.entity.BonefishEntity;
import com.sirjain.entities.models.BonefishModel;
import com.sirjain.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class BonefishRenderer extends MobEntityRenderer<BonefishEntity, BonefishModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/bonefish/bonefish.png");

	public BonefishRenderer(EntityRendererFactory.Context context) {
		super(context, new BonefishModel(context.getPart(AquaticPlusEntities.BONEFISH_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(BonefishEntity entity) {
		return TEXTURE;
	}
}