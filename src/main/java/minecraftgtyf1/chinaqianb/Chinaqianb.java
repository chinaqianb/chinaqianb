package minecraftgtyf1.chinaqianb;

import minecraftgtyf1.chinaqianb.Networking.sendwork;
import minecraftgtyf1.chinaqianb.block.laodeng;
import minecraftgtyf1.chinaqianb.block.voi;
import minecraftgtyf1.chinaqianb.blockentity.laodengep;
import minecraftgtyf1.chinaqianb.blockentity.voientity;
import minecraftgtyf1.chinaqianb.entity.Bkill;
import minecraftgtyf1.chinaqianb.item.eatingb;
import minecraftgtyf1.chinaqianb.item.heartsnow;
import minecraftgtyf1.chinaqianb.item.s686;
import minecraftgtyf1.chinaqianb.item.sword;
import minecraftgtyf1.chinaqianb.screen.laodengscreenhandle;
import minecraftgtyf1.chinaqianb.sounds.CHA;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.sound.v1.FabricSoundInstance;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.sound.Sound;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.floatprovider.FloatSupplier;

public class Chinaqianb implements ModInitializer {
    //物品定义
    public static final Item po =new Item(new FabricItemSettings().maxCount(17));//maxCount堆叠数量
    public static final eatingb eating_b =new eatingb(new FabricItemSettings().food(eatingb.EATingB));//食物定义
    public static final s686 S_686 =new s686(new FabricItemSettings().maxCount(1));
    public static final heartsnow HEARTSNOW =new heartsnow(new FabricItemSettings().maxCount(64));
    //方块定义
    public static final minecraftgtyf1.chinaqianb.block.laodeng laodeng =new laodeng(FabricBlockSettings.create().strength(1F));
    public static final voi voi =new voi(FabricBlockSettings.create().strength(1F));
    //方块实体
    public static final BlockEntityType<laodengep> laodengepa =FabricBlockEntityTypeBuilder.create(laodengep::
            new,laodeng).build();
    public static final BlockEntityType<voientity> voi_entity =FabricBlockEntityTypeBuilder.create(
            voientity::new
            ,voi).build();
    //屏幕定义
    public static  ScreenHandlerType<laodengscreenhandle> laodengscreen1;

    //工具
    public static ToolItem jiang =new SwordItem(sword.INSTANCE,5,3F,new Item.Settings());
    //public static final sword jian =new sword(new FabricItemSettings());

    //纹理
    //实体
    public static final EntityType<Bkill> BKILL =
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE,Bkill::new)
                    .dimensions(EntityDimensions.fixed(1f,1.2f)).build();//碰撞体积16为1f
    //实体刷怪蛋
    public static final Item BKILL_EGG = new SpawnEggItem(BKILL,0x475fbe,0x475f66,new FabricItemSettings());



   //public static final CHA cha =new CHA("cha",1, Sound.RegistrationType.SOUND_EVENT,true,true,5);



    //物品组
    private static final ItemGroup zhu = FabricItemGroup.builder().displayName(Text.translatable("chinaqianb.zhu"))//翻译名
            .icon(()->new ItemStack(po))//图标
            .entries((context, entries)->{
                entries.add(po);
                entries.add(jiang);
                entries.add(eating_b);//添加物品
                entries.add(laodeng);
                entries.add(voi);
                entries.add(BKILL_EGG);
                entries.add(S_686);
                entries.add(HEARTSNOW);
            })
            .build();
    @Override
    public  void onInitialize() {//注册
        //物品注册
        Registry.register(Registries.ITEM, new Identifier("chinaqianb", "po"), po);
        Registry.register(Registries.ITEM,new Identifier("chinaqianb", "eating_b"), eating_b);
        Registry.register(Registries.ITEM,new Identifier("chinaqianb", "jiang"), jiang);
        Registry.register(Registries.ITEM,new Identifier("chinaqianb","s686"),S_686);
        Registry.register(Registries.ITEM,new Identifier("chinaqianb","laodeng"),new BlockItem(laodeng,new
                FabricItemSettings()));
        Registry.register(Registries.ITEM,new Identifier("chinaqianb","voi"),new BlockItem(voi,new
                FabricItemSettings()));
        Registry.register(Registries.ITEM,new Identifier("chinaqianb","heart_snow"),HEARTSNOW);
        //方块注册
        Registry.register(Registries.BLOCK,new Identifier("chinaqianb", "laodeng"), laodeng);
        Registry.register(Registries.BLOCK,new Identifier("chinaqianb","voi"),voi);
        //方块实体注册
        Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier("chinaqianb","laodengep"),laodengepa);
        Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier("chinaqianb","voi"),voi_entity);
        //screenhandle注册
        laodengscreen1=Registry.register(Registries.SCREEN_HANDLER,new Identifier(
                "chianqianb","laodengscreen1"
        ),new ScreenHandlerType<>(laodengscreenhandle::new, FeatureFlags.VANILLA_FEATURES));
        //物品栏注册
        Registry.register(Registries.ITEM_GROUP,new Identifier("chinaqianb", "zhu"), zhu);
        //实体
        Registry.register(Registries.ENTITY_TYPE,new Identifier("chinaqianb","bkill"),BKILL);
        //实体属性
        FabricDefaultAttributeRegistry.register(BKILL,Bkill.createLivingAttributes());
        //实体刷怪蛋
        Registry.register(Registries.ITEM,new Identifier("chinaqianb","bkill_spwan"),BKILL_EGG);

        //Registry.register(Registries.SOUND_EVENT,new Identifier("chinaqianb","cha"),cha);
        //网络发包
        sendwork.clienttoserver();

    }


}
