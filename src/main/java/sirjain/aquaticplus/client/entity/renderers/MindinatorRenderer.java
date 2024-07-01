package sirjain.aquaticplus.client.entity.renderers;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.client.entity.AquaticPlusEntityLayers;
import sirjain.aquaticplus.client.entity.models.MindinatorModel;
import sirjain.aquaticplus.entity.entities.ShadowSardelEasterEggEntity;

public class MindinatorRenderer extends MobEntityRenderer<ShadowSardelEasterEggEntity, MindinatorModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/shadow_sardel/mindinator.png");

	public MindinatorRenderer(EntityRendererFactory.Context context) {
		super(context, new MindinatorModel(context.getPart(AquaticPlusEntityLayers.MINDINATOR_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(ShadowSardelEasterEggEntity entity) {
		return TEXTURE;
	}
}