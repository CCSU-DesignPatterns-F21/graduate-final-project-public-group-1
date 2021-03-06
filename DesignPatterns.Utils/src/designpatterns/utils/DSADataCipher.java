package designpatterns.utils;

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
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/**
 * concrete DSA DataCipher that create an instance of DSA Cipher to be used for encryption/decryption
 * @author Yassir
 *
 */
public class DSADataCipher extends DataCipher {

	@Override
	protected Cipher makeCipher() throws NoSuchAlgorithmException, NoSuchPaddingException {
		return Cipher.getInstance(getAlgorithm());
	}

	@Override
	protected String getAlgorithm() {
		// TODO Auto-generated method stub
		return AlgorithmType.DSA.toString();
	}

	@Override
	protected Key getEncryptionKey(byte[] key) throws NoSuchAlgorithmException, InvalidKeySpecException {
		Base64.Decoder decoder = Base64.getDecoder();
		EncodedKeySpec spec = new X509EncodedKeySpec(decoder.decode(key));
		KeyFactory kf = KeyFactory.getInstance(getAlgorithm());
		return kf.generatePublic(spec);
	}

	@Override
	protected Key getDecryptionKey(byte[] key) throws NoSuchAlgorithmException, InvalidKeySpecException {
		Base64.Decoder decoder = Base64.getDecoder();
		EncodedKeySpec spec = new PKCS8EncodedKeySpec(decoder.decode(key));
		KeyFactory kf = KeyFactory.getInstance(getAlgorithm());
		return kf.generatePrivate(spec);
	}

}
