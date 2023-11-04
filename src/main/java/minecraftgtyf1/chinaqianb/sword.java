package minecraftgtyf1.chinaqianb;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.List;

public  class sword implements ToolMaterial {
    public static final sword INSTANCE = new sword();
    //耐久
    @Override
    public int getDurability() {
        return 500;
    }


    //破坏速度
    @Override
    public float getMiningSpeedMultiplier() {
        return 10F;
    }
    //攻击伤害
    @Override
    public float getAttackDamage() {
        return 20F;
    }



    //挖掘等级
    @Override
    public int getMiningLevel() {
        return 3;
    }
    //附魔能力
    @Override
    public int getEnchantability() {
        return 20;
    }




    //修复原料
    @Override
    public Ingredient getRepairIngredient(){
        return Ingredient.ofItems(Items.AIR);
    }



}
