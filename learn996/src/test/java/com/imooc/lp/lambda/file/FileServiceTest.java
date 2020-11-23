package com.imooc.lp.lambda.file;

import org.junit.Test;

import java.io.IOException;

public class FileServiceTest {

    @Test
    public void fileHandle() throws IOException {
        FileService fileService = new FileService();
        fileService.fileHandle("/Users/lipeng/Documents/development/workspace/" +
                "learn996/src/test/java/com/imooc/lp/lambda/file/FileServiceTest.java", fileContent -> {
            //
            System.out.println(fileContent);
        });
    }
}
