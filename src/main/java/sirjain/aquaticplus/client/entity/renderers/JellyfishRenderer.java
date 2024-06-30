package sirjain.aquaticplus.client.entity.renderers;

import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.entity.entities.JellyfishEntity;
import sirjain.aquaticplus.client.entity.models.JellyfishModel;
import sirjain.aquaticplus.entity.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class JellyfishRenderer extends MobEntityRenderer<JellyfishEntity, JellyfishModel> {
	public JellyfishRenderer(EntityRendererFactory.Context context) {
		super(context, new JellyfishModel(context.getPart(AquaticPlusEntities.JELLYFISH_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(JellyfishEntity entity) {
		String variantName = entity.getVariant().name().toLowerCase();
		return new Identifier(AquaticPlus.MOD_ID, "textures/entity/jellyfish/jellyfish_" + variantName + ".png");
	}

	@Override
	protected void scale(JellyfishEntity entity, MatrixStack matrices, float amount) {
		matrices.scale(entity.getModelScale(), entity.getModelScale(), entity.getModelScale());
	}
}