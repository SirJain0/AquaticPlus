package sirjain.aquaticplus.client.entity.renderers;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.client.entity.AquaticPlusEntityLayers;
import sirjain.aquaticplus.client.entity.models.IvySeahorseModel;
import sirjain.aquaticplus.entity.entities.IvySeahorseEntity;

public class IvySeahorseRenderer extends MobEntityRenderer<IvySeahorseEntity, IvySeahorseModel> {
	public IvySeahorseRenderer(EntityRendererFactory.Context context) {
		super(context, new IvySeahorseModel(context.getPart(AquaticPlusEntityLayers.IVY_SEAHORSE_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(IvySeahorseEntity entity) {
		String sheared = entity.isSheared() ? "_sheared" : "";
		return new Identifier(AquaticPlus.MOD_ID, "textures/entity/seahorse/ivy_seahorse" + sheared + ".png");
	}
}
