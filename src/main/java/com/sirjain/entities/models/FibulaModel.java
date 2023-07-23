package com.sirjain.entities.models;

import com.sirjain.entities.entity.FibulaEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class FibulaModel extends EntityModel<FibulaEntity> {
    private final ModelPart root;
    private final ModelPart main;
    private final ModelPart head;
    private final ModelPart upperJaw;
    private final ModelPart lowerJaw;
    private final ModelPart tailSeg1;
    private final ModelPart tailSeg2;

    public FibulaModel(ModelPart part) {
        root = part;
        main = root.getChild("main");

        head = main.getChild("head");
        upperJaw = head.getChild("jaw_upper");
        lowerJaw = head.getChild("jaw_lower");

        tailSeg1 = main.getChild("tail_1");
        tailSeg2 = tailSeg1.getChild("tail_2");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();

        ModelPartData main = modelPartData.addChild("main", ModelPartBuilder.create().uv(31, 20).cuboid(-3.0F, -4.1965F, -7.8536F, 6.0F, 8.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, 21.1965F, 3.8536F));
        ModelPartData upper_fin_r1 = main.addChild("upper_fin_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -7.0F, -2.0F, 2.0F, 10.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -4.1965F, -1.8536F, -0.7854F, 0.0F, 0.0F));
        ModelPartData side_fin_r_r1 = main.addChild("side_fin_r_r1", ModelPartBuilder.create().uv(24, 0).mirrored().cuboid(-7.0F, 0.0F, -6.0F, 7.0F, 1.0F, 12.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-3.0F, 1.8035F, 0.1464F, 0.0F, 0.0F, -0.1745F));
        ModelPartData side_fin_l_r1 = main.addChild("side_fin_l_r1", ModelPartBuilder.create().uv(24, 0).cuboid(0.0F, 0.0F, -6.0F, 7.0F, 1.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, 1.8035F, 0.1464F, 0.0F, 0.0F, 0.1745F));
        ModelPartData head = main.addChild("head", ModelPartBuilder.create().uv(37, 45).cuboid(-2.5F, -3.0F, -6.25F, 5.0F, 6.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.3035F, -7.8536F));
        ModelPartData jaw_upper = head.addChild("jaw_upper", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -0.5F, -6.5F));
        ModelPartData cube_r1 = jaw_upper.addChild("cube_r1", ModelPartBuilder.create().uv(24, 14).cuboid(-2.0F, -1.5F, -4.5F, 4.0F, 3.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.8727F, 0.0F, 0.0F));
        ModelPartData jaw_lower = head.addChild("jaw_lower", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.5F, -6.5F));
        ModelPartData cube_r2 = jaw_lower.addChild("cube_r2", ModelPartBuilder.create().uv(24, 14).cuboid(-2.0F, -1.5F, -4.5F, 4.0F, 3.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.8727F, 0.0F, 3.1416F));
        ModelPartData tail_1 = main.addChild("tail_1", ModelPartBuilder.create().uv(0, 36).cuboid(-2.0F, -3.0F, 0.0F, 4.0F, 6.0F, 14.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0535F, 8.1464F));
        ModelPartData tail_2 = tail_1.addChild("tail_2", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -6.0F, 0.0F, 0.0F, 12.0F, 23.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.5F, 14.0F));

        return TexturedModelData.of(modelData, 128, 128);
    }

    @Override
    public void setAngles(FibulaEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        tailSeg1.yaw = MathHelper.cos(animationProgress * 0.25f) * 0.35f;
        tailSeg2.yaw = MathHelper.cos(-20 + animationProgress * 0.25f) * 0.65f;
        head.yaw = -(MathHelper.cos(animationProgress * 0.25f)  * 0.08f);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        matrices.push();
        main.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        matrices.scale(1.3f, 1.3f, 1.3f);
        matrices.translate(0, 4, 0);
        matrices.pop();
    }
}