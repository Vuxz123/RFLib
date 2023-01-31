package com.ethnicthv.rflib.test.node.io.reader.util;

import com.ethnicthv.rflib.node.io.reader.util.ReaderUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.regex.Matcher;

@Test(groups = "default")
public class ReaderUtilTest {

    public void testRegEx() {
        Matcher matcher = ReaderUtil.HEADER_PATTERN.matcher("[CN-c1]:absauhdiuahwid");
        Assert.assertTrue(matcher.matches());
    }

}
