package sirjain.aquaticplus.client.entity.renderers;

import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.client.entity.AquaticPlusEntityLayers;
import sirjain.aquaticplus.entity.entities.BonefishEntity;
import sirjain.aquaticplus.client.entity.models.BonefishModel;
import sirjain.aquaticplus.entity.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class BonefishRenderer extends MobEntityRenderer<BonefishEntity, BonefishModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/bonefish/bonefish.png");

	public BonefishRenderer(EntityRendererFactory.Context context) {
		super(context, new BonefishModel(context.getPart(AquaticPlusEntityLayers.BONEFISH_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(BonefishEntity entity) {
		return TEXTURE;
	}
}