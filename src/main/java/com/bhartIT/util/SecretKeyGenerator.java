package com.bhartIT.util;

import java.security.SecureRandom;
import java.util.Base64;

public class SecretKeyGenerator {

    public static void main(String[] args) {
        // Define the length of the secret key (in bytes)
        int keyLength = 64; // You can adjust the length as needed for your security requirements

        // Generate a random byte array of the specified length
        byte[] keyBytes = new byte[keyLength];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(keyBytes);

        // Encode the byte array using Base64 encoding to get a human-readable string
        String base64EncodedKey = Base64.getEncoder().encodeToString(keyBytes);

        // Print the generated secret key
        System.out.println("Generated Secret Key: " + base64EncodedKey);
    }
}

