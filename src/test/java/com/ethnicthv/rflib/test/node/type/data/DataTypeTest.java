package com.ethnicthv.rflib.test.node.type.data;

import com.ethnicthv.rflib.node.type.data.DataStorage;
import com.ethnicthv.rflib.node.type.data.DataType;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.time.LocalTime;

import java.time.temporal.ChronoField;
import java.util.Random;

@Test(groups = "default")
public class DataTypeTest {

    @DataProvider(name = "provider_int")
    public Object[][] provide() {
        Object[][] random = new Object[5][2];

        Random random1 = new Random(LocalTime.now().getLong(ChronoField.MICRO_OF_DAY));

        for (int i = 0; i < 5; i++) {
            random[i][0] = random1.nextInt();
            random[i][1] = random1.nextInt();
        }

        return random;
    }

    public void test_int_comparator_equal() {
        DataStorage int1 = DataType.INT.creatStorageWithDefault(1);
        DataStorage int2 = DataType.INT.creatStorageWithDefault(1);
        boolean test = (int1.compareTo(int2) == 0);
        Assert.assertTrue(test);
    }

    public void test_int_comparator_higher() {
        DataStorage int1 = DataType.INT.creatStorageWithDefault(2);
        DataStorage int2 = DataType.INT.creatStorageWithDefault(1);
        boolean test = (int1.compareTo(int2) == 1);
        Assert.assertTrue(test);
    }

    public void test_int_comparator_under() {
        DataStorage int1 = DataType.INT.creatStorageWithDefault(-1);
        DataStorage int2 = DataType.INT.creatStorageWithDefault(1);
        boolean test = (int1.compareTo(int2) == -1);
        Assert.assertTrue(test);
    }

    @DataProvider(name = "provider_long")
    public Object[][] provide2() {
        Object[][] random = new Object[5][2];

        Random random1 = new Random(LocalTime.now().getLong(ChronoField.MICRO_OF_DAY));

        for (int i = 0; i < 5; i++) {
            random[i][0] = random1.nextLong();
            random[i][1] = random1.nextLong();
        }

        return random;
    }

    public void test_long_comparator_equal() {
        DataStorage int1 = DataType.LONG.creatStorageWithDefault(1L);
        DataStorage int2 = DataType.LONG.creatStorageWithDefault(1L);
        boolean test = (int1.compareTo(int2) == 0);
        Assert.assertTrue(test);
    }

    public void test_long_comparator_higher() {
        DataStorage int1 = DataType.LONG.creatStorageWithDefault(2L);
        DataStorage int2 = DataType.LONG.creatStorageWithDefault(1L);
        boolean test = (int1.compareTo(int2) == 1);
        Assert.assertTrue(test);
    }

    public void test_long_comparator_under() {
        DataStorage int1 = DataType.LONG.creatStorageWithDefault(-1L);
        DataStorage int2 = DataType.LONG.creatStorageWithDefault(1L);
        boolean test = (int1.compareTo(int2) == -1);
        Assert.assertTrue(test);
    }

    @Test(dataProvider = "provider_long")
    public void test_comparator_long(Long a, Long b) {
        DataStorage int1 = DataType.LONG.creatStorageWithDefault(a);
        DataStorage int2 = DataType.LONG.creatStorageWithDefault(b);
        boolean test = (int1.compareTo(int2) == Long.compare(a,b));
        Assert.assertTrue(test);
    }

    @DataProvider(name = "provider_short")
    public Object[][] provide3() {
        Object[][] random = new Object[5][2];

        Random random1 = new Random(LocalTime.now().getLong(ChronoField.MICRO_OF_DAY));

        for (int i = 0; i < 5; i++) {
            random[i][0] = (short) random1.nextInt(Short.MIN_VALUE, Short.MAX_VALUE);
            random[i][1] = (short) random1.nextInt(Short.MIN_VALUE, Short.MAX_VALUE);
        }

        return random;
    }

    public void test_short_comparator_equal() {
        DataStorage int1 = DataType.SHORT.creatStorageWithDefault((short) 1);
        DataStorage int2 = DataType.SHORT.creatStorageWithDefault((short) 1);
        boolean test = (int1.compareTo(int2) == 0);
        Assert.assertTrue(test);
    }

    public void test_short_comparator_higher() {
        DataStorage int1 = DataType.SHORT.creatStorageWithDefault((short) 2);
        DataStorage int2 = DataType.SHORT.creatStorageWithDefault((short) 1);
        boolean test = (int1.compareTo(int2) == 1);
        Assert.assertTrue(test);
    }

    public void test_short_comparator_under() {
        DataStorage int1 = DataType.SHORT.creatStorageWithDefault( (short)-1);
        DataStorage int2 = DataType.SHORT.creatStorageWithDefault((short) 1);
        boolean test = (int1.compareTo(int2) == Short.compare((short)-1, (short) 1));
        Assert.assertTrue(test);
    }

    @Test(dataProvider = "provider_short")
    public void test_comparator_short(Short a, Short b) {
        DataStorage int1 = DataType.SHORT.creatStorageWithDefault(a);
        DataStorage int2 = DataType.SHORT.creatStorageWithDefault(b);
        boolean test = (int1.compareTo(int2) == Short.compare(a,b));
        Assert.assertTrue(test);
    }

    @DataProvider(name = "provider_double")
    public Object[][] provide4() {
        Object[][] random = new Object[5][2];

        Random random1 = new Random(LocalTime.now().getLong(ChronoField.MICRO_OF_DAY));

        for (int i = 0; i < 5; i++) {
            random[i][0] = random1.nextDouble();
            random[i][1] = random1.nextDouble();
        }

        return random;
    }

    public void test_double_comparator_equal() {
        DataStorage int1 = DataType.DOUBLE.creatStorageWithDefault(1D);
        DataStorage int2 = DataType.DOUBLE.creatStorageWithDefault(1D);
        boolean test = (int1.compareTo(int2) == 0);
        Assert.assertTrue(test);
    }

    public void test_double_comparator_higher() {
        DataStorage int1 = DataType.DOUBLE.creatStorageWithDefault(2D);
        DataStorage int2 = DataType.DOUBLE.creatStorageWithDefault(1D);
        boolean test = (int1.compareTo(int2) == 1);
        Assert.assertTrue(test);
    }

    public void test_double_comparator_under() {
        DataStorage int1 = DataType.DOUBLE.creatStorageWithDefault(-1D);
        DataStorage int2 = DataType.DOUBLE.creatStorageWithDefault(1D);
        boolean test = (int1.compareTo(int2) == -1);
        Assert.assertTrue(test);
    }

    @Test(dataProvider = "provider_double")
    public void test_comparator_short(Double a, Double b) {
        DataStorage int1 = DataType.DOUBLE.creatStorageWithDefault(a);
        DataStorage int2 = DataType.DOUBLE.creatStorageWithDefault(b);
        boolean test = (int1.compareTo(int2) == Double.compare(a,b));
        Assert.assertTrue(test);
    }
}


