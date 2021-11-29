package designpatterns.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import org.eclipse.persistence.jaxb.UnmarshallerProperties;



public class JSONConfigReader<T> implements ConfigReader<T>{

	private byte[] configData; 
	public  JSONConfigReader(URL location) throws URISyntaxException, IOException {
		
		File file = new File(location.toURI());

		configData = Files.readAllBytes(file.toPath());
	}
	
	
	@Override
	public T GetConfig(Class<T> clazz) throws JAXBException, URISyntaxException, IOException {

		return Unmarshal(configData, clazz);

	}

	private T Unmarshal(byte[] data, Class<T> clazz) throws JAXBException {

		JAXBContext jaxbContext = JAXBContext.newInstance(clazz);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        //Set JSON type
        jaxbUnmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, "application/json");
        jaxbUnmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT,true);
        
		ByteArrayInputStream input = new ByteArrayInputStream(data);
		T config = (T) jaxbUnmarshaller.unmarshal(input);
		return config;

	}


	@Override
	public void setConfigData(byte[] data) {
		configData = data;
		
	}


	@Override
	public byte[] getConfigData() {
		return configData;
	}
			
}

