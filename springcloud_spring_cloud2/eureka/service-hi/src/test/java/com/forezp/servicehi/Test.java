package com.forezp.servicehi;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        String aaa="123456";
        List<String> list=new ArrayList<>();
        for(int i=0;i<10;i++){
            String hash=encoder.encode(aaa);
            list.add(hash);
            System.out.println(i+":"+hash);
        }
        for (int i=0;i<10;i++){
            System.out.println(encoder.matches(list.get(0),list.get(i)));
        }
    }
}
