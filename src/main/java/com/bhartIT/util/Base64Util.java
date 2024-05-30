package com.bhartIT.util;

import java.util.Base64;

public class Base64Util {
    public static void main(String[] args) {
        String secretKey = "BmE5yjcur0ShLkRM2OmtgQUMqYlKzoLjwfK8l8Kl+MulPnhXuF/QA0whsRmWIMq8NSH5JBeDDDVg/63tjCoiRQ=="; // Replace with your actual secret key
        String encodedKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
        System.out.println(encodedKey);
    }
}
