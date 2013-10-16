// package azathoth.thaumcraft.grimoires.client;
package azathoth.thaumcraft.grimoires;

import net.minecraftforge.client.MinecraftForgeClient;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityGrimoire.class, new RenderGrimoire(new ModelGrimoire(), 0.5F));
		EntityRegistry.registerGlobalEntityID(EntityGrimoire.class, "Grimoire", EntityRegistry.findGlobalUniqueEntityId());
//		RenderingRegistry.registerEntityRenderingHandler(EntityGrimoire.class, new RenderGrimoire(new ModelGrimoire(), 0.5F));
//		EntityRegistry.registerGlobalEntityID(EntityGrimoire.class, "Grimoire Nix", EntityRegistry.findGlobalUniqueEntityId());
//
//		RenderingRegistry.registerEntityRenderingHandler(EntityGrimoireIgnis.class, new RenderGrimoire(new ModelGrimoire(), 0.5F));
//		EntityRegistry.registerGlobalEntityID(EntityGrimoireIgnis.class, "Grimoire Ignis", EntityRegistry.findGlobalUniqueEntityId());
//
//		RenderingRegistry.registerEntityRenderingHandler(EntityGrimoireAqua.class, new RenderGrimoire(new ModelGrimoire(), 0.5F));
//		EntityRegistry.registerGlobalEntityID(EntityGrimoireAqua.class, "Grimoire Aqua", EntityRegistry.findGlobalUniqueEntityId());
//
//		RenderingRegistry.registerEntityRenderingHandler(EntityGrimoireAer.class, new RenderGrimoire(new ModelGrimoire(), 0.5F));
//		EntityRegistry.registerGlobalEntityID(EntityGrimoireAer.class, "Grimoire Aer", EntityRegistry.findGlobalUniqueEntityId());
//
//		RenderingRegistry.registerEntityRenderingHandler(EntityGrimoireTerra.class, new RenderGrimoire(new ModelGrimoire(), 0.5F));
//		EntityRegistry.registerGlobalEntityID(EntityGrimoireTerra.class, "Grimoire Terra", EntityRegistry.findGlobalUniqueEntityId());
	}

}
