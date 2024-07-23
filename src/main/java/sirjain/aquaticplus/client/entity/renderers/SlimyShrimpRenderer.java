package sirjain.aquaticplus.client.entity.renderers;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.client.entity.AquaticPlusEntityLayers;
import sirjain.aquaticplus.client.entity.models.GulperEelModel;
import sirjain.aquaticplus.client.entity.models.SlimyShrimpModel;
import sirjain.aquaticplus.entity.entities.GulperEelEntity;
import sirjain.aquaticplus.entity.entities.SlimyShrimpEntity;

public class SlimyShrimpRenderer extends MobEntityRenderer<SlimyShrimpEntity, SlimyShrimpModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/slimy_shrimp.png");

	public SlimyShrimpRenderer(EntityRendererFactory.Context context) {
		super(context, new SlimyShrimpModel(context.getPart(AquaticPlusEntityLayers.SLIMY_SHRIMP_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(SlimyShrimpEntity entity) {
		return TEXTURE;
	}

	@Nullable
	@Override
	protected RenderLayer getRenderLayer(SlimyShrimpEntity entity, boolean showBody, boolean translucent, boolean showOutline) {
		return super.getRenderLayer(entity, showBody, true, showOutline);
	}
}
