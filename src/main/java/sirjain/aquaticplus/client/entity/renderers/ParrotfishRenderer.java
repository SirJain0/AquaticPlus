package sirjain.aquaticplus.client.entity.renderers;

import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.client.entity.AquaticPlusEntityLayers;
import sirjain.aquaticplus.entity.entities.ParrotfishEntity;
import sirjain.aquaticplus.client.entity.models.ParrotfishModel;
import sirjain.aquaticplus.entity.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class ParrotfishRenderer extends MobEntityRenderer<ParrotfishEntity, ParrotfishModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/parrotfish.png");

	public ParrotfishRenderer(EntityRendererFactory.Context context) {
		super(context, new ParrotfishModel(context.getPart(AquaticPlusEntityLayers.PARROTFISH_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(ParrotfishEntity entity) {
		return TEXTURE;
	}
}