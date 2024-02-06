package minecraftgtyf1.chinaqianb.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class eatingb extends Item {
    public eatingb(Item.Settings settings){
        super(settings);
    }


    @Override
    public void appendTooltip(ItemStack stack,  World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(Text.translatable("item.chinaqianb.eating_b.tooltip"));
    }
    public static final FoodComponent EATingB =new FoodComponent.Builder()//食物
            .hunger(5)
            .saturationModifier(0.25f)
            /*
            药水效果
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,100),1)
            喂狗
            .meat()
            零食
            .snack()
             */
            .build();



}
