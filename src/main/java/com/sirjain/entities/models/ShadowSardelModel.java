package com.sirjain.entities.models;

import com.sirjain.entities.entity.ShadowSardelEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class ShadowSardelModel extends EntityModel<ShadowSardelEntity> {
        private final ModelPart root;

        public ShadowSardelModel(ModelPart part) {
                root = part;
        }

        // blah
        public static TexturedModelData getTexturedModelData() {
                ModelData modelData = new ModelData();
                ModelPartData modelPartData = modelData.getRoot();

                ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(18, 0).cuboid(-1.5F, -1.5F, -2.875F, 3.0F, 3.0F, 4.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-2.0F, -2.5F, -4.125F, 4.0F, 5.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 19.5F, 0.125F));
                ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(16, 15).cuboid(-1.5F, -1.5F, -4.0F, 3.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.5F, -4.125F));
                ModelPartData top_fin = body.addChild("top_fin", ModelPartBuilder.create().uv(0, 14).cuboid(0.0F, -3.0F, -4.0F, 0.0F, 3.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.5F, -2.5F, 0.875F));
                ModelPartData back_fin = body.addChild("back_fin", ModelPartBuilder.create().uv(0, 7).cuboid(0.0F, -3.0F, 0.0F, 0.0F, 7.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.5F, -0.5F, 5.875F));

                return TexturedModelData.of(modelData, 32, 32);
        }

        @Override
        public void setAngles(ShadowSardelEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
                // TODO: Animate
        }

        @Override
        public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
                // TODO: Render
        }
}
