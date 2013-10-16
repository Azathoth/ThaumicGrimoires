package azathoth.thaumcraft.grimoires;

import net.minecraft.world.World;

public class EntityGrimoireIgnis extends EntityGrimoire {

	public EntityGrimoireIgnis(World world) {
		super(world, EnumGrimoire.Ignis);

		this.isImmuneToFire = true;
	}

}
