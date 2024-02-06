package minecraftgtyf1.chinaqianb.Networking;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;

public class heartsnowrecie {
    public static void recie(MinecraftClient client, ClientPlayNetworkHandler networkHandler, PacketByteBuf buf, PacketSender sender){
        PlayerEntity player =client.player;
        if (player.getMaxHealth() == player.getHealth()){
        } else if (player.getHealth()+5<player.getMaxHealth()) {
            player.setHealth(player.getHealth()+5);
        } else if (player.getHealth()+5>=player.getMaxHealth()) {
            player.setHealth(player.getMaxHealth());
        }
    }
}
