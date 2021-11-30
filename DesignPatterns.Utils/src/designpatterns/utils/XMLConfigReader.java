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

public class XMLConfigReader<T> implements ConfigReader<T> {

	private byte[] data; 
	
	public  XMLConfigReader(URL location) throws URISyntaxException, IOException {
		
		File file = new File(location.toURI());

		data = Files.readAllBytes(file.toPath());
	}
	public  XMLConfigReader(byte[] configData) {
			this.data = configData;
	}

	@Override
	public T GetConfig(Class<T> clazz) throws JAXBException, URISyntaxException, IOException {

		return Unmarshal(data, clazz);

	}

	private T Unmarshal(byte[] data, Class<T> clazz) throws JAXBException {

		JAXBContext jaxbContext = JAXBContext.newInstance(clazz);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		ByteArrayInputStream input = new ByteArrayInputStream(data);
		T config = (T) jaxbUnmarshaller.unmarshal(input);
		return config;

	}
	@Override
	public void setConfigData(byte[] data) {
		this.data = data;
		
	}
	@Override
	public byte[] getConfigData() {
		return data;
	}

}
