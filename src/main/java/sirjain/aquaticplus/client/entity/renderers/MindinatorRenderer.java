package sirjain.aquaticplus.client.entity.renderers;

import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.entity.entities.ShadowSardelEasterEggEntity;
import sirjain.aquaticplus.client.entity.models.MindinatorModel;
import sirjain.aquaticplus.entity.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class MindinatorRenderer extends MobEntityRenderer<ShadowSardelEasterEggEntity, MindinatorModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/shadow_sardel/mindinator.png");

	public MindinatorRenderer(EntityRendererFactory.Context context) {
		super(context, new MindinatorModel(context.getPart(AquaticPlusEntities.MINDINATOR_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(ShadowSardelEasterEggEntity entity) {
		return TEXTURE;
	}
}