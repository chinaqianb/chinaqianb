package minecraftgtyf1.chinaqianbforge.data;

import jdk.jfr.Event;
import minecraftgtyf1.chinaqianbforge.Chinaqianb_forge;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.IModBusEvent;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = Chinaqianb_forge.MODID,bus =Mod.EventBusSubscriber.Bus.MOD)
public class DataEvent  {
    //数据生成
@SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
    DataGenerator generator =event.getGenerator();
    PackOutput output =generator.getPackOutput();
    CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
    ExistingFileHelper helper =event.getExistingFileHelper();
    //物品模型
    generator.addProvider(event.includeClient(),new ItemData(output,helper));
    //方块模型
    generator.addProvider(event.includeClient(),new blockData(output,helper));
    //语言文件
    generator.addProvider(event.includeClient(),new Lang_EN(output,"en_us"));
    generator.addProvider(event.includeClient(),new Lang_CN(output,"zh_cn"));

    }
}
