package designpatterns.utils;

import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;


public class RSAKeyPairCreator extends KeyPairCreator {

	public RSAKeyPairCreator(int keyLength) throws NoSuchAlgorithmException {
		super(keyLength);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected KeyPairGenerator makeKeyPairGen(int length) throws NoSuchAlgorithmException {

		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
		keyGen.initialize(length);
		return keyGen;
	}

	@Override
	protected String getAlgorithmType() {

		return AlgorithmType.RSA.toString();
	}

}
