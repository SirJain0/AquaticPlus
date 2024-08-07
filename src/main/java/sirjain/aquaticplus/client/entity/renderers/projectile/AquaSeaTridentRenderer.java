package sirjain.aquaticplus.client.entity.renderers.projectile;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.client.entity.AquaticPlusEntityLayers;
import sirjain.aquaticplus.client.entity.models.projectile.PlasmaModel;
import sirjain.aquaticplus.client.entity.models.projectile.SeaTridentModel;
import sirjain.aquaticplus.entity.entities.projectile.PlasmaEntity;
import sirjain.aquaticplus.entity.entities.template.SeaTridentEntity;

public class AquaSeaTridentRenderer extends EntityRenderer<SeaTridentEntity> {
	private final SeaTridentModel<SeaTridentEntity> model;

	public AquaSeaTridentRenderer(EntityRendererFactory.Context ctx) {
		super(ctx);
		this.model = new SeaTridentModel<>(ctx.getPart(AquaticPlusEntityLayers.SEA_TRIDENT_LAYER));
	}

	@Override
	public Identifier getTexture(SeaTridentEntity entity) {
		return new Identifier(AquaticPlus.MOD_ID, "textures/entity/sea_trident/aqua_sea_trident.png");
	}

	@Override
	public void render(SeaTridentEntity tridentEntity, float yaw, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light) {
		matrixStack.push();
		matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(tickDelta, tridentEntity.prevYaw, tridentEntity.getYaw()) - 90.0F));
		matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp(tickDelta, tridentEntity.prevPitch, tridentEntity.getPitch()) + 90.0F));
		VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, this.model.getLayer(this.getTexture(tridentEntity)), false, false);
		this.model.render(matrixStack, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
		matrixStack.pop();
		super.render(tridentEntity, yaw, tickDelta, matrixStack, vertexConsumerProvider, light);
	}
}
