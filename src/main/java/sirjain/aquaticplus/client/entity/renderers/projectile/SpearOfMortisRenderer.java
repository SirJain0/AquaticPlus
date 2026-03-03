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
import sirjain.aquaticplus.client.entity.models.projectile.SeaTridentModel;
import sirjain.aquaticplus.client.entity.models.projectile.SpearOfMortisModel;
import sirjain.aquaticplus.client.entity.renderers.projectile.template.SeaTridentRenderer;
import sirjain.aquaticplus.entity.entities.projectile.SpearOfMortisEntity;
import sirjain.aquaticplus.entity.entities.template.SeaTridentEntity;

public class SpearOfMortisRenderer extends EntityRenderer<SpearOfMortisEntity> {
	private final SpearOfMortisModel<SpearOfMortisEntity> model;

	public SpearOfMortisRenderer(EntityRendererFactory.Context ctx) {
		super(ctx);
		this.model = new SpearOfMortisModel<>(ctx.getPart(AquaticPlusEntityLayers.SPEAR_OF_MORTIS_LAYER));
	}

	@Override
	public void render(SpearOfMortisEntity tridentEntity, float yaw, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light) {
		matrixStack.push();
		matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(tickDelta, tridentEntity.prevYaw, tridentEntity.getYaw()) - 90.0F));
		matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp(tickDelta, tridentEntity.prevPitch, tridentEntity.getPitch()) + 90.0F));
		VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, this.model.getLayer(this.getTexture(tridentEntity)), false, false);
		this.model.render(matrixStack, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
		matrixStack.pop();
		super.render(tridentEntity, yaw, tickDelta, matrixStack, vertexConsumerProvider, light);
	}

	@Override
	public Identifier getTexture(SpearOfMortisEntity entity) {
		return new Identifier(AquaticPlus.MOD_ID, "textures/entity/spear_of_mortis.png");
	}
}