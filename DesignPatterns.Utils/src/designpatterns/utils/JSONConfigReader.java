package designpatterns.utils;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;




import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import org.eclipse.persistence.jaxb.UnmarshallerProperties;



public class JSONConfigReader<T> implements ConfigReader<T>{

	@Override
	public T GetConfig(URL location, Class<T> clazz) throws JAXBException, URISyntaxException  {
		
		File file = new File(location.toURI());
		
		JAXBContext jaxbContext;
		jaxbContext = JAXBContext.newInstance(clazz);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        //Set JSON type
        jaxbUnmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, "application/json");
        jaxbUnmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT,true);
         
        T config = (T) jaxbUnmarshaller.unmarshal(file);
        
        return config;
         

	}
			
}

