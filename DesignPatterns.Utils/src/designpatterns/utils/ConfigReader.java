package designpatterns.utils;


import java.net.URISyntaxException;
import java.net.URL;

import jakarta.xml.bind.JAXBException;

/**
 * 
 * @author Yassir
 *
 * @param <T>
 */

public interface ConfigReader<T> {

	public T GetConfig(URL location, Class<T> class1) throws JAXBException, URISyntaxException;
}





