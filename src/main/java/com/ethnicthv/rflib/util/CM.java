package com.ethnicthv.rflib.util;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

public class CM {
    private CM(){}
    public static boolean isSubclassOf(Class<?> subclass, Class<?> superclass)
    {
        if(subclass == superclass || superclass == Object.class) return true;

        while(subclass != superclass && subclass != Object.class)
        {
            subclass = subclass.getSuperclass();
        }
        return false;
    }

    public static List<Object> getStaticField(Class a) {
        return Arrays.stream(a.getDeclaredFields()).filter(field -> Modifier.isStatic(field.getModifiers())).map(field -> {
            try {
                return field.get(null);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }).toList();
    }
}
