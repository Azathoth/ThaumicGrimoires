package azathoth.thaumcraft.grimoires;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemGrimoireIgnis extends ItemGrimoire {

	public ItemGrimoireIgnis(int id) {
		super(id);

//		maxStackSize = 1;
//		setCreativeTab(CreativeTabs.tabMisc);
		setTextureName("thaumicgrimoires:grimoireIgnis");
	}

	@Override
	public EntityGrimoire spawnGrimoire(World par0World, double par2, double par4, double par6) {
		EntityGrimoire entity = new EntityGrimoire(par0World, EnumGrimoire.Ignis);

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
