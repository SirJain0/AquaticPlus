package sirjain.aquaticplus.client.entity.renderers;

import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.entity.entities.ViperfishEntity;
import sirjain.aquaticplus.client.entity.features.ViperfishEmissiveTextureFeature;
import sirjain.aquaticplus.client.entity.models.ViperfishModel;
import sirjain.aquaticplus.entity.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class ViperfishRenderer extends MobEntityRenderer<ViperfishEntity, ViperfishModel> {
	private static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/viperfish/viperfish.png");

	public ViperfishRenderer(EntityRendererFactory.Context context) {
		super(context, new ViperfishModel(context.getPart(AquaticPlusEntities.VIPERFISH_LAYER)), 0.5f);
		this.addFeature(new ViperfishEmissiveTextureFeature<>(this));
	}

	@Override
	public Identifier getTexture(ViperfishEntity entity) {
		return TEXTURE;
	}
}
