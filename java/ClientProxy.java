// package azathoth.thaumcraft.grimoires.client;
package azathoth.thaumcraft.grimoires;

import net.minecraftforge.client.MinecraftForgeClient;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityGrimoire.class, new RenderGrimoire(new ModelGrimoire(), 0.5F));
	}

}
