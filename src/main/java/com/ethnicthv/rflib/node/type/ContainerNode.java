package com.ethnicthv.rflib.node.type;

import com.ethnicthv.rflib.node.io.writer.util.RFUsable;
import com.ethnicthv.rflib.node.io.writer.util.WriterUtil;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContainerNode extends AbstractNode {
    protected List<AbstractNode> childrent = new ArrayList<>();

    public ContainerNode(String header) {
        super(Type.CONTAINERNODE, header);
    }

    public ContainerNode(String header, AbstractNode parent) {
        super(Type.CONTAINERNODE, header, parent);
    }

    public List<AbstractNode> getChild() {
        return childrent;
    }

    public void addChild(AbstractNode child) {
        boolean test = true;
        for (AbstractNode abstractNode :
                childrent) {
            if (abstractNode.equals(child)) {
                test = false;
                break;
            }
        }
        if (test) {
            child.setParent(this);
            childrent.add(child);
        }
    }

    public void removeChild(AbstractNode child) {
        childrent.removeIf(node -> node.equals(child));
    }

    @Override
    public void fromStringRF(String input) {
        Scanner reader = new Scanner(input);
    }

    @Override
    public String toStringRF() {
        StringBuilder builder = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        for (RFUsable usable :
                childrent) {
            String temp = usable.toStringRF();
            String temp2 = WriterUtil.getLevelTab(usable.getLevel());
            temp = "\n" + temp2 + temp;
            builder2.append(temp);
        }
        builder.append(String.format(WriterUtil.NAMESPACESCHEME, WriterUtil.getHeader(this), builder2.toString()));
        return builder.toString();
    }


}
