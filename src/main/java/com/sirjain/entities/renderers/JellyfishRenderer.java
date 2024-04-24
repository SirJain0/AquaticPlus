package com.sirjain.entities.renderers;

import com.sirjain.AquaticPlus;
import com.sirjain.entities.entity.BluefinTunaEntity;
import com.sirjain.entities.entity.JellyfishEntity;
import com.sirjain.entities.models.BluefinTunaModel;
import com.sirjain.entities.models.JellyfishModel;
import com.sirjain.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class JellyfishRenderer extends MobEntityRenderer<JellyfishEntity, JellyfishModel> {
	public JellyfishRenderer(EntityRendererFactory.Context context) {
		super(context, new JellyfishModel(context.getPart(AquaticPlusEntities.JELLYFISH_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(JellyfishEntity entity) {
		String variantName = entity.getVariant().name().toLowerCase();
		return new Identifier(AquaticPlus.MOD_ID, "textures/entity/jellyfish/jellyfish_" + variantName + ".png");
	}

	@Override
	protected void scale(JellyfishEntity entity, MatrixStack matrices, float amount) {
		matrices.scale(entity.getModelScale(), entity.getModelScale(), entity.getModelScale());
	}
}