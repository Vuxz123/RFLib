package com.ethnicthv.rflib.node.io.writer.util;

public interface RFUsable {
    void fromStringRF(String input);
    String toStringRF();

    int getLevel();
}
