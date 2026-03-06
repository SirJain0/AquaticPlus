package sirjain.aquaticplus.sounds;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import sirjain.aquaticplus.AquaticPlus;

public class AquaticPlusSounds {
	public static  SoundEvent FISH_FLOP;

	private static SoundEvent registerSoundEvent(String name) {
		Identifier identifier = new Identifier(AquaticPlus.MOD_ID, name);
		return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
	}

	public static void registerSounds() {
		FISH_FLOP = registerSoundEvent("fish_flop");
	}
}
