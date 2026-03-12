package sirjain.aquaticplus.client.entity.renderers.projectile;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.client.entity.AquaticPlusEntityLayers;
import sirjain.aquaticplus.client.entity.models.projectile.AirleechPouchModel;
import sirjain.aquaticplus.entity.entities.projectile.AirleechPouchEntity;

public class AirleechPouchRenderer extends EntityRenderer<AirleechPouchEntity> {
	private static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entity/airleech_pouch.png");
	private final AirleechPouchModel<AirleechPouchEntity> model;

	public AirleechPouchRenderer(EntityRendererFactory.Context ctx) {
		super(ctx);
		this.model = new AirleechPouchModel<>(ctx.getPart(AquaticPlusEntityLayers.AIRLEECH_POUCH_LAYER));
	}

	@Override
	public void render(AirleechPouchEntity entity, float yaw, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light) {
		matrixStack.push();
		VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(this.model.getLayer(TEXTURE));
		this.model.render(matrixStack, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
		matrixStack.pop();
	}

	@Override
	public Identifier getTexture(AirleechPouchEntity entity) {
		return TEXTURE;
	}
}
