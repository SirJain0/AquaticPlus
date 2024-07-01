package sirjain.aquaticplus.client.entity.renderers;

import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.client.entity.AquaticPlusEntityLayers;
import sirjain.aquaticplus.entity.entities.YetiCrabEntity;
import sirjain.aquaticplus.client.entity.models.YetiCrabModel;
import sirjain.aquaticplus.entity.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class YetiCrabRenderer extends MobEntityRenderer<YetiCrabEntity, YetiCrabModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/crab/yeti_crab.png");

	public YetiCrabRenderer(EntityRendererFactory.Context context) {
		super(context, new YetiCrabModel(context.getPart(AquaticPlusEntityLayers.YETI_CRAB_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(YetiCrabEntity entity) {
		return TEXTURE;
	}
}