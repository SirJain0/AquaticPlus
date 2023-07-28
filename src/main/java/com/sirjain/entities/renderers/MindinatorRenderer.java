package com.sirjain.entities.renderers;

import com.sirjain.AquaticPlus;
import com.sirjain.entities.entity.ShadowSardelEasterEggEntity;
import com.sirjain.entities.models.MindinatorModel;
import com.sirjain.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class MindinatorRenderer extends MobEntityRenderer<ShadowSardelEasterEggEntity, MindinatorModel> {
        public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entities/shadow_sardel/mindinator.png");

        public MindinatorRenderer(EntityRendererFactory.Context context) {
                super(context, new MindinatorModel(context.getPart(AquaticPlusEntities.MINDINATOR_LAYER)), 0.5f);
        }

        @Override
        public Identifier getTexture(ShadowSardelEasterEggEntity entity) {
                return TEXTURE;
        }
}