package minecraftgtyf1.chinaqianbforge.block;

import minecraftgtyf1.chinaqianbforge.Chinaqianb_forge;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlock {
    public static final DeferredRegister<Block> Blocks =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Chinaqianb_forge.MODID);
    //方块注册
    public static final RegistryObject<Block> U235_BLOCK =Blocks.register("u235_block",
            ()->new Block(BlockBehaviour.Properties.of().strength(2F)));

    public static void register(IEventBus eventBus){
        Blocks.register(eventBus);
    }
}
