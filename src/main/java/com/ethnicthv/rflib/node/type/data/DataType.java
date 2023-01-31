package com.ethnicthv.rflib.node.type.data;

import java.util.Comparator;

public class DataType extends AbstractDataType {
    //Constance
    public static final DataType INT = new DataType(Integer.class, (o1, o2) -> {
        Integer i1 = (Integer) o1;
        Integer i2 = (Integer) o2;
        return Integer.compare(i1, i2);
    });

    public static final DataType DOUBLE = new DataType(Double.class, (o1, o2) -> {
        Double i1 = (Double) o1;
        Double i2 = (Double) o2;
        return Double.compare(i1, i2);
    });

    public static final DataType LONG = new DataType(Long.class, (o1, o2) -> {
        Long i1 = (Long) o1;
        Long i2 = (Long) o2;
        return Long.compare(i1, i2);
    });

    public static final DataType SHORT = new DataType(Short.class, (o1, o2) -> {
        Short i1 = (Short) o1;
        Short i2 = (Short) o2;
        return Short.compare(i1, i2);
    });

    public static final DataType STRING = new DataType(String.class);

    //Define
    DataType(Class<?> type) {
        super(type);
    }

    DataType(Class<?> type, Comparator<Object> comparator) {
        super(type, comparator);
    }

}
