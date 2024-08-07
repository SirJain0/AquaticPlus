package sirjain.aquaticplus.client.entity;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import sirjain.aquaticplus.client.entity.renderers.*;
import sirjain.aquaticplus.client.entity.renderers.projectile.FlatSpinningProjectileRenderer;
import sirjain.aquaticplus.client.entity.renderers.projectile.PlasmaRenderer;
import sirjain.aquaticplus.client.entity.renderers.projectile.SeaTridentRenderer;
import sirjain.aquaticplus.entity.AquaticPlusEntities;

public class AquaticPlusEntityRenderers {
	public static void registerEntityRenderers() {
		registerProjectileRenderers();

		EntityRendererRegistry.register(AquaticPlusEntities.JOHNSON_ENTITY, JohnsonRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.MINDINATOR_ENTITY, MindinatorRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.SPIRITED_FISH_ENTITY, SpiritedFishRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.MAXILLA_MORTIS_ENTITY, MaxillaMortisRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.PARROTFISH_ENTITY, ParrotfishRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.KELP_EEL_ENTITY, KelpEelRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.SHADOW_SARDEL_ENTITY, ShadowSardelRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.BONEFISH_ENTITY, BonefishRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.LONG_BONEFISH_ENTITY, LongBonefishRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.OCULI_MAGNI_ENTITY, OculiMagniRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.VIPERFISH_ENTITY, ViperfishRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.MANTA_RAY_ENTITY, MantaRayRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.DUMBO_BLOB_ENTITY, DumboBlobRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.PINK_SUNFISH_ENTITY, PinkSunfishRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.LANTERNFISH_ENTITY, LanternfishRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.BLUEFIN_TUNA_ENTITY, BluefinTunaRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.GULPER_EEL_ENTITY, GulperEelRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.HALIBUT_ENTITY, HalibutRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.SARDINE_ENTITY, SardineRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.MINNOW_ENTITY, MinnowRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.LIONFISH_ENTITY, LionfishRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.FROSTED_SPLASHER_ENTITY, FrostedSplasherRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.JELLYFISH_ENTITY, JellyfishRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.NARWHAL_ENTITY, NarwhalRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.SWORDFISH_ENTITY, SwordfishRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.NEON_CRAB_ENTITY, NeonCrabRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.ALLIGATOR_GAR_ENTITY, AlligatorGarRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.SEA_PEN_ENTITY, SeaPenRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.VOLAN_AURORA_ENTITY, VolanAuroraRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.PIKE_ENTITY, PikeRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.RIBBON_EEL_ENTITY, RibbonEelRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.DEEP_SEA_ISOPOD_ENTITY, DeepSeaIsopodRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.YETI_CRAB_ENTITY, YetiCrabRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.STONEFISH_ENTITY, StonefishRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.SLIMY_SHRIMP_ENTITY, SlimyShrimpRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.IVY_SEAHORSE_ENTITY, IvySeahorseRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.MYTHICAL_SEAHORSE_ENTITY, MythicalSeahorseRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.PHANTOM_JELLYFISH_ENTITY, PhantomJellyfishRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.VERMILLION_JELLY_ENTITY, VermillionJellyRenderer::new);
	}

	public static void registerProjectileRenderers() {
		EntityRendererRegistry.register(AquaticPlusEntities.AQUATIC_STAR_ENTITY, ctx -> new FlatSpinningProjectileRenderer(ctx, 1, false));
		EntityRendererRegistry.register(AquaticPlusEntities.NUMBING_AQUATIC_STAR_ENTITY, ctx -> new FlatSpinningProjectileRenderer(ctx, 1, false));
		EntityRendererRegistry.register(AquaticPlusEntities.LAND_DROWNING_AQUATIC_STAR_ENTITY, ctx -> new FlatSpinningProjectileRenderer(ctx, 1, false));
		EntityRendererRegistry.register(AquaticPlusEntities.SEA_BANE_AQUATIC_STAR_ENTITY, ctx -> new FlatSpinningProjectileRenderer(ctx, 1, false));
		EntityRendererRegistry.register(AquaticPlusEntities.FROSTED_SNOWBALL_ENTITY, FlyingItemEntityRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.AURORA_ENTITY, FlyingItemEntityRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.PLASMA_ENTITY, PlasmaRenderer::new);
		EntityRendererRegistry.register(AquaticPlusEntities.SEAHORSE_SPIKE_ENTITY, ctx -> new FlatSpinningProjectileRenderer(ctx, 4f, false));
		EntityRendererRegistry.register(AquaticPlusEntities.AQUA_SEA_TRIDENT_ENTITY, SeaTridentRenderer::new);
	}
}
