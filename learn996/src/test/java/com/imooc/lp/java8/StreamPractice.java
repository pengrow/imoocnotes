package com.imooc.lp.java8;

import com.alibaba.fastjson.JSON;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPractice {
    List<Transaction> transactions = null;

    @Before
    public void before() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }

    //    (1) 找出2011年发生的所有交易，并按交易额排序（从低到高）
    @Test
    public void test1() {
        List<Transaction> list = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(list, true));
    }


    //    (2) 交易员都在哪些不同的城市工作过？
    @Test
    public void test2() {
        List<String> list = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(JSON.toJSONString(list, true));
    }

    //    (3) 查找所有来自于剑桥的交易员，并按姓名排序。
    @Test
    public void test3() {
        List<Trader> list = transactions.stream()
                .map(t -> t.getTrader())
                .filter(t -> t.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .distinct()
                .collect(Collectors.toList());

        System.out.println(JSON.toJSONString(list, true));

    }


    //    (4) 返回所有交易员的姓名字符串，按字母顺序排序。
    @Test
    public void test4() {
        List<String> list = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted(String::compareTo)
                .collect(Collectors.toList());

        System.out.println(JSON.toJSONString(list, true));

    }

    //    (5) 有没有交易员是在米兰工作的？
    @Test
    public void test5() {
        boolean milan = transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        System.out.println("有没有交易员是在米兰工作的: " + milan);
    }


    //    (6) 打印生活在剑桥的交易员的所有交易额。
    @Test
    public void test6() {
        transactions.stream().filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(t -> t.getValue())
                .forEach(System.out::println);
    }

    //    (7) 所有交易中，最高的交易额是多少？
    @Test
    public void test7() {
        int max = transactions.stream()
                .mapToInt(Transaction::getValue)
                .max()
                .getAsInt();
        System.out.println("最高的交易额是: " + max);
    }


//    (8) 找到交易额最小的交易。
    @Test
    public void test8() {
        Transaction transaction = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue)).get();
        System.out.println(JSON.toJSONString(transaction, true));
    }
}
