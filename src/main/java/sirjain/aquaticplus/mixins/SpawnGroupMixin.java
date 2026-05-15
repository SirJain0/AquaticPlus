package sirjain.aquaticplus.mixins;

import net.minecraft.entity.SpawnGroup;
import org.objectweb.asm.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.gen.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.*;
import sirjain.aquaticplus.*;

import java.util.*;

@Mixin(SpawnGroup.class)
@SuppressWarnings({"ShadowTarget", "InvokerTarget"})
public class SpawnGroupMixin {

    @Shadow
    private static @Final
    @Mutable
    SpawnGroup[] field_6301;

    @Invoker("<init>")
    private static SpawnGroup newSpawnGroup(String internalName, int internalId, String name, int spawnCap, boolean peaceful, boolean rare, int immediateDespawnRange) {
        throw new AssertionError();
    }


    @Inject(
            method = "<clinit>",
            at = @At(
                    value = "FIELD",
                    opcode = Opcodes.PUTSTATIC,
                    target = "Lnet/minecraft/entity/SpawnGroup;field_6301:[Lnet/minecraft/entity/SpawnGroup;",
                    shift = At.Shift.AFTER
            )
    )
    private static void aqpNewSpawnGroup(CallbackInfo ci) {
        List<SpawnGroup> newSpawnGroups = new ArrayList<>(Arrays.asList(field_6301));
        AQPSpawnGroup.AQUATIC_PLUS = newSpawnGroup("aquatic_plus", newSpawnGroups.size(), "aquatic_plus", 570, true, false, 128);
        newSpawnGroups.add(AQPSpawnGroup.AQUATIC_PLUS);
        field_6301 = newSpawnGroups.toArray(new SpawnGroup[0]);
    }
}

