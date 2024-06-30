package sirjain.aquaticplus.client.entity.renderers;

import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.entity.entities.KelpEelEntity;
import sirjain.aquaticplus.client.entity.models.KelpEelModel;
import sirjain.aquaticplus.entity.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class KelpEelRenderer extends MobEntityRenderer<KelpEelEntity, KelpEelModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/eels/kelp_eel.png");

	public KelpEelRenderer(EntityRendererFactory.Context context) {
		super(context, new KelpEelModel(context.getPart(AquaticPlusEntities.KELP_EEL_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(KelpEelEntity entity) {
		return TEXTURE;
	}
}
