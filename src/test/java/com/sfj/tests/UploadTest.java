package com.sfj.tests;

import com.sfj.testdata.TestData;
import io.github.sskorol.core.DataSupplier;
import io.github.sskorol.data.TestDataReader;
import io.github.sskorol.data.XlsxReader;
import one.util.streamex.StreamEx;
import org.testng.annotations.Test;

public class UploadTest {
    @Test(dataProvider="getData")
    public void test1(TestData testData){
        System.out.println(testData.userName);

    }

    @DataSupplier
    public StreamEx<TestData> getData(){
        return TestDataReader.use(XlsxReader.class)
                .withTarget(TestData.class)
                .withSource("testdata.xlsx")
                .read();

    }
}
