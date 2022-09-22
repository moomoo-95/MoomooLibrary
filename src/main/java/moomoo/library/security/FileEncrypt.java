package moomoo.library.security;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class FileEncrypt {

    private static final String AES_CBC_ALG = "AES/CBC/PKCS5Padding";

    private FileEncrypt() {
        // nothing
    }

    public static String encryptAES256(String key, String iv, String text) throws Exception {
        Cipher cipher = Cipher.getInstance(AES_CBC_ALG);
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
        IvParameterSpec ivParamSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParamSpec);

        byte[] encrypted = cipher.doFinal(text.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static String decryptAES256(String key, String iv, String cipherText) throws Exception {
        Cipher cipher = Cipher.getInstance(AES_CBC_ALG);
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
        IvParameterSpec ivParamSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParamSpec);

        byte[] decodedBytes = Base64.getDecoder().decode(cipherText);
        byte[] decrypted = cipher.doFinal(decodedBytes);
        return new String(decrypted, StandardCharsets.UTF_8);
    }

    public static String encryptFile(String filePath) {
        return "";
    }

}
