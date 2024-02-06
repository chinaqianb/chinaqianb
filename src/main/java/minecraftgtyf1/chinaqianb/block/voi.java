package minecraftgtyf1.chinaqianb.block;

import minecraftgtyf1.chinaqianb.blockentity.laodengep;
import minecraftgtyf1.chinaqianb.blockentity.voientity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.apache.commons.compress.compressors.lz77support.LZ77Compressor;

import java.util.List;

public class voi extends BlockWithEntity implements BlockEntityProvider {
    public voi(Settings settings){
        super(settings);;
    }
    @Override
    public void appendTooltip(ItemStack itemStack, BlockView world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(Text.translatable("item.chinaqianb.voi.jie"));
    }
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new voientity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
