package minecraftgtyf1.chinaqianbforge.data;

import minecraftgtyf1.chinaqianbforge.Chinaqianb_forge;
import minecraftgtyf1.chinaqianbforge.block.ModBlock;
import minecraftgtyf1.chinaqianbforge.item.ModItem;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.injection.struct.InjectorGroupInfo;

import java.util.Map;
import java.util.stream.Collectors;

public class Loot_tableGEN extends VanillaBlockLoot {
    //掉落物
    @Override
    protected void generate() {
        //掉落自己
       dropSelf(ModBlock.U235_BLOCK.get());
       //掉落其他
        add(ModBlock.U235_ORE.get(),this::createA);
    }
    protected LootTable.Builder createA(Block pblock){
        return createSilkTouchDispatchTable(pblock, (LootPoolEntryContainer.Builder)this.applyExplosionDecay(pblock, LootItem.lootTableItem(ModItem.U235.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(4.0F, 5.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ForgeRegistries.BLOCKS.getEntries().stream()
                .filter(e->e.getKey().location().getNamespace().equals(Chinaqianb_forge.MODID))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}
