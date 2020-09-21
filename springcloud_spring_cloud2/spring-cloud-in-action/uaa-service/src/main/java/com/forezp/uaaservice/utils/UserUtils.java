package com.forezp.uaaservice.utils;

import org.springframework.security.core.context.SecurityContextHolder;

public class UserUtils {
    public static String getCurrentPrinciple(){
        return (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
