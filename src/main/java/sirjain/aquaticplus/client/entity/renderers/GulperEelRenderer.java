package sirjain.aquaticplus.client.entity.renderers;

import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.entity.entities.GulperEelEntity;
import sirjain.aquaticplus.client.entity.models.GulperEelModel;
import sirjain.aquaticplus.entity.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class GulperEelRenderer extends MobEntityRenderer<GulperEelEntity, GulperEelModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/eels/gulper_eel.png");

	public GulperEelRenderer(EntityRendererFactory.Context context) {
		super(context, new GulperEelModel(context.getPart(AquaticPlusEntities.GULPER_EEL_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(GulperEelEntity entity) {
		return TEXTURE;
	}
}
