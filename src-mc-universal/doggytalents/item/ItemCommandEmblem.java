package doggytalents.item;

import doggytalents.entity.EntityDoggyBeam;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

/**
 * @author ProPercivalalb
 **/
public class ItemCommandEmblem extends ItemDT {
	
	public ItemCommandEmblem() {
		super();
	}
	
	public ActionResult<ItemStack> onItemRightClickGENERAL(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		if(!worldIn.isRemote) {
			EntityDoggyBeam doggyBeam = new EntityDoggyBeam(worldIn, playerIn);
            doggyBeam.setHeadingFromThrower(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 2.5F, 1.0F);
            worldIn.spawnEntity(doggyBeam);
		}
		
		playerIn.addStat(StatList.getObjectUseStats(this));
	    return new ActionResult(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
    }
}
