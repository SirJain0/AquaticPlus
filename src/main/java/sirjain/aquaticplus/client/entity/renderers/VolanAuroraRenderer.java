package sirjain.aquaticplus.client.entity.renderers;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.client.entity.AquaticPlusEntityLayers;
import sirjain.aquaticplus.client.entity.features.VolanAuroraEmissiveTextureFeature;
import sirjain.aquaticplus.client.entity.models.VolanAuroraModel;
import sirjain.aquaticplus.entity.entities.VolanAuroraEntity;

public class VolanAuroraRenderer extends MobEntityRenderer<VolanAuroraEntity, VolanAuroraModel> {
	public VolanAuroraRenderer(EntityRendererFactory.Context context) {
		super(context, new VolanAuroraModel(context.getPart(AquaticPlusEntityLayers.VOLAN_AURORA_LAYER)), 0.5f);
		this.addFeature(new VolanAuroraEmissiveTextureFeature<>(this));
	}

	@Override
	public Identifier getTexture(VolanAuroraEntity entity) {
		boolean isAngry = entity.isAngry();
		return new Identifier(AquaticPlus.MOD_ID, "textures/entity/volan_aurora/volan_aurora" + (isAngry ? "_angry" : "") + ".png");
	}
}