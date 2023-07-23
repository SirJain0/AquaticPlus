package com.sirjain.entities.renderers;

import com.sirjain.AquaticPlus;
import com.sirjain.entities.entity.FibulaEntity;
import com.sirjain.entities.features.APEmissiveTextureFeature;
import com.sirjain.entities.models.FibulaModel;
import com.sirjain.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class FibulaRenderer extends MobEntityRenderer<FibulaEntity, FibulaModel> {
    private static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entities/fibula/fibula.png");
    private static final Identifier EMISSIVE = new Identifier(AquaticPlus.MOD_ID, "textures/entities/fibula/fibula_e.png");

    public FibulaRenderer(EntityRendererFactory.Context context) {
        super(context, new FibulaModel(context.getPart(AquaticPlusEntities.FIBULA_LAYER)), 0.5f);
        this.addFeature(new APEmissiveTextureFeature<>(this, EMISSIVE));
    }

    @Override
    public Identifier getTexture(FibulaEntity entity) {
        return TEXTURE;
    }
}