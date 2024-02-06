package minecraftgtyf1.chinaqianb.blockentity;

import minecraftgtyf1.chinaqianb.Chinaqianb;
import minecraftgtyf1.chinaqianb.ImplementedInventory;
import minecraftgtyf1.chinaqianb.screen.laodengscreenhandle;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class laodengep extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {//方块实体
    private final DefaultedList<ItemStack> inventory =DefaultedList.ofSize(2,ItemStack.EMPTY);
    public laodengep(BlockPos pos, BlockState state){
        super(Chinaqianb.laodengepa,pos,state);
    }
    @Override
    public void writeNbt(NbtCompound nbt){//nbt标签写入数据
        //nbt.putInt();//数据
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt,this.inventory);

    }

    @Override
    public void readNbt(NbtCompound nbt){//读取nbt数据
        super.readNbt(nbt);
        Inventories.readNbt(nbt,this.inventory);
    }
    //服务器发送数据给客户端
    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }
    @Override
    public DefaultedList<ItemStack> getItems(){
        return inventory;
    }
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new laodengscreenhandle(syncId,playerInventory,this);
    }
    @Override
    public Text getDisplayName(){
        return Text.translatable(getCachedState().getBlock().getTranslationKey());
    }

}
