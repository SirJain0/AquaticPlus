package sirjain.aquaticplus.client.entity.renderers;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.client.entity.AquaticPlusEntityLayers;
import sirjain.aquaticplus.client.entity.features.APEmissiveTextureFeature;
import sirjain.aquaticplus.client.entity.models.PhantomJellyfishModel;
import sirjain.aquaticplus.entity.entities.boss.PhantomJellyfishEntity;

public class PhantomJellyfishRenderer extends MobEntityRenderer<PhantomJellyfishEntity, PhantomJellyfishModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/phantom_jellyfish.png");

	public PhantomJellyfishRenderer(EntityRendererFactory.Context context) {
		super(context, new PhantomJellyfishModel(context.getPart(AquaticPlusEntityLayers.PHANTOM_JELLYFISH_LAYER)), 0.75f);
		this.addFeature(new APEmissiveTextureFeature<>(this, TEXTURE));
	}

	@Override
	public Identifier getTexture(PhantomJellyfishEntity entity) {
		return TEXTURE;
	}

	@Nullable
	@Override
	protected RenderLayer getRenderLayer(PhantomJellyfishEntity entity, boolean showBody, boolean translucent, boolean showOutline) {
		return super.getRenderLayer(entity, showBody, true, showOutline);
	}
}