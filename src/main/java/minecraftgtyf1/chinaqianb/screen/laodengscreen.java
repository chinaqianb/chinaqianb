package minecraftgtyf1.chinaqianb.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class laodengscreen extends HandledScreen<ScreenHandler> {
    //纹理
    private static final Identifier Text =new Identifier("chinaqianb","textures/gui/laodeng.png");
    public laodengscreen(ScreenHandler handler, PlayerInventory inventory, Text title){
        super(handler,inventory,title);
        this.backgroundHeight=221;//图片大小
        this.backgroundWidth=175;
    }
    @Override
    protected void drawBackground(DrawContext matrices,float delta,int mouseX,int mouseY){
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, Text);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
         matrices.drawTexture(Text,x,y,0,0,backgroundWidth,backgroundHeight);
         //renderarrow进度条方法
    }
    @Override
    public void render(DrawContext matrices,int mouseX,int mouseY,float delta){
        renderBackground(matrices);
        super.render(matrices,mouseX,mouseY,delta);
        drawMouseoverTooltip(matrices,mouseX,mouseY);

    }
    @Override
    protected void init(){
        super.init();
        titleX=7;
        titleY=4;//这里也要改哦！
        playerInventoryTitleX=7;
        playerInventoryTitleY=126;
    }
    /*private void renderarrow(DrawContext context,int x,int y){//进度条
        if (handler.isCarfting()){//是否处于合成
            context.drawTexture(Text,x+100,y+12,176,0,8,handler.getScaledProgress());//进度条位置更换
        }
    }*/
}
