package minecraftgtyf1.chinaqianbforge.data;

import minecraftgtyf1.chinaqianbforge.Chinaqianb_forge;
import minecraftgtyf1.chinaqianbforge.item.ModItem;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemData extends ItemModelProvider {
    //物品模型生成
    public static final String GEN ="item/generated";//物品总模型

    public ItemData(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Chinaqianb_forge.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
      itemmodel(ModItem.U235.get(),ItemLocation(itemname(ModItem.U235.get())));
      itemmodel(ModItem.HEART_SNOW.get(),ItemLocation(itemname(ModItem.HEART_SNOW.get())));
    }
    public void itemmodel(Item item, ResourceLocation texture){
        withExistingParent(itemname(item),GEN).texture("layer0",texture);
    }
    private String itemname (Item item){
        return ForgeRegistries.ITEMS.getKey(item).getPath();
    }
    public ResourceLocation BlockLocation(String path){
        return new ResourceLocation(Chinaqianb_forge.MODID,"block/"+path);
    }
    public ResourceLocation ItemLocation(String path){
         return new ResourceLocation(Chinaqianb_forge.MODID,"item/"+path);
     }
}
