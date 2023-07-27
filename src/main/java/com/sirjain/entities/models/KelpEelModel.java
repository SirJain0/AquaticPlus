package com.sirjain.entities.models;

import com.sirjain.entities.entity.KelpEelEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class KelpEelModel extends EntityModel<KelpEelEntity> {
        private final ModelPart root;
        private final ModelPart main;
        private final ModelPart seg1;
        private final ModelPart seg2;
        private final ModelPart seg3;

        public KelpEelModel(ModelPart part) {
                root = part;
                main = root.getChild("kelp_eel");
                seg1 = main.getChild("body_seg_1");
                seg2 = seg1.getChild("body_seg_2");
                seg3 = seg2.getChild("body_seg_3");
        }

        public static TexturedModelData getTexturedModelData() {
                ModelData modelData = new ModelData();
                ModelPartData modelPartData = modelData.getRoot();

                ModelPartData kelp_eel = modelPartData.addChild("kelp_eel", ModelPartBuilder.create().uv(16, 0).cuboid(-1.5F, -1.75F, -5.015F, 3.0F, 4.0F, 4.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(-2.0F, -3.75F, -0.985F, 4.0F, 7.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 18.74F, -14.25F));
                ModelPartData body_seg_1 = kelp_eel.addChild("body_seg_1", ModelPartBuilder.create().uv(0, 36).cuboid(-1.0F, -2.5F, 0.0F, 2.0F, 5.0F, 8.0F, new Dilation(0.0F))
                        .uv(0, 14).cuboid(0.0F, -4.5F, -4.0F, 0.0F, 9.0F, 12.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.25F, 7.015F));
                ModelPartData body_seg_2 = body_seg_1.addChild("body_seg_2", ModelPartBuilder.create().uv(16, 31).cuboid(-1.0F, -2.5F, 0.0F, 2.0F, 5.0F, 8.0F, new Dilation(0.0F))
                        .uv(24, 0).cuboid(0.0F, -4.5F, 0.0F, 0.0F, 9.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 8.0F));
                ModelPartData body_seg_3 = body_seg_2.addChild("body_seg_3", ModelPartBuilder.create().uv(26, 18).cuboid(-1.0F, -2.5F, -0.25F, 2.0F, 5.0F, 8.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(0.0F, -4.5F, -0.25F, 0.0F, 9.0F, 17.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 8.25F));

                return TexturedModelData.of(modelData, 64, 64);
        }

        @Override
        public void setAngles(KelpEelEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
                main.pivotX = -MathHelper.sin(animationProgress * 0.25f) * 4;
                seg1.yaw = MathHelper.sin(-30 + animationProgress * 0.25f) * 0.4f;
                seg2.yaw = -MathHelper.sin(-60 + animationProgress * 0.25f) * 0.5f;
                seg3.yaw = MathHelper.sin(-90 + animationProgress * 0.25f) * 0.65f;
        }

        @Override
        public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
                matrices.push();
                root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
                matrices.pop();
        }
}
