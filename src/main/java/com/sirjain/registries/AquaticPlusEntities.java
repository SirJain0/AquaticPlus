package com.sirjain.registries;

import com.sirjain.AquaticPlus;
import com.sirjain.entities.entity.*;
import com.sirjain.entities.entity.projectile.AquaticStarEntity;
import com.sirjain.entities.entity.projectile.FrostedSnowballProjectileEntity;
import com.sirjain.entities.entity.projectile.LandDrowningAquaticStarEntity;
import com.sirjain.entities.entity.projectile.NumbingAquaticStarEntity;
import com.sirjain.entities.models.*;
import com.sirjain.entities.renderers.*;
import com.sirjain.entities.renderers.projectile.AquaticStarRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
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

        public static final EntityModelLayer MAXILLA_MORTIS_LAYER = new EntityModelLayer(new Identifier(AquaticPlus.MOD_ID, "maxilla_mortis"), "root");
        public static final EntityType<MaxillaMortisEntity> MAXILLA_MORTIS_ENTITY = Registry.register(
                Registries.ENTITY_TYPE,
                new Identifier(AquaticPlus.MOD_ID, "maxilla_mortis"),
                FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, MaxillaMortisEntity::new)
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

        public static final EntityModelLayer SHADOW_SARDEL_LAYER = new EntityModelLayer(new Identifier(AquaticPlus.MOD_ID, "shadow_sardel"), "root");
        public static final EntityType<ShadowSardelEntity> SHADOW_SARDEL_ENTITY = Registry.register(
                Registries.ENTITY_TYPE,
                new Identifier(AquaticPlus.MOD_ID, "shadow_sardel"),
                FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, ShadowSardelEntity::new)
                        .dimensions(EntityDimensions.fixed(0.7f, 0.8f))
                        .build()
        );

        public static final EntityType<AquaticStarEntity> AQUATIC_STAR_ENTITY = Registry.register(
                Registries.ENTITY_TYPE,
                new Identifier(AquaticPlus.MOD_ID, "aquatic_star"),
                FabricEntityTypeBuilder.<AquaticStarEntity>create(SpawnGroup.MISC, AquaticStarEntity::new)
                        .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                        .trackRangeBlocks(16)
                        .trackedUpdateRate(10)
                        .build()
        );

        public static final EntityType<NumbingAquaticStarEntity> NUMBING_AQUATIC_STAR_ENTITY = Registry.register(
                Registries.ENTITY_TYPE,
                new Identifier(AquaticPlus.MOD_ID, "numbing_aquatic_star"),
                FabricEntityTypeBuilder.<NumbingAquaticStarEntity>create(SpawnGroup.MISC, NumbingAquaticStarEntity::new)
                        .trackRangeBlocks(16)
                        .trackedUpdateRate(10)
                        .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                        .build()
        );

        public static final EntityType<LandDrowningAquaticStarEntity> LAND_DROWNING_AQUATIC_STAR_ENTITY = Registry.register(
                Registries.ENTITY_TYPE,
                new Identifier(AquaticPlus.MOD_ID, "land_drowning_aquatic_star"),
                FabricEntityTypeBuilder.<LandDrowningAquaticStarEntity>create(SpawnGroup.MISC, LandDrowningAquaticStarEntity::new)
                        .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                        .trackRangeBlocks(16)
                        .trackedUpdateRate(10)
                        .build()
        );

        public static final EntityType<FrostedSnowballProjectileEntity> FROSTED_SNOWBALL_PROJECTILE_ENTITY = Registry.register(
                Registries.ENTITY_TYPE,
                new Identifier(AquaticPlus.MOD_ID, "frosted_snowball"),
                FabricEntityTypeBuilder.<FrostedSnowballProjectileEntity>create(SpawnGroup.MISC, FrostedSnowballProjectileEntity::new)
                        .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                        .trackRangeBlocks(16)
                        .trackedUpdateRate(20)
                        .build()
        );

        public static void registerAttributes() {
                FabricDefaultAttributeRegistry.register(JOHNSON_ENTITY, ShadowSardelEasterEggEntity.createEasterEggAttributes());
                FabricDefaultAttributeRegistry.register(MINDINATOR_ENTITY, ShadowSardelEasterEggEntity.createEasterEggAttributes());
                FabricDefaultAttributeRegistry.register(SPIRITED_FISH_ENTITY, SpiritedFishEntity.createSpiritedFishAttributes());
                FabricDefaultAttributeRegistry.register(MAXILLA_MORTIS_ENTITY, MaxillaMortisEntity.createMaxillaMortisAttributes());
                FabricDefaultAttributeRegistry.register(PARROTFISH_ENTITY, ParrotfishEntity.createParrotfishAttributes());
                FabricDefaultAttributeRegistry.register(KELP_EEL_ENTITY, KelpEelEntity.createKelpEelAttributes());
                FabricDefaultAttributeRegistry.register(SHADOW_SARDEL_ENTITY, ShadowSardelEntity.createShadowSardelAttributes());
        }

        public static void registerEntityRender() {
                EntityRendererRegistry.register(JOHNSON_ENTITY, JohnsonRenderer::new);
                EntityRendererRegistry.register(MINDINATOR_ENTITY, MindinatorRenderer::new);
                EntityRendererRegistry.register(SPIRITED_FISH_ENTITY, SpiritedFishRenderer::new);
                EntityRendererRegistry.register(MAXILLA_MORTIS_ENTITY, MaxillaMortisRenderer::new);
                EntityRendererRegistry.register(PARROTFISH_ENTITY, ParrotfishRenderer::new);
                EntityRendererRegistry.register(KELP_EEL_ENTITY, KelpEelRenderer::new);
                EntityRendererRegistry.register(SHADOW_SARDEL_ENTITY, ShadowSardelRenderer::new);

                // Projectiles
                EntityRendererRegistry.register(AQUATIC_STAR_ENTITY, (ctx) -> new AquaticStarRenderer(ctx, 1, false));
                EntityRendererRegistry.register(NUMBING_AQUATIC_STAR_ENTITY, (ctx) -> new AquaticStarRenderer(ctx, 1, false));
                EntityRendererRegistry.register(LAND_DROWNING_AQUATIC_STAR_ENTITY, (ctx) -> new AquaticStarRenderer(ctx, 1, false));
                EntityRendererRegistry.register(FROSTED_SNOWBALL_PROJECTILE_ENTITY, FlyingItemEntityRenderer::new);

                EntityModelLayerRegistry.registerModelLayer(JOHNNSON_LAYER, JohnsonModel::getTexturedModelData);
                EntityModelLayerRegistry.registerModelLayer(MINDINATOR_LAYER, MindinatorModel::getTexturedModelData);
                EntityModelLayerRegistry.registerModelLayer(SPIRITED_FISH_LAYER, SpiritedFishModel::getTexturedModelData);
                EntityModelLayerRegistry.registerModelLayer(MAXILLA_MORTIS_LAYER, MaxillaMortisModel::getTexturedModelData);
                EntityModelLayerRegistry.registerModelLayer(PARROTFISH_LAYER, ParrotfishModel::getTexturedModelData);
                EntityModelLayerRegistry.registerModelLayer(KELP_EEL_LAYER, KelpEelModel::getTexturedModelData);
                EntityModelLayerRegistry.registerModelLayer(SHADOW_SARDEL_LAYER, ShadowSardelModel::getTexturedModelData);
        }
}