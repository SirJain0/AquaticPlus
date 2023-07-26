package com.sirjain.entities.models;

import com.sirjain.entities.entity.ParrotfishEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class ParrotfishModel extends EntityModel<ParrotfishEntity> {
        private final ModelPart root;
        private final ModelPart parrotfish;
        private final ModelPart leftFin;
        private final ModelPart rightFin;
        private final ModelPart tail;

        public ParrotfishModel(ModelPart part) {
                root = part;
                parrotfish = root.getChild("parrotfish");
                leftFin = parrotfish.getChild("fin_l");
                rightFin = parrotfish.getChild("fin_r");
                tail = parrotfish.getChild("tail");
        }

        public static TexturedModelData getTexturedModelData() {
                ModelData modelData = new ModelData();
                ModelPartData modelPartData = modelData.getRoot();

                ModelPartData parrotfish = modelPartData.addChild("parrotfish", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -4.5F, -8.3333F, 4.0F, 8.0F, 18.0F, new Dilation(0.0F))
                        .uv(26, 0).cuboid(0.0F, -5.5F, -5.3333F, 0.0F, 1.0F, 13.0F, new Dilation(0.0F))
                        .uv(0, 8).cuboid(0.0F, 3.5F, -4.3333F, 0.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 17.5F, -5.8413F));
                ModelPartData fin_l = parrotfish.addChild("fin_l", ModelPartBuilder.create(), ModelTransform.pivot(2.0F, 0.0F, -4.3333F));
                ModelPartData cube_r1 = fin_l.addChild("cube_r1", ModelPartBuilder.create().uv(26, 0).cuboid(0.0F, -3.5F, -1.0F, 0.0F, 6.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.3491F, 0.0F));
                ModelPartData fin_r = parrotfish.addChild("fin_r", ModelPartBuilder.create(), ModelTransform.pivot(-2.0F, 0.0F, -4.3333F));
                ModelPartData cube_r2 = fin_r.addChild("cube_r2", ModelPartBuilder.create().uv(26, 0).mirrored().cuboid(0.0F, -3.5F, -1.0F, 0.0F, 6.0F, 7.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.3491F, 0.0F));
                ModelPartData tail = parrotfish.addChild("tail", ModelPartBuilder.create().uv(52, 30).cuboid(0.0F, -5.0F, 3.0F, 0.0F, 10.0F, 6.0F, new Dilation(0.0F))
                        .uv(45, 48).cuboid(-1.0F, -3.0F, -2.0F, 2.0F, 6.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.5F, 9.6667F));

                return TexturedModelData.of(modelData, 64, 64);
        }

        @Override
        public void setAngles(ParrotfishEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
                tail.yaw = -MathHelper.sin(-40 + animationProgress * 0.6f) * 0.35f;
                parrotfish.pivotX = -MathHelper.sin(-40 + animationProgress * 0.6f) * 0.35f;
        }

        @Override
        public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
                matrices.push();
                root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
                matrices.pop();
        }
}