package minecraftgtyf1.chinaqianb.client;


import minecraftgtyf1.chinaqianb.Chinaqianb;
import minecraftgtyf1.chinaqianb.EntityRenderer.voiEntityRenderer;
import minecraftgtyf1.chinaqianb.Networking.sendwork;
import minecraftgtyf1.chinaqianb.entity.entityrender.BkillRender;
import minecraftgtyf1.chinaqianb.model.voiprider;
import minecraftgtyf1.chinaqianb.screen.laodengscreen;
import minecraftgtyf1.chinaqianb.screen.laodengscreenhandle;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.screen.ScreenHandlerType;

import static minecraftgtyf1.chinaqianb.Chinaqianb.voi_entity;

@Environment(EnvType.CLIENT)
public class ChinaqianbClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        //HandledScreens.register(Chinaqianb.laodengscreen1,laodengscreen::new);
        ScreenRegistry.register(Chinaqianb.laodengscreen1, laodengscreen::new);
        ModelLoadingRegistry.INSTANCE.registerResourceProvider(rm -> new voiprider());
        //BlockEntityRendererRegistry.register(Chinaqianb.voi_entity,voiEntityRenderer::new);
        //实体渲染器
        EntityRendererRegistry.register(Chinaqianb.BKILL,BkillRender::new);
        //网络发包，为客户端接收数据
        ClientPlayNetworking.registerGlobalReceiver(sendwork.HEART_SNOW_SEND,(client, handler, buf, responseSender)->{
      client.execute(()->{

      });
        });
        //网络发包注册
        sendwork.servertoclient();
    }
}
