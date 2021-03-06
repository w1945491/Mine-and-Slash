package com.robertx22.items.bags;

import javax.annotation.Nonnull;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;

public abstract class BaseInventory implements IItemHandlerModifiable {

    public final IItemHandlerModifiable bagInv;
    final public ItemStack bag;

    public BaseInventory(ItemStack bag) {
	this.bag = bag;
	bagInv = (IItemHandlerModifiable) bag.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
    }

    @Override
    public void setStackInSlot(int slot, @Nonnull ItemStack stack) {
	bagInv.setStackInSlot(slot, stack);
    }

    @Override
    public int getSlots() {
	return bagInv.getSlots();
    }

    @Nonnull
    @Override
    public ItemStack getStackInSlot(int slot) {
	return bagInv.getStackInSlot(slot);
    }

    @Nonnull
    @Override
    public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
	return bagInv.insertItem(slot, stack, simulate);
    }

    @Nonnull
    @Override
    public ItemStack extractItem(int slot, int amount, boolean simulate) {
	return bagInv.extractItem(slot, amount, simulate);
    }

    @Override
    public int getSlotLimit(int slot) {
	return bagInv.getSlotLimit(slot);
    }
}