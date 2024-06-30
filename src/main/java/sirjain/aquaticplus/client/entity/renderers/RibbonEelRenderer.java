package sirjain.aquaticplus.client.entity.renderers;

import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.entity.entities.RibbonEelEntity;
import sirjain.aquaticplus.client.entity.models.RibbonEelModel;
import sirjain.aquaticplus.entity.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class RibbonEelRenderer extends MobEntityRenderer<RibbonEelEntity, RibbonEelModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/eels/ribbon_eel.png");

	public RibbonEelRenderer(EntityRendererFactory.Context context) {
		super(context, new RibbonEelModel(context.getPart(AquaticPlusEntities.RIBBON_EEL_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(RibbonEelEntity entity) {
		return TEXTURE;
	}
}