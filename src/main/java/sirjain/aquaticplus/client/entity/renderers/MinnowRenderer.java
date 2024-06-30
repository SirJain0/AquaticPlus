package sirjain.aquaticplus.client.entity.renderers;

import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.entity.entities.MinnowEntity;
import sirjain.aquaticplus.client.entity.models.MinnowModel;
import sirjain.aquaticplus.entity.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class MinnowRenderer extends MobEntityRenderer<MinnowEntity, MinnowModel> {
	public MinnowRenderer(EntityRendererFactory.Context context) {
		super(context, new MinnowModel(context.getPart(AquaticPlusEntities.MINNOW_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(MinnowEntity entity) {
		String variantName = entity.getVariant().name().toLowerCase();
		return new Identifier(AquaticPlus.MOD_ID, "textures/entity/minnow/" + variantName + ".png");
	}

	@Override
	protected void scale(MinnowEntity entity, MatrixStack matrices, float amount) {
		matrices.scale(0.7f, 0.7f, 0.7f);
	}
}