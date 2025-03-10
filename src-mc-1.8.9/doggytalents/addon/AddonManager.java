package doggytalents.addon;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.eventhandler.EventBus;

/**
 * @author ProPercivalalb
 */
public class AddonManager {

	private static final EventBus EVENT_BUS	= new EventBus();
	
	public static void registerAddons() {

	}

	public static void runRegisteredAddons(Configuration config) {
		EVENT_BUS.post(new AddonEvent.Pre(config));
		EVENT_BUS.post(new AddonEvent.Init(config));
		EVENT_BUS.post(new AddonEvent.Post(config));
	}
	
	public static boolean areModsLoaded(String... modIds) {
		for(String modId : modIds)
			if(!Loader.isModLoaded(modId))
				return false;
		return true;
	}
}
