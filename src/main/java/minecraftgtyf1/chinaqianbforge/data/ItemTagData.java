package minecraftgtyf1.chinaqianbforge.data;

import minecraftgtyf1.chinaqianbforge.Chinaqianb_forge;
import minecraftgtyf1.chinaqianbforge.Tags.ModTags;
import minecraftgtyf1.chinaqianbforge.item.ModItem;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ItemTagData extends ItemTagsProvider {


    public ItemTagData(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags) {
        super(pOutput, pLookupProvider, pBlockTags);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.U235TAG)
                .add(ModItem.U235.get())
                .add(ModItem.U235_ORE.get())
                .add(ModItem.U235_BLOCK.get());
    }
}
