package com.ethnicthv.rflib.node.persistence;

public class ImutableContainer<T> {
    protected T t;

    public ImutableContainer(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }
}
