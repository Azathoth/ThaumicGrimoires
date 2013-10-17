package azathoth.thaumcraft.grimoires;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.Facing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLLog;

public class ItemGrimoire extends Item {

	public ItemGrimoire(int id) {
		super(id);

		maxStackSize = 1;
		setCreativeTab(CreativeTabs.tabMisc);
		setTextureName("thaumicgrimoires:grimoireNix");
	}

	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		if (par3World.isRemote) {
			return true;
		}
		else {
			int i1 = par3World.getBlockId(par4, par5, par6);

			par4 += Facing.offsetsXForSide[par7];
			par5 += Facing.offsetsYForSide[par7];
			par6 += Facing.offsetsZForSide[par7];

			double d0 = 0.0D;

			if (par7 == 1 && Block.blocksList[i1] != null && Block.blocksList[i1].getRenderType() == 11) {
				d0 = 0.5D;
			}

			EntityGrimoire g = spawnGrimoire(par3World, (double) par4 + 0.5D, (double) par5 + d0, (double) par6 + 0.5D);

			if (g != null) {
				g.becomeTame(par2EntityPlayer);
				--par1ItemStack.stackSize;
			}

			return true;
		}
	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		if (par2World.isRemote) {
			return par1ItemStack;
		}
		else {
			MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(par2World, par3EntityPlayer, true);

			if (movingobjectposition == null) {
				return par1ItemStack;
			}
			else {
				if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE) {
					int i = movingobjectposition.blockX;
					int j = movingobjectposition.blockY;
					int k = movingobjectposition.blockZ;

					if (!par2World.canMineBlock(par3EntityPlayer, i, j, k)) {
						return par1ItemStack;
					}
					
					if (!par3EntityPlayer.canPlayerEdit(i, j, k, movingobjectposition.sideHit, par1ItemStack)) {
						return par1ItemStack;
					}

					if (par2World.getBlockMaterial(i, j, k) == Material.water) {
						EntityGrimoire g = spawnGrimoire(par2World, (double) i, (double) j, (double) k);

						if (g != null) {
							g.becomeTame(par3EntityPlayer);
							--par1ItemStack.stackSize;
						}
					}
				}
				return par1ItemStack;
			}
		}
	}

	public EntityGrimoire spawnGrimoire(World par0World, double par2, double par4, double par6) {

		EntityGrimoire entity = new EntityGrimoire(par0World);

		if (entity != null) {
			entity.setLocationAndAngles(par2, par4, par6, MathHelper.wrapAngleTo180_float(par0World.rand.nextFloat() * 360.0F), 0.0F);
			entity.rotationYawHead = entity.rotationYaw;
			entity.renderYawOffset = entity.rotationYaw;
			par0World.spawnEntityInWorld(entity);
			entity.playLivingSound();
		}

		return entity;

	}

}
