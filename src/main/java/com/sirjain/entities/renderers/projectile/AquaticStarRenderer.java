package com.sirjain.entities.renderers.projectile;

import com.sirjain.entities.entity.projectile.AquaticStarEntity;
import com.sirjain.entities.entity.template.AbstractAquaticStarEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.data.client.VariantSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import org.joml.Math;

public class AquaticStarRenderer extends FlyingItemEntityRenderer<AbstractAquaticStarEntity> {
	public AquaticStarRenderer(EntityRendererFactory.Context ctx, float scale, boolean lit) {
		super(ctx, scale, lit);
	}

	@Override
	public void render(AbstractAquaticStarEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
		Entity thrower = entity.getOwner();

		if (thrower instanceof LivingEntity player) {
			float ownerYaw = player.getYaw();
			float ownerPitch = player.getPitch();
			float ownerRoll = player.getRoll();

			matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90 - ownerPitch));
			System.out.println(ownerPitch);
			matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(((player.getWorld().getTime() + tickDelta) * 23) - ownerPitch));
		}

		int lightAbove = WorldRenderer.getLightmapCoordinates(entity.getWorld(), entity.getBlockPos().up());
		MinecraftClient.getInstance().getItemRenderer().renderItem(entity.getStack(), ModelTransformationMode.GROUND, lightAbove, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 0);
	}

	public boolean throwerFacing(Entity entity, Direction... directions) {
		for (Direction dir : directions) {
			if (entity.getHorizontalFacing() == dir)
				return true;
		}

		return false;
	}
}
