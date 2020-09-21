package com.forezp.userservice;

import java.util.Base64;

public class TestBase64 {
    public static void main(String[] args) {
        Base64.Decoder decoder=Base64.getDecoder();
        Base64.Encoder encoder=Base64.getEncoder();
        String auth="user-service:123456";
        System.out.println("hahah: "+encoder.encode(auth.getBytes()));
    }
}
