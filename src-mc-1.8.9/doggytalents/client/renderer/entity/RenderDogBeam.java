package doggytalents.client.renderer.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.init.Items;

public class RenderDogBeam extends RenderSnowball {

	public RenderDogBeam(RenderManager renderManagerIn) {
		super(renderManagerIn, Items.snowball, Minecraft.getMinecraft().getRenderItem());
	}

}
