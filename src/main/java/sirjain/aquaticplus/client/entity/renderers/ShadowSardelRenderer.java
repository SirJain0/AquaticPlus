package sirjain.aquaticplus.client.entity.renderers;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.client.entity.AquaticPlusEntityLayers;
import sirjain.aquaticplus.client.entity.models.ShadowSardelModel;
import sirjain.aquaticplus.entity.entities.ShadowSardelEntity;

public class ShadowSardelRenderer extends MobEntityRenderer<ShadowSardelEntity, ShadowSardelModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/shadow_sardel/shadow_sardel.png");

	public ShadowSardelRenderer(EntityRendererFactory.Context context) {
		super(context, new ShadowSardelModel(context.getPart(AquaticPlusEntityLayers.SHADOW_SARDEL_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(ShadowSardelEntity entity) {
		return TEXTURE;
	}
}
