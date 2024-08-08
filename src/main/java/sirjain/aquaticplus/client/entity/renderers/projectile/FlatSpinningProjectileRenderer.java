package sirjain.aquaticplus.client.entity.renderers.projectile;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.util.math.RotationAxis;

public class FlatSpinningProjectileRenderer extends FlyingItemEntityRenderer<ThrownItemEntity> {
	public FlatSpinningProjectileRenderer(EntityRendererFactory.Context ctx, float scale, boolean lit) {
		super(ctx, scale, lit);
	}

	@Override
	public void render(ThrownItemEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
		Entity thrower = entity.getOwner();
		int lightAbove = WorldRenderer.getLightmapCoordinates(entity.getWorld(), entity.getBlockPos().up());

		if (thrower instanceof LivingEntity player) {
			float ownerPitch = player.getPitch();

			matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90 - ownerPitch));
			matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(((player.getWorld().getTime() + tickDelta) * 20) - ownerPitch));
		}

		MinecraftClient.getInstance().getItemRenderer().renderItem(entity.getStack(), ModelTransformationMode.GROUND, lightAbove, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 0);
	}
}
