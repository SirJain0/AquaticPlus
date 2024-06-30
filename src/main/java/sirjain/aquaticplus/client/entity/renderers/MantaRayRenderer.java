package sirjain.aquaticplus.client.entity.renderers;

import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.entity.entities.MantaRayEntity;
import sirjain.aquaticplus.client.entity.models.MantaRayModel;
import sirjain.aquaticplus.entity.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class MantaRayRenderer extends MobEntityRenderer<MantaRayEntity, MantaRayModel> {
	public MantaRayRenderer(EntityRendererFactory.Context context) {
		super(context, new MantaRayModel(context.getPart(AquaticPlusEntities.MANTA_RAY_LAYER)), 0.75f);
	}

	@Override
	public Identifier getTexture(MantaRayEntity entity) {
		String variantName = entity.getVariant().name().toLowerCase();
		return new Identifier(AquaticPlus.MOD_ID, "textures/entity/manta_ray/manta_ray_" + variantName + ".png");
	}
}