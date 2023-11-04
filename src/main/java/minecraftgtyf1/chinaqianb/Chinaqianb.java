package minecraftgtyf1.chinaqianb;

import minecraftgtyf1.chinaqianb.client.laodeng;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.apache.commons.compress.compressors.lz77support.LZ77Compressor;

public class Chinaqianb implements ModInitializer {
    //物品定义
    public static final Item po =new Item(new FabricItemSettings().maxCount(17));//maxCount堆叠数量
    public static final eatingb eating_b =new eatingb(new FabricItemSettings().food(eatingb.EATingB));//食物定义
    //方块定义
    public static final laodeng laodeng =new laodeng(FabricBlockSettings.create().strength(1F));
    public static ToolItem jiang =new SwordItem(sword.INSTANCE,5,3F,new Item.Settings());
    //public static final sword jian =new sword(new FabricItemSettings());
    //物品组
    private static final ItemGroup zhu = FabricItemGroup.builder().displayName(Text.translatable("chinaqianb.zhu"))//翻译名
            .icon(()->new ItemStack(po))//图标
            .entries((context, entries)->{
                entries.add(po);
                entries.add(jiang);
                entries.add(eating_b);//添加物品
            })
            .build();
    @Override
    public  void onInitialize() {//注册
        //物品注册
        Registry.register(Registries.ITEM, new Identifier("chinaqianb", "po"), po);
        Registry.register(Registries.ITEM,new Identifier("chinaqianb", "eating_b"), eating_b);
        Registry.register(Registries.ITEM,new Identifier("chinaqianb", "jiang"), jiang);
        Registry.register(Registries.ITEM,new Identifier("chinaqianb","laodeng"),new BlockItem(laodeng,new
                FabricItemSettings()));
        //方块注册
        Registry.register(Registries.BLOCK,new Identifier("chinaqianb", "laodeng"), laodeng);
        //物品栏注册
        Registry.register(Registries.ITEM_GROUP,new Identifier("chinaqianb", "zhu"), zhu);
    }


}
