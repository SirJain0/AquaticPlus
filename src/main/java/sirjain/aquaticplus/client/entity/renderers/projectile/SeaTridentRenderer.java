package sirjain.aquaticplus.client.entity.renderers.projectile;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import sirjain.aquaticplus.AquaticPlus;
import sirjain.aquaticplus.AquaticPlusUtil;
import sirjain.aquaticplus.entity.AquaticPlusEntities;
import sirjain.aquaticplus.entity.entities.template.SeaTridentEntity;
import sirjain.aquaticplus.item.AquaticPlusItems;

public class SeaTridentRenderer extends EntityRenderer<SeaTridentEntity> {
	public SeaTridentRenderer(EntityRendererFactory.Context ctx) {
		super(ctx);
	}

	@Override
	public Identifier getTexture(SeaTridentEntity entity) {
		return new Identifier(AquaticPlus.MOD_ID, "");
	}

	@Override
	public void render(SeaTridentEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
//		Entity thrower = entity.getOwner();
//		int lightAbove = WorldRenderer.getLightmapCoordinates(entity.getWorld(), entity.getBlockPos().up());
//
//		if (thrower instanceof LivingEntity player) {
//			float ownerPitch = player.getPitch();
//
//			matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90 - ownerPitch));
////			matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(((player.getWorld().getTime() + tickDelta) * 20) - ownerPitch));
//		}
//
//		MinecraftClient.getInstance().getItemRenderer().renderItem(AquaticPlusItems.AQUA_SEA_TRIDENT.getDefaultStack(), ModelTransformationMode.GROUND, lightAbove, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 0);
	}
}
