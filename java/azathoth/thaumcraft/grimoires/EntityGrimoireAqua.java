package azathoth.thaumcraft.grimoires;

import net.minecraft.world.World;

public class EntityGrimoireAqua extends EntityGrimoire {

	public EntityGrimoireAqua(World world) {
		super(world, EnumGrimoire.Aqua);
		this.getNavigator().setAvoidsWater(false);
	}

}
