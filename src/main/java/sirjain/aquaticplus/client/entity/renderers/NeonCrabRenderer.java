package sirjain.aquaticplus.client.entity.renderers;

import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.client.entity.AquaticPlusEntityLayers;
import sirjain.aquaticplus.entity.entities.NeonCrabEntity;
import sirjain.aquaticplus.client.entity.models.NeonCrabModel;
import sirjain.aquaticplus.entity.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class NeonCrabRenderer extends MobEntityRenderer<NeonCrabEntity, NeonCrabModel> {
	public NeonCrabRenderer(EntityRendererFactory.Context context) {
		super(context, new NeonCrabModel(context.getPart(AquaticPlusEntityLayers.NEON_CRAB_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(NeonCrabEntity entity) {
		String variantName = entity.getVariant().name().toLowerCase();
		return new Identifier(AquaticPlus.MOD_ID, "textures/entity/crab/neon_crab_" + variantName + ".png");
	}
}