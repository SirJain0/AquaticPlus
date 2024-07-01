package sirjain.aquaticplus.client.entity.renderers;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.client.entity.AquaticPlusEntityLayers;
import sirjain.aquaticplus.client.entity.models.LionfishModel;
import sirjain.aquaticplus.entity.entities.LionfishEntity;

public class LionfishRenderer extends MobEntityRenderer<LionfishEntity, LionfishModel> {
	public LionfishRenderer(EntityRendererFactory.Context context) {
		super(context, new LionfishModel(context.getPart(AquaticPlusEntityLayers.LIONFISH_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(LionfishEntity entity) {
		String variantName = entity.getVariant().name().toLowerCase();
		return new Identifier(AquaticPlus.MOD_ID, "textures/entity/lionfish/" + variantName + ".png");
	}
}
