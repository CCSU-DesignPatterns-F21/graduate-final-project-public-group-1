package designpatterns.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import jakarta.xml.bind.JAXBException;

public class ConfigReaderDecorator<T> implements ConfigReader<T>  {

	protected ConfigReader<T> wrapee;
	
	public ConfigReaderDecorator(ConfigReader<T> wrapee) {
		this.wrapee = wrapee;
	}
	
	
	
	@Override
	public T GetConfig(Class<T> class1) throws JAXBException, URISyntaxException, IOException {
		return wrapee.GetConfig(class1);
	}


	@Override
	public void setConfigData(byte[] data) {
		wrapee.setConfigData(data);
		
	}


	@Override
	public byte[] getConfigData() {
		return wrapee.getConfigData();
	}

}
;