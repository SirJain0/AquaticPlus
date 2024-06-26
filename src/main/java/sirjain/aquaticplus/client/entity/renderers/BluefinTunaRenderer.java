package sirjain.aquaticplus.client.entity.renderers;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.client.entity.AquaticPlusEntityLayers;
import sirjain.aquaticplus.client.entity.models.BluefinTunaModel;
import sirjain.aquaticplus.entity.entities.BluefinTunaEntity;

public class BluefinTunaRenderer extends MobEntityRenderer<BluefinTunaEntity, BluefinTunaModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/bluefin_tuna.png");

	public BluefinTunaRenderer(EntityRendererFactory.Context context) {
		super(context, new BluefinTunaModel(context.getPart(AquaticPlusEntityLayers.BLUEFIN_TUNA_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(BluefinTunaEntity entity) {
		return TEXTURE;
	}

	@Override
	protected void scale(BluefinTunaEntity entity, MatrixStack matrices, float amount) {
		matrices.scale(1.25f, 1.25f, 1.25f);
	}
}
