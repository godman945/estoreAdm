package com.fet.alex;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;

import com.sun.mail.util.BASE64DecoderStream;

public class AES {
	private static final String characterEncoding = "UTF-8";
    private static final String cipherTransformation = "AES/CBC/PKCS5Padding";
    private static final String aesEncryptionAlgorithm = "AES";
    private static final String iv ="7LPMMNG4ECGPPF69";
    
    private static byte[] decrypt(byte[] cipherText, byte[] key, byte [] initialVector) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, NoSuchProviderException
    {
    	Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        Cipher cipher = Cipher.getInstance(cipherTransformation);
        SecretKeySpec secretKeySpecy = new SecretKeySpec(key, aesEncryptionAlgorithm);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initialVector);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpecy, ivParameterSpec);
        cipherText = cipher.doFinal(cipherText);
        return cipherText;
    }
 
    private static byte[] encrypt(byte[] plainText, byte[] key, byte [] initialVector) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException
    {
    	Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        Cipher cipher = Cipher.getInstance(cipherTransformation);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, aesEncryptionAlgorithm);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initialVector);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
        plainText = cipher.doFinal(plainText);
        return plainText;
    }
 
    private static byte[] getKeyBytes(String key) throws UnsupportedEncodingException{
        byte[] keyBytes= new byte[16];
        byte[] parameterKeyBytes= key.getBytes(characterEncoding);
        System.arraycopy(parameterKeyBytes, 0, keyBytes, 0, Math.min(parameterKeyBytes.length, keyBytes.length));
        return keyBytes;
    }
 
    /// <summary>
    /// Encrypts plaintext using AES 128bit key and a Chain Block Cipher and returns a base64 encoded string
    /// </summary>
    /// <param name="plainText">Plain text to encrypt</param>
    /// <param name="key">Secret key</param>
    /// <returns>Base64 encoded string</returns>
    public static String encrypt(String plainText, String key) throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException{
        byte[] plainTextbytes = plainText.getBytes(characterEncoding);
        byte[] keyBytes = getKeyBytes(key);
        
       
        //有問題
       //  return (new sun.misc.BASE64Encoder()).encode(encrypt(plainTextbytes,keyBytes, keyBytes));
       
        
        
        
        byte[] alex = encrypt(plainText.getBytes(),key.getBytes(),iv.getBytes());
        return Base64.encodeBase64String(alex);
        
        //return Base64.encodeToString(encrypt(plainTextbytes,keyBytes, keyBytes), Base64.DEFAULT);
    }
 
    /// <summary>
    /// Decrypts a base64 encoded string using the given key (AES 128bit key and a Chain Block Cipher)
    /// </summary>
    /// <param name="encryptedText">Base64 Encoded String</param>
    /// <param name="key">Secret Key</param>
    /// <returns>Decrypted String</returns>
    public static String decrypt(String encryptedText, String key) throws KeyException, GeneralSecurityException, GeneralSecurityException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, IOException{
    	
    	
    	//有問題
//    	byte[] cipheredBytes = (new sun.misc.BASE64Decoder()).decodeBuffer(encryptedText);
//    	//byte[] cipheredBytes = Base64.decode(encryptedText, Base64.DEFAULT);
//        byte[] keyBytes = getKeyBytes(key);
//        return new String(decrypt(cipheredBytes, keyBytes, keyBytes), characterEncoding);
    	
    	
    	byte[] alex = Base64.decodeBase64(encryptedText);
    	return new String(decrypt(alex, key.getBytes(), iv.getBytes()), characterEncoding);
    	
    	
    }

    
    public static void main(String args[]) throws Exception{
//    	ZGzkHbz0/FFxe9l8tikOFq0fTQxPzYKtilpflkGegGg=
//    	System.out.println(AES.encrypt("2020062968113737589867", "TW3CRZ8YTZKL38P4YDNGP56PRR6BCK93"));
//    	System.out.println(AES.decrypt("KDkEmT1YZ2zUYfevwMbZXs2xiXDjDFtV76S6v/O/ny8=","TW3CRZ8YTZKL38P4YDNGP56PRR6BCK93"));
    	
    	
    	
    	System.out.println(AES.encrypt("周子智", "TW3CRZ8YTZKL38P4YDNGP56PRR6BCK93"));
    	System.out.println(AES.decrypt("Zd9YiYIzLj8OCtVlprsEcg==", "TW3CRZ8YTZKL38P4YDNGP56PRR6BCK93"));
//    	System.out.println(AES.encrypt("2A123852549", "TW3CRZ8YTZKL38P4YDNGP56PRR6BCK93"));
//    	System.out.println(AES.encrypt("a8952426@yahoo.com.tw", "TW3CRZ8YTZKL38P4YDNGP56PRR6BCK93"));
//    	System.out.println(AES.encrypt("0979002438", "TW3CRZ8YTZKL38P4YDNGP56PRR6BCK93"));
//    	System.out.println(AES.encrypt("0979002438", "TW3CRZ8YTZKL38P4YDNGP56PRR6BCK93"));
//    	System.out.println(AES.encrypt("0979002438", "TW3CRZ8YTZKL38P4YDNGP56PRR6BCK93"));
//    	System.out.println(AES.encrypt("台北市松山區復興北路３３７號１０樓", "TW3CRZ8YTZKL38P4YDNGP56PRR6BCK93"));
//    	System.out.println(AES.encrypt("61/01/25", "TW3CRZ8YTZKL38P4YDNGP56PRR6BCK93"));
//    	System.out.println(AES.encrypt("新北市蘆洲區民族路５４２號４樓", "TW3CRZ8YTZKL38P4YDNGP56PRR6BCK93"));
//    	System.out.println(AES.encrypt("新北市蘆洲區民族路５４２號４樓", "TW3CRZ8YTZKL38P4YDNGP56PRR6BCK93"));
//    	System.out.println(AES.encrypt("a8952426@yahoo.com.tw", "TW3CRZ8YTZKL38P4YDNGP56PRR6BCK93"));
//    	System.out.println(AES.encrypt("0935363626", "TW3CRZ8YTZKL38P4YDNGP56PRR6BCK93"));
    	
    	
    	
    	
    	
//    	System.out.println(AES.encrypt("ALEX#@$%^20&19.陳", "TW3CRZ8YTZKL38P4YDNGP56PRR6BCK93"));
    	
//    	System.out.println(AES.decrypt("eek2heVm8LgxBemjcanYOA==","TW3CRZ8YTZKL38P4YDNGP56PRR6BCK93"));
//    	System.out.println(AES.decrypt("vm3+lcRBHYi76rkl9/FIaA==","TW3CRZ8YTZKL38P4YDNGP56PRR6BCK93"));
//    	System.out.println(AES.decrypt("yzviXgQkIDv9+aYo5ZjI6vzcZmiDkb8HI/T7XcNQPrE=","TW3CRZ8YTZKL38P4YDNGP56PRR6BCK93"));
//    	System.out.println(AES.decrypt("onIVmdYLNWl/SRs5/RA2Zg==","TW3CRZ8YTZKL38P4YDNGP56PRR6BCK93"));
//    	System.out.println(AES.decrypt("onIVmdYLNWl/SRs5/RA2Zg==","TW3CRZ8YTZKL38P4YDNGP56PRR6BCK93"));
//    	System.out.println(AES.decrypt("onIVmdYLNWl/SRs5/RA2Zg==","TW3CRZ8YTZKL38P4YDNGP56PRR6BCK93"));
//    	System.out.println(AES.decrypt("ieHxYE+WZYv92Y6Ww01er9hxBGgncTo+HhC0piDAxgQZwaPQpzzBk7BVC0ovev0eHsMJ5MlA1DPxs7MKDHtW2w==","TW3CRZ8YTZKL38P4YDNGP56PRR6BCK93"));
//    	System.out.println(AES.decrypt("0AWh750tjdM8K8bsC7kuHw==","TW3CRZ8YTZKL38P4YDNGP56PRR6BCK93"));
//    	System.out.println(AES.decrypt("eek2heVm8LgxBemjcanYOA==","TW3CRZ8YTZKL38P4YDNGP56PRR6BCK93"));
//    	System.out.println(AES.decrypt("OvtcdNQLNEObYqk6h2okZpu/ly+dEtQzs4/0BBQjghHLQ4lmwZqO6Kw7+D2nu9Ql","TW3CRZ8YTZKL38P4YDNGP56PRR6BCK93"));
    	
    }
}
