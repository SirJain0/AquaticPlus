package sirjain.aquaticplus.client.entity.renderers;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.client.entity.AquaticPlusEntityLayers;
import sirjain.aquaticplus.client.entity.models.SardineModel;
import sirjain.aquaticplus.entity.entities.SardineEntity;

public class SardineRenderer extends MobEntityRenderer<SardineEntity, SardineModel> {
	public SardineRenderer(EntityRendererFactory.Context context) {
		super(context, new SardineModel(context.getPart(AquaticPlusEntityLayers.SARDINE_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(SardineEntity entity) {
		String variantName = entity.getVariant().name().toLowerCase();
		return new Identifier(AquaticPlus.MOD_ID, "textures/entity/sardine/sardine_" + variantName + ".png");
	}

	@Override
	protected void scale(SardineEntity entity, MatrixStack matrices, float amount) {
		matrices.scale(0.6f, 0.6f, 0.6f);
	}
}