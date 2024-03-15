package minecraftgtyf1.chinaqianbforge.Tags;

import minecraftgtyf1.chinaqianbforge.Chinaqianb_forge;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTags {
    //标签创建啊
    public static final TagKey<Item> U235TAG = ItemTags.create(new ResourceLocation(Chinaqianb_forge.MODID,"u235"));
    //forge的标签
    //public static final TagKey<Item> U235TAG =ForgeRegistries.ITEMS.tags().createTagKey(new ResourceLocation(Chinaqianb_forge.MODID,"u235tag"));
}
