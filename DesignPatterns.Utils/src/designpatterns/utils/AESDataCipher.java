package designpatterns.utils;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES implementation of DataCipher, allows encryption and decryption using AES algorithm
 * @author Yassir
 *
 */
public class AESDataCipher extends DataCipher {

	@Override
	/**
	 * Factory method to generate an instance of AES Cipher
	 */
	protected Cipher makeCipher() throws NoSuchAlgorithmException, NoSuchPaddingException {
		return Cipher.getInstance(getAlgorithm());
	}

	/**
	 * Method that returns name of Algorithm
	 */
	@Override
	protected String getAlgorithm() {
		// TODO Auto-generated method stub
		return AlgorithmType.AES.toString();
	}

	@Override
	/**
	 * Method returns encryption key
	 */
	protected Key getEncryptionKey(byte[] key) throws NoSuchAlgorithmException, InvalidKeySpecException {
		return getSecretKey(key);
	}

	@Override
	/**
	 * Method returns decryption key
	 */
	protected Key getDecryptionKey(byte[] key) throws NoSuchAlgorithmException, InvalidKeySpecException {
		return getSecretKey(key);
	}
	
	private SecretKey getSecretKey(byte[] key)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		byte[] decodedKey = Base64.getDecoder().decode(key);
		SecretKey secretKey = new SecretKeySpec(decodedKey,getAlgorithm());
		return secretKey;

	}

	

}
