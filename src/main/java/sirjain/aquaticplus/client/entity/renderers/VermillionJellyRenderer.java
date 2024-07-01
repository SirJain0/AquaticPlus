package sirjain.aquaticplus.client.entity.renderers;

import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.client.entity.AquaticPlusEntityLayers;
import sirjain.aquaticplus.entity.entities.VermillionJellyEntity;
import sirjain.aquaticplus.client.entity.models.VermillionJellyModel;
import sirjain.aquaticplus.entity.AquaticPlusEntities;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public class VermillionJellyRenderer extends MobEntityRenderer<VermillionJellyEntity, VermillionJellyModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/vermillion_jelly.png");

	public VermillionJellyRenderer(EntityRendererFactory.Context context) {
		super(context, new VermillionJellyModel(context.getPart(AquaticPlusEntityLayers.VERMILLION_JELLY_LAYER)), 0.75f);
	}

	@Override
	public Identifier getTexture(VermillionJellyEntity entity) {
		return TEXTURE;
	}

	@Nullable
	@Override
	protected RenderLayer getRenderLayer(VermillionJellyEntity entity, boolean showBody, boolean translucent, boolean showOutline) {
		return super.getRenderLayer(entity, showBody, true, showOutline);
	}

	@Override
	protected void scale(VermillionJellyEntity entity, MatrixStack matrices, float amount) {
		float scaleAmount = entity.isMutated() ? 2.3f : 1;
		matrices.scale(scaleAmount, scaleAmount, scaleAmount);
	}
}