package com.ethnicthv.rflib.test;

import com.ethnicthv.rflib.node.type.ContainerNode;
import com.ethnicthv.rflib.node.type.DataNode;
import com.ethnicthv.rflib.node.type.data.DataType;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(groups = "default")
public class RFLibTest {

    public static void main(String[] args) {
        ContainerNode containerNode = new ContainerNode("c1");
        ContainerNode containerNode2 = new ContainerNode("c2");
        ContainerNode containerNode3 = new ContainerNode("c3");
        ContainerNode containerNode4 = new ContainerNode("c4");

        DataNode dataNode = new DataNode("d1", DataType.INT);
        DataNode dataNode1 = new DataNode("d2", DataType.STRING);
        DataNode dataNode3 = new DataNode("d2", DataType.DOUBLE);

        dataNode.set(20);
        dataNode1.set("ALO");
        dataNode3.set(20.0D);

        containerNode3.addChild(dataNode);
        containerNode4.addChild(dataNode1);
        containerNode2.addChild(dataNode3);

        containerNode.addChild(containerNode2);
        containerNode.addChild(containerNode3);
        containerNode2.addChild(containerNode4);

        System.out.println(containerNode);
    }
}
