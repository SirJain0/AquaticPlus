package sirjain.aquaticplus.client.entity.renderers;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.client.entity.AquaticPlusEntityLayers;
import sirjain.aquaticplus.client.entity.models.DeepSeaIsopodModel;
import sirjain.aquaticplus.entity.entities.DeepSeaIsopodEntity;
import sirjain.aquaticplus.entity.entities.SardineEntity;

public class DeepSeaIsopodRenderer extends MobEntityRenderer<DeepSeaIsopodEntity, DeepSeaIsopodModel> {
	public DeepSeaIsopodRenderer(EntityRendererFactory.Context context) {
		super(context, new DeepSeaIsopodModel(context.getPart(AquaticPlusEntityLayers.DEEP_SEA_ISOPOD_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(DeepSeaIsopodEntity entity) {
		if (entity.isFrostpod()) {
			return new Identifier(AquaticPlus.MOD_ID, "textures/entity/deep_sea_isopod/frostpod.png");
		} else {
			String variantName = entity.getVariant().name().toLowerCase();
			return new Identifier(AquaticPlus.MOD_ID, "textures/entity/deep_sea_isopod/deep_sea_isopod_" + variantName + ".png");
		}
	}

	@Override
	protected void scale(DeepSeaIsopodEntity entity, MatrixStack matrices, float amount) {
		matrices.scale(1.6f, 1.6f, 1.6f);
	}
}