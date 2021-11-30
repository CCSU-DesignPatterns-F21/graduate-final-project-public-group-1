package designpatterns.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;



public abstract class DataCipher {

	
	protected abstract Cipher getCipher() throws NoSuchAlgorithmException, NoSuchPaddingException;
	
	protected abstract String getAlgorithm() ;
	
	protected abstract Key getEncryptionKey(byte[] key) throws NoSuchAlgorithmException, InvalidKeySpecException ;
	
	protected abstract Key getDecryptionKey(byte[] key) throws NoSuchAlgorithmException, InvalidKeySpecException;

	public String encryptMessage(String data, byte[] key)
			throws InvalidKeyException, IllegalBlockSizeException, 
				BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, IOException {
		
		Cipher cipher = getCipher();
		Base64.Encoder encoder = Base64.getEncoder();
		Key publicKey = getEncryptionKey(key);
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		return new String(encoder.encode(cipher.doFinal(data.getBytes())));
	}

	public String decryptMessage(String data, byte[] key)
			throws InvalidKeyException, IllegalBlockSizeException, 
				BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException {

		Cipher cipher = getCipher();
		Key privateKey = getDecryptionKey(key);
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		Base64.Decoder decoder = Base64.getDecoder();
		byte[] decodedData = decoder.decode(data.getBytes());
		return new String(cipher.doFinal(decodedData));
	}

	
}
