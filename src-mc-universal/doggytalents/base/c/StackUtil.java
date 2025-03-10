package doggytalents.base.c;

import doggytalents.base.IStackUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * 1.11.2 Code
 */
public class StackUtil implements IStackUtil {

	@Override
	public boolean isEmpty(ItemStack stack) {
		return stack.isEmpty();
	}
	
	@Override
	public int getCount(ItemStack stack) {
		return stack.getCount();
	}
	
	@Override
	public void setCount(ItemStack stack, int quantity) {
		stack.setCount(quantity);
	}

	@Override
	public void shrink(ItemStack stack, int quantity) {
		stack.shrink(quantity);
	}

	@Override
	public void grow(ItemStack stack, int quantity) {
		stack.grow(quantity);
	}
	
	@Override
	public ItemStack getEmpty() {
		return ItemStack.EMPTY;
	}

	@Override
	public ItemStack readFromNBT(NBTTagCompound tagCompound) {
		return new ItemStack(tagCompound);
	}
}
