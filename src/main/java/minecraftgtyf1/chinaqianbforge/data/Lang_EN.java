package minecraftgtyf1.chinaqianbforge.data;

import minecraftgtyf1.chinaqianbforge.Chinaqianb_forge;
import minecraftgtyf1.chinaqianbforge.block.ModBlock;
import minecraftgtyf1.chinaqianbforge.item.ModItem;
import minecraftgtyf1.chinaqianbforge.item.ModcreateTab;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class Lang_EN extends LanguageProvider {
    //英文翻译
    public Lang_EN(PackOutput output, String locale) {
        super(output, Chinaqianb_forge.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        add(ModItem.U235.get(),"U-235");
        add(ModBlock.U235_BLOCK.get(),"U-235 Block");
        add(ModcreateTab.name,"chinaqianb'mod");
    }
}
