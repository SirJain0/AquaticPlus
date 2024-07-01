package sirjain.aquaticplus.client.entity.renderers;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.client.entity.AquaticPlusEntityLayers;
import sirjain.aquaticplus.client.entity.features.MaxillaMortisEmissiveTextureFeature;
import sirjain.aquaticplus.client.entity.models.MaxillaMortisModel;
import sirjain.aquaticplus.entity.entities.MaxillaMortisEntity;

public class MaxillaMortisRenderer extends MobEntityRenderer<MaxillaMortisEntity, MaxillaMortisModel> {
	private static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/maxilla_mortis/maxilla_mortis.png");
	private static final Identifier PURPLE_TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/maxilla_mortis/maxilla_mortis_purple.png");

	public MaxillaMortisRenderer(EntityRendererFactory.Context context) {
		super(context, new MaxillaMortisModel(context.getPart(AquaticPlusEntityLayers.MAXILLA_MORTIS_LAYER)), 0.5f);
		this.addFeature(new MaxillaMortisEmissiveTextureFeature<>(this));
	}

	@Override
	public Identifier getTexture(MaxillaMortisEntity entity) {
		return entity.canRecolor() ? PURPLE_TEXTURE : TEXTURE;
	}
}