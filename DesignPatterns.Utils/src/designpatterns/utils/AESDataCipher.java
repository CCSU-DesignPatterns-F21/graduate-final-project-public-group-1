package designpatterns.utils;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


public class AESDataCipher extends DataCipher {

	@Override
	protected Cipher makeCipher() throws NoSuchAlgorithmException, NoSuchPaddingException {
		return Cipher.getInstance(getAlgorithm());
	}

	@Override
	protected String getAlgorithm() {
		// TODO Auto-generated method stub
		return AlgorithmType.AES.toString();
	}

	@Override
	protected Key getEncryptionKey(byte[] key) throws NoSuchAlgorithmException, InvalidKeySpecException {
		return getSecretKey(key);
	}

	@Override
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
