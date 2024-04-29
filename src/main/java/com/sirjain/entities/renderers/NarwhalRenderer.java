package com.sirjain.entities.renderers;

import com.sirjain.AquaticPlus;
import com.sirjain.entities.entity.BluefinTunaEntity;
import com.sirjain.entities.entity.NarwhalEntity;
import com.sirjain.entities.models.BluefinTunaModel;
import com.sirjain.entities.models.NarwhalModel;
import com.sirjain.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class NarwhalRenderer extends MobEntityRenderer<NarwhalEntity, NarwhalModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/narwhal.png");

	public NarwhalRenderer(EntityRendererFactory.Context context) {
		super(context, new NarwhalModel(context.getPart(AquaticPlusEntities.NARWHAL_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(NarwhalEntity entity) {
		return TEXTURE;
	}

	@Override
	protected void scale(NarwhalEntity entity, MatrixStack matrices, float amount) {
		if (entity.isBaby()) matrices.scale(0.7f, 0.7f, 0.7f);
		else matrices.scale(1.25f, 1.25f, 1.25f);
	}
}
