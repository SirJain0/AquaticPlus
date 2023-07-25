package com.sirjain.entities.models;

import com.sirjain.entities.entity.ParrotfishEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class ParrotfishModel extends EntityModel<ParrotfishEntity> {
    private final ModelPart root;

    public ParrotfishModel(ModelPart part) {
        root = part;
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();

        // blah

        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public void setAngles(ParrotfishEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        // TODO: Add animations
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        matrices.push();
        root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        matrices.pop();
    }
}