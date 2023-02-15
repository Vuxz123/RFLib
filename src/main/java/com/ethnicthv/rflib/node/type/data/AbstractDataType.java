package com.ethnicthv.rflib.node.type.data;

import com.ethnicthv.rflib.node.eception.RFNotMatchTypeException;
import com.ethnicthv.rflib.node.type.data.properties.Properties;
import com.ethnicthv.rflib.node.type.data.properties.Property;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class AbstractDataType {
    protected Class<?> type = null;
    protected List<Property> propertiesList = new ArrayList<>();
    protected AbstractDataType(Class<?> type) {
        this.type = type;
    }

    protected AbstractDataType(Class<?> type, Comparator<Object> comparator) {
        this.type = type;
    }

    public Class<?> getType() {
        return type;
    }

    public void addProperty(Property property) {
        this.propertiesList.add(property);
    }

    public boolean hasProperty(Property property) {
        return propertiesList.contains(property);
    }

    public Object getPropertyContainer(Property property) {
        if(!hasProperty(property)) return null;
        return null;
    }

    public boolean isComparable() {
        return this.hasProperty(Properties.COMPARATOR);
    }

    public Comparator<Object> getComparator() {
        if (!this.isComparable()) return null;
        return (Comparator<Object>) this.getPropertyContainer(Properties.COMPARATOR);
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
        AbstractDataType that = (AbstractDataType) o;
        return Objects.equals(type, that.type) && Objects.equals(propertiesList, that.propertiesList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, propertiesList);
    }

    @Override
    public String toString() {
        return type.getSimpleName().toUpperCase();
    }
}
