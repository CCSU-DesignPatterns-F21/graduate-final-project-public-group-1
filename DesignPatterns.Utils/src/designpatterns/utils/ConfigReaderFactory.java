package designpatterns.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public interface ConfigReaderFactory<T> {

	public ConfigReader<T> createReader(FileType fileType, URL fileLocation) throws URISyntaxException, IOException;
}
