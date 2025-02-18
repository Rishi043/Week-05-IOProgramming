package com.ioprogramming.csvdatahandling.advancedproblems.encryptdecryptcsv;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class DecryptionUtil {
    private static final String DES = "DES";
    private static final String SECRET_KEY = "yourkey"; // Replace with a secure key of length 8 bytes

    public String decrypt(String encryptedData) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), DES);
            Cipher cipher = Cipher.getInstance(DES);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decodedData = Base64.getDecoder().decode(encryptedData);
            return new String(cipher.doFinal(decodedData));
        } catch (Exception e) {
            throw new RuntimeException("Error while decrypting", e);
        }
    }
}

