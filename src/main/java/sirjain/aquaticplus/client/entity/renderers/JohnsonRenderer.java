package sirjain.aquaticplus.client.entity.renderers;

import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.client.entity.AquaticPlusEntityLayers;
import sirjain.aquaticplus.entity.entities.ShadowSardelEasterEggEntity;
import sirjain.aquaticplus.client.entity.models.JohnsonModel;
import sirjain.aquaticplus.entity.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class JohnsonRenderer extends MobEntityRenderer<ShadowSardelEasterEggEntity, JohnsonModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/shadow_sardel/johnson.png");

	public JohnsonRenderer(EntityRendererFactory.Context context) {
		super(context, new JohnsonModel(context.getPart(AquaticPlusEntityLayers.JOHNSON_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(ShadowSardelEasterEggEntity entity) {
		return TEXTURE;
	}
}