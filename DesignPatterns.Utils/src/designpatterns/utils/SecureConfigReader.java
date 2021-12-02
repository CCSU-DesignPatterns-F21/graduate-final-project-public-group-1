package designpatterns.utils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import jakarta.xml.bind.JAXBException;

/**
 * Concrete Secure configReader that decrypts settings file before binding it to a class
 * @author Yassir
 *
 * @param <T>
 */
public class SecureConfigReader<T> extends ConfigReaderDecorator<T> {

	private DataCipher dataCipher;
	private byte[] key;

	public SecureConfigReader(ConfigReader<T> wrapee, byte[] key) {
		super(wrapee);
		dataCipher = new AESDataCipher();
		this.key = key;

	}

	@Override
	public T GetConfig(Class<T> class1) throws JAXBException, URISyntaxException, IOException {
		decryptData(wrapee.getConfigData());
		return wrapee.GetConfig(class1);
	}

	private void decryptData(byte[] data) {

		String configData = new String(data);
		String decrypredData;

		try {
			decrypredData = dataCipher.decryptMessage(configData, key);
			wrapee.setConfigData(decrypredData.getBytes());
		} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException | NoSuchAlgorithmException
				| NoSuchPaddingException | InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
