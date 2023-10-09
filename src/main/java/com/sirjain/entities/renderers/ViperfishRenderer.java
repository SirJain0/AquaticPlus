package com.sirjain.entities.renderers;

import com.sirjain.AquaticPlus;
import com.sirjain.entities.entity.ViperfishEntity;
import com.sirjain.entities.features.APEmissiveTextureFeature;
import com.sirjain.entities.models.SpiritedFishModel;
import com.sirjain.entities.models.ViperfishModel;
import com.sirjain.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

public class ViperfishRenderer extends MobEntityRenderer<ViperfishEntity, ViperfishModel> {
	private static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/viperfish/viperfish.png");
	private static final Identifier EMISSIVE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/viperfish/viperfish_e.png");

	public ViperfishRenderer(EntityRendererFactory.Context context) {
		super(context, new ViperfishModel(context.getPart(AquaticPlusEntities.VIPERFISH_LAYER)), 0.5f);
		this.addFeature(new APEmissiveTextureFeature<>(this, EMISSIVE));
	}

	@Override
	public Identifier getTexture(ViperfishEntity entity) {
		return TEXTURE;
	}
}
