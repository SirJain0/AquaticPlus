package sirjain.aquaticplus.client.entity.renderers;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.client.entity.AquaticPlusEntityLayers;
import sirjain.aquaticplus.client.entity.models.RibbonEelModel;
import sirjain.aquaticplus.entity.entities.RibbonEelEntity;

public class RibbonEelRenderer extends MobEntityRenderer<RibbonEelEntity, RibbonEelModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/eels/ribbon_eel.png");

	public RibbonEelRenderer(EntityRendererFactory.Context context) {
		super(context, new RibbonEelModel(context.getPart(AquaticPlusEntityLayers.RIBBON_EEL_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(RibbonEelEntity entity) {
		return TEXTURE;
	}
}