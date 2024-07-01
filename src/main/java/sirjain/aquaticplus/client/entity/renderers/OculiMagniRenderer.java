package sirjain.aquaticplus.client.entity.renderers;

import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.client.entity.AquaticPlusEntityLayers;
import sirjain.aquaticplus.entity.entities.OculiMagniEntity;
import sirjain.aquaticplus.client.entity.models.OculiMagniModel;
import sirjain.aquaticplus.entity.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class OculiMagniRenderer extends MobEntityRenderer<OculiMagniEntity, OculiMagniModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/oculi_magni.png");

	public OculiMagniRenderer(EntityRendererFactory.Context context) {
		super(context, new OculiMagniModel(context.getPart(AquaticPlusEntityLayers.OCULI_MAGNI_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(OculiMagniEntity entity) {
		return TEXTURE;
	}
}
