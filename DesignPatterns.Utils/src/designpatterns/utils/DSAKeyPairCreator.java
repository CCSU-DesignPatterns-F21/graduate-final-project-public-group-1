package designpatterns.utils;

import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;


public class DSAKeyPairCreator extends KeyPairCreator {

	public DSAKeyPairCreator(int keyLength) throws NoSuchAlgorithmException {
		super(keyLength);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected KeyPairGenerator makeKeyPairGen(int length) throws NoSuchAlgorithmException {

		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
		keyGen.initialize(length);
		return keyGen;

	}

	@Override
	protected String getAlgorithmType() {

		return AlgorithmType.DSA.toString();
	}

}
