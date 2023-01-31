package com.ethnicthv.rflib.node.type.data;

import com.ethnicthv.rflib.node.eception.RFNotMatchTypeException;

import java.util.Comparator;
import java.util.Objects;

public class AbstractDataType {
    protected Class<?> type = null;
    protected boolean comparable = false;
    protected Comparator<Object> comparator = null;

    protected AbstractDataType(Class<?> type) {
        this.type = type;
    }

    protected AbstractDataType(Class<?> type, Comparator<Object> comparator) {
        this.type = type;
        this.comparable = true;
        this.comparator = comparator;
    }

    public Class<?> getType() {
        return type;
    }

    public boolean isComparable() {
        return true;
    }

    public Comparator<Object> getComparator() {
        if (!this.isComparable()) return null;
        return comparator;
    }

    public DataStorage creatStorage() {
        return new DataStorage(this);
    }

    public DataStorage creatStorageWithDefault(Object data){
        try {
            return new DataStorage(this, data);
        } catch (RFNotMatchTypeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractDataType dataType = (AbstractDataType) o;
        return comparable == dataType.comparable && Objects.equals(type, dataType.type) && Objects.equals(comparator, dataType.comparator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, comparable, comparator);
    }

    @Override
    public String toString() {
        return type.getSimpleName().toUpperCase();
    }
}
