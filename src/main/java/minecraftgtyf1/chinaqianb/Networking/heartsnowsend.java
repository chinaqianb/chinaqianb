package minecraftgtyf1.chinaqianb.Networking;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.SplashPotionItem;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.Collection;
import java.util.List;

public class heartsnowsend {
    public static void send(MinecraftServer server, ServerPlayerEntity playerEntity, ServerPlayNetworkHandler playNetworkHandler
    , PacketByteBuf buf, PacketSender sender) {
        playerEntity.sendMessage(Text.literal("gd"));
       Collection<ServerPlayerEntity> world= PlayerLookup.around(server.getOverworld(),playerEntity.getPos(),5);
       PlayerEntity player = (PlayerEntity) world.stream().toList();
           if (player.getMaxHealth() == player.getHealth()) {
           } else if (player.getHealth() + 5 < player.getMaxHealth()) {
               player.setHealth(player.getHealth() + 5);
           } else if (player.getHealth() + 5 >= player.getMaxHealth()) {
               player.setHealth(player.getMaxHealth());
           }

    }

}
