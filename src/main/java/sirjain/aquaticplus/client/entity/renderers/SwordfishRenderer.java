package sirjain.aquaticplus.client.entity.renderers;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.debug.DebugRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.client.entity.AquaticPlusEntityLayers;
import sirjain.aquaticplus.client.entity.models.NarwhalModel;
import sirjain.aquaticplus.client.entity.models.SwordfishModel;
import sirjain.aquaticplus.entity.entities.NarwhalEntity;
import sirjain.aquaticplus.entity.entities.SwordfishEntity;

public class SwordfishRenderer extends MobEntityRenderer<SwordfishEntity, SwordfishModel> {
	public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/swordfish.png");

	public SwordfishRenderer(EntityRendererFactory.Context context) {
		super(context, new SwordfishModel(context.getPart(AquaticPlusEntityLayers.SWORDFISH_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(SwordfishEntity entity) {
		return TEXTURE;
	}

	@Override
	protected void scale(SwordfishEntity entity, MatrixStack matrices, float amount) {
		matrices.scale(1.25f, 1.25f, 1.25f);
	}

	@Override
	public void render(SwordfishEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
//		DebugRenderer.drawBox(matrixStack, vertexConsumerProvider, mobEntity.box, 1, 1, 1, 1);
		super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
	}
}
