package com.imooc.lp.stream.cases;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

public class CaseOne {

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

    Map<String, List<ExamStudentScore>> studentMap;
}
