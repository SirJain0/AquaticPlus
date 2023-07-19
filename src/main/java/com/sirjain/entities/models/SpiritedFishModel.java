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

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(18, 0).cuboid(-1.5F, -3.0F, -0.75F, 3.0F, 3.0F, 4.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-2.0F, -4.0F, -2.0F, 4.0F, 5.0F, 10.0F, new Dilation(0.0F))
                .uv(16, 15).cuboid(-1.5F, -2.5F, -6.0F, 3.0F, 3.0F, 4.0F, new Dilation(0.0F))
                .uv(0, 14).cuboid(0.5F, -7.0F, -1.0F, 0.0F, 3.0F, 8.0F, new Dilation(0.0F))
                .uv(0, 7).cuboid(0.5F, -5.0F, 8.0F, 0.0F, 7.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 21.0F, -2.0F));

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