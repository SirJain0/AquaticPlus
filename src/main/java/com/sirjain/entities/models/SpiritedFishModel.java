package com.sirjain.entities.models;

import com.sirjain.entities.entity.SpiritedFishEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class SpiritedFishModel extends EntityModel<SpiritedFishEntity> {
        private final ModelPart root;
        private final ModelPart body;
        private final ModelPart backFin;
        private final ModelPart topFin;
        private final ModelPart head;

        public SpiritedFishModel(ModelPart part) {
                root = part;

                body = root.getChild("body");
                backFin = body.getChild("back_fin");
                topFin = body.getChild("top_fin");
                head = body.getChild("head");
        }

        public static TexturedModelData getTexturedModelData() {
                ModelData modelData = new ModelData();
                ModelPartData modelPartData = modelData.getRoot();

                ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-2.5F, -2.5F, -4.25F, 5.0F, 5.0F, 10.0F, new Dilation(0.0F))
                        .uv(11, 23).cuboid(-1.5F, -1.5F, -3.25F, 3.0F, 3.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 20.5F, -1.75F));
                ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(24, 19).cuboid(-2.0F, -1.5F, -4.0F, 4.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.5F, -4.25F));
                ModelPartData top_fin = body.addChild("top_fin", ModelPartBuilder.create().uv(0, 5).cuboid(0.0F, -2.0F, -5.0F, 0.0F, 2.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.5F, 0.75F));
                ModelPartData back_fin = body.addChild("back_fin", ModelPartBuilder.create().uv(12, 15).cuboid(-2.0F, -2.0F, 0.0F, 4.0F, 0.0F, 8.0F, new Dilation(0.0F))
                        .uv(12, 0).cuboid(-2.0F, 2.0F, 0.0F, 4.0F, 0.0F, 8.0F, new Dilation(0.0F))
                        .uv(0, 13).cuboid(2.0F, -2.0F, 0.0F, 0.0F, 4.0F, 8.0F, new Dilation(0.0F))
                        .uv(0, 9).cuboid(-2.0F, -2.0F, 0.0F, 0.0F, 4.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 5.75F));

                return TexturedModelData.of(modelData, 64, 64);
        }

        @Override
        public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
                matrices.push();
                root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
                matrices.pop();
        }

        @Override
        public void setAngles(SpiritedFishEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
                backFin.yaw = -MathHelper.sin(-40 + animationProgress * 0.6f) * 0.1f;
                head.yaw = -MathHelper.sin(animationProgress * 0.6f) * 0.15f;
                body.pivotX = -MathHelper.sin(animationProgress * 0.6f) * 0.35f;
        }
}