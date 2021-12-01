package designpatterns.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class AppConfigReaderFactory<T> implements ConfigReaderFactory<T>{

	public ConfigReader<T> createReader(FileType fileType, URL fileLocation) throws URISyntaxException, IOException {

		if (fileType == FileType.JSON)
			return new JSONConfigReader<T>(fileLocation);

		else if (fileType == FileType.XML)
			return new XMLConfigReader<T>(fileLocation);		

		return null;
	}


}
