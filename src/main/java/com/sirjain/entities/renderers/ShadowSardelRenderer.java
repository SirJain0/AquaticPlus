package com.sirjain.entities.renderers;

import com.sirjain.AquaticPlus;
import com.sirjain.entities.entity.ShadowSardelEntity;
import com.sirjain.entities.models.ShadowSardelModel;
import com.sirjain.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class ShadowSardelRenderer extends MobEntityRenderer<ShadowSardelEntity, ShadowSardelModel> {
        public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entities/shadow_sardel/shadow_sardel.png");

        public ShadowSardelRenderer(EntityRendererFactory.Context context) {
                super(context, new ShadowSardelModel(context.getPart(AquaticPlusEntities.SHADOW_SARDEL_LAYER)), 0.5f);
        }

        @Override
        public Identifier getTexture(ShadowSardelEntity entity) {
                return TEXTURE;
        }
}
