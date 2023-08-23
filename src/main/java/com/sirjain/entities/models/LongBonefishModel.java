package com.sirjain.entities.models;

import com.sirjain.entities.entity.LongBonefishEntity;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class LongBonefishModel extends EntityModel<LongBonefishEntity> {
        private final ModelPart root;
        private final ModelPart main;

        public LongBonefishModel(ModelPart part) {
                root = part;
                main = root.getChild("long_bonefish");
        }

        public static TexturedModelData getTexturedModelData() {
                ModelData modelData = new ModelData();
                ModelPartData modelPartData = modelData.getRoot();

                return TexturedModelData.of(modelData, 32, 32);
        }

        @Override
        public void setAngles(LongBonefishEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
                // TODO: Animate
        }

        @Override
        public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
                matrices.push();
                main.render(matrices, vertices, light, overlay, red, green, blue, alpha);
                matrices.pop();
        }
}
