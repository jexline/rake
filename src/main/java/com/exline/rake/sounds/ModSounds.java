package com.exline.rake.sounds;

import com.exline.rake.ModMain;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent RAKE_LEAVES = registerSoundEvent("rake_leaves");
    public static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(ModMain.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
    public static void registerSounds() {}
}