package com.ethnicthv.rflib.node.type;

import com.ethnicthv.rflib.node.io.writer.util.RFUsable;

import java.util.Objects;

public abstract class AbstractNode implements RFUsable {
    protected String header;
    protected AbstractNode PARENT = null;
    public Type TYPE;

    protected AbstractNode(Type type, String header) {
        this.TYPE = type;
        this.header = header;
    }

    protected AbstractNode(Type type, String header, AbstractNode parent) {
        this(type, header);
        this.setParent(parent);
    }

    @Override
    public int getLevel() {
        if(PARENT == null) return 0;
        return PARENT.getLevel() + 1;
    }

    public AbstractNode getParent() {
        return PARENT;
    }

    public void setParent(AbstractNode parent) {
        this.PARENT = parent;
    }

    public boolean isType(Type type) {
        return this.TYPE.equals(type);
    }

    public String getHeader() {
        return header;
    }

    @Override
    public String toString() {
        return this.toStringRF();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractNode that = (AbstractNode) o;
        return this.getHeader().equals(that.getHeader());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getHeader());
    }
}
