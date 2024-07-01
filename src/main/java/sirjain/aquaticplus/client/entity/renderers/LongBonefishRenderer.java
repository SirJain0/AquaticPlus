package sirjain.aquaticplus.client.entity.renderers;

import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.client.entity.AquaticPlusEntityLayers;
import sirjain.aquaticplus.entity.entities.LongBonefishEntity;
import sirjain.aquaticplus.client.entity.models.LongBonefishModel;
import sirjain.aquaticplus.entity.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class LongBonefishRenderer extends MobEntityRenderer<LongBonefishEntity, LongBonefishModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/bonefish/long_bonefish.png");

	public LongBonefishRenderer(EntityRendererFactory.Context context) {
		super(context, new LongBonefishModel(context.getPart(AquaticPlusEntityLayers.LONG_BONEFISH_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(LongBonefishEntity entity) {
		return TEXTURE;
	}
}