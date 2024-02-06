package minecraftgtyf1.chinaqianb.sounds;

import net.minecraft.client.sound.AbstractSoundInstance;
import net.minecraft.client.sound.Sound;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.ResourceFinder;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.floatprovider.FloatSupplier;
import net.minecraft.util.math.random.Random;

public class CHA extends Sound  {


    public CHA(String id, FloatSupplier volume, FloatSupplier pitch, int weight, RegistrationType registrationType, boolean stream, boolean preload, int attenuation) {
        super(id, volume, pitch, weight, registrationType, stream, preload, attenuation);
    }

    @Override
    public Identifier getLocation() {
        return new Identifier("chinaqianb","sounds/cha.ogg");
    }
}
