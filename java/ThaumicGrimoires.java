package azathoth.thaumcraft.grimoires;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;

@Mod(modid = "ThaumicGrimoires", name = "ThaumicGrimoires", version = "0.0.0")
@NetworkMod(clientSideRequired=true)
public class ThaumicGrimoires {

	@Instance(value = "ThaumicGrimoires")
	public static ThaumicGrimoires instance;

	public static Item grimoireNix;
	public static Item grimoireIgnis;
	public static Item grimoireAqua;
	public static Item grimoireAer;
	public static Item grimoireTerra;

	@SidedProxy(clientSide="azathoth.thaumcraft.grimoires.ClientProxy", serverSide="azathoth.thaumcraft.grimoires.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		grimoireNix = new ItemGrimoire(5000).setUnlocalizedName("grimoreNix");
		grimoireAer = new ItemGrimoire(5001).setGrimoireType((byte) 1).setTextureName("thaumicgrimoires:grimoireAer").setUnlocalizedName("grimoireAer");
		grimoireAqua = new ItemGrimoire(5002).setGrimoireType((byte) 2).setTextureName("thaumicgrimoires:grimoireAqua").setUnlocalizedName("grimoireAqua");
		grimoireIgnis = new ItemGrimoire(5003).setGrimoireType((byte) 3).setTextureName("thaumicgrimoires:grimoireIgnis").setUnlocalizedName("grimoireIgnis");
		grimoireTerra = new ItemGrimoire(5004).setGrimoireType((byte) 4).setTextureName("thaumicgrimoires:grimoireTerra").setUnlocalizedName("grimoireTerra");
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		LanguageRegistry.addName(grimoireNix, "Grimoire Nix");
		LanguageRegistry.addName(grimoireIgnis, "Grimoire Ignis");
		LanguageRegistry.addName(grimoireAqua, "Grimoire Aqua");
		LanguageRegistry.addName(grimoireAer, "Grimoire Aer");
		LanguageRegistry.addName(grimoireTerra, "Grimoire Terra");

		EntityRegistry.registerModEntity(EntityGrimoire.class, "grimoireBase", 2, this, 80, 3, true);
		proxy.registerRenderers();
		//LanguageRegistry.instance().addStringLocalization("entity.instance.grimoireBase.name", "Grimoire Nullos");
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		// stub method
	}


}
