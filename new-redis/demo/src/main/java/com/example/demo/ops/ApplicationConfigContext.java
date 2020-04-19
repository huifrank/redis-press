package com.example.demo.ops;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.ConcurrentHashMap;

public class ApplicationConfigContext {
    private static final ConcurrentHashMap<String,String> context = new ConcurrentHashMap<>();


    public static String get(String key){
        if(StringUtils.isBlank(key)){
            return StringUtils.EMPTY;
        }
        return context.get(key);
    }

}
