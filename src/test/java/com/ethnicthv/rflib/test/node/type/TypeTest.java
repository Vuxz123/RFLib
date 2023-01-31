package com.ethnicthv.rflib.test.node.type;

import com.ethnicthv.rflib.node.type.Type;
import com.ethnicthv.rflib.util.CM;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Test(groups = "default")
public class TypeTest {

    @DataProvider(name = "type_provider")
    public Object[][] provider() {
        var temp = CM.getStaticField(Type.class);
        int length = (int) temp.size();
        Object[][] list = new Object[length][1];
        AtomicInteger i = new AtomicInteger(0);
        temp.forEach(field -> {
            list[i.get()][0] = field;
            int a = i.getAndIncrement();
            if (a >= length) throw new RuntimeException("out of bounds in Type Data Provider");
        });
        return list;
    }

    @Test(dataProvider = "type_provider")
    public void test_type_reflect_from_short_name(Type field) {
        Type type = Type.TypeIO.fromStringRF((field).getShortName());
        Assert.assertEquals(type, field);
    }

    @Test(dataProvider = "type_provider")
    public void test_type_reflect_from_name(Type field) {
        Type type = Type.TypeIO.fromStringRF((field).getName());
        Assert.assertEquals(type, field);
    }
}
