package com.sirjain.entities.renderers;

import com.sirjain.AquaticPlus;
import com.sirjain.entities.entity.JohnsonEntity;
import com.sirjain.entities.models.JohnsonModel;
import com.sirjain.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class JohnsonRenderer extends MobEntityRenderer<JohnsonEntity, JohnsonModel> {
        public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entities/johnson/johnson.png");

        public JohnsonRenderer(EntityRendererFactory.Context context) {
                super(context, new JohnsonModel(context.getPart(AquaticPlusEntities.JOHNNSON_LAYER)), 0.5f);
        }

        @Override
        public Identifier getTexture(JohnsonEntity entity) {
                return TEXTURE;
        }
}