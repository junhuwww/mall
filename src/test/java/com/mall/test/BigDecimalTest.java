package com.mall.test;

import org.junit.Test;

import java.math.BigDecimal;

public class BigDecimalTest {
    @Test
    public void test1(){
        System.out.println(0.06 + 0.01);
        System.out.println(0.06 - 0.01);
        System.out.println(4.015 * 1000);
        System.out.println(123.3/100);
    }

    @Test
    public void test2(){
        BigDecimal b1= new BigDecimal(0.06);
        BigDecimal b2= new BigDecimal(0.01);
        System.out.println(b1.add(b2));
    }


    @Test
    public void test3(){
        BigDecimal b1= new BigDecimal("0.06");
        BigDecimal b2= new BigDecimal("0.01");
        System.out.println(b1.add(b2));
    }
}
