package minecraftgtyf1.chinaqianbforge.event;

import com.mojang.logging.LogUtils;
import minecraftgtyf1.chinaqianbforge.Chinaqianb_forge;
import minecraftgtyf1.chinaqianbforge.item.ModItem;
import net.minecraft.advancements.critereon.ItemUsedOnLocationTrigger;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundPlayerLookAtPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SnowballItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingSwapItemsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import org.jline.utils.Log;
import org.slf4j.Logger;

import java.util.Collection;

@Mod.EventBusSubscriber(modid = Chinaqianb_forge.MODID)
public class ModEvent {

    @SubscribeEvent
    public static void UseItemBack(PlayerInteractEvent.RightClickItem event){
        Level world =event.getEntity().level();
        Player player = event.getEntity();
        InteractionHand hand =player.getUsedItemHand();
        if (!world.isClientSide()) {
            if (!player.isCreative()) {
                ItemStack stack = player.getItemInHand(hand);
                if (stack.getItem() == ModItem.HEART_SNOW.get()) {
                    stack.shrink(1);//我受不了，这™减少的方法竟然是这个
                    heartCheck(player);
                    AABB whatisdis =new AABB(player.getX() - 5, player.getY() - 5, player.getZ() - 5, player.getX() + 5, player.getY() + 5, player.getZ() + 5);
                    Collection<Player> serverworld = world.getNearbyPlayers(TargetingConditions.DEFAULT,player,whatisdis);
                    for (Player serverPlayerEntity : serverworld) {
                        heartCheck(serverPlayerEntity);
                    }
                }
            }
        }
    }
    public static void heartCheck(Player player){
        player.setHealth(Math.min(player.getHealth() + 5, player.getMaxHealth()));
    }

}
