package designpatterns.utils;


import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import jakarta.xml.bind.JAXBException;

/**
 * 
 * @author Yassir
 * ConfigReader interface 
 * @param <T>
 */

public interface ConfigReader<T> {

	public T GetConfig(Class<T> class1) throws JAXBException, URISyntaxException, IOException;
	public void setConfigData(byte[] data);
	public byte[]  getConfigData();
	

}





