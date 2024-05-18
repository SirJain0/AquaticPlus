package com.aquaticplus.entities.renderers;

import com.aquaticplus.AquaticPlus;
import com.aquaticplus.entities.entity.SeaPenEntity;
import com.aquaticplus.entities.models.SeaPenModel;
import com.aquaticplus.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class SeaPenRenderer extends MobEntityRenderer<SeaPenEntity, SeaPenModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/sea_pen.png");

	public SeaPenRenderer(EntityRendererFactory.Context context) {
		super(context, new SeaPenModel(context.getPart(AquaticPlusEntities.SEA_PEN_LAYER)), 0.3f);
	}

	@Override
	public Identifier getTexture(SeaPenEntity entity) {
		return TEXTURE;
	}

	@Override
	protected void scale(SeaPenEntity entity, MatrixStack matrices, float amount) {
		matrices.scale(entity.getModelScale(), entity.getModelScale(), entity.getModelScale());
	}
}