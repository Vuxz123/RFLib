package com.ethnicthv.rflib.node.type.data;

import com.ethnicthv.rflib.node.eception.RFNotMatchTypeException;
import com.ethnicthv.rflib.node.eception.RFNullException;
import com.ethnicthv.rflib.util.CM;

import java.util.Objects;

public class DataStorage implements Comparable<DataStorage> {
    private AbstractDataType type;
    private Object storageData = null;

    DataStorage(AbstractDataType type) {
        this.type = type;
    }

    DataStorage(AbstractDataType type, Object storageData) throws RFNotMatchTypeException {
        this(type);
        this.setStorageData(storageData);
    }

    public Object getStorageData() {
        return storageData;
    }

    public AbstractDataType getType() {
        return type;
    }

    /**
     * @param storageData must be an Object
     */
    public void setStorageData(Object storageData) throws RFNotMatchTypeException {
        if (storageData.getClass() != type.getType()){
            if(CM.isSubclassOf(storageData.getClass(), type.getType())) {
                type.getType().cast(storageData);
                return;
            }
            else throw new RFNotMatchTypeException(String.format("%s cannot be stored as %s in DataStorage", storageData.getClass().getName(), type.type.getName()));
        }
        this.storageData = storageData;
    }

    public boolean isEmpty() {
        return this.storageData == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataStorage that = (DataStorage) o;
        return Objects.equals(type, that.type) && Objects.equals(storageData, that.storageData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, storageData);
    }

    @Override
    public String toString() {
        return type.toString() + ": " + storageData;
    }

    @Override
    public int compareTo(DataStorage o) {
        if (!this.type.isComparable()) return 0;
        if (this.isEmpty()) try {
            throw new RFNullException(String.format("%s is null", "storageData"));
        } catch (RFNullException e) {
            throw new RuntimeException(e);
        }
        if (o == null) try {
            throw new RFNullException(String.format("%s is null", "storageData"));
        } catch (RFNullException e) {
            throw new RuntimeException(e);
        }
        return this.type.getComparator().compare(this.storageData, o.storageData);
    }
}
