package com.ethnicthv.rflib.node.type;

import java.lang.reflect.Field;
import java.util.Objects;

public class Type {
    //Instance
    public static final Type DATANODE = new Type("datanode", "dn");
    public static final Type CONTAINERNODE = new Type("containernode", "cn");
    public static final Type PRIORITYCONTAINERNODE = new Type("prioritycontainernode", "pcn");

    //Define
    private final String name;
    private final String sn;

    public Type(String name, String sn) {
        this.name = name;
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return sn;
    }

    @Override
    public String toString() {
        return this.sn.toUpperCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type = (Type) o;
        return Objects.equals(name, type.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public static class TypeIO {
        public static Type fromStringRF(String a) {
            try {
                Field[] fields = Type.class.getDeclaredFields();
                for (Field f :
                        fields) {
                    if (Type.class != f.getType()) continue;

                    Type type = (Type) f.get(null);

                    String alc = a.toLowerCase();

                    if(type.name == alc || type.sn == alc) return type;
                }
            } catch (IllegalAccessException e) {
                return null;
            }
            return null;
        }

        public static String toStringRF(Type type) {
            return "[" + type.sn + "]";
        }
    }
}
