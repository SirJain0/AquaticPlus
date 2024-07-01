package sirjain.aquaticplus.client.entity.renderers;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.client.entity.AquaticPlusEntityLayers;
import sirjain.aquaticplus.client.entity.features.DumboBlobEmissiveTextureFeature;
import sirjain.aquaticplus.client.entity.models.DumboBlobModel;
import sirjain.aquaticplus.entity.entities.DumboBlobEntity;

public class DumboBlobRenderer extends MobEntityRenderer<DumboBlobEntity, DumboBlobModel> {
	public DumboBlobRenderer(EntityRendererFactory.Context context) {
		super(context, new DumboBlobModel(context.getPart(AquaticPlusEntityLayers.DUMBO_BLOB_LAYER)), 0.75f);
		this.addFeature(new DumboBlobEmissiveTextureFeature<>(this));
	}

	@Override
	public Identifier getTexture(DumboBlobEntity entity) {
		String variantName = entity.getVariant().name().toLowerCase();
		return new Identifier(AquaticPlus.MOD_ID, "textures/entity/dumbo_blob/dumbo_blob_" + variantName + ".png");
	}
}