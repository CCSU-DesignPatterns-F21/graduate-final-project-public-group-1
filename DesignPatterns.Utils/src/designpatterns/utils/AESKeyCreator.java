package designpatterns.utils;

import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;

public class AESKeyCreator extends KeyCreator {

	public AESKeyCreator(int keyLength) throws NoSuchAlgorithmException {
		super(keyLength);
		// TODO Auto-generated constructor stub
	}

	

	@Override
	protected String getAlgorithmType() { 
		
		return AlgorithmType.AES.toString();
	}

	@Override
	protected KeyGenerator makeKeyGen(int length) throws NoSuchAlgorithmException {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(length);
		return keyGenerator;
	}

}
