package sirjain.aquaticplus.client.entity.renderers;

import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.client.entity.AquaticPlusEntityLayers;
import sirjain.aquaticplus.entity.entities.StonefishEntity;
import sirjain.aquaticplus.client.entity.models.StonefishModel;
import sirjain.aquaticplus.entity.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class StonefishRenderer extends MobEntityRenderer<StonefishEntity, StonefishModel> {
	public StonefishRenderer(EntityRendererFactory.Context context) {
		super(context, new StonefishModel(context.getPart(AquaticPlusEntityLayers.STONEFISH_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(StonefishEntity entity) {
		String variantName = entity.getVariant().name().toLowerCase();
		return new Identifier(AquaticPlus.MOD_ID, "textures/entity/stonefish/stonefish_" + variantName + ".png");
	}
}