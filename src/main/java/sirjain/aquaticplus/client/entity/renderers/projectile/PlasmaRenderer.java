package sirjain.aquaticplus.client.entity.renderers.projectile;

import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.entity.entities.projectile.PlasmaEntity;
import sirjain.aquaticplus.client.entity.models.projectile.PlasmaModel;
import sirjain.aquaticplus.entity.AquaticPlusEntities;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class PlasmaRenderer extends EntityRenderer<PlasmaEntity> {
	private static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/plasma.png");
	private final PlasmaModel<PlasmaEntity> model;

	public PlasmaRenderer(EntityRendererFactory.Context context) {
		super(context);
		this.model = new PlasmaModel<>(context.getPart(AquaticPlusEntities.PLASMA_LAYER));
	}

	@Override
	protected int getBlockLight(PlasmaEntity entity, BlockPos pos) {
		return 15;
	}

	@Override
	protected int getSkyLight(PlasmaEntity entity, BlockPos pos) {
		return 15;
	}

	@Override
	public void render(PlasmaEntity entity, float yaw, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light) {
		matrixStack.push();
		VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(this.model.getLayer(TEXTURE));

		if (!entity.isShotAsBeam())
			this.model.render(matrixStack, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);

		matrixStack.pop();
	}

	@Override
	public Identifier getTexture(PlasmaEntity entity) {
		return TEXTURE;
	}
}
