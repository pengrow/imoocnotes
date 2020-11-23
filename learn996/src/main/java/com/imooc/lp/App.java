package com.imooc.lp;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        List<String> str = new ArrayList<>();

        str.add("aaa");
        str.add("bb");

//        System.out.println(str.stream().filter(s->s.equals("aaa")).collect(Collectors.toList()));

        System.out.println(str.stream().peek(s -> System.out.println("mm"+s)).sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.toList()));

//        stream(null);

        TestInter test = new TestImpl();
        test.test();
    }


    public static void stream(List<String> list) {
//        list.stream().forEach(System.out::println);
        Optional.ofNullable(list)
                .map(List::stream)
                .get()
                .forEach(System.out::println);

//                .orElseGet(Stream::empty)

//        list.forEach();
    }

}

class TestImpl implements TestInter, TestInter2 {

    public void test() {
        System.out.println("TestImpl");
    }
}

interface TestInter {
    default void test() {
        System.out.println("TestInter");
    };
}

interface  TestInter2 {
     default void test() {
        System.out.println("TestInter2");
    }
}
