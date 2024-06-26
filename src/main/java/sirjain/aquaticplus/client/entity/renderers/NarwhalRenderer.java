package sirjain.aquaticplus.client.entity.renderers;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.client.entity.AquaticPlusEntityLayers;
import sirjain.aquaticplus.client.entity.models.NarwhalModel;
import sirjain.aquaticplus.entity.entities.NarwhalEntity;

public class NarwhalRenderer extends MobEntityRenderer<NarwhalEntity, NarwhalModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/narwhal.png");

	public NarwhalRenderer(EntityRendererFactory.Context context) {
		super(context, new NarwhalModel(context.getPart(AquaticPlusEntityLayers.NARWHAL_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(NarwhalEntity entity) {
		return TEXTURE;
	}

	@Override
	protected void scale(NarwhalEntity entity, MatrixStack matrices, float amount) {
		matrices.scale(1.25f, 1.25f, 1.25f);
	}
}
