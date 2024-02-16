package minecraftgtyf1.chinaqianbforge.data;

import minecraftgtyf1.chinaqianbforge.Chinaqianb_forge;
import minecraftgtyf1.chinaqianbforge.block.ModBlock;
import net.minecraft.commands.arguments.blocks.BlockStateParser;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class blockData extends BlockStateProvider {
    //方块模型
    public blockData(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Chinaqianb_forge.MODID, exFileHelper);
    }
//注册
    @Override
    protected void registerStatesAndModels() {
this.registerBlockandItem(ModBlock.U235_BLOCK.get());
    }
    //简单模型
    public void registerBlockandItem(Block block){
this.simpleBlockWithItem(block,this.cubeAll(block));
    }
//多状态模型
    public void registeryProcerss(Block block){
        //ModelFile off =models().cubeAll(name(block)+"_off",)
    }
    private ResourceLocation key(Block block){
        return ForgeRegistries.BLOCKS.getKey(block);
    }
    private String name(Block block){
        return key(block).getPath();
    }

}
