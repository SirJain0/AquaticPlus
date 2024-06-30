package sirjain.aquaticplus.client.entity.renderers;

import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.entity.entities.DeepSeaIsopodEntity;
import sirjain.aquaticplus.client.entity.models.DeepSeaIsopodModel;
import sirjain.aquaticplus.entity.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class DeepSeaIsopodRenderer extends MobEntityRenderer<DeepSeaIsopodEntity, DeepSeaIsopodModel> {
	public DeepSeaIsopodRenderer(EntityRendererFactory.Context context) {
		super(context, new DeepSeaIsopodModel(context.getPart(AquaticPlusEntities.DEEP_SEA_ISOPOD_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(DeepSeaIsopodEntity entity) {
		return buildTexture(entity);
	}

	public Identifier buildTexture(DeepSeaIsopodEntity entity) {
		String variantName = entity.isFrostpod() ? "frostpod" : "deep_sea_isopod";
		return new Identifier(AquaticPlus.MOD_ID, "textures/entity/deep_sea_isopod/" + variantName + ".png");
	}

	@Override
	protected void scale(DeepSeaIsopodEntity entity, MatrixStack matrices, float amount) {
		matrices.scale(1.6f, 1.6f, 1.6f);
	}
}