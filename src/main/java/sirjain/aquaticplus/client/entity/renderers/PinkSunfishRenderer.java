package sirjain.aquaticplus.client.entity.renderers;

import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.client.entity.AquaticPlusEntityLayers;
import sirjain.aquaticplus.entity.entities.PinkSunfishEntity;
import sirjain.aquaticplus.client.entity.models.PinkSunfishModel;
import sirjain.aquaticplus.entity.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class PinkSunfishRenderer extends MobEntityRenderer<PinkSunfishEntity, PinkSunfishModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/pink_sunfish.png");

	public PinkSunfishRenderer(EntityRendererFactory.Context context) {
		super(context, new PinkSunfishModel(context.getPart(AquaticPlusEntityLayers.PINK_SUNFISH_LAYER)), 0.75f);
	}

	@Override
	public Identifier getTexture(PinkSunfishEntity entity) {
		return TEXTURE;
	}
}