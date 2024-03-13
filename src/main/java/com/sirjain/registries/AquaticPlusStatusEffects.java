package com.sirjain.registries;

import com.sirjain.AquaticPlus;
import com.sirjain.status_effects.LandDrowningStatusEffect;
import com.sirjain.status_effects.NumbingStatusEffect;
import com.sirjain.status_effects.SunfishGraceStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class AquaticPlusStatusEffects {
	public static StatusEffect NUMBING;
	public static StatusEffect LAND_DROWNING;
	public static StatusEffect SUNFISH_GRACE;

	public static void registerModEffects() {
		NUMBING = registerStatusEffect("numbing", new NumbingStatusEffect(StatusEffectCategory.HARMFUL, 0xF2F2D2));
		LAND_DROWNING = registerStatusEffect("land_drowning", new LandDrowningStatusEffect(StatusEffectCategory.HARMFUL, 0x7DC2B6));
		SUNFISH_GRACE = registerStatusEffect("sunfish_grace", new SunfishGraceStatusEffect(StatusEffectCategory.BENEFICIAL, 0xcb8fbc));
	}

	private static StatusEffect registerStatusEffect(String name, StatusEffect statusEffect) {
		return Registry.register(
			Registries.STATUS_EFFECT,
			new Identifier(AquaticPlus.MOD_ID, name),
			statusEffect
		);
	}
}