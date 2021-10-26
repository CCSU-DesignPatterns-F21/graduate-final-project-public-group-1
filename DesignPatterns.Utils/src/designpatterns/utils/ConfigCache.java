package designpatterns.utils;


public class ConfigCache {

	private static ConfigCache instance;
	
	private ConfigCache() {
		
	}
	
	private Object config;
	
	
	public static  ConfigCache getConfigCache() {
		
		if(instance == null)
			instance = new ConfigCache();
		
		return instance;
	}
	
	public <T> void setConfig(T config) {
		
		this.config = config;
		
	}
	
	public <T> T getConfig() {
		
		return (T) config;
		
	}
	
	
}
