package sirjain.aquaticplus.client.entity.renderers;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.client.entity.AquaticPlusEntityLayers;
import sirjain.aquaticplus.client.entity.models.FrostedSplasherModel;
import sirjain.aquaticplus.entity.entities.FrostedSplasherEntity;

public class FrostedSplasherRenderer extends MobEntityRenderer<FrostedSplasherEntity, FrostedSplasherModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/frosted_splasher/frosted_splasher.png");

	public FrostedSplasherRenderer(EntityRendererFactory.Context context) {
		super(context, new FrostedSplasherModel(context.getPart(AquaticPlusEntityLayers.FROSTED_SPLASHER_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(FrostedSplasherEntity entity) {
		return TEXTURE;
	}
}
