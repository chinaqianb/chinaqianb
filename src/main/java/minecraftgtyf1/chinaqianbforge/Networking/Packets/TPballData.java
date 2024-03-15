package minecraftgtyf1.chinaqianbforge.Networking.Packets;

import minecraftgtyf1.chinaqianbforge.Networking.PackAll;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class TPballData {
    //toServer
    public TPballData(){
    }
    public TPballData(FriendlyByteBuf buf){

    }
    public void toBytes(FriendlyByteBuf buf){

    }
    public boolean handle(Supplier<NetworkEvent.Context> supplier){
        NetworkEvent.Context context =supplier.get();
        context.enqueueWork(()->{
            ServerPlayer player =context.getSender();
            ServerLevel world =player.serverLevel();
           //逻辑
            //发包PackAll.toServer(new TPballData());
        });
        return true;
    }
}
