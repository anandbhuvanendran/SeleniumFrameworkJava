package com.sfj.testdata;

import com.creditdatamw.zerocell.annotation.Column;
import com.creditdatamw.zerocell.converter.IntegerConverter;

public class TestData {
    @Column(name = "TestcaseName", index = 0)
    public String testCaseName;
    @Column(name = "Username",index = 1)
    public String userName;
    @Column(name = "Password",index = 2)
    public String password;
    @Column(name = "Age",index = 3,converterClass = IntegerConverter.class)
    public int age;
    @Column(name = "Title",index = 4)
    public String title;

}
