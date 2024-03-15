package minecraftgtyf1.chinaqianbforge.item;

import minecraftgtyf1.chinaqianbforge.Chinaqianb_forge;
import minecraftgtyf1.chinaqianbforge.block.ModBlock;
import minecraftgtyf1.chinaqianbforge.item.dyitem.heart_snow;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItem {
    public static final DeferredRegister<Item> Items =
            DeferredRegister.create(ForgeRegistries.ITEMS, Chinaqianb_forge.MODID);
    //物品注册
    public static final RegistryObject<Item> U235 =Items.register("u235",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> HEART_SNOW =Items.register("heart_snow",
            ()->new heart_snow(new Item.Properties()));
    //物品方块
    public static final RegistryObject<Item> U235_BLOCK =Items.register("u235_block",
            ()->new BlockItem(ModBlock.U235_BLOCK.get(),new Item.Properties()));
    public static final RegistryObject<Item> U235_ORE =Items.register("u235_ore",
            ()->new BlockItem(ModBlock.U235_ORE.get(),new Item.Properties()));


   public static void register(IEventBus eventBus){
        Items.register(eventBus);
    }


}
