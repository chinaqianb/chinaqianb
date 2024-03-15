package minecraftgtyf1.chinaqianbforge.Networking;

import minecraftgtyf1.chinaqianbforge.Chinaqianb_forge;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class PackAll {
    private static SimpleChannel pack;
    private static int ID =0;
    private static int id(){
        return ID++;
    }
    public static void register(){
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(Chinaqianb_forge.MODID,"mes"))
                .networkProtocolVersion(()->"1.0.0")
                .clientAcceptedVersions(s->true)
                .serverAcceptedVersions(s->true)
                .simpleChannel();
        pack=net;

    }
    public static <MSG> void toServer(MSG message){
        pack.sendToServer(message);
    }
    public static <MSG> void toClient(MSG message, ServerPlayer player){
        pack.send(PacketDistributor.PLAYER.with(()->player),message);
    }
}
