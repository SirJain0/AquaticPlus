package sirjain.aquaticplus.client.entity.renderers;

import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.client.entity.AquaticPlusEntityLayers;
import sirjain.aquaticplus.entity.entities.LanternfishEntity;
import sirjain.aquaticplus.client.entity.features.APEmissiveTextureFeature;
import sirjain.aquaticplus.client.entity.models.LanternfishModel;
import sirjain.aquaticplus.entity.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class LanternfishRenderer extends MobEntityRenderer<LanternfishEntity, LanternfishModel> {
	// TODO: Fix black z-fighting with planes
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/lanternfish/lanternfish.png");
	public static final Identifier EMISSIVE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/lanternfish/lanternfish_e.png");

	public LanternfishRenderer(EntityRendererFactory.Context context) {
		super(context, new LanternfishModel(context.getPart(AquaticPlusEntityLayers.LANTERNFISH_LAYER)), 0.5f);
		this.addFeature(new APEmissiveTextureFeature<>(this, EMISSIVE));
	}

	@Override
	public Identifier getTexture(LanternfishEntity entity) {
		return TEXTURE;
	}
}