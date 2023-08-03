package com.sirjain.entities.renderers;

import com.sirjain.AquaticPlus;
import com.sirjain.entities.entity.SpiritedFishEntity;
import com.sirjain.entities.models.SpiritedFishModel;
import com.sirjain.registries.AquaticPlusEntities;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public class SpiritedFishRenderer extends MobEntityRenderer<SpiritedFishEntity, SpiritedFishModel> {
        public static final Identifier TEXTURE_FULL = new Identifier(AquaticPlus.MOD_ID, "textures/entities/spirited_fish/spirited_fish_full.png");
        public static final Identifier TEXTURE_4 = new Identifier(AquaticPlus.MOD_ID, "textures/entities/spirited_fish/spirited_fish_4.png");
        public static final Identifier TEXTURE_2 = new Identifier(AquaticPlus.MOD_ID, "textures/entities/spirited_fish/spirited_fish_2.png");

        public SpiritedFishRenderer(EntityRendererFactory.Context context) {
                super(context, new SpiritedFishModel(context.getPart(AquaticPlusEntities.SPIRITED_FISH_LAYER)), 0.5f);
        }

        @Override
        public Identifier getTexture(SpiritedFishEntity entity) {
                return switch ((int) entity.getHealth()) {
                        case 4, 3 -> TEXTURE_4;
                        case 2, 1, 0 -> TEXTURE_2;
                        default -> TEXTURE_FULL;
                };
        }

        @Nullable
        @Override
        protected RenderLayer getRenderLayer(SpiritedFishEntity entity, boolean showBody, boolean translucent, boolean showOutline) {
                return super.getRenderLayer(entity, showBody, true, showOutline);
        }
}