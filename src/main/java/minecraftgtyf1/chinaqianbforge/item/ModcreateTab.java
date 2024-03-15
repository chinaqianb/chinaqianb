package minecraftgtyf1.chinaqianbforge.item;

import minecraftgtyf1.chinaqianbforge.Chinaqianb_forge;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModcreateTab {
    //物品栏翻译名字
    public static final String name ="chinaqianb.tab";
    public static final DeferredRegister<CreativeModeTab> Create_tab =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Chinaqianb_forge.MODID);

    //创建物品栏
    public static final RegistryObject<CreativeModeTab> TAB_REGISTRY_OBJECT =
            Create_tab.register(name,
                    ()-> CreativeModeTab.builder()
                            .icon(()->new ItemStack(ModItem.U235.get()))//图标
                            .title(Component.translatable(name))//标题,forge的翻译方法
                            .displayItems((itemDisplayParameters, output) -> {
                                //物品
                                output.accept(ModItem.U235.get());
                                output.accept(ModItem.U235_BLOCK.get());
                                output.accept(ModItem.U235_ORE.get());
                                output.accept(ModItem.HEART_SNOW.get());
                            })
                            .build());
    public static void register(IEventBus eventBus){
        Create_tab.register(eventBus);
    }
}
