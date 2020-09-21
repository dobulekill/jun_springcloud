package com.forezp.userservice.common;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BPwdEncoderUtils {
    private static final BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

    public static String encode(String password){
        return encoder.encode(password);
    }
    public static boolean match(CharSequence rawPassword,String encodedPassword){
        return encoder.matches(rawPassword,encodedPassword);
    }
}
