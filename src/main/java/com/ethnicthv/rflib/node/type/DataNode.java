package com.ethnicthv.rflib.node.type;

import com.ethnicthv.rflib.node.eception.RFNotMatchTypeException;
import com.ethnicthv.rflib.node.eception.RFNullException;
import com.ethnicthv.rflib.node.io.writer.util.WriterUtil;
import com.ethnicthv.rflib.node.type.data.DataStorage;
import com.ethnicthv.rflib.node.type.data.DataType;
import org.jetbrains.annotations.NotNull;

public class DataNode extends AbstractNode {
    private DataType dataType;
    private DataStorage dataStorage;

    public DataNode(String header, @NotNull DataType dataType) {
        super(Type.DATANODE, header);
        this.dataType = dataType;
        dataStorage = dataType.creatStorage();
    }

    public DataNode(String header, @NotNull DataType dataType, AbstractNode parent) {
        super(Type.DATANODE, header, parent);
        this.dataType = dataType;
        dataStorage = dataType.creatStorage();
    }

    public Object get() {
        try {
            return this.get(false);
        } catch (RFNullException e) {
            return null;
        }
    }

    public Object get(boolean checkNull) throws RFNullException {
        if (checkNull && this.dataStorage.isEmpty()) throw new RFNullException();
        return this.dataStorage.getStorageData();
    }

    public void set(Object object) {
        try {
            this.set(object, false);
        } catch (RFNotMatchTypeException ignore) {}
    }

    public void set(Object object, boolean checkMatching) throws RFNotMatchTypeException {
        if(object.getClass() == this.dataType.getType()) {
            this.dataStorage.setStorageData(object);
        }
        else if(checkMatching) {
            throw new RFNotMatchTypeException();
        }
    }

    public DataStorage getDataStorage() {
        return dataStorage;
    }

    public void setDataStorage(DataStorage dataStorage) {
        if(!this.dataType.equals(dataStorage.getType())) return;
        this.dataStorage = dataStorage;
    }

    @Override
    public void fromStringRF(String input) {

    }

    @Override
    public String toStringRF() {
        StringBuilder builder = new StringBuilder();
        StringBuilder builder1 = new StringBuilder();
        builder.append(String.format(WriterUtil.NAMESPACESCHEME, WriterUtil.getHeader(this), this.dataStorage.toString()));
        return builder.toString();
    }
}
