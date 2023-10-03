package com.example.demoCommunicateAPI;

import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;

import javax.crypto.Cipher;

public class RSAUtil {

	public void genRSAKey() {
		/* 生成公私鑰 */
		KeyPairGenerator keyPairGenerator = null;
		try {
			keyPairGenerator = KeyPairGenerator.getInstance("RSA"); // NoSuchAlgorithmException
		} catch (Exception e) {
			e.printStackTrace();
		}
		keyPairGenerator.initialize(2048);
		// 此處可以新增引數new SecureRandom(UUID.randomUUID().toString().getBytes())
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
		RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
		System.out.println(rsaPrivateKey.getEncoded());
		System.out.println(rsaPublicKey.getEncoded());
		System.out.println(rsaPrivateKey.getModulus().bitLength() / 8);
		System.out.println(rsaPublicKey.getModulus().bitLength() / 8);

		String secretMessage = "secret message";
		System.out.println(secretMessage);

		/* 加密 */
		try {
			Cipher encryptCipher = Cipher.getInstance("RSA");
			encryptCipher.init(Cipher.ENCRYPT_MODE, rsaPublicKey);
			byte[] secretMessageBytes = secretMessage.getBytes(StandardCharsets.UTF_8);
			byte[] encryptedMessageBytes = encryptCipher.doFinal(secretMessageBytes);
			String encodedMessage = Base64.getEncoder().encodeToString(encryptedMessageBytes);
			System.out.println(encodedMessage);

			Cipher decryptCipher = Cipher.getInstance("RSA");
			decryptCipher.init(Cipher.DECRYPT_MODE, rsaPrivateKey);
			byte[] decryptedMessageBytes = decryptCipher.doFinal(encryptedMessageBytes);
			String decryptedMessage = new String(decryptedMessageBytes, StandardCharsets.UTF_8);
			System.out.println(decryptedMessage);
		} catch (GeneralSecurityException e) {
			throw new IllegalStateException("Could not retrieve AES cipher", e);
		}

	}

}
