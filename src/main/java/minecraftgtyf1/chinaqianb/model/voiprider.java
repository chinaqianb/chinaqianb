package minecraftgtyf1.chinaqianb.model;

import net.fabricmc.fabric.api.client.model.ModelProviderContext;
import net.fabricmc.fabric.api.client.model.ModelProviderException;
import net.fabricmc.fabric.api.client.model.ModelResourceProvider;
import net.minecraft.client.render.model.UnbakedModel;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public class voiprider implements ModelResourceProvider {
    public static final voimodel model =new voimodel();
    public static final Identifier VOI_MODEL =new Identifier("chinaqianb:block/voi");
    public static final Identifier VOI_ITEM_MODEL=new Identifier("chinaqianb:item/voi");
    @Override
    public @Nullable UnbakedModel loadModelResource(Identifier resourceId, ModelProviderContext context) throws ModelProviderException {
        if(resourceId.equals(VOI_MODEL)||resourceId.equals(VOI_ITEM_MODEL)) {
            return model;
        } else {
            return null;
        }
    }
}
