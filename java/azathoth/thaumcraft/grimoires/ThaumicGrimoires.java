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

	private static Item grimoireNix;
	private static Item grimoireIgnis;
	private static Item grimoireAqua;
	private static Item grimoireAer;
	private static Item grimoireTerra;

	@SidedProxy(clientSide="azathoth.thaumcraft.grimoires.ClientProxy", serverSide="azathoth.thaumcraft.grimoires.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		grimoireNix = new ItemGrimoire(5000).setUnlocalizedName("grimoreNix");
		grimoireIgnis = new ItemGrimoireIgnis(5001).setUnlocalizedName("grimoireIgnis");
		grimoireAqua = new ItemGrimoireAqua(5002).setUnlocalizedName("grimoireAqua");
		grimoireAer = new ItemGrimoireAer(5003).setUnlocalizedName("grimoireAer");
		grimoireTerra = new ItemGrimoireTerra(5004).setUnlocalizedName("grimoireTerra");
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		LanguageRegistry.addName(grimoireNix, "Grimoire Nix");
		LanguageRegistry.addName(grimoireIgnis, "Grimoire Ignis");
		LanguageRegistry.addName(grimoireAqua, "Grimoire Aqua");
		LanguageRegistry.addName(grimoireAer, "Grimoire Aer");
		LanguageRegistry.addName(grimoireTerra, "Grimoire Terra");

		//EntityRegistry.registerModEntity(EntityGrimoire.class, "grimoireBase", 2, this, 80, 3, true);
		proxy.registerRenderers();
		//LanguageRegistry.instance().addStringLocalization("entity.instance.grimoireBase.name", "Grimoire Nullos");
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		// stub method
	}


}
