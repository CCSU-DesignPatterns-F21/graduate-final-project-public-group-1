package designpatterns.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 * 
 * @author Yassir Factory Method Design Pattern
 *         https://www.novixys.com/blog/how-to-generate-rsa-keys-java/
 *
 */
public abstract class KeyCreator {

	private SecretKey secretKey;

	public KeyCreator(int keyLength) throws NoSuchAlgorithmException {

		KeyGenerator keyGen = makeKeyGen(keyLength);
		secretKey = keyGen.generateKey();
//		

	}

	protected abstract KeyGenerator makeKeyGen(int length) throws NoSuchAlgorithmException;

	protected abstract String getAlgorithmType();

	public void saveKeyToFile(String pathName, String label) throws IOException {

		String keyFileName = label + "_secretKey" + getAlgorithmType() + ".txt";
		Base64.Encoder encoder = Base64.getEncoder();

		writeToFile(pathName + "/" + keyFileName, encoder.encodeToString(secretKey.getEncoded()));

	}

	public SecretKey getSecretKey() {

		return secretKey;

	}

	private void writeToFile(String pathName, String key) throws IOException {
		File f = new File(pathName);
		f.getParentFile().mkdirs();

		FileWriter fos = new FileWriter(f);
		fos.write(key);
		fos.flush();
		fos.close();
	}

}
