package com.company.RSA_server_client;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * RSA (Rivest–Shamir–Adleman) Algorithm Cryptography
 *
 * It is a public-private key cryptology that is one of the oldest and widely used system to secure data transmission.
 * In a public-key cryptology, the encryption key is public and distinct from the decryption key, which is kept secret (private).
 * Messages can be encrypted by anyone, via the public key, but can only be decoded by someone who knows the prime
 * numbers also called as private key.
 * RSA is a relatively slow algorithm. Because of this, it is not commonly used to directly encrypt user data.
 *
 * @Author Anastasiia Ponkratova and Julia Migiel
 * Source: https://github.com/only2dhir/rsaencryption
 */

public class RSA {
	private PrivateKey privateKey;
	private PublicKey publicKey;
	private String Encodedpublickey;
	private String Encodedprivatekey;

	/**
	 * Constructor generating private key and public key and separate them
	 * @return parameter that returns the public key needed for encryption
	 * @throws NoSuchAlgorithmException
	 */
	public void Keygenerate() {
		try {
			//Generuje klucz
			KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA");
			keygen.initialize(2048);
			KeyPair pair = keygen.generateKeyPair();
		    this.privateKey = pair.getPrivate();
		    this.publicKey = pair.getPublic();
		    Encodedpublickey = Base64.getEncoder().encodeToString(publicKey.getEncoded());
	        Encodedprivatekey = Base64.getEncoder().encodeToString(privateKey.getEncoded());
		} catch(NoSuchAlgorithmException e) {}
	}

	/**
	 * Module that is encrypting with the RSA Algorithm with the use of Public Key
	 *
	 * @param text the data string that you want to encrypt (you enter it in the main function)
	 * @param b64publickey the public key which is then used to encrypt the data
	 * @return returns the encrypted string
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeySpecException
	 */
	public byte[] encrypt(String text,String b64publickey) throws IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, BadPaddingException {
		PublicKey pk = null;
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(b64publickey.getBytes()));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        pk = keyFactory.generatePublic(keySpec);
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.ENCRYPT_MODE, pk);
		return cipher.doFinal(text.getBytes());
	}

	/**
	 * Module that is decrypting with the RSA Algorithm with the use of Private Key
	 *
	 * @param data the data which is encrypted, you get it from encrypt function
	 * @param privateKey the private key which is used to decrypt a public encrypted text
	 * @return returns the decrypted string
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 */
	public static String decrypt(byte[] data, PrivateKey privateKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return new String(cipher.doFinal(data));
     }

	/**
	 * Module calling the decrypt method
	 *
	 * @param cmessage encrypted string in Base64 format
	 * @param b64privatekey the private key based on 64 bits which is used to decrypt a public encrypted text
	 * @return returns the decrypted string from class decrypt
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeySpecException
	 */
	public String decrypt(String cmessage, String b64privatekey) throws IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, BadPaddingException {
		PrivateKey pk = null;
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(b64privatekey.getBytes()));
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        pk = keyFactory.generatePrivate(keySpec);
        return decrypt(Base64.getDecoder().decode(cmessage.getBytes()),pk);
	}

	public String getpubkey()
    {
        return Encodedpublickey;
    }

    public String getprivkey()
    {
        return Encodedprivatekey;
    }

	/**
	 * The main object used to initialize and declare the variables
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeySpecException
	 */
	public static void main(String args[]) throws IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, BadPaddingException {
		RSA obj = new RSA();
		obj.Keygenerate();
		String pubkey = obj.Encodedpublickey;
		String encryptedString = Base64.getEncoder().encodeToString(obj.encrypt("Helloo how are you", pubkey));
		System.out.println(encryptedString);
		String decryptedString = obj.decrypt(encryptedString, obj.Encodedprivatekey);
		System.out.println(decryptedString);
	}
}