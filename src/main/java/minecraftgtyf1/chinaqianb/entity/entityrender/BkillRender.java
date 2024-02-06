package minecraftgtyf1.chinaqianb.entity.entityrender;

import minecraftgtyf1.chinaqianb.entity.Bkill;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class BkillRender extends MobEntityRenderer<Bkill,BkillModel> {
    public BkillRender(EntityRendererFactory.Context context){//问题，把这个改为这个
        super(context,new BkillModel(),0.5f);
    }

    @Override
    public Identifier getTexture(Bkill entity) {
        return new Identifier("chinaqianb","textures/entity/bkill/bkill.png");
    }


}
