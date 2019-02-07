package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.lang.reflect.Field;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException {
        Resume r = new Resume();
        Field field = r.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(r));
        field.set(r, "new uuid");
        //TODO: invoke r.toString via reflection
        System.out.println(r);
        String methodToString = r.toString();
        methodToString = "uuid2";
        System.out.println(methodToString);
    }
}
