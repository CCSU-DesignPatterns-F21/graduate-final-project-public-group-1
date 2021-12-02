package designpatterns.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * 
 * @author Yassir
 *
 *Concrete factory to create secure configReader instance.  support XML and JSON
 * @param <T>
 */
public class SecureAppConfigReaderFactory<T> implements ConfigReaderFactory<T> {
	
	private byte[] key;
	
	public SecureAppConfigReaderFactory(byte[] key) {
		
		this.key = key;
	}
	
	public ConfigReader<T> createReader(FileType fileType, URL fileLocation) throws URISyntaxException, IOException {

		if (fileType == FileType.JSON)
			return new SecureConfigReader<T>(new JSONConfigReader<T>(fileLocation), key);

		else if (fileType == FileType.XML)
			return new SecureConfigReader<T>(new XMLConfigReader<T>(fileLocation), key);

		return null;
	}

	
}
