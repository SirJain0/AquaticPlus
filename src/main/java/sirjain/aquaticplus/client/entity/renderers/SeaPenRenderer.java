package sirjain.aquaticplus.client.entity.renderers;

import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.entity.entities.SeaPenEntity;
import sirjain.aquaticplus.client.entity.models.SeaPenModel;
import sirjain.aquaticplus.entity.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class SeaPenRenderer extends MobEntityRenderer<SeaPenEntity, SeaPenModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/sea_pen.png");

	public SeaPenRenderer(EntityRendererFactory.Context context) {
		super(context, new SeaPenModel(context.getPart(AquaticPlusEntities.SEA_PEN_LAYER)), 0.3f);
	}

	@Override
	public Identifier getTexture(SeaPenEntity entity) {
		return TEXTURE;
	}

	@Override
	protected void scale(SeaPenEntity entity, MatrixStack matrices, float amount) {
		matrices.scale(entity.getModelScale(), entity.getModelScale(), entity.getModelScale());
	}
}