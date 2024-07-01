package sirjain.aquaticplus.client.entity.renderers;

import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.client.entity.AquaticPlusEntityLayers;
import sirjain.aquaticplus.entity.entities.PikeEntity;
import sirjain.aquaticplus.client.entity.models.PikeModel;
import sirjain.aquaticplus.entity.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class PikeRenderer extends MobEntityRenderer<PikeEntity, PikeModel> {
	public PikeRenderer(EntityRendererFactory.Context context) {
		super(context, new PikeModel(context.getPart(AquaticPlusEntityLayers.PIKE_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(PikeEntity entity) {
		String variantName = entity.getVariant().name().toLowerCase();
		return new Identifier(AquaticPlus.MOD_ID, "textures/entity/pike/pike_" + variantName + ".png");
	}
}