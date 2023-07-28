package com.sirjain.registries;

import com.sirjain.AquaticPlus;
import com.sirjain.entities.entity.*;
import com.sirjain.entities.models.*;
import com.sirjain.entities.renderers.*;
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
        public static final EntityType<ShadowSardelEasterEggEntity> JOHNSON_ENTITY = Registry.register(
                Registries.ENTITY_TYPE,
                new Identifier(AquaticPlus.MOD_ID, "johnson"),
                FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, ShadowSardelEasterEggEntity::new)
                        .dimensions(EntityDimensions.fixed(0.5f, 0.5f))
                        .build()
        );

        public static final EntityModelLayer MINDINATOR_LAYER = new EntityModelLayer(new Identifier(AquaticPlus.MOD_ID, "mindinator"), "root");
        public static final EntityType<ShadowSardelEasterEggEntity> MINDINATOR_ENTITY = Registry.register(
                Registries.ENTITY_TYPE,
                new Identifier(AquaticPlus.MOD_ID, "mindinator"),
                FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, ShadowSardelEasterEggEntity::new)
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

        public static final EntityModelLayer FIBULA_LAYER = new EntityModelLayer(new Identifier(AquaticPlus.MOD_ID, "fibula"), "root");
        public static final EntityType<FibulaEntity> FIBULA_ENTITY = Registry.register(
                Registries.ENTITY_TYPE,
                new Identifier(AquaticPlus.MOD_ID, "fibula"),
                FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, FibulaEntity::new)
                        .dimensions(EntityDimensions.fixed(0.7f, 0.8f))
                        .build()
        );

        public static final EntityModelLayer PARROTFISH_LAYER = new EntityModelLayer(new Identifier(AquaticPlus.MOD_ID, "parrotfish"), "root");
        public static final EntityType<ParrotfishEntity> PARROTFISH_ENTITY = Registry.register(
                Registries.ENTITY_TYPE,
                new Identifier(AquaticPlus.MOD_ID, "parrotfish"),
                FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, ParrotfishEntity::new)
                        .dimensions(EntityDimensions.fixed(0.7f, 0.8f))
                        .build()
        );

        public static final EntityModelLayer KELP_EEL_LAYER = new EntityModelLayer(new Identifier(AquaticPlus.MOD_ID, "kelp_eel"), "root");
        public static final EntityType<KelpEelEntity> KELP_EEL_ENTITY = Registry.register(
                Registries.ENTITY_TYPE,
                new Identifier(AquaticPlus.MOD_ID, "kelp_eel"),
                FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, KelpEelEntity::new)
                        .dimensions(EntityDimensions.fixed(0.7f, 0.8f))
                        .build()
        );

        public static void registerAttributes() {
                FabricDefaultAttributeRegistry.register(JOHNSON_ENTITY, ShadowSardelEasterEggEntity.createEasterEggAttributes());
                FabricDefaultAttributeRegistry.register(MINDINATOR_ENTITY, ShadowSardelEasterEggEntity.createEasterEggAttributes());
                FabricDefaultAttributeRegistry.register(SPIRITED_FISH_ENTITY, SpiritedFishEntity.createSpiritedFishAttributes());
                FabricDefaultAttributeRegistry.register(FIBULA_ENTITY, FibulaEntity.createFibulaAttributes());
                FabricDefaultAttributeRegistry.register(PARROTFISH_ENTITY, ParrotfishEntity.createParrotfishAttributes());
                FabricDefaultAttributeRegistry.register(KELP_EEL_ENTITY, KelpEelEntity.createKelpEelAttributes());
        }

        public static void registerEntityRender() {
                EntityRendererRegistry.register(JOHNSON_ENTITY, JohnsonRenderer::new);
                EntityRendererRegistry.register(MINDINATOR_ENTITY, MindinatorRenderer::new);
                EntityRendererRegistry.register(SPIRITED_FISH_ENTITY, SpiritedFishRenderer::new);
                EntityRendererRegistry.register(FIBULA_ENTITY, FibulaRenderer::new);
                EntityRendererRegistry.register(PARROTFISH_ENTITY, ParrotfishRenderer::new);
                EntityRendererRegistry.register(KELP_EEL_ENTITY, KelpEelRenderer::new);

                EntityModelLayerRegistry.registerModelLayer(JOHNNSON_LAYER, JohnsonModel::getTexturedModelData);
                EntityModelLayerRegistry.registerModelLayer(MINDINATOR_LAYER, MindinatorModel::getTexturedModelData);
                EntityModelLayerRegistry.registerModelLayer(SPIRITED_FISH_LAYER, SpiritedFishModel::getTexturedModelData);
                EntityModelLayerRegistry.registerModelLayer(FIBULA_LAYER, FibulaModel::getTexturedModelData);
                EntityModelLayerRegistry.registerModelLayer(PARROTFISH_LAYER, ParrotfishModel::getTexturedModelData);
                EntityModelLayerRegistry.registerModelLayer(KELP_EEL_LAYER, KelpEelModel::getTexturedModelData);
        }
}