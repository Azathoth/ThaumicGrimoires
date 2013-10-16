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
import net.minecraft.world.World;

import cpw.mods.fml.common.FMLLog;


public class EntityGrimoire extends EntityTameable {

	public EnumGrimoire grimoireType = EnumGrimoire.None;

	public EntityGrimoire(World world) {
		super(world);
		FMLLog.info("EntityGrimoire(World)");
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

	public EntityGrimoire(World world, EnumGrimoire grimoireType) {
		super(world);

		this.grimoireType = grimoireType;

		FMLLog.info("Creating EntityGrimoire of type %s", this.grimoireType);

		this.setSize(0.75F, 1F);

		this.getNavigator().setAvoidsWater(this.grimoireType != EnumGrimoire.Aqua);

		this.isImmuneToFire = (this.grimoireType == EnumGrimoire.Ignis);

		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
		this.tasks.addTask(2, new EntityAIWander(this, 0.25F));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(4, new EntityAILookIdle(this));

		this.setTamed(false);

	}

	protected boolean isAIEnabled() {
		return true;
	}

	protected String getLivingSound() {
		return null;
	}

	protected String getHurtSound() {
		return null;
	}

	protected String getDeathSound() {
		return null;
	}

	protected void playStepSound(int par1, int par2, int par3, int par4) {
		// stub method
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(10.0D);
	}

	protected boolean canTriggerWalking() {
		return false;
	}

	protected void fall(float par1) {
		// stub method
	}

	protected void updateFallState(double par1, boolean par3) {
		// stub method
	}

	public boolean doesEntityNotTriggerPressurePlate() {
		return true;
	}

	public boolean isOnLadder() {
		return false;
	}

	public EntityAgeable createChild(EntityAgeable ea1) {
		return null;
	}

	public void onLivingUpdate() {
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

}
