package sirjain.aquaticplus.client.entity.renderers;

import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.client.entity.AquaticPlusEntityLayers;
import sirjain.aquaticplus.entity.entities.HalibutEntity;
import sirjain.aquaticplus.client.entity.models.HalibutModel;
import sirjain.aquaticplus.entity.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class HalibutRenderer extends MobEntityRenderer<HalibutEntity, HalibutModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/halibut.png");

	public HalibutRenderer(EntityRendererFactory.Context context) {
		super(context, new HalibutModel(context.getPart(AquaticPlusEntityLayers.HALIBUT_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(HalibutEntity entity) {
		return TEXTURE;
	}

	@Override
	protected void scale(HalibutEntity entity, MatrixStack matrices, float amount) {
		matrices.scale(1.25f, 1.25f, 1.25f);
	}
}
