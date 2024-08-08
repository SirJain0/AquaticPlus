package sirjain.aquaticplus.client.entity.renderers;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.client.entity.AquaticPlusEntityLayers;
import sirjain.aquaticplus.client.entity.models.JellyfishModel;
import sirjain.aquaticplus.client.entity.models.MythicalSeahorseModel;
import sirjain.aquaticplus.entity.entities.JellyfishEntity;
import sirjain.aquaticplus.entity.entities.MythicalSeahorseEntity;

public class MythicalSeahorseRenderer extends MobEntityRenderer<MythicalSeahorseEntity, MythicalSeahorseModel> {
	public MythicalSeahorseRenderer(EntityRendererFactory.Context context) {
		super(context, new MythicalSeahorseModel(context.getPart(AquaticPlusEntityLayers.MYTHICAL_SEAHORSE_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(MythicalSeahorseEntity entity) {
		String variantName = entity.getVariant().name().toLowerCase();
		return new Identifier(AquaticPlus.MOD_ID, "textures/entity/seahorse/mythical_seahorse_" + variantName + ".png");
	}
}