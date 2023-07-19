package com.sirjain.entities.renderers;

import com.sirjain.AquaticPlus;
import com.sirjain.entities.entity.SpiritedFishEntity;
import com.sirjain.entities.models.SpiritedFishModel;
import com.sirjain.registries.AquaticPlusEntities;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class SpiritedFishRenderer extends MobEntityRenderer<SpiritedFishEntity, SpiritedFishModel> {
    public static final Identifier TEXTURE = new Identifier(AquaticPlus.MOD_ID, "textures/entities/johnson/johnson.png");

    public SpiritedFishRenderer(EntityRendererFactory.Context context) {
        super(context, new SpiritedFishModel(context.getPart(AquaticPlusEntities.SPIRITED_FISH_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(SpiritedFishEntity entity) {
        return TEXTURE;
    }

    // TODO: When model implemented, make outer layer translucent
}