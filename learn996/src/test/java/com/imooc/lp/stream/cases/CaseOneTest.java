package com.imooc.lp.stream.cases;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CaseOneTest {
    /**
     * 考试成绩模型
     */
    @Data
    @AllArgsConstructor
    class ExamStudentScore {

        /**
         * 学生姓名
         */
        private String studentName;

        /**
         * 成绩
         */
        private Integer scoreValue;

        /**
         * 考试科目
         */
        private String subject;


    }


    /**
     * 学生考试成绩
     */
    Map<String, List<ExamStudentScore>> studentMap;

    @Before
    public void init() {
        studentMap = new HashMap<>();

        List<ExamStudentScore> zsScoreList = new ArrayList<>();
        zsScoreList.add(
                new ExamStudentScore(
                        "张三",
                        30,
                        "CHINESE"));
        zsScoreList.add(
                new ExamStudentScore(
                        "张三",
                        40,
                        "ENGLISH"));
        zsScoreList.add(
                new ExamStudentScore(
                        "张三",
                        50,
                        "MATHS"));
        studentMap.put("张三", zsScoreList);

        List<ExamStudentScore> lsScoreList = new ArrayList<>();
        lsScoreList.add(new ExamStudentScore("李四",80,"CHINESE"));
        lsScoreList.add(
                new ExamStudentScore(
                        "李四",
                        null,
                        "ENGLISH"));
        lsScoreList.add(
                new ExamStudentScore(
                        "李四",
                        100,
                        "MATHS"));
        studentMap.put("李四", lsScoreList);

        List<ExamStudentScore> wwScoreList = new ArrayList<>();
        wwScoreList.add(
                new ExamStudentScore(
                        "王五",
                        null,
                        "CHINESE"));
        wwScoreList.add(
                new ExamStudentScore(
                        "王五",
                        null,
                        "ENGLISH"));
        wwScoreList.add(
                new ExamStudentScore(
                        "王五",
                        70,
                        "MATHS"));
        studentMap.put("王五", wwScoreList);
//        JSON.toJSONString(wwScoreList, true);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                ;
            }
        });
    }


    @Test
    public void findStudentsWhoHasNullScore() {
        studentMap.forEach((studentName, scoreList) -> {
            boolean bool = scoreList.stream().anyMatch(ess -> ess.getScoreValue() == null);
            if(bool) {
                System.out.println("此学生[ " + studentName + " ]有缺考情况");
            }
        });
        Map<String, String> map = new HashMap<>();

    }

    @Test
    public void findStudents() {
        studentMap.forEach((studentName, scoreList) -> {
            List<String> subjects = new ArrayList<>();
            long count = scoreList.stream().filter(ess -> ess.getScoreValue() == null).peek(ess-> subjects.add(ess.getSubject())).count();
            System.out.println();
            System.out.println("此学生[ " + studentName + " ]有" + count + "门课程缺考");
            if(count > 0){
                System.out.println("缺考科目为: " + subjects);
            }
        });
    }
}
