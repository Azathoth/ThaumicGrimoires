package azathoth.thaumcraft.grimoires;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.util.ResourceLocation;

import cpw.mods.fml.common.FMLLog;

@SideOnly(Side.CLIENT)
public class RenderGrimoire extends RenderLiving {

	ResourceLocation none = new ResourceLocation("thaumicgrimoires", "textures/models/GrimoireNix.png");
	ResourceLocation ignis = new ResourceLocation("thaumicgrimoires", "textures/models/GrimoireIgnis.png");
	ResourceLocation aqua = new ResourceLocation("thaumicgrimoires", "textures/models/GrimoireAqua.png");
	ResourceLocation aer = new ResourceLocation("thaumicgrimoires", "textures/models/GrimoireAer.png");
	ResourceLocation terra = new ResourceLocation("thaumicgrimoires", "textures/models/GrimoireTerra.png");

	public RenderGrimoire(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
	}

	public void renderGrimoire(EntityGrimoire par1EntityGrimoire, double par2, double par4, double par6, float par8, float par9) {
		super.doRenderLiving(par1EntityGrimoire, par2, par4, par6, par8, par9);
	}

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
		this.renderGrimoire((EntityGrimoire) par1EntityLiving, par2, par4, par6, par8, par9);
	}

	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
		this.renderGrimoire((EntityGrimoire) par1Entity, par2, par4, par6, par8, par9);
	}

	public ResourceLocation getEntityTexture(Entity entity) {
		switch (((EntityGrimoire) entity).getGrimoireType()) {
			case 1:
				return this.aer;
			case 2:
				return this.aqua;
			case 3:
				return this.ignis;
			case 4:
				return this.terra;
			default:
				return this.none;
		}
	}
}
