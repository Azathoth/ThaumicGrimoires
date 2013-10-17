package azathoth.thaumcraft.grimoires;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import cpw.mods.fml.common.FMLLog;


public class EntityGrimoire extends EntityTameable {

	public EntityGrimoire(World world) {
		super(world);
		this.setSize(0.75F, 1F);
		this.getNavigator().setAvoidsWater(true);
		this.isImmuneToFire = false;
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
		this.tasks.addTask(2, new EntityAIWander(this, 0.25F));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(4, new EntityAILookIdle(this));
		this.setTamed(false);
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		this.getDataWatcher().addObject(18, Byte.valueOf((byte) 0));
	}

	public byte getGrimoireType() {
		return this.getDataWatcher().getWatchableObjectByte(18);
	}

	public void setGrimoireType(byte type) {
		this.getDataWatcher().updateObject(18, Byte.valueOf(type));
		this.updateGrimoireCapabilities();
	}

	private void updateGrimoireCapabilities() {
		switch(this.getGrimoireType()) {
			case 2:
				this.getNavigator().setAvoidsWater(false);
				break;
			case 3:
				this.isImmuneToFire = true;
				break;
			default:
		}
	}

	@Override
	protected boolean isAIEnabled() {
		return true;
	}

	@Override
	protected String getLivingSound() {
		return null;
	}

	@Override
	protected String getHurtSound() {
		return null;
	}

	@Override
	protected String getDeathSound() {
		return null;
	}

	@Override
	protected void playStepSound(int par1, int par2, int par3, int par4) {
		// stub method
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.8F);
	}

	@Override
	protected boolean canTriggerWalking() {
		return false;
	}

	@Override
	protected void fall(float par1) {
		// stub method
	}

	@Override
	protected void updateFallState(double par1, boolean par3) {
		// stub method
	}

	@Override
	public boolean doesEntityNotTriggerPressurePlate() {
		return true;
	}

	@Override
	public boolean isOnLadder() {
		return false;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable ea1) {
		return null;
	}

	@Override
	public void onLivingUpdate() {
		if (this.isWet() && (this.getGrimoireType() != (byte) 2))
			this.attackEntityFrom(DamageSource.drown, 1.0F);
		super.onLivingUpdate();
	}

	public void becomeTame(EntityPlayer p) {
		if (!this.worldObj.isRemote) {
			this.setTamed(true);
			this.setOwner(p.getCommandSenderName());
			this.playTameEffect(true);
			this.worldObj.setEntityState(this, (byte) 7);
		}
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setByte("GrimoireType", this.getGrimoireType());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readEntityFromNBT(par1NBTTagCompound);
		this.setGrimoireType(par1NBTTagCompound.getByte("GrimoireType"));
	}

}
