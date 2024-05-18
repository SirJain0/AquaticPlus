package com.aquaticplus.entities.renderers;

import com.aquaticplus.AquaticPlus;
import com.aquaticplus.entities.entity.HalibutEntity;
import com.aquaticplus.entities.models.HalibutModel;
import com.aquaticplus.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class HalibutRenderer extends MobEntityRenderer<HalibutEntity, HalibutModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/halibut.png");

	public HalibutRenderer(EntityRendererFactory.Context context) {
		super(context, new HalibutModel(context.getPart(AquaticPlusEntities.HALIBUT_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(HalibutEntity entity) {
		return TEXTURE;
	}

	@Override
	protected void scale(HalibutEntity entity, MatrixStack matrices, float amount) {
		matrices.scale(1.25f, 1.25f, 1.25f);
	}
}
