package com.sirjain.entities.models;

import com.sirjain.entities.entity.JohnsonEntity;
import com.sirjain.entities.entity.SpiritedFishEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class SpiritedFishModel extends EntityModel<SpiritedFishEntity> {
    private final ModelPart root;

    public SpiritedFishModel(ModelPart part) {
        root = part;
    }

    // TODO: Fill with geo
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();

        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        matrices.push();
        root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        matrices.pop();
    }

    @Override
    public void setAngles(SpiritedFishEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        // TODO: Do animations
    }
}