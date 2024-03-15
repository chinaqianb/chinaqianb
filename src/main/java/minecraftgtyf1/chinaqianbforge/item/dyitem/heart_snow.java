package minecraftgtyf1.chinaqianbforge.item.dyitem;

import com.mojang.logging.LogUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import java.util.List;

public class heart_snow extends Item {
    public heart_snow(Properties p_41383_) {
        super(p_41383_);
    }
    private static final Logger LOGGER = LogUtils.getLogger();
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> appo, TooltipFlag tooltipFlag) {
        appo.add(Component.translatable("item.heart_snow_js"));
        super.appendHoverText(stack, world, appo, tooltipFlag);
    }


}
