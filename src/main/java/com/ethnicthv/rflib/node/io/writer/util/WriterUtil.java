package com.ethnicthv.rflib.node.io.writer.util;

import com.ethnicthv.rflib.node.type.AbstractNode;

public class WriterUtil {
    public static final String NAMESPACESCHEME = "[%s]: %s";
    public static String getHeader(AbstractNode abstractNode) {
        return abstractNode.TYPE + "-" + abstractNode.getHeader();
    }

    public static String getLevelTab(int level) {
        String temp = "";
        for (int i = 0; i < level; i++) {
            temp = temp + '\t';
        }
        return temp;
    }
}
