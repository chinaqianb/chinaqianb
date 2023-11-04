package minecraftgtyf1.chinaqianb.client;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.apache.commons.compress.compressors.lz77support.LZ77Compressor;

public class laodeng extends Block {
    public laodeng(Settings settings){
        super(settings);
    }
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit){
        if (!world.isClient){
            player.sendMessage(Text.translatable("chinaqianb_laodeng_use").formatted(Formatting.BLUE),false);
        }
        return ActionResult.SUCCESS;
    }
}
