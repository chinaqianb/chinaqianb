package minecraftgtyf1.chinaqianb;

import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public  class sword implements ToolMaterial {
    public static final sword INSTANCE = new sword();
    //耐久
    @Override
    public int getDurability() {
        return 500;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 0;
    }

    //破坏速度
    /*@Override
    public float getMiningSpeedMultiplier() {
        return 10F;
    }*/
    //攻击伤害
    @Override
    public float getAttackDamage() {
        return 20F;
    }

    @Override
    public int getMiningLevel() {
        return 0;
    }

    //挖掘等级
    /*@Override
    public int getMiningLevel() {
        return 3;
    }*/
    //附魔能力
    @Override
    public int getEnchantability() {
        return 20;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }


    //修复原料
    /*@Override
    public Ingredient getRepairIngredient(){
        return Ingredient.ofItems(Items.sword);
    }*/

}
