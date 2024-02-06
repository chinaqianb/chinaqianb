package minecraftgtyf1.chinaqianb.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class s686 extends Item {

    public s686(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!world.isClient()) {
            String x = String.valueOf(Math.floor(user.getPos().getX()));
            String y = String.valueOf(Math.floor(user.getPos().getY()));
            String z = String.valueOf(Math.floor(user.getPos().getZ()));

            user.sendMessage(Text.translatable("item.s686.xyz").append(Text.literal("x:" + x + "y:" + y + "z:" + z)));
        }
        return super.use(world, user, hand);

    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.s686.tooltip").append(Text.literal("s686").formatted(Formatting.BLUE)));
    }
}
