package minecraftgtyf1.chinaqianb.model;

import minecraftgtyf1.chinaqianb.Chinaqianb;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;
import org.apache.commons.compress.compressors.lz77support.LZ77Compressor;

import java.util.Optional;

public class modelgenerator extends FabricModelProvider {
    public modelgenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(Chinaqianb.voi);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
     itemModelGenerator.register(Chinaqianb.voi.asItem(),model(Chinaqianb.voi));
    }
    public static Model model(Block block, TextureKey ... requiredTextures){
        String name = ModelIds.getBlockModelId(block).getPath();
        return new Model(Optional.of(new Identifier("chinaqianb",name)),Optional.empty(),requiredTextures);
    }
}
