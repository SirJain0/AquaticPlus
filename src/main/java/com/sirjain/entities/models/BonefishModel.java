package com.sirjain.entities.models;

import com.sirjain.entities.entity.BonefishEntity;
import com.sirjain.entities.entity.ParrotfishEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class BonefishModel extends EntityModel<BonefishEntity> {
        private final ModelPart root;
        private final ModelPart main;
        private final ModelPart tail;

        public BonefishModel(ModelPart part) {
                root = part;
                main = root.getChild("bonefish");
                tail = main.getChild("tail");
        }

        public static TexturedModelData getTexturedModelData() {
                ModelData modelData = new ModelData();
                ModelPartData modelPartData = modelData.getRoot();

                ModelPartData bonefish = modelPartData.addChild("bonefish", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -3.0F, -5.5F, 4.0F, 6.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 19.0F, -2.625F));
                ModelPartData tail = bonefish.addChild("tail", ModelPartBuilder.create().uv(0, 17).cuboid(-1.0F, -2.0F, -0.3333F, 2.0F, 4.0F, 4.0F, new Dilation(0.0F))
                        .uv(0, 0).cuboid(0.0F, -3.0F, 1.6667F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 5.5833F));
                ModelPartData cube_r1 = tail.addChild("cube_r1", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -1.0F, -2.0F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.0F, 3.6667F, 0.0F, 0.0F, -3.1416F));

                return TexturedModelData.of(modelData, 32, 32);
        }

        @Override
        public void setAngles(BonefishEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
                tail.yaw = -MathHelper.sin(-40 + animationProgress * 0.8f) * 0.35f;
                main.pivotX = -MathHelper.sin(-40 + animationProgress * 0.8f) * 0.35f;
        }

        @Override
        public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
                matrices.push();
                root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
                matrices.pop();
        }
}
