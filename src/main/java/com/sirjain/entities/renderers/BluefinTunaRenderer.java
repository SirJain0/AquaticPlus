package com.sirjain.entities.renderers;

import com.sirjain.AquaticPlus;
import com.sirjain.entities.entity.BluefinTunaEntity;
import com.sirjain.entities.models.BluefinTunaModel;
import com.sirjain.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class BluefinTunaRenderer extends MobEntityRenderer<BluefinTunaEntity, BluefinTunaModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/bluefin_tuna.png");

	public BluefinTunaRenderer(EntityRendererFactory.Context context) {
		super(context, new BluefinTunaModel(context.getPart(AquaticPlusEntities.BLUEFIN_TUNA_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(BluefinTunaEntity entity) {
		return TEXTURE;
	}

	@Override
	protected void scale(BluefinTunaEntity entity, MatrixStack matrices, float amount) {
		matrices.scale(1.25f, 1.25f, 1.25f);
	}
}
