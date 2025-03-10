package doggytalents.helper;

import doggytalents.ModItems;
import doggytalents.base.ObjectLib;
import doggytalents.entity.EntityDog;
import net.minecraft.entity.Entity;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class DogUtil {

	public static void teleportDogToOwner(Entity owner, Entity entity, World world, PathNavigate pathfinder) {
    	int i = MathHelper.floor(owner.posX) - 2;
        int j = MathHelper.floor(owner.posZ) - 2;
        int k = MathHelper.floor(owner.getEntityBoundingBox().minY);

        for(int l = 0; l <= 4; ++l) {
            for(int i1 = 0; i1 <= 4; ++i1) {
                if((l < 1 || i1 < 1 || l > 3 || i1 > 3) && ObjectLib.METHODS.isTeleportFriendlyBlock(entity, world, i, j, k, l, i1)) {
                	entity.setLocationAndAngles((double)((float)(i + l) + 0.5F), (double)k, (double)((float)(j + i1) + 0.5F), entity.rotationYaw, entity.rotationPitch);
                    pathfinder.clearPathEntity();
                    return;
                }
            }
        }
    }
    
    public static ItemStack feedDog(EntityDog dog, IInventory inventory, int slotIndex) {
        if(!ObjectLib.STACK_UTIL.isEmpty(inventory.getStackInSlot(slotIndex))) {
            ItemStack itemstack = inventory.getStackInSlot(slotIndex);
            dog.setDogHunger(dog.getDogHunger() + dog.foodValue(itemstack));
            
            if(itemstack.getItem() == ModItems.CHEW_STICK) {
            	dog.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 100, 1, false, true));
            	dog.addPotionEffect(new PotionEffect(MobEffects.SPEED, 200, 6, false, true));
            	dog.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 100, 2, false, true));
            }

            if(ObjectLib.STACK_UTIL.getCount(inventory.getStackInSlot(slotIndex)) <= 1) {
                ItemStack itemstack1 = inventory.getStackInSlot(slotIndex);
                inventory.setInventorySlotContents(slotIndex, ObjectLib.STACK_UTIL.getEmpty());
                return itemstack1;
            }

            ItemStack itemstack2 = inventory.getStackInSlot(slotIndex).splitStack(1);

            if(ObjectLib.STACK_UTIL.isEmpty(inventory.getStackInSlot(slotIndex)))
            	inventory.setInventorySlotContents(slotIndex, ObjectLib.STACK_UTIL.getEmpty());
            else
            	inventory.markDirty();

            return itemstack2;
        }
        else
            return ObjectLib.STACK_UTIL.getEmpty();
    }
    
    public static boolean doesInventoryContainFood(EntityDog dog, IInventory inventory) {
        for(int i = 0; i < inventory.getSizeInventory(); i++) {
            if(dog.foodValue(inventory.getStackInSlot(i)) > 0)
            	return true;
        }

        return false;
    }
    
    public static int getFirstSlotWithFood(EntityDog dog, IInventory inventory) {
    	 for(int i = 0; i < inventory.getSizeInventory(); i++) {
             if(dog.foodValue(inventory.getStackInSlot(i)) > 0)
             	return i;
         }

        return -1;
    }
}
