package com.sirjain.entities.renderers;

import com.sirjain.AquaticPlus;
import com.sirjain.entities.entity.BluefinTunaEntity;
import com.sirjain.entities.entity.HalibutEntity;
import com.sirjain.entities.models.BluefinTunaModel;
import com.sirjain.entities.models.HalibutModel;
import com.sirjain.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class HalibutRenderer extends MobEntityRenderer<HalibutEntity, HalibutModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/halibut/halibut.png");

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
