package doggytalents.entity;

import net.minecraft.nbt.NBTTagCompound;

/**
 * @author ProPercivalalb
 **/
public class ModeUtil {

	public EntityDog dog;
	
	public ModeUtil(EntityDog dog) {
		this.dog = dog;
	}
	
	public EnumMode getMode() {
		return EnumMode.values()[this.getModeID()];
	}
	
	public EnumMode getMode(int index) {
		return EnumMode.values()[index];
	}
	
	public static int getId(EnumMode mode) {
		return mode.ordinal();
	}
	
	public boolean isMode(EnumMode mode) {
		return this.getMode() == mode;
	}

	public void setMode(EnumMode mode) {	
		this.setMode(this.getId(mode));
	}
	
	public void setMode(int mode) {	
		this.dog.getDataWatcher().updateObject(27, mode);
	}
	
	protected int getModeID() {
		return this.dog.getDataWatcher().getWatchableObjectInt(27);
	}
	
	public void writeToNBT(NBTTagCompound tagCompound) {
		tagCompound.setInteger("mode", this.getModeID());
	}
	
	public void readFromNBT(NBTTagCompound tagCompound) {
		this.setMode(tagCompound.getInteger("mode"));
	}
	
	public enum EnumMode {

		DOCILE("Docile", "(D)"),
		WANDERING("Wandering", "(W)", false),
		AGGRESIVE("Aggresive", "(A)"),
		BERSERKER("Berserker", "(B)"),
		TACTICAL("Tactical", "(T)");
		
		private String tip;
		private String name;
		/** By default it is true */
		public boolean followsOwner;
		
		private EnumMode(String name, String tip) {
			this(name, tip, true);
		}
		
		private EnumMode(String name, String tip, boolean followsOwner) {
			this.name = name;
			this.tip = tip;
			this.followsOwner = followsOwner;
		}
		
		public String getTip() {
			return tip;
		}
		
		public String modeName() {
			return name;
		}
		
		public boolean doesFollowOwner() {
			return this.followsOwner;
		}
	}
}
