package security;

import lombok.extern.slf4j.Slf4j;
import moomoo.library.security.FileEncrypt;
import org.junit.Test;

@Slf4j
public class SecurityTest {

    private static final String key = "abcdefghabcdefghabcdefghabcdefgh"; // 32byte
    private static final String iv = "0123456789abcdef"; // 16byte

    @Test
    public void AES256Test() {
        String plainText = "This document specifies an Internet standards track protocol for the Internet community, and requests discussion and suggestions for improvements.\n" +
                "Please refer to the current edition of the \"Internet Official Protocol Standards\" (STD 1) for the standardization state and status of this protocol.\n" +
                "Distribution of this memo is unlimited.\n";
        log.debug("plain   text : {}", plainText);
        try {
            String encryptText = FileEncrypt.encryptAES256(key, iv, plainText);
            log.debug("encrypt text : {}", encryptText);
            String decryptText = FileEncrypt.decryptAES256(key, iv, encryptText);
            log.debug("decrypt text : {}", decryptText);
        } catch (Exception e) {
            log.error("SecurityTest.AES256Test ", e);
        }

    }
}
