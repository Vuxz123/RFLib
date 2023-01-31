package com.ethnicthv.rflib.util;

import com.ethnicthv.rflib.node.type.Type;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public class CM {
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
        var temp = Arrays.stream(a.getDeclaredFields()).filter(field -> Modifier.isStatic(field.getModifiers())).map(field -> {
            try {
                return field.get(null);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }).toList();
        return temp;
    }
}
