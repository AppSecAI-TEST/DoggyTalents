package doggytalents.lib;

import doggytalents.helper.ReflectionUtil;

/**
 * @author ProPercivalalb
 */
public class Reference {

	//Mod Related Constants 
	public static final String 		 MOD_ID 	      = "doggytalents";
	public static final String		 MOD_NAME         = "Doggy Talents";
	public static final String 		 MOD_VERSION      = "${MOD_VERSION}";
	public static final String 		 DEPENDENCIES     = "${DEPENDENCIES}"; //TODO required-after:forge@[14.21.1.2387,)
	public static final String 		 CLIENT_PROXY 	  = "doggytalents.proxy.ClientProxy";
	public static final String 		 SERVER_PROXY     = "doggytalents.proxy.CommonProxy";
	public static final String 		 UPDATE_URL 	  = "https://raw.githubusercontent.com/ProPercivalalb/DoggyTalents/master/version.json";
	public static final String       CHANNEL_NAME     = "DOGGY";
	public static final String       GUI_FACTORY      = "${GUI_FACTORY}";//doggytalents.base.d.GuiFactory
	
	public static final boolean		 DEBUG 			  = false;
	
	public static boolean IS_DEV_ENVIR = false;
	
	static {
		if(ReflectionUtil.getClass("doggytalents.base.c.RegistrySubscriber") != null && ReflectionUtil.getClass("doggytalents.base.b.RegistrySubscriber") != null)
			IS_DEV_ENVIR = true;
		
	}
}
