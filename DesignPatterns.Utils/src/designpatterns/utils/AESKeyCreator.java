package designpatterns.utils;

import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;

/**
 * 
 * @author Yassir
 * Implementation of Key Creator, Class generate an AES secret key and provides interface to save 
 * key to file 
 *
 */
public class AESKeyCreator extends KeyCreator {

	public AESKeyCreator(int keyLength) throws NoSuchAlgorithmException {
		super(keyLength);
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * Method returns Algorithm Type as string
	 */
	@Override
	protected String getAlgorithmType() { 
		
		return AlgorithmType.AES.toString();
	}

	@Override
	/**
	 * Factory method to create AES keyGenerator 
	 */
	protected KeyGenerator makeKeyGen(int length) throws NoSuchAlgorithmException {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(length);
		return keyGenerator;
	}

}
