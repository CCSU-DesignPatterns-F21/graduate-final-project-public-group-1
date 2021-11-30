## graduate-final-project-public-group-1

To use, clone this repo and include as a package in your own codebase.

# To set up:

Use any custom config XML file that you need to store to read/write to/from, with elements indicating the values being stored. Such as...

AppConfig.xml:
```xml
<appConfig>
	<backgroundColor>Blue</backgroundColor>
	<userStorePath>C:\Users\rbernard\Documents\FinalProj\UserStore</userStorePath>
</appConfig>
```

Have a matching class...

AppConfig.java:

```
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "appConfig")
public class AppConfig {
	private String backgroundColor;
	private String userStorePath; 
	
	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public void setUserStorePath(String userStorePath) {
		this.userStorePath = userStorePath;
	}
	
	public String getUserStorePath() {
		return userStorePath;
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}
}
```
# Example implementation:

In the Main class of your app, set your CacheConfig:
```
//import some members of this package:
import designpatterns.utils.ConfigCache;
import designpatterns.utils.ConfigReader;
import designpatterns.utils.ConfigReaderFactory;
import designpatterns.utils.FileType;

//note that "AppConfig" should be replaced with your class name.
ConfigReaderFactory<AppConfig> appConfigReaderFactory = new ConfigReaderFactory<AppConfig>();
//use resource location of your own .xml file:
URL configLocation = getClass().getResource("/cs/designpatterns/cryptography/resources/AppConfig.xml");
ConfigReader<AppConfig> xmlAppConfigReader = appConfigReaderFactory.createReader(FileType.XML, configLocation);
appConfig = xmlAppConfigReader.GetConfig(AppConfig.class);

//set ConfigCache (this is a singleton):
ConfigCache cache = ConfigCache.getConfigCache();
cache.setConfig(appConfig);
```

elsewhere in your application... get the ConfigCache that you set.
```
ConfigCache cache = ConfigCache.getConfigCache();
AppConfig config = cache.getConfig();
String myImportantPath = config.getUserStorePath();
```

From here you can get or set any of the values within the config cache.
