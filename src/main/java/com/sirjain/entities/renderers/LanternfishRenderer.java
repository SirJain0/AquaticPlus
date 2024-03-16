package com.sirjain.entities.renderers;

import com.sirjain.AquaticPlus;
import com.sirjain.entities.entity.LanternfishEntity;
import com.sirjain.entities.features.APEmissiveTextureFeature;
import com.sirjain.entities.models.LanternfishModel;
import com.sirjain.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class LanternfishRenderer extends MobEntityRenderer<LanternfishEntity, LanternfishModel> {
	// TODO: Fix black z-fighting with planes
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/lanternfish/lanternfish.png");
	public static final Identifier EMISSIVE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/lanternfish/lanternfish_e.png");

	public LanternfishRenderer(EntityRendererFactory.Context context) {
		super(context, new LanternfishModel(context.getPart(AquaticPlusEntities.LANTERNFISH_LAYER)), 0.5f);
		this.addFeature(new APEmissiveTextureFeature<>(this, EMISSIVE));
	}

	@Override
	public Identifier getTexture(LanternfishEntity entity) {
		return TEXTURE;
	}
}