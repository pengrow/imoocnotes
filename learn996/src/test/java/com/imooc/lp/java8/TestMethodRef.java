package com.imooc.lp.java8;

import org.junit.Test;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestMethodRef {

    @Test
    public void test1() {
        BiPredicate<String, String> biPredicate = (x, y) -> x.equals(y);

        BiPredicate<String, String> biPredicate1 = String::equals;

        boolean test = biPredicate1.test("a", "a");
        System.out.println(test);
    }

    @Test
    public void test2() {
        Consumer<String> consumer = x -> System.out.println(x);
        Consumer<String> consumer1 = System.out::println;

        consumer1.accept("aaaa");
    }

    public void test3() {
//        Supplier
    }

    public  void test4() {
//        Function
    }
}
