package com.ethnicthv.rflib.test.node.type.data;

import com.ethnicthv.rflib.node.eception.RFNotMatchTypeException;
import com.ethnicthv.rflib.node.type.data.DataStorage;
import com.ethnicthv.rflib.node.type.data.DataType;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(groups = "default")
public class DataStorageTest {

    public void testStorageCreate() {
        DataStorage int1 = DataType.INT.creatStorage();
        Integer i = 1;
        try {
            int1.setStorageData(i);
        } catch (RFNotMatchTypeException ignored) {
        }
        DataStorage int2 = DataType.INT.creatStorageWithDefault(1);
        Assert.assertEquals(int1, int2, "pass");
    }
}