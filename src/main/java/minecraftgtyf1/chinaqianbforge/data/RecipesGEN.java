package minecraftgtyf1.chinaqianbforge.data;

import minecraftgtyf1.chinaqianbforge.Chinaqianb_forge;
import minecraftgtyf1.chinaqianbforge.block.ModBlock;
import minecraftgtyf1.chinaqianbforge.item.ModItem;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.function.Consumer;

public class RecipesGEN extends RecipeProvider {
    public RecipesGEN(PackOutput p_248933_) {
        super(p_248933_);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
      //有序合成表
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItem.U235_BLOCK.get(),1)//分类，合成的物品,数量
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItem.U235.get())//定义#号代表的物品
                .group("Chinaqainb")//分组
                .unlockedBy("has_u235"/*什么时候获取这个配方，名字，触发器(拥有这个物品后触发)->*/, InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ModItem.U235.get()).build()))
                .save(consumer,new ResourceLocation(Chinaqianb_forge.MODID,"u235_block"));
        //无序合成表
        /*ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS,ModItem.U235_BLOCK.get(),1)
                .requires(ModItem.U235.get())
                .group("Chinaqianb")
                .save(consumer,new ResourceLocation(Chinaqianb_forge.MODID,"u235_block"));*/
        //熔炉合成表
        /*
        第一个：要烧的物品
        第2个：物品类型
        第3个：结果
        第4个：经验值
        5：燃烧时间
        6：分组

         */

        //oreBlasting();
        Ingredient cf =Ingredient.of(ModItem.U235_ORE.get());
           SimpleCookingRecipeBuilder.smelting(cf,RecipeCategory.BUILDING_BLOCKS,ModItem.U235.get(),1f,10)
                   .unlockedBy("has_u235"/*什么时候获取这个配方，名字，触发器(拥有这个物品后触发)->*/, InventoryChangeTrigger.TriggerInstance.hasItems(
                           ItemPredicate.Builder.item().of(ModItem.U235.get()).build()))
                   .save(consumer,new ResourceLocation(Chinaqianb_forge.MODID,"u235_ore_smelting"));


    }

}
