package com.sirjain.registries;

import com.sirjain.AquaticPlus;
import com.sirjain.entities.entity.JohnsonEntity;
import com.sirjain.entities.entity.SpiritedFishEntity;
import com.sirjain.entities.models.JohnsonModel;
import com.sirjain.entities.models.SpiritedFishModel;
import com.sirjain.entities.renderers.JohnsonRenderer;
import com.sirjain.entities.renderers.SpiritedFishRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class AquaticPlusEntities {
    public static final EntityModelLayer JOHNNSON_LAYER = new EntityModelLayer(new Identifier(AquaticPlus.MOD_ID, "johnson"), "root");
    public static final EntityType<JohnsonEntity> JOHNSON_ENTITY = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(AquaticPlus.MOD_ID, "johnson"),
            FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, JohnsonEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f))
                    .build()
    );

    public static final EntityModelLayer SPIRITED_FISH_LAYER = new EntityModelLayer(new Identifier(AquaticPlus.MOD_ID, "spirited_fish"), "root");
    public static final EntityType<SpiritedFishEntity> SPIRITED_FISH_ENTITY = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(AquaticPlus.MOD_ID, "spirited_fish"),
            FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, SpiritedFishEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f))
                    .build()
    );

    public static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(JOHNSON_ENTITY, JohnsonEntity.createJohnsonAttributes());
        FabricDefaultAttributeRegistry.register(SPIRITED_FISH_ENTITY, SpiritedFishEntity.createSpiritedFishAttributes());
    }

    public static void registerEntityRender() {
        EntityRendererRegistry.register(JOHNSON_ENTITY, JohnsonRenderer::new);
        EntityRendererRegistry.register(SPIRITED_FISH_ENTITY, SpiritedFishRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(JOHNNSON_LAYER, JohnsonModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(SPIRITED_FISH_LAYER, SpiritedFishModel::getTexturedModelData);
    }
}