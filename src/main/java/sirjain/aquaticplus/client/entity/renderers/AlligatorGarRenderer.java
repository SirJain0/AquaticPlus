package sirjain.aquaticplus.client.entity.renderers;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.client.entity.AquaticPlusEntityLayers;
import sirjain.aquaticplus.client.entity.models.AlligatorGarModel;
import sirjain.aquaticplus.entity.entities.AlligatorGarEntity;

public class AlligatorGarRenderer extends MobEntityRenderer<AlligatorGarEntity, AlligatorGarModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/alligator_gar.png");

	public AlligatorGarRenderer(EntityRendererFactory.Context context) {
		super(context, new AlligatorGarModel(context.getPart(AquaticPlusEntityLayers.ALLIGATOR_GAR_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(AlligatorGarEntity entity) {
		return TEXTURE;
	}
}