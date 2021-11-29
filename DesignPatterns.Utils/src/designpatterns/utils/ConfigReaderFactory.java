package designpatterns.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class ConfigReaderFactory<T> {

	public ConfigReader<T> createReader(FileType fileType, URL fileLocation) throws URISyntaxException, IOException {

		if (fileType == FileType.JSON)
			return new JSONConfigReader<T>(fileLocation);

		else if (fileType == FileType.XML)
			return new XMLConfigReader<T>(fileLocation);		

		return null;
	}

	public ConfigReader<T> createSecureReader(FileType fileType, URL fileLocation, byte[] key) throws URISyntaxException, IOException {

		if (fileType == FileType.JSON)
			return new SecureConfigReader<T>(new JSONConfigReader<T>(fileLocation), key);

		else if (fileType == FileType.XML)
			return new SecureConfigReader<T>(new XMLConfigReader<T>(fileLocation), key);

		return null;
	}
}
