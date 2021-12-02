package designpatterns.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

/**
 * 
 * @author Yassir Factory Method Design Pattern
 * abstract factory method to create key pair.  Class allows to create any Asymmetric keyPairGenerator
 *         https://www.novixys.com/blog/how-to-generate-rsa-keys-java/
 *
 */
public abstract class KeyPairCreator {

	private KeyPair keyPair;

	public KeyPairCreator(int keyLength) throws NoSuchAlgorithmException {

		KeyPairGenerator keyPairGen = makeKeyPairGen(keyLength);
		keyPair = keyPairGen.generateKeyPair();
//		

	}

	protected abstract KeyPairGenerator makeKeyPairGen(int length) throws NoSuchAlgorithmException;

	protected abstract String getAlgorithmType();

	public void saveKeyPairToFiles(String pathName, String label) throws IOException {

		String publicFileName = label + "_publicKey" + getAlgorithmType() + ".txt";
		String privateFileName = label + "_privateKey" + getAlgorithmType() + ".txt";

		Base64.Encoder encoder = Base64.getEncoder();

		PublicKey publicKey = keyPair.getPublic();
		PrivateKey privateKey = keyPair.getPrivate();

		// X.509 format. Need this info when encrypting
		writeToFile(pathName + "/" + publicFileName, encoder.encodeToString(publicKey.getEncoded()));
		// PKCS#8 format. Needs this info when decrypting
		writeToFile(pathName + "/" + privateFileName, encoder.encodeToString(privateKey.getEncoded()));

		System.out.println(keyPair.getPublic().getFormat());
		System.out.println(keyPair.getPrivate().getFormat());

	}

	public KeyPair getKeyPair() {

		return keyPair;

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
