package com.testP.model;

import java.util.HashMap;
import java.util.Map;

public class ViewObject {
    public Map<String,Object> objs = new HashMap<String,Object>();

    public void set(String key,Object value){
        objs.put(key,value);
    }

    public Object get(String key){
        return objs.get(key);
    }
}
