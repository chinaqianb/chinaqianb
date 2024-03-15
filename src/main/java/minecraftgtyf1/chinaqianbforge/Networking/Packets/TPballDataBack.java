package minecraftgtyf1.chinaqianbforge.Networking.Packets;

import minecraftgtyf1.chinaqianbforge.Networking.PackAll;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class TPballDataBack {
    //toClient
    public TPballDataBack(){
    }
    public TPballDataBack(FriendlyByteBuf buf){

    }
    public void toBytes(FriendlyByteBuf buf){

    }
 public boolean handle(Supplier<NetworkEvent.Context> supplier){
     NetworkEvent.Context context =supplier.get();
     context.enqueueWork(()->{
         //逻辑
         //发包PackAll.toClient(new TPballDataBack(),player);
     });
     return true;
 }
}
