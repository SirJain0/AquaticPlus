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
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.Arrays;
import java.util.List;

// TODO: Check all hitboxes and shadow radiuses
// TODO: Refactor system?

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

	public static final EntityModelLayer BONEFISH_LAYER = new EntityModelLayer(new Identifier(AquaticPlus.MOD_ID, "bonefish"), "root");
	public static final EntityType<BonefishEntity> BONEFISH_ENTITY = Registry.register(
		Registries.ENTITY_TYPE,
		new Identifier(AquaticPlus.MOD_ID, "bonefish"),
		FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, BonefishEntity::new)
			.dimensions(EntityDimensions.fixed(0.7f, 0.8f))
			.build()
	);

	public static final EntityModelLayer LONG_BONEFISH_LAYER = new EntityModelLayer(new Identifier(AquaticPlus.MOD_ID, "long_bonefish"), "root");
	public static final EntityType<LongBonefishEntity> LONG_BONEFISH_ENTITY = Registry.register(
		Registries.ENTITY_TYPE,
		new Identifier(AquaticPlus.MOD_ID, "long_bonefish"),
		FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, LongBonefishEntity::new)
			.dimensions(EntityDimensions.fixed(0.7f, 0.8f))
			.build()
	);

	public static final EntityModelLayer OCULI_MAGNI_LAYER = new EntityModelLayer(new Identifier(AquaticPlus.MOD_ID, "oculi_magni"), "root");
	public static final EntityType<OculiMagniEntity> OCULI_MAGNI_ENTITY = Registry.register(
		Registries.ENTITY_TYPE,
		new Identifier(AquaticPlus.MOD_ID, "oculi_magni"),
		FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, OculiMagniEntity::new)
			.dimensions(EntityDimensions.fixed(0.7f, 0.8f))
			.build()
	);

	public static final EntityModelLayer VIPERFISH_LAYER = new EntityModelLayer(new Identifier(AquaticPlus.MOD_ID, "viperfish"), "root");
	public static final EntityType<ViperfishEntity> VIPERFISH_ENTITY = Registry.register(
		Registries.ENTITY_TYPE,
		new Identifier(AquaticPlus.MOD_ID, "viperfish"),
		FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, ViperfishEntity::new)
			.dimensions(EntityDimensions.fixed(0.6f, 0.6f))
			.build()
	);

	public static final EntityModelLayer MANTA_RAY_LAYER = new EntityModelLayer(new Identifier(AquaticPlus.MOD_ID, "manta_ray"), "root");
	public static final EntityType<MantaRayEntity> MANTA_RAY_ENTITY = Registry.register(
		Registries.ENTITY_TYPE,
		new Identifier(AquaticPlus.MOD_ID, "manta_ray"),
		FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, MantaRayEntity::new)
			.dimensions(EntityDimensions.fixed(1.1f, 0.9f))
			.build()
	);

	public static final EntityModelLayer DUMBO_BLOB_LAYER = new EntityModelLayer(new Identifier(AquaticPlus.MOD_ID, "dumbo_blob"), "root");
	public static final EntityType<DumboBlobEntity> DUMBO_BLOB_ENTITY = Registry.register(
		Registries.ENTITY_TYPE,
		new Identifier(AquaticPlus.MOD_ID, "dumbo_blob"),
		FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, DumboBlobEntity::new)
			.dimensions(EntityDimensions.fixed(0.4f, 0.4f))
			.build()
	);

	public static final EntityModelLayer PINK_SUNFISH_LAYER = new EntityModelLayer(new Identifier(AquaticPlus.MOD_ID, "pink_sunfish"), "root");
	public static final EntityType<PinkSunfishEntity> PINK_SUNFISH_ENTITY = Registry.register(
		Registries.ENTITY_TYPE,
		new Identifier(AquaticPlus.MOD_ID, "pink_sunfish"),
		FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, PinkSunfishEntity::new)
			.dimensions(EntityDimensions.fixed(0.4f, 0.4f))
			.build()
	);

	public static final EntityModelLayer LANTERNFISH_LAYER = new EntityModelLayer(new Identifier(AquaticPlus.MOD_ID, "lanternfish"), "root");
	public static final EntityType<LanternfishEntity> LANTERNFISH_ENTITY = Registry.register(
		Registries.ENTITY_TYPE,
		new Identifier(AquaticPlus.MOD_ID, "lanternfish"),
		FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, LanternfishEntity::new)
			.dimensions(EntityDimensions.fixed(0.4f, 0.4f))
			.build()
	);

	public static final EntityModelLayer BLUEFIN_TUNA_LAYER = new EntityModelLayer(new Identifier(AquaticPlus.MOD_ID, "bluefin_tuna"), "root");
	public static final EntityType<BluefinTunaEntity> BLUEFIN_TUNA_ENTITY = Registry.register(
		Registries.ENTITY_TYPE,
		new Identifier(AquaticPlus.MOD_ID, "bluefin_tuna"),
		FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, BluefinTunaEntity::new)
			.dimensions(EntityDimensions.fixed(0.4f, 0.4f))
			.build()
	);

	public static final EntityModelLayer GULPER_EEL_LAYER = new EntityModelLayer(new Identifier(AquaticPlus.MOD_ID, "gulper_eel"), "root");
	public static final EntityType<GulperEelEntity> GULPER_EEL_ENTITY = Registry.register(
		Registries.ENTITY_TYPE,
		new Identifier(AquaticPlus.MOD_ID, "gulper_eel"),
		FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, GulperEelEntity::new)
			.dimensions(EntityDimensions.fixed(0.4f, 0.4f))
			.build()
	);

	public static final EntityModelLayer HALIBUT_LAYER = new EntityModelLayer(new Identifier(AquaticPlus.MOD_ID, "halibut"), "root");
	public static final EntityType<HalibutEntity> HALIBUT_ENTITY = Registry.register(
		Registries.ENTITY_TYPE,
		new Identifier(AquaticPlus.MOD_ID, "halibut"),
		FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, HalibutEntity::new)
			.dimensions(EntityDimensions.fixed(0.4f, 0.4f))
			.build()
	);

	public static final EntityModelLayer SARDINE_LAYER = new EntityModelLayer(new Identifier(AquaticPlus.MOD_ID, "sardine"), "root");
	public static final EntityType<SardineEntity> SARDINE_ENTITY = Registry.register(
		Registries.ENTITY_TYPE,
		new Identifier(AquaticPlus.MOD_ID, "sardine"),
		FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, SardineEntity::new)
			.dimensions(EntityDimensions.fixed(0.4f, 0.4f))
			.build()
	);

	public static final EntityModelLayer MINNOW_LAYER = new EntityModelLayer(new Identifier(AquaticPlus.MOD_ID, "minnow"), "root");
	public static final EntityType<MinnowEntity> MINNOW_ENTITY = Registry.register(
		Registries.ENTITY_TYPE,
		new Identifier(AquaticPlus.MOD_ID, "minnow"),
		FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, MinnowEntity::new)
			.dimensions(EntityDimensions.fixed(0.4f, 0.4f))
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

	public static final List<EntityType<? extends FishEntity>> MOD_ENTITIES = Arrays.asList(
		JOHNSON_ENTITY,
		MINDINATOR_ENTITY,
		SPIRITED_FISH_ENTITY,
		MAXILLA_MORTIS_ENTITY,
		PARROTFISH_ENTITY,
		KELP_EEL_ENTITY,
		SHADOW_SARDEL_ENTITY,
		BONEFISH_ENTITY,
		LONG_BONEFISH_ENTITY,
		OCULI_MAGNI_ENTITY,
		MANTA_RAY_ENTITY,
		VIPERFISH_ENTITY,
		DUMBO_BLOB_ENTITY,
		PINK_SUNFISH_ENTITY,
		LANTERNFISH_ENTITY,
		BLUEFIN_TUNA_ENTITY,
		GULPER_EEL_ENTITY,
		HALIBUT_ENTITY,
		SARDINE_ENTITY,
		MINNOW_ENTITY
	);

	public static void registerAttributes() {
		FabricDefaultAttributeRegistry.register(JOHNSON_ENTITY, ShadowSardelEasterEggEntity.createEasterEggAttributes());
		FabricDefaultAttributeRegistry.register(MINDINATOR_ENTITY, ShadowSardelEasterEggEntity.createEasterEggAttributes());
		FabricDefaultAttributeRegistry.register(SPIRITED_FISH_ENTITY, SpiritedFishEntity.createSpiritedFishAttributes());
		FabricDefaultAttributeRegistry.register(MAXILLA_MORTIS_ENTITY, MaxillaMortisEntity.createMaxillaMortisAttributes());
		FabricDefaultAttributeRegistry.register(PARROTFISH_ENTITY, ParrotfishEntity.createParrotfishAttributes());
		FabricDefaultAttributeRegistry.register(KELP_EEL_ENTITY, KelpEelEntity.createKelpEelAttributes());
		FabricDefaultAttributeRegistry.register(SHADOW_SARDEL_ENTITY, ShadowSardelEntity.createShadowSardelAttributes());
		FabricDefaultAttributeRegistry.register(BONEFISH_ENTITY, BonefishEntity.createBonefishAttributes());
		FabricDefaultAttributeRegistry.register(LONG_BONEFISH_ENTITY, LongBonefishEntity.createLongBonefishAttributes());
		FabricDefaultAttributeRegistry.register(OCULI_MAGNI_ENTITY, OculiMagniEntity.createOculiMagniAttributes());
		FabricDefaultAttributeRegistry.register(VIPERFISH_ENTITY, ViperfishEntity.createViperfishAttributes());
		FabricDefaultAttributeRegistry.register(MANTA_RAY_ENTITY, MantaRayEntity.createMantaRayAttributes());
		FabricDefaultAttributeRegistry.register(DUMBO_BLOB_ENTITY, DumboBlobEntity.createDumboBlobAttributes());
		FabricDefaultAttributeRegistry.register(PINK_SUNFISH_ENTITY, PinkSunfishEntity.createPinkSunfishAttributes());
		FabricDefaultAttributeRegistry.register(LANTERNFISH_ENTITY, LanternfishEntity.createLanternfishAttributes());
		FabricDefaultAttributeRegistry.register(BLUEFIN_TUNA_ENTITY, BluefinTunaEntity.createBluefinTunaAttributes());
		FabricDefaultAttributeRegistry.register(GULPER_EEL_ENTITY, GulperEelEntity.createGulperEelEntity());
		FabricDefaultAttributeRegistry.register(HALIBUT_ENTITY, HalibutEntity.createHalibutAttributes());
		FabricDefaultAttributeRegistry.register(SARDINE_ENTITY, FishEntity.createFishAttributes());
		FabricDefaultAttributeRegistry.register(MINNOW_ENTITY, FishEntity.createFishAttributes());
	}

	public static void registerEntityRenderers() {
		registerProjectileRenderers();

		EntityRendererRegistry.register(JOHNSON_ENTITY, JohnsonRenderer::new);
		EntityRendererRegistry.register(MINDINATOR_ENTITY, MindinatorRenderer::new);
		EntityRendererRegistry.register(SPIRITED_FISH_ENTITY, SpiritedFishRenderer::new);
		EntityRendererRegistry.register(MAXILLA_MORTIS_ENTITY, MaxillaMortisRenderer::new);
		EntityRendererRegistry.register(PARROTFISH_ENTITY, ParrotfishRenderer::new);
		EntityRendererRegistry.register(KELP_EEL_ENTITY, KelpEelRenderer::new);
		EntityRendererRegistry.register(SHADOW_SARDEL_ENTITY, ShadowSardelRenderer::new);
		EntityRendererRegistry.register(BONEFISH_ENTITY, BonefishRenderer::new);
		EntityRendererRegistry.register(LONG_BONEFISH_ENTITY, LongBonefishRenderer::new);
		EntityRendererRegistry.register(OCULI_MAGNI_ENTITY, OculiMagniRenderer::new);
		EntityRendererRegistry.register(VIPERFISH_ENTITY, ViperfishRenderer::new);
		EntityRendererRegistry.register(MANTA_RAY_ENTITY, MantaRayRenderer::new);
		EntityRendererRegistry.register(DUMBO_BLOB_ENTITY, DumboBlobRenderer::new);
		EntityRendererRegistry.register(PINK_SUNFISH_ENTITY, PinkSunfishRenderer::new);
		EntityRendererRegistry.register(LANTERNFISH_ENTITY, LanternfishRenderer::new);
		EntityRendererRegistry.register(BLUEFIN_TUNA_ENTITY, BluefinTunaRenderer::new);
		EntityRendererRegistry.register(GULPER_EEL_ENTITY, GulperEelRenderer::new);
		EntityRendererRegistry.register(HALIBUT_ENTITY, HalibutRenderer::new);
		EntityRendererRegistry.register(SARDINE_ENTITY, SardineRenderer::new);
		EntityRendererRegistry.register(MINNOW_ENTITY, MinnowRenderer::new);

		EntityModelLayerRegistry.registerModelLayer(JOHNNSON_LAYER, JohnsonModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(MINDINATOR_LAYER, MindinatorModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(SPIRITED_FISH_LAYER, SpiritedFishModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(MAXILLA_MORTIS_LAYER, MaxillaMortisModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(PARROTFISH_LAYER, ParrotfishModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(KELP_EEL_LAYER, KelpEelModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(SHADOW_SARDEL_LAYER, ShadowSardelModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(BONEFISH_LAYER, BonefishModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(LONG_BONEFISH_LAYER, LongBonefishModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(OCULI_MAGNI_LAYER, OculiMagniModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(VIPERFISH_LAYER, ViperfishModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(MANTA_RAY_LAYER, MantaRayModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(DUMBO_BLOB_LAYER, DumboBlobModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(PINK_SUNFISH_LAYER, PinkSunfishModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(LANTERNFISH_LAYER, LanternfishModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(BLUEFIN_TUNA_LAYER, BluefinTunaModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(GULPER_EEL_LAYER, GulperEelModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(HALIBUT_LAYER, HalibutModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(SARDINE_LAYER, SardineModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(MINNOW_LAYER, MinnowModel::getTexturedModelData);
	}

	public static void registerProjectileRenderers() {
		EntityRendererRegistry.register(AQUATIC_STAR_ENTITY, (ctx) -> new AquaticStarRenderer(ctx, 1, false));
		EntityRendererRegistry.register(NUMBING_AQUATIC_STAR_ENTITY, (ctx) -> new AquaticStarRenderer(ctx, 1, false));
		EntityRendererRegistry.register(LAND_DROWNING_AQUATIC_STAR_ENTITY, (ctx) -> new AquaticStarRenderer(ctx, 1, false));
		EntityRendererRegistry.register(FROSTED_SNOWBALL_PROJECTILE_ENTITY, FlyingItemEntityRenderer::new);
	}
}