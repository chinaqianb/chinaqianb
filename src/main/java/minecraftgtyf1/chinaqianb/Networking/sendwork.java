package minecraftgtyf1.chinaqianb.Networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

public class sendwork {
public static final Identifier HEART_SNOW_SEND =new Identifier("chinaqianb","heart_snow_send");
public static final Identifier HEART_SNOW_RECEIVE =new Identifier("chinaqianb","heart_snow_receive");
  public static void clienttoserver(){
      ServerPlayNetworking.registerGlobalReceiver(HEART_SNOW_SEND,heartsnowsend::send);
}
public static void servertoclient(){
    ClientPlayNetworking.registerGlobalReceiver(HEART_SNOW_RECEIVE,heartsnowrecie::recie);
}

}
