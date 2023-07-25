package com.sirjain.registries;

import com.sirjain.AquaticPlus;
import com.sirjain.status_effects.LandDrowningStatusEffect;
import com.sirjain.status_effects.NumbingStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class AquaticPlusStatusEffects {
    public static StatusEffect NUMBING;
    public static StatusEffect LAND_DROWNING;

    public static void registerModEffects() {
        NUMBING = registerStatusEffect("numbing", new NumbingStatusEffect(StatusEffectCategory.HARMFUL, 0x31948e));
        LAND_DROWNING = registerStatusEffect("land_drowning", new LandDrowningStatusEffect(StatusEffectCategory.HARMFUL, 0x61D7C2));
    }

    private static StatusEffect registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.register(
                Registries.STATUS_EFFECT,
                new Identifier(AquaticPlus.MOD_ID, name),
                statusEffect
        );
    }
}
