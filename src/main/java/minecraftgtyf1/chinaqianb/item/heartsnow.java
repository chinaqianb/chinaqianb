package minecraftgtyf1.chinaqianb.item;

import io.netty.buffer.ByteBuf;
import minecraftgtyf1.chinaqianb.Networking.sendwork;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PotionItem;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.predicate.entity.EntityEffectPredicate;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class heartsnow extends Item {

    public heartsnow(Settings settings) {
        super(settings);

    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack =user.getStackInHand(hand);
        world.addParticle(ParticleTypes.HEART, user.getX(), user.getY() , user.getZ(), 1, 2, 2);
         if (!world.isClient){
             itemStack.decrement(1);
             if (user.getMaxHealth() == user.getHealth()){
             } else if (user.getHealth()+5<user.getMaxHealth()) {
                 user.setHealth(user.getHealth()+5);
             } else if (user.getHealth()+5>=user.getMaxHealth()) {
                 user.setHealth(user.getMaxHealth());
             }

         }else {
             PacketByteBuf buf = PacketByteBufs.create();
             ServerPlayNetworking.send((ServerPlayerEntity) user, sendwork.HEART_SNOW_SEND, buf);
         }
        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.heart_snow.tooltip"));
    }
}
