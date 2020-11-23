package com.imooc.lp.stream.cases;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class CaseTwoTest {

    @Data
    @AllArgsConstructor
    class TagReqDTO {
        private String name;
        private Integer age;

    }


    List<String> tagListFromDB;
    List<TagReqDTO> tagListFromReq;

    @Before
    public void init() {
        // 数据库中存在的标签名列表
        tagListFromDB = Lists.newArrayList(
                "李四", "王五", "赵六");

        // 用户提交的
        tagListFromReq = Lists.newArrayList(
                new TagReqDTO("张三", 10),
                new TagReqDTO("李四", 30),
                new TagReqDTO("张三", 10));
    }

    @Test
    public void distinctTag() {
        tagListFromReq.stream().distinct().filter(tag -> !tagListFromDB.contains(tag.getName())).forEach(tag -> System.out.println(tag));
    }

}
