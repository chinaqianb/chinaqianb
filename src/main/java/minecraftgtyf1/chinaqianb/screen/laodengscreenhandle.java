package minecraftgtyf1.chinaqianb.screen;

import minecraftgtyf1.chinaqianb.Chinaqianb;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class laodengscreenhandle extends ScreenHandler {
    private final Inventory inventory;
    public laodengscreenhandle(int syncId, PlayerInventory playerinventory) {
        this(syncId,playerinventory,new SimpleInventory(2));
    }
    public laodengscreenhandle(int syncId,PlayerInventory playerInventory,Inventory inventory){
        super(Chinaqianb.laodengscreen1,syncId);
        checkSize(inventory,2);
        this.inventory=inventory;
        inventory.onOpen(playerInventory.player);
      this.addSlot(new Slot(inventory,0,80,36));//槽位,1为槽位0，1，2；后面为x，y
        this.addSlot(new Slot(inventory,1,80,72));
        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);


   }
    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    // Shift + 玩家物品栏槽位
    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }
    //玩家物品栏
    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {//修改位置
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 140 + i * 18));
            }
        }
    }
    //玩家快捷栏
    private void addPlayerHotbar(PlayerInventory inventory){//这里也要修改
        for (int i=0;i<9;i++){
            this.addSlot(new Slot(inventory,i,8+i*18,198));
        }
    }
}
