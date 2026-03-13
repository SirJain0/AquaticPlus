package sirjain.aquaticplus.client.entity.renderers;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.client.entity.AquaticPlusEntityLayers;
import sirjain.aquaticplus.client.entity.models.CristinatorModel;
import sirjain.aquaticplus.client.entity.models.JohnsonModel;
import sirjain.aquaticplus.entity.entities.ShadowSardelEasterEggEntity;

public class CristinatorRenderer extends MobEntityRenderer<ShadowSardelEasterEggEntity, CristinatorModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/shadow_sardel/cristinator.png");

	public CristinatorRenderer(EntityRendererFactory.Context context) {
		super(context, new CristinatorModel(context.getPart(AquaticPlusEntityLayers.CRISTINATOR_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(ShadowSardelEasterEggEntity entity) {
		return TEXTURE;
	}
}